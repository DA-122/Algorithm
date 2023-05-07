
public class KmpSolution {
    public static int kmp(String S, String P){
        int n = S.length();
        int m = P.length();
        if(n < m){
            return -1;
        }
        int [] next = new int[m+1];
        char[] p = P.toCharArray();
        char[] s = S.toCharArray();
        for(int i = 2, j = 0; i <= m; i++){
            while(j!=0 && p[i-1] != p[j])
                j = next[j];
            if(p[i-1] == p[j])
                j++;
            next[i] = j;
        }
        for(int i = 1, j = 0; i <= n; i++){
            // ²»Æ¥Åä
            while(j!=0 && s[i-1] != p[j]){
                j = next[j];
            }
            if(s[i-1] == p[j])
                j++;
            if(j==m)
                return i-m;
        }
        return -1;
    }
    public static void main(String[] args){
        String S ="caabaabaabaabaaaa";
        String P ="aabaabaaaa";
        System.out.println(kmp(S,P));
    }
}
