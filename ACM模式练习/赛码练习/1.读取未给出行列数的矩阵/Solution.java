// 1. �ڿ���ʱ����Щʱ��û�и������ݵ�����n�����ھ��󣬿�������n������m��δ�������������Ϊ��ѵ��������Ŀ�����롣���ڸ�����һ����ά������ת�ú���������
// ������δ֪��������ת��Ϊ�ַ�����ȡ���ָ��ַ���



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