package fmt.DynamicProgramming;


/**
 * A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), followed by some
 * number of '1's (also possibly 0.)
 * <p>
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
 * <p>
 * Return the minimum number of flips to make S monotone increasing. Example 1:
 * <p>
 * Input: "00110" Output: 1 Explanation: We flip the last digit to get 00111. Example 2:
 * <p>
 * Input: "010110" Output: 2 Explanation: We flip to get 011111, or alternatively 000111. Example 3:
 * <p>
 * Input: "00011000" Output: 2 Explanation: We flip to get 00000000.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 20000 S only consists of '0' and '1' characters.
 */
public class FlipStringtoMonotoneIncreasing {
    // Brute Force (O(N^2))
    // TLE
    // Try all possible ks so that => S[0] ~ S[k] == '0' and S[k+1] ~ S[N] == '1'
    public int minFlipsMonoIncrBF(String S) {
        int res = Integer.MAX_VALUE;

        for (int k = -1; k < S.length(); k++) {
            int cnt = 0;
            for (int i = 0; i <= k; i++) if (S.charAt(i) == '1') cnt++;
            for (int i = k + 1; i < S.length(); i++) if (S.charAt(i) == '0') cnt++;
            res = Math.min(res, cnt);
        }

        return res;
    }


    /**
     * Complexity Analysis
     * <p>
     * Time Complexity: O(N)O(N), where NN is the length of S.
     * <p>
     * Space Complexity: O(N)O(N).
     *
     * @param S
     *
     * @return
     */
    public int minFlipsMonoIncr(String S) {
        int N = S.length();
        int[] dp = new int[N + 1];
        for (int i = 0; i < N; ++i)
            dp[i + 1] = dp[i] + (S.charAt(i) == '1' ? 1 : 0);

        int res = Integer.MAX_VALUE;
        for (int j = 0; j <= N; ++j) {
            res = Math.min(res, dp[j] + N - j - (dp[N] - dp[j]));
        }

        return res;
    }

    public int minFlipsMonoIncr2(String S) {
        if (S == null || S.length() <= 0)
            return 0;

        char[] sChars = S.toCharArray();
        int flipCount = 0;
        int onesCount = 0;

        for (char sChar : sChars) {
            if (sChar == '0') {
                if (onesCount == 0) continue;
                else flipCount++;
            } else {
                onesCount++;
            }
            flipCount = Math.min(flipCount, onesCount);
        }
        return flipCount;
    }

    public static void main(String[] args) {
        FlipStringtoMonotoneIncreasing flip = new FlipStringtoMonotoneIncreasing();
        System.out.println(flip.minFlipsMonoIncr("010110"));
        System.out.println(flip.minFlipsMonoIncr2("010110"));
        System.out.println(flip.minFlipsMonoIncrBF("11011"));
        System.out.println(flip.minFlipsMonoIncr2("010110001100"));
    }
}
