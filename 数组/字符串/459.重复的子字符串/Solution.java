// 力扣459 重复的子字符串
// 1.枚举法O(N^2)
// 字符串 == 比较引用地址，equals比较字符串内容
// 引用类型 == 表示引用地址， equals默认调用==，引用类型比较相等重载equals函数，用equals比较值
// 2.字符串匹配
// 字符串s可以写成s's'......s's' 总共 n/n'个s'
// 如果移除一个s'再把s'添加到字符串末尾，得到的字符串仍然是s
// 
public class Solution{
    public static boolean repeatedSubstringPattern(String s) {
        StringBuffer str =  new StringBuffer();
        int n = s.length();
        for(int i = 0; i < n/2; i++){
            int len = i + 1;
            str.append(s.charAt(i));
            if(n % len!=0){
                continue;
            }else{
                int j = 0;
                while(j < n/len){
                    if(!s.substring(len*j,len*(j+1)).equals(str.toString())){
                        break;
                    }
                    j++;
                }
                if(j == n/len){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        String s = "aba";
        repeatedSubstringPattern(s);
    }
}