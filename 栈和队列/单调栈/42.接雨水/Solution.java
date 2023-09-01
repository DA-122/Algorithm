// ����42. ����ˮ
// ˼·�������������������μ����ˮ
//��1�����м��㣨�޷�AC��
//��2�����м��㣬����ÿһ�У��ֱ�Ѱ�������������߶�
// ��������߶� max_left, �ұ����߶� max_right
// ��� min(max_left, max_right) > height[i] ���л�ʢˮ
// ��� min(max_left, max_right) < height[i] ���в�����ʢˮ
// ��3����̬�滮����2��ÿ�ζ�����Ѱ������Ҳ����ֵ���ظ�̫��Σ������ÿռ任ʱ�䣬
// ��4��˫ָ���Ż��ռ临�Ӷȣ����Կ��������ж����max_left�����max_right����ÿһλ���Ƕ�ֻ����һ�Σ���˲���Ҫ�������飬����һ�������һ��ָ����С�
// ��5������ջ 
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution{
    // ����
    public static int trap1(int[] height) {
        int sum = 0 ;
        for(int i = 1; i < height.length - 1; i++){
            int max_left = 0;
            for(int j  = i -1; j >=0; j--){
                if(height[j] > max_left){
                    max_left = height[j];
                }
            }
            int max_right = 0;
            for(int j = i + 1; j < height.length; j++){
                if(height[j] > max_right){
                    max_right = height[j];
                }
            }
            int minHeight = Math.min(max_left,max_right);
            if(minHeight > height[i]){
                sum += minHeight - height[i];
            }else{
                continue;
            }
        }
        return sum;
    }
    // ����
    public static int trap2(int[] height) {
        int sum = 0 ;
        int n = height.length;
        int max_lefts[] = new int[n];
        int max_rights[] = new int[n];
        int max_left = height[0];
        int max_right = height[n-1];
        for(int i = 1; i < n ; i++){
            max_lefts[i] = max_left;
            max_left = Math.max(max_left, height[i]);
        }

        for(int i = n - 2; i > 0; i--){
            max_rights[i] = max_right;
            max_right =Math.max(max_right,height[i]);
        }
        for(int i = 1; i < n-1; i++){
            int minHeight = Math.min(max_lefts[i],max_rights[i]);
            if(minHeight > height[i]){
                sum+= minHeight - height[i];
            }
        }
        return sum;
    }
    // �����ռ临�Ӷ�
    public int trap3(int[] height) {
        int sum = 0 ;
        int n = height.length;
        int max_rights[] = new int[n];
        int max_left = height[0];
        int max_right = height[n-1];

        for(int i = n - 2; i > 0; i--){
            max_rights[i] = max_right;
            max_right =Math.max(max_right,height[i]);
        }
        for(int i = 1; i < n-1; i++){
            int minHeight = Math.min(max_left,max_rights[i]);
            if(minHeight > height[i]){
                sum+= minHeight - height[i];
            }
            max_left = Math.max(max_left,height[i]);
        }
        return sum;
    }
    // ����ջ
    public int trap4(int [] height){
        int sum = 0 ;
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i = 1; i < n ; i++){
            if(height[i] > height[stack.peek()]){
                // ջ����ջ ������
                while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                    int h = height[stack.pop()];
                    if(stack.isEmpty()){
                        break;
                    }
                    // ���Կ����Ƿ�2��ÿ�л�ˮ����
                    int distance =  i - stack.peek()-1;
                    int min = Math.min(height[i],height[stack.peek()]);
                    sum += distance *  (min - h);
                }
                // �����ˮ
            }
            stack.push(i);
            
        }
        return sum;
    }



    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap4(height));
    }
}