// ����3. ���ظ��ַ�����Ӵ�
// ˼·�������������ڣ���ϣ���¼�ַ�λ��
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int left = 0;
        int right = 1;
        int max = 1;
        Map<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        while(right < s.length()){
            // ��ǰ�ظ��ַ���map value����left�����ظ�
            if(map.containsKey(s.charAt(right))&& map.get(s.charAt(right))>=left){
                max = Math.max(max,right - left);
                left = map.get(s.charAt(right))+1;            
            }                
            map.put(s.charAt(right),right);
            right++;
        }
        max = Math.max(max,right - left);
        return max;
    }
}