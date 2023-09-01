// ע��ʹ��java��api��ʡʱ�䣬�����ظ�������

// �ֵܵ��ʣ�1. ��ϣ���Ա�ÿ��key��value
// 2. ת��Ϊ���飬sort֮���������������ȫһ�������ֵܵ���

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ע�� hasNext �� hasNextLine ������
        String line = in.nextLine();
        String[] words = line.split(" ");
        int length = words.length;
        String x = words[length - 2];
        int n = Integer.parseInt(words[0]);
        int k = Integer.parseInt(words[length - 1]);
        int m = 0;
        List<String> strs = new ArrayList<>();
        for(int i = 1; i < length-2; i++){
            if(isSibling(words[i],x)){
                strs.add(words[i]);
                m++;
            }
        }
        Collections.sort(strs);
        System.out.println(m);
        if(k <= m)
            System.out.print(strs.get(k-1));
    }
    public static boolean isSibling(String str, String pattern){
        if(str.length() != pattern.length() || str.equals(pattern)){
            return false;
        }

        char[] c1 = str.toCharArray();
        char[] c2 = pattern.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }
}