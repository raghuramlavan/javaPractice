import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class CombinationSum2 {

    public void backtrack(int[] candidates, int target, LinkedList<Integer> temp, List<List<Integer>> result,
            int index) {
        if (target == 0) {
            ArrayList<Integer> temp1 = new ArrayList<>(temp);
            temp1.sort(null);
            if (!result.contains(temp1)) {
                result.add(temp1);
                // System.out.println("temp: " + temp + " result: " + result + " index: " +
                // candidates[index - 1]);
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                temp.add(candidates[i]);
                backtrack(candidates, target - candidates[i], temp, result, i + 1);
                temp.removeLast();
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], temp, result, i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        CombinationSum2 cs = new CombinationSum2();
        int target = 5;
        int[] candidates = { 2, 5, 2, 1, 2 };
        System.out.println(cs.combinationSum2(candidates, target));
    }
}