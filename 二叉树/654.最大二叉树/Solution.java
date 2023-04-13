import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// ����653.��������
// ��Ŀ: ����һ�������ظ�Ԫ�ص��������顣һ���Դ����鹹�������������������£�
// 1.�������ĸ��������е����Ԫ�ء�
// 2.��������ͨ�����������ֵ��߲��ֹ����������������
// 3.��������ͨ�����������ֵ�ұ߲��ֹ����������������
// ˼·������1.�ݹ鹹��
// 2.����ջ

// 1. �ݹ鹹����ÿ�����������ֵ��Ϊ���ڵ㣬�������������Ϊ���������Ҳ�������Ϊ������ ʱ�临�Ӷ�O(n^2),�ռ临�Ӷ�O(n)
// 2. ����ջ: �ɴ����������Ե�֪������һ���ڵ�����Ӻ��Һ��ӣ��ýڵ��������Ҳ��һ���������ӵĽڵ㣬���Һ�������һ�������Һ��ӵĽڵ�
// ��˶��ڶ������е�һ��������˵�����������е���߽���ұ߽綼���ڸ������ĸ��ڵ㣬�������ұ߽��н�С��Ϊ�丸�ڵ�
// ��˾�ת�����˵���ջ���⣬Ѱ��������ÿ��Ԫ�������Ҳ��һ�����Ԫ��λ�ã���С��һ�����Ǹ��ڵ�

public class Solution {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        int max = findMax(nums,0,nums.length-1);
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructChild(nums,0,max-1);
        root.right = constructChild(nums,max+1,nums.length-1);
        return root;
    }
    public static TreeNode constructChild(int[] nums,int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return new TreeNode(nums[start]);
        }
        int max = findMax(nums,start,end);
        TreeNode node = new TreeNode(nums[max]);
        node.left = constructChild(nums,start,max-1);
        node.right = constructChild(nums,max+1,end);
        return node;
    }
    public static int findMax(int [] nums,int start, int end){
        int max = start;
        for(int i = start; i <= end; i++){
            if(nums[i]>nums[max]){
                max = i;
            }
        }
        return max;
    }

    public static TreeNode constructMaximumBinaryTreeStack(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        TreeNode[] tree = new TreeNode[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        tree[0] = new TreeNode(nums[0]);
        stack.push(0);
        for(int i = 1; i < nums.length; i++){
            tree[i] = new TreeNode(nums[i]);
            while(!stack.isEmpty()&& nums[i] > nums[stack.peek()]){
                right[stack.peek()] = i;
                stack.pop();
            }         
            if(!stack.isEmpty()){
                left[i] = stack.peek();
            }       
            stack.push(i);
        }

        TreeNode root = null;
        for(int i = 0; i < left.length; i++){
            if(left[i] == -1 && right[i] ==-1){
                root = tree[i];
                continue;
            }
            if(left[i] == -1){  
                tree[right[i]].left = tree[i];
                continue;
            }
            if(right[i] ==-1 ){
                tree[left[i]].right = tree[i];
                continue;
            }
            if(nums[left[i]] > nums[right[i]]){
                tree[right[i]].left = tree[i];
            }else{
                tree[left[i]].right = tree[i];
            }
        }
        return root;
    }





    public static void main(String[] args){
        int[] nums = {3,2,1,6,0,5};
        constructMaximumBinaryTree(nums);
    }
}
