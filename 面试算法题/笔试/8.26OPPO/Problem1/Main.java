// �ַ����Ӵ�Ȩ��֮��
// �ַ���Ȩ�أ� �ַ����а�����'oppo'�Ӵ���
// CASE  oppo Ȩ�� 1 oppoppo Ȩ�غ� 8 

import java.util.Scanner;
import java.util.ArrayList;
// ע����������Ϊ Main, ��Ҫ���κ� package xxx ��Ϣ
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // �����Ӵ�Ȩֵ֮��
        String line = in.nextLine();
        int n = line.length();
        int res = 0;
        // �������OPPO�Ӵ���ʼλ��
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < line.length() - 3; i++){
            if(line.substring(i, i + 4).equals("oppo"))
                list.add(i);
        }
        // ��������
        for (int i = 0; i < list.size(); i++) {
            int weight = i + 1;
            // j���OPPO�ַ����� j+i �Ҳ�OPPO�ַ���
            for (int j = 0; j + i < list.size(); j++) {
                int left = 0, right = 0;
                // �ȼ���� ���Լ�
                if (j == 0) {
                    left = list.get(j);
                } else {
                    left = list.get(j) - list.get(j - 1) - 1;
                }
                // �ټ����Ҳ�
                if (j + i == list.size() - 1) {
                    right = n - (list.get(j + i) + 4);
                } else {
                    right = list.get(j + i + 1) - list.get(j + i) - 1;
                }
                res += (left * right + 1 + left + right) * weight;
            }
        }
        System.out.print(res);
    }
    // ��n�ĸ��Ӷ��ҳ����е�'OPPO'�Ӵ�
    // Ȼ���� ����1��OPPO���Ӵ��� ����2��OPPO���Ӵ� ���� N ��OPPO���Ӵ�
}