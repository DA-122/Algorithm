// ����76.��С�����ַ���
// ˼·������˫ָ�� �������� + ��ϣ���洢�ַ�������
// 

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        // ��¼t��ÿ���ַ�δ���ֵĴ���
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        // ��¼t���ж��ٸ��ַ�δ��s�г���
        int remains = t.length();
        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // ���ָ��
        int start =0, end = 0;
        // ��¼��ǰ��С����
        int min = s.length()+1;
        // �������ڱ߽�ָ��
        int left = 0, right = 0;
        while(left < n || remains > 0){
            while(right < n && remains > 0){
                char c = s.charAt(right);
                // ��������ַ� ���ϣ���ַ�����-1
                if(map.containsKey(c)){
                    if(map.get(c) > 0){
                        remains--;
                    }
                    map.put(c,map.get(c)-1);
                }
                right++;
            }
            // remains > 0; ˵���Ҳ���
            if(remains > 0){
                break;
            }else{
                if(right-left < min){
                    start = left;
                    end = right;
                    min = right - left;
                }
                if(map.containsKey(s.charAt(left))){
                    if(map.get(s.charAt(left))>= 0){
                        remains++;
                    }
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
                }
                left++;
            }
        }
        return min==s.length()+1 ? "":s.substring(start,end);
    }
    public static void main(String [] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
}
