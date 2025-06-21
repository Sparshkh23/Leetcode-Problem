public class Solution 
{
    public int minimumDeletions(String word, int k) 
    {
        int[] count = new int[26];
        for (char c : word.toCharArray()) 
        {
            count[c - 'a']++;
        }

        List<Integer> freqs = new ArrayList<>();
        for (int c : count) 
        {
            if (c > 0) freqs.add(c);
        }

        Collections.sort(freqs);
        int n = freqs.size();

        int[] prefix = new int[n + 1]; 
        for (int i = 0; i < n; i++) 
        {
            prefix[i + 1] = prefix[i] + freqs.get(i);
        }

        int total = prefix[n]; 
        int minDeletions = Integer.MAX_VALUE;

       
        for (int i = 0; i < n; i++) 
        {
            int target = freqs.get(i);
            int maxAllowed = target + k;

     
            int left = i;
            int right = n;
            while (left < right) 
            {
                int mid = (left + right) / 2;
                if (freqs.get(mid) <= maxAllowed) 
                {
                    left = mid + 1;
                }
                else 
                {
                    right = mid;
                }
            }
            int j = left;

            int deleteBelow = prefix[i]; 
            int deleteAbove = total - prefix[j] - (maxAllowed * (n - j)); 

            int deletions = deleteBelow + deleteAbove;

           
            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }
}