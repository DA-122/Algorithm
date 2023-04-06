// 1626��ì�ܵ�������
// ˼·����������С�ķ����ϸ���������ģ���ì��
// ages[i] < ages[j] scores[i] > scores[j]
// ��ì��: ages[i] >= ages[j] scores[i] >= scores[j] ���䲻�ȣ������ɵ�
// ��ì�ܣ� ������������һ�����������ǵݼ������У�������ͬ���������ߵ�����
// �������ߵ�������һ����������ǵݼ�������
import java.util.Arrays;
public class Solution {
    // �Լ�ʵ�ֵ�sort
    public static int bestTeamScore(int[] scores, int[] ages) {
        mergeSort(0,ages.length-1,scores,ages);
        int[] dp = new int[scores.length+1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j <dp.length;j++){
                if(scores[i-1]>=scores[j-1])
                    dp[i] = Math.max(dp[i],dp[j]);
            }
            dp[i] = dp[i]+scores[i-1];
        }
        return dp[dp.length-1];
    }
    public static void mergeSort(int l, int r, int[]scores, int[] ages){
        if(l == r){
            return;
        }
        int mid = (l+r)/2;
        int left = l;
        int right =mid+1;
        mergeSort(l,mid,scores,ages);
        mergeSort(mid+1,r,scores,ages);
        while(left<=mid&&right<=r){
            if(ages[left]<ages[right]){
                left++;
            }else{
                int tempA = ages[right];
                int tempS = scores[right];
                for(int i = right; i > left; i--){
                    ages[i] = ages[i-1];
                    scores[i] = scores[i-1];                   
                }
                ages[left] = tempA;
                scores[left] =tempS;
                left++;
                right++;
            }
        }
    }
    // Arrays.sort
    public static int bestTeamScore2(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] people = new int[n][2];
        for (int i = 0; i < n; ++i) {
            people[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public static void main(String[] args){
        int[] scores ={319776,611683,835240,602298,430007,574,142444,858606,734364,896074};
        int[] ages = {1,1,1,1,1,1,1,1,1,1};
        bestTeamScore(scores, ages);
    }
}