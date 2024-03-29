package fmt.Array.problems;

public class DominantIndex {

    private static int dominantIndex(int[] nums) {
        int la = Integer.MIN_VALUE, lb = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > la) {
                lb = la;
                la = num;
                idx = i;
            } else if (num > lb) {
                lb = num;
            }
        }
        if (la >= lb * 2) return idx;
        return -1;
    }

    public static int dominantIndex2(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] t1 = new int[]{3, 6, 1, 0};
        int[] t2 = new int[]{0, 0, 3, 2, 7};
        System.out.println(dominantIndex(t1));
        System.out.println(dominantIndex2(t1));
        System.out.println(dominantIndex(t2));
        System.out.println(dominantIndex2(t2));
    }
}
