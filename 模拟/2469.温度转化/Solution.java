// ����2469 �¶�ת��
// �����϶�ת��Ϊ���϶Ⱥͻ��϶�
// ���϶� = ���϶� + 273.15
// ���϶� = ���϶� * 1.80 + 32.00
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