// 力扣2446.判断两件事情是否存在冲突
// 思路分析：模拟，转化成int比较或者字符串直接比较
public class Solution{
    // 转化成int比较
    public boolean haveConflict(String[] event1, String[] event2) {
        int time1Start = Integer.parseInt(event1[0].substring(0,2))*60 + Integer.parseInt(event1[0].substring(3));
        int time1End = Integer.parseInt(event1[1].substring(0,2))*60 + Integer.parseInt(event1[1].substring(3));
        int time2Start = Integer.parseInt(event2[0].substring(0,2))*60 + Integer.parseInt(event2[0].substring(3));
        int time2End = Integer.parseInt(event2[1].substring(0,2))*60 + Integer.parseInt(event2[1].substring(3));
        if(time1End <= time2End && time1End >= time2Start || time1Start<=time2Start && time1End>=time2Start || time1Start >= time2Start && time1End <= time2End ||time1Start <= time2End && time1Start >= time2Start){
            return true;
        }
        // 取反
        // if(!(time1End < time2Start || time2End < time1Start)){
        //     return true;
        // }
        return false;
    }

    // 字符串直接比较(时间小字典序一定小)
    public boolean haveConflict2(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
    
    

}