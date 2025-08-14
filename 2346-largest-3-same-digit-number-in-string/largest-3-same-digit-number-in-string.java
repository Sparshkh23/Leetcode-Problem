class Solution {
    public String largestGoodInteger(String num) {
        String largest = ""; 
        
        for (int i = 0; i <= num.length() - 3; i++) {
            String substring = num.substring(i, i + 3);
            
            if (substring.charAt(0) == substring.charAt(1) && substring.charAt(1) == substring.charAt(2)) {
                
                if (largest.compareTo(substring) < 0) {
                    largest = substring;
                }
            }
        }
        
        return largest;
    }
}