class Solution {
    public int maxProfit(int[] prices) {
        
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;

        int SecondBuy = Integer.MIN_VALUE;
        int SecondSell = 0;

        for(int price : prices){
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            
            SecondBuy = Math.max(SecondBuy , firstSell - price);
            SecondSell = Math.max(SecondSell , SecondBuy + price);
        }
        return SecondSell;
    }
}