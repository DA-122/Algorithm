// ����77.���
// ��Ŀ������������������ n �� k�����ط�Χ [1, n] �����п��ܵ� k ��������ϡ���ϲ����ظ�
// ˼·������1.�ݹ���ݷ� ʱ�临�Ӷ�O(C(n,k)*k �ռ临�Ӷ�O(n+k)



// 2. �ǵݹ鷨- �������ֵ���
// ��n�����ְ��������У�ѡ��k�����֣���ѡ��λ�ñ�Ϊ1����ѡ��λ�ñ�Ϊ0����ô���Եõ�C(n,k)���������ַ���������Щ�������ַ����ǰ����ֵ������еġ�
// �ֵ�����С���ַ����϶���000...001...1
// �ֵ�������һ������next(x) Ӧ�������¹���
// (1) x���λ��1. ���ĩβ������t��1���ͽ����λ��1��ǰһλ��0�滻
// 000111 -> 001011
// (2) x���λ��0. ���ĩβ������t��0������m��1���Ͱ�t+mλ��1��t+m+1λ��0�������ٽ�ʣ�µ�m-1��1������λ��
// 001110 -> 010011
// 100110 -> 101001
// �Ϳ�������������ʾ������Ϸ�����ʱ�临�ӵ�O(C(n,k) * k),�ռ临�Ӷ� O��n��


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
        // �ֵ�����С�Ķ���������
        for(int i = 0; i <=k ; i++){
            temp.add(i);
        }
        temp.add(n+1);
        int j = 0;
        while (j < k) {
            ans.add(new ArrayList<Integer>(temp.subList(0, k)));
            j = 0;
            // Ѱ�ҵ�һ�� temp[j] + 1 != temp[j + 1] ��λ�� t
            // ������Ҫ�� [0, t - 1] �����ڵ�ÿ��λ�����ó� [1, t]
            while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                temp.set(j, j + 1);
                ++j;
            }
            // j �ǵ�һ�� temp[j] + 1 != temp[j + 1] ��λ��
            temp.set(j, temp.get(j) + 1);
        }
        return ans;
    }


}