// 2178. 拆分成最多数目的正偶数之和
// 思路分析： 贪心算法
// 反证法证明贪心方法是正确的。
// 用我们的方法找到的一个答案2 + 4 + ... + 2n + k = finalsum，即最多可以分成n + 1个数。 由于k不可继续划分，这意味着2n < k < (2n + 2) + (2n + 4) = 4n + 6。
// 假设不使用2~2n中的某个数2x之后，可以将finalsum分成更多的偶数，这意味着 k + 2x可以分成3个大于2n的数。 即k + 2x >= (2n + 2) + (2n + 4) + (2n + 6) = 6n + 12，即k + 2x >= 6n + 12。
// 由于k < 4n + 6，且2x <= 2n，既有k + 2x < 6n + 6。这与假设矛盾，即不存在这样的数2x

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if(finalSum % 2 != 0){
            return res;
        }
        long even = 2;
        while(finalSum - even >= 0){
            res.add(even);
            finalSum -= even;
            even += 2;
        }

        long last = res.get(res.size() - 1);
        res.set(res.size() - 1, finalSum + last) ;
        return res; 
    }
}