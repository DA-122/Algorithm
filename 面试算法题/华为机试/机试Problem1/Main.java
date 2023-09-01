import java.util.Scanner;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;


public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        // �ײ����� ��Ҫ���������
        int food[][] = new int[M][4];
        for(int i = 0; i < M; i++){
            food[i][0] = i;
            for(int j = 1; j < 4; j++){
                food[i][j] = in.nextInt();
            }
        }
        Map<Integer,Integer> mainFood = new HashMap<>();
        int N = in.nextInt();
        for(int i = 0; i < N; i++){
            int id = in.nextInt();
            int num = in.nextInt();
            mainFood.put(id,num);
        }
        int NUM = in.nextInt();
        int res[] = new int[NUM];
        // ���ɱ�����Ȼ����������Ȼ����������
        Arrays.sort(food, (a,b)->{
            if(a[2] != b[2]){
                return a[2] - b[2];
            }else if(a[3] != b[3]){
                return a[3] - b[3];
            }else{
                return a[0] - b[0];
            }
        });
        // ��¼resλ��
        int cnt = 0;
        for(int i = 0; i < M&&cnt < NUM; i++){
            int mainId = food[i][1];
            // mainId������
            if(mainFood.containsKey(mainId)){
                // ��ʳ������ܼ���
                if(mainFood.get(mainId) > 0){
                    res[cnt++] = food[i][0];
                    mainFood.put(mainId,mainFood.get(mainId)-1);
                }
            }else{
                res[cnt++] = food[i][0];
            }
        }
        Arrays.sort(res);
        if(cnt < NUM){
            System.out.println(-1);
        }else{
            for(int i = 0; i < NUM - 1; i++){
                System.out.print(res[i] + " ");
            }
            System.out.print(res[NUM-1]);
        }
    }
}