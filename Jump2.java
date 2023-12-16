import java.util.LinkedList;
import java.util.ListIterator;

public class Jump2 {
    public LinkedList<Integer> check(int[] nums, LinkedList<Integer> values, int cursor) {

        if (cursor == nums.length - 1) {
            values.addFirst(0);
            System.out.println("values: " + values + " cursor: " + cursor);
            return check(nums, values, cursor - 1);
        } else if (cursor < 0) {
            System.out.println("values: " + values + " cursor: " + cursor);
            return values;
        } else {
            int count = nums[cursor];

            int mini = Integer.MAX_VALUE;
            ListIterator<Integer> t = values.listIterator();
            for (int i = 0; i < count; i++) {
                if (t.hasNext()) {
                    int val = t.next();
                    if (val < mini) {
                        mini = val;
                    }
                } else
                    break;
            }
            if (count == 0)
                values.addFirst(Integer.MAX_VALUE);
            else if (mini == Integer.MAX_VALUE) {
                values.addFirst(Integer.MAX_VALUE);
            } else {
                values.addFirst(mini + 1);
            }
            if (values.size() > 1000)
                values.removeLast();
            System.out.println("values: " + values + " cursor: " + cursor + " mini " + mini);
            return check(nums, values, cursor - 1);
        }

    }

    public int jump(int[] nums) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        int cursor = nums.length - 1;
        LinkedList<Integer> ret = check(nums, list, cursor);
        return ret.getFirst();
    }

    public int jump2(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;
        
        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Jump2 j = new Jump2();
        // int[] nums = { 2, 3, 0, 1, 4 };
        int[] nums = { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
        // int[] nums = { 1, 2, 3 };
        System.out.println(j.jump2(nums));
    }
}
