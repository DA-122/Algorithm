// 483.�ҵ��ַ�����������ĸ��λ��
// ���ݹ�ģ 3 * 10 ^ 4 
// �϶�����ʹ������+equals�ķ�����
// ����ʹ�û������� + ��ϣ�ķ���
// 1. ������ϣ+�������ڣ�ʱ�临�Ӷ� O((m-n)*n)���ռ临�Ӷ� O��1��
// 2. һ����ϣ+��ֵ ʱ�临�Ӷ� O(m+n)

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