public class Solution {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i = 0; i < dp.length;i++){
            dp[i][dp[0].length-1] = dp.length-i-1;
        }
        for(int i = 0; i < dp[0].length;i++){
            dp[dp.length-1][i] = dp[0].length-i-1;
        }
        for(int i = dp.length-2; i >=0; i--){
            for(int j = dp[0].length-2; j >=0; j--){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] +1;
                }else{
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+1;
                }
            }
        }
        StringBuffer builder = new StringBuffer();
        int i = 0, j = 0;
        while (i < dp.length-1&& j<dp[0].length-1){
            if(str1.charAt(i) == str2.charAt(j)){
                builder.append(str1.charAt(i));
                i++;
                j++;
            }else if(dp[i][j] == dp[i+1][j]+1){
                builder.append(str1.charAt(i));
                i++;
            }else{
                builder.append(str2.charAt(j));
                j++;
            }
        }
        if(i < str1.length()){
            builder.append(str1.substring(i));
        }else if(j < str2.length()){
            builder.append(str1.substring(j));
        }
        return builder.toString();

    }
    public static void main(String[] args){
        String text1 = "abac";
        String text2 = "cab" ;
        System.out.println(shortestCommonSupersequence(text1,text2));
    }

}