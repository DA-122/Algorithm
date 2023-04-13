// 1041 ���ڻ��еĻ�����
// ��Ŀ������ �����޵�ƽ���ϣ����������λ�� (0, 0) �����泯������ע��:
// ������ ��y���������
// �Ϸ��� ��y��ĸ�����
// ������ ��x���������
// ������ ��x��ĸ�����
// �����˿��Խ�����������ָ��֮һ��
// "G"��ֱ�� 1 ����λ
// "L"����ת 90 ��
// "R"����ת 90 ��
// �����˰�˳��ִ��ָ�� instructions����һֱ�ظ����ǡ�
// ֻ����ƽ���д��ڻ�ʹ�û�������Զ�޷��뿪ʱ������ true�����򣬷��� false��
// ˼·������ һ��ָ��ִ����ɺ������������ԭ�㣺
// 1. �泯�����ָ�������ʱ��״̬����Ȼ�л�
// 2. �泯�ϣ���ִ��һ�־ͻص�ԭ�����泯��
// 3�� �泯��/�泯���� ��ִ�����־ͻص�ԭ�����泯����

// ��������˲�λ��ԭ�㣺
// 1. λ��(x,y)���泯���� ִ��һ�ֺ�λ��(2x,2y)�泯�������뻷
// 2. λ��(x,y)���泯��,  ִ��һ�ֺ�λ��ԭ�㣬�汱
// 3. λ��(x,y)�泯�����泯����ִ��һ�ֱ��(x+y,y-x)�汱 �����ϣ�ִ�����ֱ�Ȼ�ص�ԭ��

public class Solution{
    public static boolean isRobotBounded(String instructions) {
        // dir 0 - 3  �� �� �� ��
        int x = 0, y = 0;
        int dir = 1;
        int [][]directions = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 0; i < instructions.length(); i++){
            if(instructions.charAt(i) == 'L'){
                dir = (dir+3)%4;
            }
            if(instructions.charAt(i) =='R'){
                dir = (dir+1)%4;
            }
            if(instructions.charAt(i) =='G'){
                x += directions[dir][0];
                y += directions[dir][1];
            }
        }
        return (x == 0 && y==0) || dir!=1;
    }
    public static void main(String[] args){
        String instructions = "GGLLGG";
        System.out.println(isRobotBounded(instructions));
    }
}