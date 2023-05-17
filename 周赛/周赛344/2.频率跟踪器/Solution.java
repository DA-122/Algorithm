// 2.频率跟踪器
// 思路分析：如果单哈希，hasfrequency复杂度为O(M)，复杂度过高
// 双哈希一个哈希记录数字及其频率，另一个哈希记录频率的出现次数

class FrequencyTracker {
    Map<Integer,Integer> map;
    Map<Integer,Integer> frequencyMap;
    public FrequencyTracker() {
        map = new HashMap<>();
        frequencyMap = new HashMap<>();
    }
    
    public void add(int number) {
        map.put(number, map.getOrDefault(number,0)+1);
        // 当前频率!=1 说明可以对之前的频率-1
        int frequency = map.get(number);
        if(frequency!=1){
            frequencyMap.put(frequency-1, frequencyMap.get(frequency-1) - 1);
        }
        frequencyMap.put(frequency, frequencyMap.getOrDefault(frequency,0)+1);
    }
    
    public void deleteOne(int number) {
        if(map.containsKey(number)&&map.get(number)!=0){
            int frequency = map.get(number);
            if(frequency == 1){
                map.remove(number);
                frequencyMap.put(frequency,frequencyMap.get(frequency)-1);
            }else{
                map.put(number,frequency-1);
                // 更新频率
                frequencyMap.put(frequency,frequencyMap.get(frequency)-1);
                frequencyMap.put(frequency-1,frequencyMap.get(frequency-1)+1);
            }
        }
    }
    
    public boolean hasFrequency(int frequency) {
        return frequencyMap.containsKey(frequency)? frequencyMap.get(frequency)!=0:false;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */