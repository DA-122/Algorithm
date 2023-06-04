// ����93.��ԭIP��ַ
// ˼·���������ݷ�+��֦���Ƚϸ���

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() > 12 || s.length() < 4){
            return list;
        }
        backtracing(list,s,new StringBuffer(), 0, 1);
        return list;
    }
    // curָ���ַ���s���ַ�λ��
    // StringBuffer��ԭip��ַ
    // ip_numָʾ��ǰ��ip�ڼ���
    public static void backtracing(List<String> list, String s,StringBuffer buffer, int cur,int ip_num){
        if(ip_num == 4){
            String ip = s.substring(cur);
            if(isValid(ip)){            
                buffer.append(ip);
                list.add(buffer.toString());
            }
            return;
        }
        
        for(int i = cur; i < cur + 3; i++){
            buffer.append(s.charAt(i));
            // ���ʣ��ĳ��ȴ���ʣ��ip���������ַ�����˵�����ڵ�ip��Ӧ�ü������ӡ�
            if(s.length() - i - 1 > 3 * (4 - ip_num))
                continue;
            // ���ʣ�µĳ��Ȳ�����֧��4��ip����������
            if(s.length() - i - 1 < 4 - ip_num){
                break;
            }
            if(isValid(s.substring(cur,i+1))){
                buffer.append('.');
                backtracing(list,s,new StringBuffer(buffer.toString()),i+1,ip_num+1);
                // ɾ��'.''
                buffer.deleteCharAt(buffer.length()-1);
            }else{
                break;
            }
        }
    }
    // ������һλip�Ƿ�Ϸ�
    public static boolean isValid(String str){
        // �Ƿ�ip > 255 ������ǰ��0
        if(Integer.parseInt(str) > 255 || (str.charAt(0) == '0' && str.length() > 1)){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        String ip = "0000";
        List<String> list =  restoreIpAddresses(ip);
        for(String str : list ){
            System.out.println(str);
        }
    }
}
