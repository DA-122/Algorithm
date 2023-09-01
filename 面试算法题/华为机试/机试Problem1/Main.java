import java.util.Scanner;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;


public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        // 套餐数组 需要添加索引列
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
        // 按成本排序，然后按利润排序，然后按索引排序
        Arrays.sort(food, (a,b)->{
            if(a[2] != b[2]){
                return a[2] - b[2];
            }else if(a[3] != b[3]){
                return a[3] - b[3];
            }else{
                return a[0] - b[0];
            }
        });
        // 记录res位置
        int cnt = 0;
        for(int i = 0; i < M&&cnt < NUM; i++){
            int mainId = food[i][1];
            // mainId有限制
            if(mainFood.containsKey(mainId)){
                // 主食充足才能计算
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