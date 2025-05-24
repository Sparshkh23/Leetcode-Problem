class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        for(int i=0;i<bits.length;i++){
            if(bits[i] == 1){
                if(i+2>n-1){
                    return false;
                }
                i = i+1;
            }else{
                if(i == n-1){
                    return true;
                }
            }
        }
        return false;
    }
}