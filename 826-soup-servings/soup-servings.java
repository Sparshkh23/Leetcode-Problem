import java.util.HashMap;
import java.util.Map;

class Solution {
    public double soupServings(int n) {
        if (n >= 4800) return 1.0;

        n = (int) Math.ceil(n / 25.0);

        Map<String, Double> memo = new HashMap<>();

        return helper(n, n, memo);
    }

    private double helper(int a, int b, Map<String, Double> memo) {
        // Base cases
        if (a <= 0 && b > 0) return 1.0; 
        if (b <= 0 && a > 0) return 0.0; 
        if (a <= 0 && b <= 0) return 0.5;

        String key = a + "," + b;
        if (memo.containsKey(key)) return memo.get(key);

        double result = 0.25 * (helper(a - 4, b, memo) + helper(a - 3, b - 1, memo) +
                                helper(a - 2, b - 2, memo) + helper(a - 1, b - 3, memo));

        memo.put(key, result);

        return result;
    }
}