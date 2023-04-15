import java.util.ArrayList;
import java.util.List;

// ����1023 �շ�ʽƥ��
// ��Ŀ���������Խ�Сд��ĸ����ģʽ�� pattern �õ�����ѯ�� query����ô����ѯ�������ģʽ��ƥ�䡣�����ǿ������κ�λ�ò���ÿ���ַ���Ҳ���Բ��� 0 ���ַ�����
// ��������ѯ�б� queries����ģʽ�� pattern�������ɲ���ֵ��ɵĴ��б� answer��ֻ���ڴ����� queries[i] ��ģʽ�� pattern ƥ��ʱ�� answer[i] ��Ϊ true������Ϊ false��

// ˼·������1.˫ָ�룬һ��ָ��ָ��query����һ��ָ��ָ��pattern���������ָ��ָ���ַ���ȣ��ƶ�ָ�룬����ȣ����query����ָ���Ǵ�д����false�� 
// ��pattern��ָ���ƶ���ĩβʱ��query��ʣ�ಿ�ֲ�Ӧ���д�д��ĸ
// ��query���ƶ���ĩβʱ��pattern��ҲӦ�ƶ���ĩβ��
public class Solution{
    // ˫ָ�뷨
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = pattern.length();
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            boolean isMatched = true;
            String str = queries[i];
            // pattern ָ��
            int pivot = 0;
            for(int j = 0; j < str.length(); j++){
                if(pivot < n){
                    // ����ַ���ȣ��ƶ�ģʽ��ָ��
                    if(str.charAt(j) == pattern.charAt(pivot)){
                        pivot++;
                    }else{
                        //���queries���ַ����ȣ���Ϊ��д��˵������ȷ
                        if(str.charAt(j) >= 'A' && str.charAt(j)<='Z')
                            isMatched = false;
                    }
                }else{
                    if(str.charAt(j) >= 'A' && str.charAt(j)<='Z')
                        isMatched = false;
                }
            }
            if(pivot < n)
                isMatched = false;
            ans.add(isMatched);
        }
        return ans;
    }
    public static void main(String[] args){
        String [] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern  = "FB";
        System.out.println(camelMatch(queries,pattern));
    }
}