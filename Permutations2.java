import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Permutations2 {
    public void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> result, HashMap<Integer, Integer> map) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        System.out.println("temp: " + temp + " map: " + map);
        for (int i = 0; i < nums.length; i++) {

            if (map.get(nums[i]) != 0) {
                temp.add(nums[i]);
                map.put(nums[i], map.get(nums[i]) - 1);
                backtrack(nums, new ArrayList<Integer>(temp), result, new HashMap<>(map));
                temp.remove(temp.size() - 1);

            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }

        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            HashMap<Integer, Integer> map1 = new HashMap<>(map);
            temp.add(nums[i]);
            map1.put(nums[i], map1.get(nums[i]) - 1);
            backtrack(nums, temp, result, new HashMap<>(map1));
        }

        return result;
    }

    public static void main(String[] args) {
        Permutations2 p = new Permutations2();
        System.out.println(p.permuteUnique(new int[] { 1, 3, 2 }).toString());
    }

}
