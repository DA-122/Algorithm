/*
小明很喜欢打字，今天小红给了小明一个字符串。
  这个字符串只包含大写和小写字母。 
  我们知道，按下CapsLock键，可以切换大小写模式。
  我们在小写模式时候，同时按下shift+字母键，就能写出大写字母。
  在大写模式的时候，按下shift+字母键，就能写出小写字母。
  现在问题来了，给你一个字符串，问你最少使用多少个按键，就可以写出这个字符串呢？
  注意，按shift和字母键，算两次按键。开始时均为小写状态。
*/

// 读数据如果有int类型使用nextInt需要换行，可以用sc.nextLine()来进行换行，否则会直接退出读取
// nextInt可以接收空格，但不能接收回车


// 思路分析：动态规划
// small  当前输入状态为small且保持small所需字符数
// big   当前输入状态为big且保持big所需字符数

// 当前字符小写，且保持小写状态 small =  small + 1 | big + caps + 1
// 当前字符小写，且保持大写状态 big = big + shift + 1  | small + caps + 1
// 当前字符大写，且保持小写状态 small = small + shift + 1 |  big+ caps + 1
// 当前字符大写，且保持大写状态 big = big + 1| small + caps + 1

// 初始化: 初始状态是small 所以 small = 0, big = 1;
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
            // 不可以直接用small = ... big还会用到small
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