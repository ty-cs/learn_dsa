package dsa.UnionFind;

public class UnionFind {
    private int[] parents;
    private int[] ranks;

    public UnionFind(int n) {
        this.parents = new int[n + 1];
        this.ranks = new int[n + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    // O(1)
    // Union by rank: merge low rank tree to high rank one.
    public boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) return false;

        if (ranks[rootV] > ranks[rootU]) {
            parents[rootU] = rootV;
        } else if (ranks[rootU] > ranks[rootV]) {
            parents[rootV] = rootU;
        } else {
            parents[rootV] = rootU;
            ranks[rootU]++;
        }
        return true;
    }

    // O(1)
    // Path compression: make the tree flat.
    public int find(int u) {
        while (parents[u] != u) {
            parents[u] = parents[parents[u]];
            u = parents[u];
        }
        return u;
    }

    private int find2(int u) {
        if (parents[u] != u) { // not root
            parents[u] = find2(parents[u]); // point parents to root
        }
        return parents[u];
    }
}
