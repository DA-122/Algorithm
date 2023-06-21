import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        String queries[] = {"bbb","cc"};
        String words[] = {"a","aa","aaa","aaaa"} ;
        numSmallerByFrequency2(queries, words);
    }

    // 二分处理
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int result[] = new int[queries.length];
        int f_queries[] = new int[queries.length];
        int f_words[] = new int[words.length];
        for(int i = 0; i < queries.length; i++){
            char min = 'z';
            for(char c: queries[i].toCharArray()){
                if(c < min){
                    min = c;
                    f_queries[i] = 1;
                }else if(c > min){
                    continue;
                }else{
                    f_queries[i]++;
                }
            }
        }
        for(int i = 0; i < words.length; i++){
            char min = 'z';
            for(char c: words[i].toCharArray()){
                if(c < min){
                    min = c;
                    f_words[i] = 1;
                }else if(c > min){
                    continue;
                }else{
                    f_words[i]++;
                }
            }
        }
        Arrays.sort(f_words);
        for(int i = 0; i  < queries.length; i++){
            int target = f_queries[i];
            int left = 0, right = words.length-1;
            while(left <= right){
                int mid = left + (right -left) /2;
                if(target >= f_words[mid]){
                    left = mid+1;
                }else if(target < f_words[mid]){
                    right = mid-1;
                }
            }
            result[i] = left+1;
        }
        return result;
    }
    // 后缀和处理
    public static int[] numSmallerByFrequency2(String[] queries, String[] words) {
        int result[] = new int[queries.length];
        int f_queries[] = new int[queries.length];
        int f_words[] = new int[words.length];
        for(int i = 0; i < queries.length; i++){
            char min = 'z';
            for(char c: queries[i].toCharArray()){
                if(c < min){
                    min = c;
                    f_queries[i] = 1;
                }else if(c > min){
                    continue;
                }else{
                    f_queries[i]++;
                }
            }
        }
        for(int i = 0; i < words.length; i++){
            char min = 'z';
            for(char c: words[i].toCharArray()){
                if(c < min){
                    min = c;
                    f_words[i] = 1;
                }else if(c > min){
                    continue;
                }else{
                    f_words[i]++;
                }
            }
        }
        // 记录每个f值的字符串有几个
        int count[]  = new int [12];
        for(int i = 0; i < words.length; i++){
            count[f_words[i]]++;
        }
        for(int i = 9; i >0; i--){
            count[i] = count[i] + count[i+1];
        }
        for(int i = 0; i < result.length; i++){
            result[i] = count[f_queries[i]+1];
        }
        return result;
    }
}