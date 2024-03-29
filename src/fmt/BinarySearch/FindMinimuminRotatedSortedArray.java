package fmt.BinarySearch;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else hi = mid;
        }
        return nums[lo];
    }

    public int findMinII(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] == nums[hi]) {
                hi--;
            } else hi = mid;
        }
        return nums[lo];
    }


    public int findMinIII(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }


    public static void main(String[] args) {
        int[] ints = new int[]{3, 1, 2};
        System.out.println(new FindMinimuminRotatedSortedArray().findMin(ints));
        System.out.println(new FindMinimuminRotatedSortedArray().findMinII(ints));
        System.out.println(new FindMinimuminRotatedSortedArray().findMinIII(ints));
    }
}
