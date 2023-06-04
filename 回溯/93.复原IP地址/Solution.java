// 力扣93.复原IP地址
// 思路分析：回溯法+剪枝，比较复杂

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
    // cur指向字符串s中字符位置
    // StringBuffer复原ip地址
    // ip_num指示当前是ip第几段
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
            // 如果剩余的长度大于剩下ip所需的最大字符数，说明现在的ip段应该继续增加。
            if(s.length() - i - 1 > 3 * (4 - ip_num))
                continue;
            // 如果剩下的长度不足以支持4段ip，就跳出。
            if(s.length() - i - 1 < 4 - ip_num){
                break;
            }
            if(isValid(s.substring(cur,i+1))){
                buffer.append('.');
                backtracing(list,s,new StringBuffer(buffer.toString()),i+1,ip_num+1);
                // 删掉'.''
                buffer.deleteCharAt(buffer.length()-1);
            }else{
                break;
            }
        }
    }
    // 检验这一位ip是否合法
    public static boolean isValid(String str){
        // 非法ip > 255 或者有前置0
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
