// 力扣77.组合
// 题目分析：给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。组合不可重复
// 思路分析：1.递归回溯法 时间复杂度O(C(n,k)*k 空间复杂度O(n+k)



// 2. 非递归法- 二进制字典序法
// 将n个数字按降序排列，选择k个数字，将选中位置标为1，非选中位置标为0，那么可以得到C(n,k)个二进制字符串，且这些二进制字符串是按照字典序排列的。
// 字典序最小的字符串肯定是000...001...1
// 字典序中下一个数字next(x) 应服从以下规则
// (1) x最低位是1. 如果末尾有连续t个1，就将最高位的1与前一位的0替换
// 000111 -> 001011
// (2) x最低位是0. 如果末尾有连续t个0和连续m个1，就把t+m位的1和t+m+1位的0交换，再将剩下的m-1个1拉到低位。
// 001110 -> 010011
// 100110 -> 101001
// 就可以用数组来表示所有组合方案，时间复杂的O(C(n,k) * k),空间复杂度 O（n）


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return res;
    }
    public void dfs(int cur, int n, int k){
        if(list.size() == k){
            res.add(new ArrayList(list));
            return;
        }
        for (int i = cur; i <= n - (k - list.size()) + 1; i++){
            list.add(i);
            dfs(i + 1,n, k);
            list.removeLast();
        }
    }


    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combine2(int n, int k) {
        // 字典序最小的二进制数组
        for(int i = 0; i <=k ; i++){
            temp.add(i);
        }
        temp.add(n+1);
        int j = 0;
        while (j < k) {
            ans.add(new ArrayList<Integer>(temp.subList(0, k)));
            j = 0;
            // 寻找第一个 temp[j] + 1 != temp[j + 1] 的位置 t
            // 我们需要把 [0, t - 1] 区间内的每个位置重置成 [1, t]
            while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                temp.set(j, j + 1);
                ++j;
            }
            // j 是第一个 temp[j] + 1 != temp[j + 1] 的位置
            temp.set(j, temp.get(j) + 1);
        }
        return ans;
    }


}