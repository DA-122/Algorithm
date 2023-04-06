// 1653 ʹ�ַ���ƽ�����Сɾ������
// ˼·����������Ӻ���ǰ,���ĩβԪ����b����ô����ɾ��
// ���ĩβԪ����a����ôѡ��ɾ��a����ɾ��aǰ����bԪ�أ������Ҫ��¼bԪ������
// ���ƹ�ʽ�� dp[i] = Math.min(dp[i-1]+1,cntB[i])
// �����飬�������������ɱ�ʾ
public class Solution {
    // dp 
    public static int minimumDeletionsDp(String s) {
        int ans = 0, cntB =0;
        for(int i =0; i <s.length();i++){
            if(s.charAt(i == 'a')){
                ans = Math.min(ans+1;cntB);
            }else{
                cntB++;
            }
        }
        return ans;
    }
    // ���ָ���ö��, �ָ���ǰɾ��b���ָ��ߺ�ɾ��a
    public static int minimumDeletionsEnum(String s) {
        int cntA = 0, cntB = 0;
        for(char word: s.toCharArray()){
            if(word =='a'){
                cntA++;
            }
        }
        int ans = cntA;
        for(char word: s.toCharArray()){
            if(word=='a'){
                cntA--;
            }else{
                cntB++;
            }
            ans = Math.min(ans,cntA+cntB);
        }
        return ans;
    }
}