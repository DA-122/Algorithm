// 周赛343 保龄球游戏获胜者
// 思路： 简单模拟，要理解清楚题意
public class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int score1 = player1[0];
        int score2 = player2[0];
        if(player1.length ==1 ){
            return score1>score2? 1:(score1==score2? 0:2);
        }
        if(player1[0] != 10){
            score1+=player1[1];
        }else{
            score1+=player1[1]*2;
        }
        if(player2[0] != 10){
            score2+=player2[1];
        }else{
            score2+=player2[1]*2;
        }

        for(int i = 2; i < player1.length; i++){
            if(player1[i-1] ==10 || player1[i-2] ==10){
                score1+=player1[i]*2;
            }else{
                score1+=player1[i];
            }
        }
        for(int i = 2; i < player2.length; i++){
            if(player2[i-1]==10 || player2[i-2] ==10){
                score2+=player2[i]*2;
            }else{
                score2+=player2[i];
            }
        }
        return score1>score2? 1:(score1==score2? 0:2);
    }
}