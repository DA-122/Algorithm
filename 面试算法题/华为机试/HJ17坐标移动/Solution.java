import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String pos [] = line.split(";");
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < pos.length; i++){
            if(isValid(pos[i])){
                char dir = pos[i].charAt(0);
                int num = Integer.parseInt(pos[i].substring(1,pos[i].length()));
                if(dir == 'W'){
                    y+=num;
                }else if(dir == 'A'){
                    x-=num;
                }else if(dir == 'S'){
                    y-=num;
                }else{
                    x+=num;
                }
            }
        }
        System.out.println(x+ ","+y);
    }
    public static boolean isValid(String str){
        if(str.length() < 2 || str.length() > 3){
            return false;
        }
        if(str.charAt(0) != 'A' && str.charAt(0) !='W' && str.charAt(0)!='S' && str.charAt(0)!='D'){
            return false;
        }
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) >'9' || str.charAt(i) < '0'){
                return false;
            }
        }
        return true;
    }
}