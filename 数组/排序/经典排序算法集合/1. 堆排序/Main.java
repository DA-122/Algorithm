public class Main{
    public static void main(String[] args){
        int[] unorderArr = {1,2,3,4,5,6,7};
        Heap heap = new Heap(unorderArr);
        heap.buildMaxHeap();
        heap.MaxHeapSort();
        return;
    }
}