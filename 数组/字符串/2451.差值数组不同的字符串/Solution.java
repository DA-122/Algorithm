// 力扣2451.差值数组不同的字符串
// 思路：先比较0和1
// 0和1不一样，就找2和0和1比较
// 0和1一样，就拿0和后边的比较
public class Solution {
    public String oddString(String[] words) {
        int len = words.length;
        int n = words[0].length();
        int differences[][] = new int [len][n-1];
        for(int i = 0; i < len; i++){
            for(int j = 1; j < n; j++){
                differences[i][j-1] = words[i].charAt(j) - words[i].charAt(j-1);
            }
        }
        boolean isEqual = true;
        for(int i = 0 ; i < n-1; i++){
            if(differences[0][i] != differences[1][i]){
                isEqual = false;
                break;
            }
        }
        String result = words[1];
        if(!isEqual){
            boolean isDiff0 = true;
            for(int i = 0; i < n-1; i++){
                if(differences[0][i] != differences[2][i]){
                    result = words[0];
                    break;
                }
            }
        }else{
            for(int i = 2; i < len; i++){
                for(int j = 0; j < n-1; j++){
                    if(differences[0][j] != differences[i][j]){
                        result =  words[i];
                        break;
                    }
                }
            }
        }
        return result;
    }
}
