// ����151. ��ת�ַ����еĸ�����
// ˼·������ ˫ָ��
class Solution {
    public String reverseWords(String s) {
        StringBuffer buffer = new StringBuffer();
        char [] c = s.toCharArray();
        int left = 0;
        int right = c.length -1;
        while(c[left] == ' '){
            left++;
        }
        while(c[right] == ' '){
            right--;
        }        
        while(left <= right){
            int index = left;
            while(index <= right && c[index] != ' '){
                index++;
            }
            buffer.insert(0,s.substring(left,index));
            if(index < right){
                buffer.insert(0,' ');
            }
            left = index;
            while(left <= right && c[left] == ' '){
                left++;
            }
        }
        return buffer.toString();
    }
}