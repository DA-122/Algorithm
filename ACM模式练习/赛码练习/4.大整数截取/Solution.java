/* 
 * ������һ�����������ִ���������̫���ˣ�û�а취�������������������ȡ����һ�α���������
 * ������ϣ����ȡ��������һ������1000000007ȡģ֮�����Ai������֪���ж����ֽ�ȡ������
 * ���ִ�S�н�ȡһ����ָS[L], S[L+1], ��, S[R]���������γɵ�ʮ��������
 * ����L��R����1��L��R��|S|������S=��1023456789����S(1,2)=10��S(2,4)=23��S(2,10)=23456789��
*/
// ����
// ��һ��һ�����ִ������Ȳ�����30000��
// �ڶ���һ����T����ʾѯ�ʵ���������T��100��
// ������T�У�ÿ��һ���Ǹ�����Ai����ʾѯ���ж����ֽ�ȡ����ʹ����ֵģ1000000007�����Ai����0��Ai<1000000007��

// ���
// ��T�У�ÿ��һ���Ǹ���������ʾ��������

// ˼·�������ݹ飬��Ϊ����������ֱ�������������ȶ���1
// ���Ӷ�Ϊn^2
import java.util.HashMap;
import java.util.Scanner;

import java.util.Map;;

public class Solution{
    static Map<Integer,Integer> map = new HashMap();

    public static void main(String[] args){
        int MOD = 1000000007;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int queryNum = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < queryNum; i++){ 
            int num = Integer.parseInt(sc.nextLine());
            map.put(num,0);
        }
        for(int i = 0; i < str.length(); i++){

        }
    }
    public static int division(String left, String right){
        if(left.length() == 1 && right.length() == 1){
            int r = Integer.parseInt(right);
            int l = Integer.parseInt(left);
            map.put(r, map.getOrDefault(r,0)+1);
            map.put(l, map.getOrDefault(l,0)+1);
            return l*10 + r;
        }
        int l = 0;
        int r = 0;
        if(left.length() == 1){
            l = Integer.parseInt(left);
            map.put(l, map.getOrDefault(l,0)+1);
        }else{
            int mid = left.length() / 2;
            l = division(left.substring(0, mid), left.substring(mid));
        }

        if(right.length() == 1){
            r = Integer.parseInt(right);
            map.put(r, map.getOrDefault(r,0)+1);
        }else{
            int mid = right.length() / 2;
            l = division(right.substring(0, mid), right.substring(mid));
        }
        return l + r;
    }
}