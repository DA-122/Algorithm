// 1. 在考试时，有些时候没有给出数据的行数n，对于矩阵，可能行数n和列数m都未给出，本题就是为了训练这类题目的输入。对于给定的一个二维矩阵，请转置后进行输出。
// 分析：未知行列数，转化为字符串读取，分割字符串



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        while(sc.hasNextLine()){
            List<Integer> row = new ArrayList<Integer>();
            String line = sc.nextLine();
            if(line.length() > 0){
                String[] arrLine = line.split(" ");
                for(int i = 0; i < arrLine.length; i++){
                    row.add(Integer.parseInt(arrLine[i]));
                }
                list.add(row);
            }else{
              break;
            }
        }
        for(int i = 0; i < list.get(0).size();i++){
            for(int j = 0; j < list.size(); j++){
                System.out.print(list.get(j).get(i)+" ");
            
            }
            System.out.println("");
        }
      }
}