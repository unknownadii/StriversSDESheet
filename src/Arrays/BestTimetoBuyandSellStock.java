package Arrays;

public class BestTimetoBuyandSellStock {

    //Time Limit exceed showing on leetcode but giving correct answer
    //0(n^2)
    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int currProfit = 0;
            for (int j = i; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (currProfit < profit) {
                    currProfit = profit;
                }
            }
            if (maxProfit < currProfit) {
                maxProfit = currProfit;
            }
        }
        return maxProfit;
    }

    //O(n)
    public static int maxProfitOptimiszed(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitOptimiszed(arr));
    }
}
