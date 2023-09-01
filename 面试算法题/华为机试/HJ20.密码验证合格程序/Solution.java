import java.util.Scanner; 
import java.util.Set;
import java.util.HashSet;
// ���ȳ�����λ
// ������Сд��ĸ�����֡��������ţ����ٺ�������
// �����г��ȴ���2�İ�������Ԫ�ص��Ӵ��ظ�

// ˼·������ HashSet

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ע�� hasNext �� hasNextLine ������
        while (in.hasNextLine()) { // ע�� while ������ case
            String password = in.nextLine();
            if(isValid(password)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
    public static boolean isValid(String password){
        if(password.length() <= 8){
            return false;
        }
        int count = 0;
        int [] cnt = new int[4];
        for(char c: password.toCharArray()){
            if(c >='0' && c <='9'){
                cnt[0]++;
            }else if(c >='a' && c <='z'){
                cnt[1]++;
            }else if(c >='A' && c <='Z'){
                cnt[2]++;
            }else{
                cnt[3]++;
            }
        }
        for(int i = 0; i < 4; i++){
            if(cnt[i] != 0){
                count++;
            }
        }
        if(count < 3){
            return false;
        }
        // ��������
        Set<String> set = new HashSet<>();
        for(int i = 3; i < password.length(); i++){
            for(int j = 0; j + i <= password.length(); j++){
                String sub = password.substring(j,j+i);
                if(set.contains(sub)){
                    return false;
                }else{
                    set.add(sub);
                }
            }
        }
        return true;
    }
}