// ��ָ45. �������ų���С����
// ˼·������ �Զ���������
// Ҫ��nums�е�����ϳ��ַ���������С����ô�Ϳ���ζ�nums����һ������/
// ��nums�����������������ַ���Ϊ X��Y
// ��� X + Y > Y + X���� X > Y(��Y֮��)
// ��֮��Y֮ǰ


import java.util.Arrays;

public class Solution{

    public String minNumber(int[] nums) {
        StringBuffer buffer = new StringBuffer();
        String[] strs = new String[nums.length];
        for(int i = 0; i < strs.length; i++){
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, (a,b) -> {
            return (a+b).compareTo(b+a);
        });
        for(String str: strs){
            buffer.append(str);
        }
        return buffer.toString();
    
    }
}
