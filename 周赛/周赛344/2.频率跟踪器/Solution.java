// 2.Ƶ�ʸ�����
// ˼·�������������ϣ��hasfrequency���Ӷ�ΪO(M)�����Ӷȹ���
// ˫��ϣһ����ϣ��¼���ּ���Ƶ�ʣ���һ����ϣ��¼Ƶ�ʵĳ��ִ���

class FrequencyTracker {
    Map<Integer,Integer> map;
    Map<Integer,Integer> frequencyMap;
    public FrequencyTracker() {
        map = new HashMap<>();
        frequencyMap = new HashMap<>();
    }
    
    public void add(int number) {
        map.put(number, map.getOrDefault(number,0)+1);
        // ��ǰƵ��!=1 ˵�����Զ�֮ǰ��Ƶ��-1
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
                // ����Ƶ��
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