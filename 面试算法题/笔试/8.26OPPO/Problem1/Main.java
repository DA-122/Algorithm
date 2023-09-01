// 字符串子串权重之和
// 字符串权重： 字符串中包含的'oppo'子串数
// CASE  oppo 权重 1 oppoppo 权重和 8 

import java.util.Scanner;
import java.util.ArrayList;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 所有子串权值之和
        String line = in.nextLine();
        int n = line.length();
        int res = 0;
        // 存放所有OPPO子串起始位置
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < line.length() - 3; i++){
            if(line.substring(i, i + 4).equals("oppo"))
                list.add(i);
        }
        // 滑动窗口
        for (int i = 0; i < list.size(); i++) {
            int weight = i + 1;
            // j左侧OPPO字符串， j+i 右侧OPPO字符串
            for (int j = 0; j + i < list.size(); j++) {
                int left = 0, right = 0;
                // 先加左边 和自己
                if (j == 0) {
                    left = list.get(j);
                } else {
                    left = list.get(j) - list.get(j - 1) - 1;
                }
                // 再计算右侧
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
    // 以n的复杂度找出所有的'OPPO'子串
    // 然后求 包括1个OPPO的子串， 包括2个OPPO的子串 包括 N 个OPPO的子串
}