package javaPractice;

import java.lang.String;

class CheckLength {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int[] out = { 1 };
        return out;

    }

    public static void main(String[] args) {
        CheckLength s = new CheckLength();
        int[] t = { 1, 2 };
        System.out.println(s.searchRange(t, 1));

    }
}