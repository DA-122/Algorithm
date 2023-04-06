// 1683
public class Solution {
    // 暴力解法
    public static int countSubstrings(String s, String t) {
        int ans = 0;
        int k = Math.min(s.length()-1,t.length()-1);
        for(int gap = k ; gap >= 0; gap--){
            for(int i = 0 ; i+gap < s.length(); i++){
                for(int j =0; j+gap < t.length();j++){
                    int counter = 0;
                    for(int m = 0; m <= gap; m++){
                        if(s.charAt(i+m)!=t.charAt(j+m))
                            counter++;
                    }
                    if(counter == 1)
                        ans++;
                }
            }
        }
        return ans;
    }
    // dp解法
    public static int countSubstringsDp(String s, String t) {
        int[][] dpl = new int[s.length()+1][t.length()+1];
        int[][] dpr = new int[s.length()+1][t.length()+1];
        int ans = 0;
        for(int i = 1; i< dpl.length;i++){
            for(int j = 1; j < dpl[0].length; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dpl[i][j] = dpl[i-1][j-1]+1;
                }
            }
        }
        for(int i = dpr.length-2; i >= 0 ;i--){
            for(int j = dpr[0].length-2; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dpr[i][j] = dpr[i+1][j+1]+1;
                }
            }
        }
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < t.length(); j++){
                if(s.charAt(i) != t.charAt(j)){
                    ans+=(dpl[i][j]+1)*(dpr[i+1][j+1]+1);
                }
            }
        }
        return ans;
    }
    public static void main(String [] args){
        String s = "aba";
        String t = "baba";
        System.out.println(countSubstrings(s,t));
    }
}