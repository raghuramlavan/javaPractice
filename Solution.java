package javaPractice;

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] result = { -1, -1 };
        if (nums.length == 0)
            return result;
        int left = 0;
        int right = nums.length - 1;
        while (right - left > 1) {
            // System.out.println("left :" + left + " right: " + right);
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(" " + left + " " + right);

        if (nums[left] == target)
            result[0] = left;
        else
            result[0] = right;

        left = right;
        right = nums.length - 1;
        while (right - left > 1) {
            // System.out.println("left :" + left + " right: " + right);
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        result[1] = left;
        System.out.println(" " + left + " " + right);

        return result;

    }

    public static void main(String[] argv) {
        Solution s = new Solution();
        int[] result = { 2, 2 };
        int[] out = s.searchRange(result, 2);
        System.out.println(" " + out[0] + " " + out[1]);

    }
}