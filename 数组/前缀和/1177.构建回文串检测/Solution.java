// ����117 �������Ĵ����
// ˼·������ǰ׺��+λ����

// �Ӵ��������š�����ͳ��ÿ���Ӵ�ÿ���ַ�����ż״̬�������������/2 < k����ô�϶��ǿ��Ա�Ϊ���ĵġ�
// ͳ��- ����ʹ��ǰ׺�����
// ���ݹ�ģ 10^5�� ǰ׺ 10^5 *26��̫���ˣ�������λ����ʾ

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        int [] sum = new int[s.length()];
        sum[0] = (1 << (s.charAt(0) - 'a'));
        for(int i = 1; i < s.length(); i++){
            int bit =  (1 << (s.charAt(i) - 'a'));
            sum[i] = sum[i-1] ^ bit;
        }
        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == queries[i][1]){
                res.add(true);
                continue;
            }
            int left = queries[i][0];
            int right = queries[i][1];
            int num = 0;
            int bit = sum[right];
            if(left != 0){
                bit = bit ^ sum[left-1];
            }
            for(int j = 0; j < 26; j++){
                if(((bit >> j)&1) == 1){
                    num++;
                }
            }
            if(num / 2 <= queries[i][2]){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
    public static void main(String args[]){
        int [][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        String s = "abcda";
        canMakePaliQueries(s, queries);
        
    }
}