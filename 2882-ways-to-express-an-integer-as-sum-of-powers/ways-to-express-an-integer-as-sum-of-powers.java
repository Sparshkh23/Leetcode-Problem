class Solution {
    public int numberOfWays(int n, int x) {
        int mod = 1_000_000_007;

        List<Integer> powers = new ArrayList<>();
        int num = 1;
        while (Math.pow(num, x) <= n) {
            powers.add((int)Math.pow(num, x));
            num++;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1; 
        
        for (int power : powers) {
            for (int i = n; i >= power; i--) {
                dp[i] = (dp[i] + dp[i - power]) % mod;
            }
        }

        return dp[n];
    }
}