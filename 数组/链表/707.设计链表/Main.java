public class Main{
    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        // list.addAtIndex(1, 4);
        list.addAtTail(3);
        // list.addAtHead(5);
        list.addAtIndex(1, 2);
        list.get(1);
        list.deleteAtIndex(3);
        list.get(0);
        // list.addAtTail(0);
        // list.addAtTail(5);
        // list.addAtIndex(6, 3);
        // list.deleteAtIndex(7);
        // list.deleteAtIndex(5);
        // list.addAtTail(4);
    }
}