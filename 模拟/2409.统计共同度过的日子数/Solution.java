// ����2049 ͳ�ƹ�ͬ�ȹ���������
// ˼·������ 1 ģ��
// 2. ������ĸ�������һ���и��ǵڶ����죬ǰ׺��
public class Solution{
    private final static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String [] str = {arriveAlice,leaveAlice,arriveBob,leaveBob};
        int[][] date = new int[4][2];
        for(int i = 0; i < 4; i++){
            date[i][0] = Integer.parseInt(str[i].substring(0,2));
            date[i][1] = Integer.parseInt(str[i].substring(3,5));
        }
        int result = 0;
        // alice�ȵ�
        if(date[0][0] < date[2][0]|| (date[0][0] == date[2][0]&&  date[0][1] < date[2][1])){
            // ��bob��ǰ����
            if(date[1][0] < date[2][0] ||(date[1][0] == date[2][0]&&  date[1][1] < date[2][1])){
                result = 0;
            // bob��֮������
            }else{
                // bob��֮ǰ���� 1 - 2
                if(date[1][0] < date[3][0]|| (date[1][0] == date[3][0]&&  date[1][1] < date[3][1])){
                    result = calDays(date[1][0], date[1][1], date[2][0], date[2][1]);
                }else{
                    result = calDays(date[3][0], date[3][1], date[2][0], date[2][1]);
                }
            }
        }else{
        // bob�ȵ�
            // ��alice��ǰ����
            if(date[3][0] < date[0][0] ||(date[3][0] == date[0][0]&&  date[3][1] < date[0][1])){
                result = 0;
            // alice��֮������
            }else{
                // alice��֮ǰ���� 3 - 0
                if(date[3][0] < date[1][0]|| (date[3][0] == date[1][0]&&  date[3][1] < date[1][1])){
                    result = calDays(date[3][0], date[3][1], date[0][0], date[0][1]);
                }else{
                    result = calDays(date[1][0], date[1][1], date[0][0], date[0][1]);
                }
            }
        }
        return result;
    }
    public static int calDays(int month1, int day1, int month2, int day2){
        int result = 0;
        if(month1 == month2){
            result =  Math.abs(day2-day1)+1;
        }else if(month1 < month2){
            for(int i = month1; i<month2; i++){
                result+= days[i-1];
            }
            result = result+day2-day1+1;
        }else{
            for(int i = month2; i<month1; i++){
                result+= days[i-1];
            }
            result = result+day1-day2+1;
        }
        return result;
    }
    // ǰ׺��
    public static int countDaysTogether2(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] dayInYear = new int[13];
        dayInYear[0] = 0;
        for(int i = 1; i  < dayInYear.length; i++){
            dayInYear[i] = dayInYear[i-1]+days[i-1];
        }
        String [] str = {arriveAlice,leaveAlice,arriveBob,leaveBob};
        int[] date = new int[4];
        for(int i = 0; i < 4; i++){
            int month = Integer.parseInt(str[i].substring(0,2));
            int day = Integer.parseInt(str[i].substring(3,5));
            date[i] = dayInYear[month-1]+day;
        }
        int maxArrive = Math.max(date[0],date[2]);
        int minLeave = Math.min(date[1],date[3]);
        
        return maxArrive<=minLeave? minLeave-maxArrive+1:0;

    }



    public static void main(String[] args){
        String arriveAlice = "09-01";
        String leaveAlice = "10-19";
        String arriveBob = "06-19";
        String leaveBob = "10-20";
        System.out.println(countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }
}