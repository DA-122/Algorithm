public class Solution{
    public static boolean isNumber(String s) {
        //������ͷ��ĩβ�ո�
        s = s.trim();
        if(s == null||s.length()==0)
            return false;
        int e_position = s.length();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'e'||s.charAt(i) == 'E'){
                e_position = i;
                break;
            }
        }
        // û��e
        if(e_position == s.length()){
            return isDecimal(s)||isInteger(s);
        }
        if(e_position == 0){
            return false;
        }
        String left = s.substring(0,e_position);
        String right = s.substring(e_position+1);
        return (isDecimal(left)||isInteger(left))&&isInteger(right);
    }
    public static boolean isDecimal(String s){
        if(s == null||s.length()==0)
            return false;
        if(s.length()==1&&(s.charAt(0) == '.' ||s.charAt(0) == '+'||s.charAt(0)=='-'||s.charAt(0)==' '||(s.charAt(0)>='a'&&s.charAt(0)<='z') ||(s.charAt(0)>='A'&&s.charAt(0)<='Z'))){
            return false;
        }
        // ֻ��Ҫ�ж��Ƿ��пո���ĸ������'+','-',��Ҫ�ж��м���'.'
        int num_point = 0;
        if(s.charAt(0) == '.')
            num_point++;

        

        for(int i  = 1; i < s.length(); i++){
            if((s.charAt(i)>='a'&&s.charAt(i)<='z') ||(s.charAt(i)>='A'&&s.charAt(i)<='Z')||s.charAt(i) == '+'||s.charAt(i) =='-'||s.charAt(i) ==' ')
                return false;
            if(s.charAt(i) == '.'){
                if(++num_point>1 )
                    return false;
            }
        }
        return true;
    }
    public static boolean isInteger(String s){
        if(s == null||s.length()==0)
            return false;
        if(s.length()==1&&(s.charAt(0) == '.' ||s.charAt(0) == '+'||s.charAt(0)=='-'||s.charAt(0)==' '||(s.charAt(0)>='a'&&s.charAt(0)<='z') ||(s.charAt(0)>='A'&&s.charAt(0)<='Z'))){
            return false;
        }
        // �ж��Ƿ��пո���ĸ������'+','-'
        for(int i = 1; i < s.length(); i++){
            if((s.charAt(i)>='a'&&s.charAt(i)<='z') ||(s.charAt(i)>='A'&&s.charAt(i)<='Z')||s.charAt(i) == '+'||s.charAt(i) =='-'||s.charAt(i) ==' '||s.charAt(i) =='.')
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        String s = "G67";
        System.out.println(isNumber(s));
    }
}