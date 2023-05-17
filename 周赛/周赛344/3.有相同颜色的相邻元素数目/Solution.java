// 数据规模 10^5
// 模拟 复杂度O(N)
class Solution {
    public static int[] colorTheArray(int n, int[][] queries) {
        if(n == 1){
            return new int[queries.length];
        }
        int[] nums = new int[n];
        int totalOp = queries.length;
        int[] answer = new int[totalOp];
        nums[queries[0][0]] = queries[0][1];
        for(int  i = 1; i < totalOp; i++){
            int color = queries[i][1];
            int pos = queries[i][0];
            answer[i] = answer[i-1];
            if(nums[pos] == color){
                continue;
            }
            // 未被染色，不会减少
            // 被染色，会减少
            if(nums[pos]!=0){
                if(pos == 0&&nums[pos] == nums[pos+1] || pos==n-1 && nums[pos] == nums[pos-1]){
                    answer[i]--;
                }
                if(pos < n -1 && pos >0){
                    if(nums[pos] == nums[pos-1]){
                        answer[i]--;
                    }
                   if(nums[pos] == nums[pos+1]){
                        answer[i]--;
                    }
                }
            }
            nums[pos] = color;
            if(pos == 0&&nums[pos] == nums[pos+1] || pos==n-1 && nums[pos] == nums[pos-1]){
                answer[i]++;
            }
            if(pos < n -1 && pos >0){
                if(nums[pos] == nums[pos-1]){
                    answer[i]++;
                }
               if(nums[pos] == nums[pos+1]){
                    answer[i]++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int n =4;
        int queries[][] = {{0,2},{1,2},{3,1},{1,1},{2,1}};
        colorTheArray(n, queries);
    }
}
