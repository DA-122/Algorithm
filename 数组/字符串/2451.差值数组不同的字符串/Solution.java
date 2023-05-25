// ����2451.��ֵ���鲻ͬ���ַ���
// ˼·���ȱȽ�0��1
// 0��1��һ��������2��0��1�Ƚ�
// 0��1һ��������0�ͺ�ߵıȽ�
public class Solution {
    public String oddString(String[] words) {
        int len = words.length;
        int n = words[0].length();
        int differences[][] = new int [len][n-1];
        for(int i = 0; i < len; i++){
            for(int j = 1; j < n; j++){
                differences[i][j-1] = words[i].charAt(j) - words[i].charAt(j-1);
            }
        }
        boolean isEqual = true;
        for(int i = 0 ; i < n-1; i++){
            if(differences[0][i] != differences[1][i]){
                isEqual = false;
                break;
            }
        }
        String result = words[1];
        if(!isEqual){
            boolean isDiff0 = true;
            for(int i = 0; i < n-1; i++){
                if(differences[0][i] != differences[2][i]){
                    result = words[0];
                    break;
                }
            }
        }else{
            for(int i = 2; i < len; i++){
                for(int j = 0; j < n-1; j++){
                    if(differences[0][j] != differences[i][j]){
                        result =  words[i];
                        break;
                    }
                }
            }
        }
        return result;
    }
}
