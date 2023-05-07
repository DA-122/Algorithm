// ½£Ö¸58. ¼òµ¥µÄ×Ö·û´®ÇÐÆ¬¼ÓÆ´½Ó

public class Solution{
    public String reverseLeftWords(String s, int n) {
        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(n));
        sb.append(s.substring(0,n));
        return sb.toString();
    }  
}