class Solution {
    public char kthCharacter(int k) {
        String word = "a"; 
        
        while (word.length() < k) {
            StringBuilder nextWord = new StringBuilder();
            for (char c : word.toCharArray()) {
                
                nextWord.append(c == 'z' ? 'a' : (char) (c + 1));
            }
            word += nextWord.toString(); 
        }
        
        
        return word.charAt(k - 1);
    }
}