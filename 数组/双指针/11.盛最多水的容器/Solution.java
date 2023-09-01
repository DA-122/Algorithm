// ����11 ʢ�����ˮ������
// ˼·������ ע����������������ұ߽��й�
// area =  (right - left)*(min(height[right],height[left]))
// ˼·��˫ָ�뷨��left���ң�right����
// left right�бض�һ������ һ���̰壬�̰�Ϳ�������
// �����ƶ�ֻ�����������С���̰��ƶ����ܴ���������ӣ�̰��˼�룩


public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length;
        while(left < right){
            max =Math.max((right - left)*Math.min(height[left],height[right]) ,max);
            // �̰��ƶ�
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }

        }
        return max;
    }
}
