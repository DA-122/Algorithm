import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double threshold = Double.parseDouble(sc.nextLine());
        String DNA1 = sc.nextLine();
        String DNA2 = sc.nextLine();
        sc.close();
        double same = 0;
        int total = DNA1.length();
        for(int i = 0; i < DNA1.length();i++){
            if(DNA1.charAt(i) == DNA2.charAt(i)){
                same++;
            }
        }
        if(same/total >= threshold){
            System.out.print("yes");
        }else{
            System.out.print("no");

        }
    }
}