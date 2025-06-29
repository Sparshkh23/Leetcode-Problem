class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = (int)(1e9 + 7);
        int n = nums.length;
        int[] power = new int[n];
        
        
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        
        Arrays.sort(nums);
        
        int left = 0, right = n - 1, count = 0;
        
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count = (count + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        
        return count;
    }
}