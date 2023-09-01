// 2600. k件物品的最大和
// 思路分析： 简答分支 
public class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int res = 0;
        if(k <= numOnes){
            res = k;
        }else if(k <= numOnes+numZeros){
            res = numOnes;
        }else if(k <= numNegOnes + numZeros + numOnes){
            res = numOnes - (k - numOnes - numZeros);
        }else{
            res = numOnes - numNegOnes;
        }
        return res;

    }
}