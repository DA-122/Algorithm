// 力扣2469 温度转化
// 将摄氏度转化为开氏度和华氏度
// 开氏度 = 摄氏度 + 273.15
// 华氏度 = 摄氏度 * 1.80 + 32.00
public class Solution {
    public static double[] convertTemperature(double celsius) {
        double[] ans = new double[2];
        ans[0] = celsius + 273.15;
        ans[1] = celsius*1.80+32.00;
        return ans;
    }
    public static void main(String[] args){
        double celsius = 36.50;
        System.out.println(convertTemperature(celsius));
    }
}