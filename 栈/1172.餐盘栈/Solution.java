public class Solution{
    public static void main(String[] args){
        DinnerPlates plates = new DinnerPlates(1);
        plates.push(1);
        plates.push(2);
        plates.push(3);
        plates.push(4);
        plates.push(5);
        plates.popAtStack(0);
        plates.push(20);
        plates.push(21);
        plates.popAtStack(0);
        plates.popAtStack(2);
        plates.pop();
        plates.pop();
        plates.pop();
        plates.pop();
        plates.pop();
    }
}