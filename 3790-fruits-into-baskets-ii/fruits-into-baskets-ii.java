class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] used = new boolean[baskets.length]; 
        int unplaced = 0; 

        for (int fruit : fruits) {
            boolean placed = false;
            for (int j = 0; j < baskets.length; j++) {
                if (!used[j] && baskets[j] >= fruit) {
                    used[j] = true; 
                    placed = true;
                    break; 
                }
            }
            if (!placed) {
                unplaced++;
            }
        }
        return unplaced;
    }
}