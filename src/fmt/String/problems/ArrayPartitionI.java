package fmt.String.problems;

import java.util.Arrays;

public class ArrayPartitionI {
    private static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 4, 3, 2};
        System.out.println(arrayPairSum(ints));
    }
}