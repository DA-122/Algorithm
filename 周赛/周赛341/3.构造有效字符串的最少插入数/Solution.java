// ����341 ������Ч�ַ�������С������(Medium)
// ˼·1�� ���������ַ�֮���ϵ
// (1). word[i+1] > word[i] && word[i+2] > word[i+1]  i+=3   cnt����
// (2). word[i+1] > word[i] i+=2   cnt+1
// (3). ���� i+=1 cnt+2 
// ע��������ַ���û�б�������

// ˼·2: ��¼����
// ��abcΪ���ڣ���¼ʵ��Ŀ�����������t����Ϊ3t-len(word)
// ֻҪword[i-1] > word[i]  t++
public class Solution{
    public static int addMinimum(String word) {
        int ans = 0;
        int i = 0;
        while(i<word.length()-2){
            if(word.charAt(i+1) > word.charAt(i)){
                if(word.charAt(i+2) > word.charAt(i+1)){
                    i+=3;
                    continue;
                }else{
                    ans++;
                    i+=2;
                }
            }else{
                ans+=2;
                i++;
            }
        }
        if(i == word.length()-2){
            if(word.charAt(i+1) > word.charAt(i)){
                ans+=1;
            }else{
                ans+=4;
            }
        }else if(i == word.length()-1){
            ans+=2;   
        }
        return ans;
    }
    public static void main(String[] args){
        String word = "aaaabb";
        addMinimum(word);
    }
}