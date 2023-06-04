// ����1156.���ַ��ظ��Ӵ�����󳤶�
// ˼·��������������

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int maxRepOpt1(String text) {
        int n = text.length();
        Map<Character,Integer> map= new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(text.charAt(i),map.getOrDefault(text.charAt(i),0)+1);
        }
        int res = 0;
        for(int i  = 0; i < n;){
            int r = i;
            // �ҵ�������
            while(r < n && text.charAt(r) == text.charAt(i)){
                r++;
            }
            int cur = r - i;
            if(cur  < map.getOrDefault(text.charAt(i),0) && (r < n || i > 0)){
                res = Math.max(res,cur+1);
            }
            // �ҵڶ���
            int k = r + 1;
            while(k < n && text.charAt(k) == text.charAt(i)){
                k++;
            }
            // k - i���ǵڶ���+��һ�εĳ���
            // �Ը��ַ��������� k - i�Ա�
            // ���k-iС����ô���Թ���k - i ����ֻ�ܹ��� k - i
            res = Math.max(res, Math.min(k-i,map.getOrDefault(text.charAt(i),0)));
            i = r;
        }
        return res;
    }
    public static void main(String[] args){
        String text = "bbababaaaa";
        System.out.print(maxRepOpt1(text));
    }
}