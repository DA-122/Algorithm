// 力扣2049 统计共同度过的日子数
// 思路分析： 1 模拟
// 2. 计算出四个日期在一年中各是第多少天，前缀和
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
        // alice先到
        if(date[0][0] < date[2][0]|| (date[0][0] == date[2][0]&&  date[0][1] < date[2][1])){
            // 在bob到前先走
            if(date[1][0] < date[2][0] ||(date[1][0] == date[2][0]&&  date[1][1] < date[2][1])){
                result = 0;
            // bob到之后再走
            }else{
                // bob走之前先走 1 - 2
                if(date[1][0] < date[3][0]|| (date[1][0] == date[3][0]&&  date[1][1] < date[3][1])){
                    result = calDays(date[1][0], date[1][1], date[2][0], date[2][1]);
                }else{
                    result = calDays(date[3][0], date[3][1], date[2][0], date[2][1]);
                }
            }
        }else{
        // bob先到
            // 在alice到前先走
            if(date[3][0] < date[0][0] ||(date[3][0] == date[0][0]&&  date[3][1] < date[0][1])){
                result = 0;
            // alice到之后再走
            }else{
                // alice走之前先走 3 - 0
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
    // 前缀和
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