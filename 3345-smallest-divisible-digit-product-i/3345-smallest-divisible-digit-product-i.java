class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int product = digit(n);
            if(product % t == 0)return n;
            n++;
        }
    }
    private int digit(int nums){
        int product = 1;
        while(nums>0){
            product *= nums%10;
            nums /= 10;
        }
        return product;
    }
}