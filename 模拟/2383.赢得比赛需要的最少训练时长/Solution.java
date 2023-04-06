// 力扣2383
// 思路分析：按照题意模拟即可。
class Solution {
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int hours = 0;
        for(int i = 0; i<energy.length;i++){
            if(initialEnergy > energy[i] && initialExperience > experience[i]){
                initialEnergy-=energy[i];
                initialExperience+=experience[i];
            }else{
                if(initialEnergy<=energy[i]){
                    hours+=energy[i] - initialEnergy+1;
                    initialEnergy = energy[i]+1;
                }
                if(initialExperience<=experience[i]){
                    hours+=experience[i] -initialExperience+1;
                    initialExperience = experience[i]+1;
                }
                initialEnergy-=energy[i];
                initialExperience+=experience[i];
            }
        }
        return hours;
    }
    public static void main(String[] args){
        int initialEnergy = 5;
        int initialExperience = 3;
        int[] energy ={1,4,3,2};
        int[] experence ={2,6,3,1};
        System.out.println(minNumberOfHours(initialEnergy, initialExperience, energy, experence));
    }
}