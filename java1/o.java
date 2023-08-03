package java1;

public class o{
    public static class Node{
        int val; 
        Node next;
        Node prev;

        Node(int val){
            this.val = val;
        }
    }
    public static void displayWithAnyNode(Node random){  //you have given random node
        Node temp = random;
        while(temp.prev != null){
            temp = temp.prev;
        }
        display(temp);
    }
    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void displayRev(Node tail){  //you have given tail node 
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
    public static Node addFirst(Node head, int val){
        Node temp = new Node(val);
        if(head == null){
            head  = temp;
            return temp;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
        return temp;
    }
    public static void addLast(Node head, int val){
        Node temp = new Node(val);
        if(head == null){
            addFirst(head, val);
            return;
        }
        Node t = head;
        while(t.next != null){
            t = t.next;
        }
        t.next = temp;
        temp.prev = t;
        temp.next = null;
    }
    public static void deleteFirst(Node head){
        if(head == null) return;
        Node temp = head;
        temp = temp.next;
        temp.prev = null;
        head = temp;
    }
    public static void deleteLast(Node head){
        if(head == null) return;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.prev.next = null;
    }
    public static void insertAt(Node head, int index, int value){
        Node t = new Node(value);
        if(index == 0){
            addFirst(head, value);
            return;
        }
        Node temp = head;
        int i = 0;
        while(i < index-1){
            temp = temp.next;
            i++;
        }
        t.next = temp.next;
        temp.next = t;
        t.prev = temp;
        t.next.prev = t;
    }
    public static void deleteAt(Node head, int index){
        Node temp = head;
        int i = 0;
        while(i < index-1){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp.next;
    }
    public static int size(Node head){
        int count = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public static boolean checkPalindrome(Node head){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node tail = temp;
        Node start = head;
        while(start != tail){
            if(start.val != tail.val){
                return false;
            }else{
                start = start.next;
                tail = tail.prev;
            }
        }
        return true;
    }
    public static void checkSum(Node head, int target){ //in a sorted linked list
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node tail = temp;
        Node start = head;
        while(start != tail){
            if((start.val + tail.val) == target){
                System.out.print(start.val +" "+ tail.val);
                return;
            }else if((start.val + tail.val) > target){
                tail = tail.prev;
            }else{
                start = start.next;
            }
        }
        System.out.println("No sum possible :");
    }
    public static void criticalMaximaMinima(Node head){
        Node temp = head;
        int critical1 = 0, count = 0, minDis = Integer.MIN_VALUE;
        while(temp != null){
            if(temp.next.val > temp.val && temp.prev.val > temp.val){
            }
            count++;
        }
    }
    public static void main(String[] args) {
        Node N1 = new Node(1);
        Node N2 = new Node(2);
        Node N3 = new Node(3);
        Node N4 = new Node(4);
        Node N5 = new Node(5);

        N1.prev = null;
        N1.next = N2;
        N2.prev = N1;
        N2.next = N3;
        N3.prev = N2;
        N3.next = N4;
        N4.prev = N3;
        N4.next = N5;
        N5.prev = N4;   

        display(N1);
        checkSum(N1, 7);
        // display(N1);
        // N1 = addFirst(N1, 1);
        // addLast(N1, 13);
        // display(N1);
        // insertAt(N1, 5, 8);
        // display(N1);
        // deleteAt(N1, 3);
        // display(N1);
        // deleteLast(N1);
        // display(N1);
    }
}