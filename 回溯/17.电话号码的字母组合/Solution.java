// 17.�绰�������ĸ���
// ˼·������������BFS��Ҫ��εı������Ԫ�أ������һ�����У��������ù�ϣ�����洢���ֺ���ĸ��Ӧ��ϵ

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Solution {
    // ��1�� ����BFS
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("");
        for(char word: digits.toCharArray()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String s = queue.poll();
                if(word == '7'){
                    for(int j = 0; j < 4; j++){
                        char c = (char)((word - '2')*3 + 'a' + j);
                        String str = s + c;
                        queue.offer(str);
                    }
                }else if(word =='8'){
                    for(int j = 0; j < 3; j++){
                        char c = (char)('t' + j);
                        String str = s + c;
                        queue.offer(str);
                    }
                }else if(word == '9'){
                    for(int j = 0; j < 4; j++){
                        char c = (char)('w' + j);
                        String str = s + c;
                        queue.offer(str);
                    }
                }else{
                    for(int j = 0; j < 3; j++){
                        char c = (char)((word - '2')*3 + 'a' + j);
                        String str = s + c;
                        queue.offer(str);
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            ans.add(queue.poll());
        }
        return ans;
    }
    // ��2 ����
    static Map<Character,String> map = new HashMap<Character,String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    static List<String> combinations = new ArrayList<String>();
    public static List<String> letterCombinations2(String digits) {
        backtracing(0, digits, new StringBuffer());
        return combinations;
    }
    public static void backtracing(int index, String digits,StringBuffer buffer){
        if(index == digits.length()){
            combinations.add(buffer.toString());
            return;
        }
        String alpha = map.get(digits.charAt(index));
        for(char word: alpha.toCharArray()){
            buffer.append(word);
            backtracing(index+1, digits, buffer);
            buffer.deleteCharAt(index);
        }
    }


    public static void main(String[] args){
        String digits = "7";
        letterCombinations(digits);
    }
}
