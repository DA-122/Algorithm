// 周赛341 构造有效字符串的最小插入数(Medium)
// 思路1： 考虑相邻字符之间关系
// (1). word[i+1] > word[i] && word[i+2] > word[i+1]  i+=3   cnt不加
// (2). word[i+1] > word[i] i+=2   cnt+1
// (3). 否则 i+=1 cnt+2 
// 注意后两个字符有没有被遍历到

// 思路2: 记录周期
// 以abc为周期，记录实现目标所需的周期t，答案为3t-len(word)
// 只要word[i-1] > word[i]  t++
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