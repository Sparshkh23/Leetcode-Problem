import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) nums.add((double) card);
        return helper(nums);
    }

    private boolean helper(List<Double> nums) {
        if (nums.size() == 1) return Math.abs(nums.get(0) - 24) < 1e-6;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;

                List<Double> nextRound = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) nextRound.add(nums.get(k));
                }

                for (double result : compute(nums.get(i), nums.get(j))) {
                    nextRound.add(result);
                    if (helper(nextRound)) return true;
                    nextRound.remove(nextRound.size() - 1);
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (b != 0) results.add(a / b);
        if (a != 0) results.add(b / a);
        return results;
    }
}