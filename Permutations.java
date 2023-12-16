import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Permutations {
    public void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> result, HashMap<Integer, Boolean> map) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                temp.add(nums[i]);
                map.put(nums[i], true);
                backtrack(nums, new ArrayList<Integer>(temp), result, new HashMap<>(map));
                temp.remove(temp.size() - 1);
                map.remove(nums[i]);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            HashMap<Integer, Boolean> map = new HashMap<>();
            temp.add(nums[i]);
            map.put(nums[i], true);
            backtrack(nums, temp, result, new HashMap<>(map));
        }
        return result;

    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        System.out.println(p.permute(new int[] { 1, 2, 3 }).toString());
    }
}
