package fmt.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] > remain) break; // optimization here

                if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new CombinationSumII().combinationSum2(ints, target));
    }
}
