public class RotatedSearch {
    public int search(int[] nums, int target) {
        int len = nums.length - 1;
        int left = 0;
        int right = len;
        while (right - left > 1) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[left])
                left = mid;
            else
                right = mid;
            System.out.println("left: " + nums[left] + " right: " + nums[right]);
        }
        if (target >= nums[0] && target <= nums[left]) {
            return binarySearch(nums, target, 0, left);

        } else if (target >= nums[right] && target <= nums[len]) {

            return binarySearch(nums, target, right, len);
        }

        return -1;

    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        while (end - start > 1) {
            if (nums[start] == target || nums[end] == target)
                return nums[start] == target ? start : end;
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid;
            else
                start = mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        RotatedSearch rs = new RotatedSearch();
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 3;
        System.out.println(rs.search(nums, target));
    }
}

/*
 * 
 * bracket ()
 * left_parameter: json_key from payload
 * ==,>,<,>=,<=,!=
 * right_parameter: json_value from payload
 * or
 * and
 * 
 */
