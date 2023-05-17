
//˼·������ 1. �����ⷨ����1��n������ת���ɶ������ַ��������Ƿ���s�Ӵ�
// 2. ����s�����Ӵ������뵽��ϣ���У���󿴹�ϣ�����Ƿ�Ϊn


// ��ѧ�Ƶ�������Ϊk + 1�Ķ��������ܹ��� 2^k��,��Щ�������������һ���ַ������Ӵ�����ʾ�����ַ�������m ����Ϊ k + 1 + 2^k -1(��������);
// ����n�Ķ����Ƴ�����k+1��
// (1)����[2^k,n]�ڵĶ����Ƴ���Ϊk+1���ܹ���n-2^k+1��,Ӧ���� m>=k+1+(n-2^k+1-1) = n-2^k+k+1
// (2)����[2^(k-1),2^k-1]�ڵĶ����Ƴ���Ϊk���ܹ���2^(k-1)��,Ӧ���� m>=k+(2^(k-1)-1)
// (3)���ڱ������������С��������˵���������������������������ַ����У���ôС�������ͨ�����Ƶõ���Ҳһ����s��
// ��������n = 1ʱ, k = 0������(2)�����ڣ����ֱ���ж�s�Ƿ����1
// Ҳ����˵����n��s,s.length = m
// ��� m < max(n-2^k+k+1,2^(k-1)+k-1), m�Ӵ��϶��޷���ʾ[1,n]�ڵ��������֣���˿���ֱ�ӷ���false


// ������ m<=1000�� n-1024+10+1 > 1000,��n> 2013ʱ����ֱ�ӷ���false
// max(n-2^k+k+1,2^(k-1)+k-1)��Լʱ n/2�����n > 2m�Ϳ��Է���false
// ���˼·һ��������2m��


// ˼·�� ����n��m�Ĺ�ϵ���㷨1���м�֦���ó���Ϊk�Ļ������ڣ��ж������������Ƿ���ڼ��ɡ�
// ʱ�临�Ӷ�O(m),�ռ临�Ӷ�O(min(m,n))

import java.util.HashSet;
import java.util.Set;

public class Solution{
    // 1. ����ת�ַ���
    public static boolean queryString1(String s, int n) {
        for(int i = 1; i <= n; i++){
            if(!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return true;
    }
    // 2.���������Ӵ�
    public static boolean queryString2(String s, int n) {
        Set<Integer> set =new HashSet<>();
        char[] array = s.toCharArray();

        for(int i = 0; i < array.length; i++){
            int x = array[i] - '0';
            if(x == 0){
                continue;
            }
            // ��֦
            for(int j = i + 1; x<=n; j++){
                set.add(x);
                if(j == array.length){
                    break;
                }
                if(array[j] - '0' == 0){
                    x = x << 1;
                }else{
                    x = (x << 1) + 1;
                }
            }
        }
        return set.size() == n;
    }
    // 3.��֦����1
    public static boolean queryString3(String s, int n) {
        if(n == 1){
            return s.contains("1");
        }
        // n�Ķ����Ƴ���-1
        int k = 31 - Integer.numberOfLeadingZeros(n);
        if(s.length()<Math.max(n-(1<<k)+k+1,(1<<(k-1)+k-1))){
            return false;
        }
        // ��������ֱ��ж�
        return check(s,k, n/2+1, (1<<k)-1)&& check(s,k+1,1<<k, n);
    }
    // �ж�s�Ӵ��Ƿ��г���Ϊk����[lower,upper]��Χ�ڵĶ�������
    // kλ��ʾ 2^(k-1) - 2^k-1
    public static boolean check(String s, int k, int lower, int upper){
        if(lower > upper){
            return true;
        }
        Set<Integer> set = new HashSet<>();
        int mask = (1 << (k-1) -1) ;    // 2^(k-1)-1 k��1  mask&x�����ڸǵ�x�����λ
        int x  = Integer.parseInt(s.substring(0, k-1),2);
        for(int i = k-1; i < s.length(); i++){
            x = ((x&mask) << 1) + s.charAt(i) - '0';
            if(lower <= x && x <= upper){
                set.add(x);
            }
        }
        return set.size() == upper - lower + 1;
    }
    public static void main(String[] args){
        String s = "0110";
        int n = 3;
        queryString2(s, n);
    }
}
