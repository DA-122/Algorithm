// 力扣1040 移动石子直到连续Ⅱ(VERY HARD)
// 题目分析：在一个长度 无限 的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作 端点石子 。
// 每个回合，你可以将一颗 端点石子 拿起并移动到一个未占用的位置，使得该石子 不再 是一颗端点石子。
// 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：
public class Solution{
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        if (stones[n-1] - stones[0] + 1 == n) {
            return new int[]{0, 0};
        }
        int[] ans = new int[2];
        int mi = n;
        //以i，j为双指针
        for (int i = 0, j = 0; i < n && j + 1 < n; ++i) {
            //不断移动j使得i，j之间距离大于n，i，j之间可以填充所有石子
            while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n) {
                ++j;
            }
            //例如[1,2,3,4,x(x>5)],j=3,i=0,找到除一个石子外，其余石子是连续的窗口，则最多移动两次就行,1->6,x->5;
            //如果是[1,2,3,4,6]最小只需要一次，那么会在i=1时，j=4时更新min为 5-（4-1+1）=1;
            if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                mi = Math.min(mi, 2);
            } else {
                //在最大连续序列中填空
                mi = Math.min(mi, n - (j - i + 1));
            }
        }
        ans[1] = Math.max(stones[n-1]-stones[1]+2-n,stones[n-2]-stones[0]+2-n);
        ans[0] = mi;
        return ans;
    }   
    public static void main(String[] args){

    }
}