class Solution {
    public long kMirror(int base, int count) {
        List<Character> digits = new ArrayList<>();
        digits.add('0'); 
        long sum = 0;

        for (int found = 0; found < count;) {
            digits = nextSymmetric(digits, base);  
            long val = Long.parseLong(toBase10(digits, base)); 
            if (isPalindrome(Long.toString(val))) { 
                sum += val;
                found++;
            }
        }
        return sum;
    }

    private boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s); 
    }

    private String toBase10(List<Character> digits, int base) {
        long val = 0;
        for (char c : digits)
            val = val * base + (c - '0'); 
        return Long.toString(val);
    }

    private List<Character> nextSymmetric(List<Character> digits, int base) {
        int half = digits.size() / 2;
        for (int i = half; i < digits.size(); i++) {
            int d = digits.get(i) - '0';
            if (d + 1 < base) {
                char c = (char) ('0' + d + 1); 
                digits.set(i, c);
                digits.set(digits.size() - 1 - i, c);
                for (int j = half; j < i; j++) {
                    digits.set(j, '0');
                    digits.set(digits.size() - 1 - j, '0'); 
                }
                return digits;
            }
        }
        
        List<Character> next = new ArrayList<>();
        next.add('1');
        for (int i = 1; i < digits.size(); i++) next.add('0');
        next.add('1');
        return next;
    }
}