// 堆数据结构 大顶堆降序排序，小顶堆升序排序

// 此数据结构是一个大根堆的实现
// Java中PriorityQueue就是个堆结构,默认为小根堆，可以通过自定义Comparator来实现大根堆(num1,num2) -> {return num2-num1}
public class Heap {
    public int[] heap;
    public int length;
    public Heap(int [] unorderArr){
        this.heap = unorderArr;
        this.length = unorderArr.length;
    }
    
    public void buildMaxHeap(){
        int lastNonLeaf = length/2-1;
        for(int i = lastNonLeaf; i >= 0; i--){
            maxHeapify(i,length);
        }
    }

    public void MaxHeapSort(){
        int tail = length -1;
        while(tail > 0){
            // 根节点与末尾节点互换位置
            int temp = heap[0];
            heap[0] = heap[tail];
            heap[tail] = temp;
            System.out.print(heap[tail]);
            // 大顶堆调整
            maxHeapify(0,tail--);
        }
        System.out.print(heap[tail]);
    }

    // 大顶堆调整(递归调整)
    public void maxHeapify(int pos,int end){
        // 当成为叶子节点时，就不调整了
        if(pos*2+1 > end-1){
            return;
        }else if (pos*2+1 == end-1){
        // 最后一个非叶子节点，看是否合适
            if(heap[pos] < heap[pos*2+1]){
                int temp = heap[pos];
                heap[pos] = heap[pos+1];
                heap[pos+1] = temp;
            }
            return;
        }
        // 小于两个子孩子里的随便一个，都用大的那个替换
        if(heap[pos] < heap[pos*2+1] || heap[pos] < heap[pos*2+2]){
            if(heap[pos*2+1] >= heap[pos*2+2]){
                int temp =  heap[pos];
                heap[pos] = heap[pos*2+1];
                heap[pos*2+1] = temp;
                maxHeapify(pos*2+1,end);
            }else{
                int temp =  heap[pos];
                heap[pos] = heap[pos*2+2];
                heap[pos*2+2] = temp;
                maxHeapify(pos*2+2,end);
            }
        }
    }
}
