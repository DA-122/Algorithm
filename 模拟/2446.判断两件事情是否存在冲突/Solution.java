// ����2446.�ж����������Ƿ���ڳ�ͻ
// ˼·������ģ�⣬ת����int�Ƚϻ����ַ���ֱ�ӱȽ�
public class Solution{
    // ת����int�Ƚ�
    public boolean haveConflict(String[] event1, String[] event2) {
        int time1Start = Integer.parseInt(event1[0].substring(0,2))*60 + Integer.parseInt(event1[0].substring(3));
        int time1End = Integer.parseInt(event1[1].substring(0,2))*60 + Integer.parseInt(event1[1].substring(3));
        int time2Start = Integer.parseInt(event2[0].substring(0,2))*60 + Integer.parseInt(event2[0].substring(3));
        int time2End = Integer.parseInt(event2[1].substring(0,2))*60 + Integer.parseInt(event2[1].substring(3));
        if(time1End <= time2End && time1End >= time2Start || time1Start<=time2Start && time1End>=time2Start || time1Start >= time2Start && time1End <= time2End ||time1Start <= time2End && time1Start >= time2Start){
            return true;
        }
        // ȡ��
        // if(!(time1End < time2Start || time2End < time1Start)){
        //     return true;
        // }
        return false;
    }

    // �ַ���ֱ�ӱȽ�(ʱ��С�ֵ���һ��С)
    public boolean haveConflict2(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
    
    

}