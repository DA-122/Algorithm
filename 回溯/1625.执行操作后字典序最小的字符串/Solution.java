// ö�ٻ��߻���
// ��ת����s.length�ξͻ�ѭ�����ۼ�����10�ξͻ�ѭ��
// ���b��ż����ô�����ռ��� n*10��С,���������������n*10*10��С
// ����ж��ֵ���(TreeSet����,���Խ��仯��ķ���TreeSet��)
class Solution {
    public static String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        boolean[] vis = new boolean[n];
        String res = s;
        // �� s �ӳ�һ���������ȡ��ת����ַ��� t
        s = s + s;
        for (int i = 0; !vis[i]; i = (i + b) % n) {
            vis[i] = true;
            for (int j = 0; j < 10; j++) {
                int kLimit = b % 2 == 0 ? 0 : 9;
                for (int k = 0; k <= kLimit; k++) {
                    // ÿ�ν����ۼ�֮ǰ�����½�ȡ t
                    char[] t = s.substring(i, i + n).toCharArray();
                    for (int p = 1; p < n; p += 2) {
                        t[p] = (char) ('0' + (t[p] - '0' + j * a) % 10);
                    }
                    for (int p = 0; p < n; p += 2) {
                        t[p] = (char) ('0' + (t[p] - '0' + k * a) % 10);
                    }
                    String tStr = new String(t);
                    if (tStr.compareTo(res) < 0) {
                        res = tStr;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        String s = "5525";
        System.out.println(findLexSmallestString(s,9,2));
    }
}