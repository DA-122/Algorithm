// ��ָ�����⣺��ӡ1�����nλ��
// ��Ŀ�������ѵ����ڴ���������������ֻ�����[1,10^n-1]����
// ����������Ǵ��������10^n����Խ����գ����ܼ򵥱�����
// ���������˼·������
//  ���Σ��̶���λ����ϵ�λ��ͨ���ݹ����������
//  �����Ϻ���Ҫ�������ַ���ͷ��0����ɾ��
public class Solution{
    StringBuffer buffer = new StringBuffer();
    public char[] nums;
    public char[] loop = {'0','1','2','3','4','5','6','7','8','9'};;
    int nine = 0, count = 0, start, n;

    // ���⣺����int�б�nΪint�������Ǵ��������
    public int[] printNumbers(int n) {
        int length = (int)Math.pow(10,n)-1;
        int[] ans = new int[length];
        int i = 0;
        while(i < length){
            ans[i++] = i;
        }
        return ans;
    }
    // ���ף����Ǵ��������������������ӦΪ�ַ�������
    public String printNumbersH(int n){
        this.nums = new char[n];
        this.n = n;
        start = n-1;
        dfs(0);
        buffer.deleteCharAt(buffer.length()-1);
        return buffer.toString();
    }
    public void dfs(int x){
        if(x == n){
            String s = String.valueOf(nums).substring(start);
            if(!s.equals("0")) 
                buffer.append(s + ",");
            if(n - start == nine) start--;
                return;
        }   
        for(char i: loop){
            if(i == '9') nine++;
            nums[x] = i;
            dfs(x+1);
        }
        nine--;
    }
}
