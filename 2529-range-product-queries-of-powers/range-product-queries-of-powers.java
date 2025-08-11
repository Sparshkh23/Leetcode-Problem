class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1_000_000_007;
        List<Integer> powers = new ArrayList<>();
        int bit = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                powers.add((int) Math.pow(2, bit));
            }
            n >>= 1;
            bit++;
        }
        int[] prefixProduct = new int[powers.size()];
        prefixProduct[0] = powers.get(0);
        for (int i = 1; i < powers.size(); i++) {
            prefixProduct[i] = (int)((long)prefixProduct[i - 1] * powers.get(i) % mod);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if (start == 0) {
                result[i] = prefixProduct[end];
            } else {
                result[i] = (int)((long)prefixProduct[end] * modInverse(prefixProduct[start - 1], mod) % mod);
            }
        }
        return result;
    }
    private int modInverse(int a, int mod) {
        return power(a, mod - 2, mod);
    }
    private int power(int a, int b, int mod) {
        long result = 1;
        long base = a;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            b >>= 1;
        }
        return (int) result;
    }
}