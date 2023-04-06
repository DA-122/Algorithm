// ����1705 ��ĸ������
// ˼·����������ת��+ǰ׺��+��ϣ��
// ͳ����ĸ����������ͬ��������������������һ�����������滻ԭ���飬��ĸΪ1,����Ϊ-1��ǰ׺������Ϳ������ֳ���ĸ���ֵ�������ϵ��
// (1) ���sum[i] = 0 ��ô(0,i]�����������������
// (2) ͬʱ���sum[i]=sum[j] ��ô(i,j]Ҳ������������
// ���Ӷȷ����� �ռ�O(n) ʱ��O(n)
import java.util.HashMap;
class Solution {
    public static String[] findLongestSubarray(String[] array) {
        int[] num = new int [array.length];
        int[] sums = new int [array.length];
        if('A'<= array[0].charAt(0) && array[0].charAt(0)<='Z'){
            num[0] = 1;
            sums[0] = 1;
        }
        else{
            num[0] = -1;
            sums[0] = -1;
        }
        for(int i = 1; i < array.length; i++){
            if('A'<= array[i].charAt(0) && array[i].charAt(0)<='Z'){
                num[i] = 1;
            }else{
                num[i] = -1;
            }
            sums[i] = sums[i-1]+num[i];
        }
        int max = 0;
        int right = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(sums[i])){   
                if(max < (i - map.get(sums[i]))){
                    max = i - map.get(sums[i]);
                    right = i;
                }
            }else{
                map.put(sums[i], i);
            }
        }
        String[] ans = new String[max];
        for(int i = 0; i < ans.length; i++){
            ans[i] = array[map.get(sums[right])+i+1];
        }
        return ans;
    }
    public static void main(String[] args){
        String[] testCase = {"42","10","O","t","y","p","g","B","96","H","5","v","P","52","25","96","b","L","Y","z","d","52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5","S","Z","D","2","A","W","k","84","44","96","96","y","M"};
        System.out.println(findLongestSubarray(testCase));
    }
}