/*
С����ϲ�����֣�����С�����С��һ���ַ�����
  ����ַ���ֻ������д��Сд��ĸ�� 
  ����֪��������CapsLock���������л���Сдģʽ��
  ������Сдģʽʱ��ͬʱ����shift+��ĸ��������д����д��ĸ��
  �ڴ�дģʽ��ʱ�򣬰���shift+��ĸ��������д��Сд��ĸ��
  �����������ˣ�����һ���ַ�������������ʹ�ö��ٸ��������Ϳ���д������ַ����أ�
  ע�⣬��shift����ĸ���������ΰ�������ʼʱ��ΪСд״̬��
*/

// �����������int����ʹ��nextInt��Ҫ���У�������sc.nextLine()�����л��У������ֱ���˳���ȡ
// nextInt���Խ��տո񣬵����ܽ��ջس�


// ˼·��������̬�滮
// small  ��ǰ����״̬Ϊsmall�ұ���small�����ַ���
// big   ��ǰ����״̬Ϊbig�ұ���big�����ַ���

// ��ǰ�ַ�Сд���ұ���Сд״̬ small =  small + 1 | big + caps + 1
// ��ǰ�ַ�Сд���ұ��ִ�д״̬ big = big + shift + 1  | small + caps + 1
// ��ǰ�ַ���д���ұ���Сд״̬ small = small + shift + 1 |  big+ caps + 1
// ��ǰ�ַ���д���ұ��ִ�д״̬ big = big + 1| small + caps + 1

// ��ʼ��: ��ʼ״̬��small ���� small = 0, big = 1;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int size = Integer.parseInt(sc.nextLine());
      for(int i = 0; i < size; i++){
        String s = sc.nextLine();
        int big = 1;
        int small = 0;
        for(int j = 0; j < s.length(); j++){
          if(s.charAt(j) >= 'a'&& s.charAt(j) <= 'z'){
            // ������ֱ����small = ... big�����õ�small
            int val1 = Math.min(small+1,big+2);
            int val2 = Math.min(big+2,small+2);
            small = val1;
            big = val2;
          }else{
            int val1 = Math.min(small+2,big+2);
            int val2 = Math.min(big+1,small+2);
            small = val1;
            big = val2;
          }
        }
        System.out.println(Math.min(big,small));
      }
    }
}