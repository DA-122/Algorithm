// n == 100

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<Integer>();
        if(bound == 0){
            return list;
        }
        int a = 0;
        for(int i = 0; a <= bound; i++){
            a = myPow(x,i);
            int b = 1;
            for(int j = 0; a+b <= bound ;j++){
                b = myPow(y,j);
                int sum = a + b;
                if(sum <= bound&& !list.contains(sum)){
                    list.add(sum);
                }
            }
        }
        return list;
    }
    public static int myPow(int num, int p){
        if(p / 2  > 0){
            if(p % 2 == 1){
                return myPow(num*num,p/2)*num;
            }else{
                return myPow(num*num,p/2);
            }
        }else{
            if(p == 1)
                return num;
            else 
                return 1;
        }
    }
    public static void main(String[] args){
        int x = 2;
        int y = 3;
        int bound = 10;
        powerfulIntegers(x, y, bound);
    }

}
