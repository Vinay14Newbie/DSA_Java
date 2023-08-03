package java1;

public class testing{
    public static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node temp = new Node(data);
        if(head == null){
            head = tail = temp;
            size++;
            return;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
        size++;
    }
    void addlast(int data){
        if(head == null){
            addFirst(data);
            return;
        }
        Node t = new Node(data);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = t;
        t.next = null;
        t = tail;
        size++;
    }
    public void deleteFirst(){
        if(size == 1){
            head = head.next;
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }
    public void deleteLast(){
        tail.prev.next = tail.next;
        size--;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void reverse(){
        Node curr = head, prev = null, after = null;
        while(curr != null){
            after = curr.next;
            curr.next = prev;
            curr.prev = after;
            prev = curr;
            curr = after;
        }
        head = prev;
    }
    public static void main(String args[]){
        testing dll = new testing();
        dll.addFirst(3);
        dll.addFirst(5);
        dll.addFirst(8);
        dll.display();
        System.out.println(size);
        dll.deleteLast();
        dll.display();
        dll.deleteFirst();
        dll.display();
        dll.addlast(6);
        dll.addlast(7);
        dll.addlast(8);
        dll.display();
        System.out.println(size);
        reverse();
        dll.display();
    }
}