// 483.找到字符串中所有字母异位词
// 数据规模 3 * 10 ^ 4 
// 肯定不能使用排序+equals的方法了
// 可以使用滑动窗口 + 哈希的方法
// 1. 两个哈希+滑动窗口，时间复杂度 O((m-n)*n)；空间复杂度 O（1）
// 2. 一个哈希+差值 时间复杂度 O(m+n)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if( m < n){
            return res;
        }

        int [] alphas = new int[26];
        int [] targets = new int[26];
        for(char c: p.toCharArray()){
            alphas[c - 'a']++;
        }
        for(int i = 0; i < p.length(); i++){
            targets[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(alphas,targets)){
            res.add(0);
        }
        for(int i = n; i < m; i++){
            targets[s.charAt(i-n) - 'a']--;
            targets[s.charAt(i) - 'a']++;
            if(Arrays.equals(alphas,targets)){
                res.add(i-n+1);
            }
        }
        return res;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if( m < n){
            return res;
        }
        int [] alphas = new int[26];
        int diff = 0;;
        for(int i = 0; i < p.length(); i++){
            alphas[p.charAt(i)-'a']++;
            alphas[s.charAt(i)-'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(alphas[i] != 0){
                diff++;
            }
        }
        if(diff == 0){
            res.add(0);
        }
        for(int i = n; i < m; i++){
            if(alphas[s.charAt(i-n) - 'a'] == -1){
                diff--;
            }else if(alphas[s.charAt(i-n) - 'a'] == 0){
                diff++;
            }
            alphas[s.charAt(i-n) - 'a']++;
            if(alphas[s.charAt(i) - 'a'] == 1){
                diff--;
            }else if(alphas[s.charAt(i) - 'a'] == 0){
                diff++;
            }
            alphas[s.charAt(i) - 'a']--;
            if(diff == 0){
                res.add(i - n + 1);
            }
        }
        return res;
    }
}