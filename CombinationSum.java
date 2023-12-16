import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    int[] candidates;
    public List<List<Integer>> result;

    public void backtrack(int target, LinkedList<Integer> x) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<>(x);
            temp.sort((a, b) -> a - b);
            if (!result.contains(temp))
                result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            // System.out.println("target: " + target + " candidates[i]: " + candidates[i]);
            if (target - candidates[i] >= 0) {
                x.add(candidates[i]);
                backtrack(target - candidates[i], x);
                x.removeLast();
            }
        }
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        this.result = new ArrayList<>();
        this.candidates = candidates;
        for (int i = 0; i < candidates.length; i++) {
            LinkedList<Integer> x = new LinkedList<>();
            x.add(candidates[i]);
            this.backtrack(target - candidates[i], x);
        }
        return result;
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int target = 8;
        System.out.println(cs.combinationSum1(new int[] { 2, 3, 5 }, target));
    }

}

/*
 * int[] candidates;
 * public List<List<Integer>> result;
 * 
 * public void backtrack(int target, LinkedList<Integer> x) {
 * if (target == 0) {
 * ArrayList<Integer> temp = new ArrayList<>(x);
 * temp.sort((a, b) -> a - b);
 * if (!result.contains(temp))
 * result.add(new ArrayList<>(temp));
 * return;
 * }
 * for (int i = 0; i < candidates.length; i++) {
 * // System.out.println("target: " + target + " candidates[i]: " +
 * candidates[i]);
 * 
 * if (target - candidates[i] >= 0) {
 * x.add(candidates[i]);
 * backtrack(target - candidates[i], x);
 * x.removeLast();
 * }
 * }
 * }
 * 
 * public List<List<Integer>> combinationSum(int[] candidates, int target) {
 * this.result = new ArrayList<>();
 * this.candidates = candidates;
 * for (int i = 0; i < candidates.length; i++) {
 * LinkedList<Integer> x = new LinkedList<>();
 * x.add(candidates[i]);
 * this.backtrack(target - candidates[i], x);
 * }
 * return result;
 * }
 */