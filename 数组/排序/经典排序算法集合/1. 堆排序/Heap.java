// �����ݽṹ �󶥶ѽ�������С������������

// �����ݽṹ��һ������ѵ�ʵ��
// Java��PriorityQueue���Ǹ��ѽṹ,Ĭ��ΪС���ѣ�����ͨ���Զ���Comparator��ʵ�ִ����(num1,num2) -> {return num2-num1}
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
            // ���ڵ���ĩβ�ڵ㻥��λ��
            int temp = heap[0];
            heap[0] = heap[tail];
            heap[tail] = temp;
            System.out.print(heap[tail]);
            // �󶥶ѵ���
            maxHeapify(0,tail--);
        }
        System.out.print(heap[tail]);
    }

    // �󶥶ѵ���(�ݹ����)
    public void maxHeapify(int pos,int end){
        // ����ΪҶ�ӽڵ�ʱ���Ͳ�������
        if(pos*2+1 > end-1){
            return;
        }else if (pos*2+1 == end-1){
        // ���һ����Ҷ�ӽڵ㣬���Ƿ����
            if(heap[pos] < heap[pos*2+1]){
                int temp = heap[pos];
                heap[pos] = heap[pos+1];
                heap[pos+1] = temp;
            }
            return;
        }
        // С�������Ӻ���������һ�������ô���Ǹ��滻
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
