// ����2485 �ҳ���������

// x  = sqrt((n^2+n) / 2)

public class Solution {
    public int pivotInteger(int n) {
        int result = (int)(Math.pow(n,2)+n) / 2;
        int s = (int)Math.sqrt(result);
        return s*s == result? s : -1;

    }
}