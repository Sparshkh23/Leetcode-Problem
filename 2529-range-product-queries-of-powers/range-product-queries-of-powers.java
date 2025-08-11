class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int mod = 1_000_000_007;
        int bit = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                powers.add((int) Math.pow(2, bit));
            }
            n >>= 1;
            bit++;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int product = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                product = (int)((long)product * powers.get(j) % mod);
            }
            result[i] = product;
        }
        return result;
    }
}