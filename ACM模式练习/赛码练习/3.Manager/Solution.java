
// 思路：排序
// 从大到小


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution{  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int k = Integer.parseInt(sc.nextLine());
    int[] employee = new int[k];
    long ans = 0;
    for(int i = 0; i < k; i++){
      employee[i] = sc.nextInt();
    }
    Arrays.sort(employee);
    ans+= employee[k-1];
    for(int i = k-2; i >=0; i--){
      if(employee[i] >= employee[i+1]){
        employee[i] = employee[i+1] -1;
        if(employee[i] <= 0){
          break;
        }
      }
      ans+= employee[i];
    }
    System.out.print(ans);
  }
}