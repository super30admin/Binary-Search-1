class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length+1][amount+1];
        int result;
        dp[0][0]= 0;
        for (int j=1;j<amount+1; j++){
            dp[0][j]= amount+1;
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(coins[i-1]> j ){
                    dp[i][j]= dp[i-1][j];
                }
                else{
                    dp[i][j]= Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        result= dp[dp.length-1][dp[0].length-1];
        if(result> amount) return -1;
        else return result;
    }
}
