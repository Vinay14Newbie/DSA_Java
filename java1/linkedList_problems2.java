package java1;
public class linkedList_problems2{
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
        Node (){

        }
    }
    public static class linkedlist{
        Node head = null;
        Node tail = null;
        int size = 0;
    public void deleteAt(int index){  //function to delete
            if(index == 0){
                head = head.next; 
                size--;
                return;
            }
            Node temp = head;
            for(int i=0; i<index-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if(index == size-1) tail = temp;
            size--;
        }
    public int getValue(int index){    //return data of given index
            if(index < 0 || index > size){
               System.out.println("wrong index :");
               return -1;
           }
           Node temp = head;
           for(int i=0; i<index; i++){
               temp = temp.next;
           }
           return temp.data;
       }
    public void insertAt(int index, int data){   //insert data at given index
        if(index == size){
            insertAtEnd(data);
            return;
        }else if(index == 0){
            insertAtBegining(data);
            return;
        }else if(index < 0 || index > size){
            System.out.println("wrong index :");
            return;
        }
        Node t = new Node(data);
        Node temp = head;
        for(int i=0; i<=index-1; i++){
            temp = temp.next;
        }
        t.next = temp.next;
        temp.next = t;
        size++;
    }
    public void insertAtBegining(int data){  //insert a data at begining
           Node temp = new Node(data);
           if(head == null){ //empty list
               head = tail = temp;
           }else{  //non empty list
               temp.next = head;
               head = temp;
           }
           size++;
       }
    public void insertAtEnd(int data){  //add a data at end of linked list
        Node temp = new Node(data);
        if(head == null){
            head = temp;
        }
        else{
            tail.next = temp;
        }
        tail = temp;
        size++;
    }
    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    }
    public static void deleteNode(Node node){
        node.data = node.next.data;
        node.next = node.next.next;
    }
    public static void display(Node head){
        while(head != null){
            System.out.print(head.data+" -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void displayrev(Node head){
        if(head == null){
            return;
        }
        displayrev(head.next);
        System.out.print(head.data+" -> ");
    }
    public static Node reverse5(Node head){
        Node curr = head, prev = null, after = null;
        while(curr != null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        } 
        return prev;
    }
    public static Node lastNthNode(Node head, int index){
        int size = 0;
        Node temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        int m = size - index + 1;
        temp = head;
        //mth node from start
        for(int i=1; i<=m-1; i++){
            temp = temp.next;
        }
        System.out.println(temp.data);
        return temp;
    }
    public static Node lastNthNode3(Node head, int index){
        Node rabbit = head;
        Node turtoise = head;
        for(int i=0; i<index; i++){
            rabbit = rabbit.next;   //rabbit's next Node's data = rabbit
        }
        while(rabbit != null){
            rabbit = rabbit.next;
            turtoise = turtoise.next;
        }
        return turtoise;
    } 
    public static Node removeNthNode(Node head, int index){
        Node slow = head; 
        Node fast = head;
        for(int i=0; i<index; i++){
            fast = fast.next;
        }
        if(fast == null){
            head = head.next;
            return head;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static Node getIntersectionNode(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        int length1 = 0;
        while(temp1 != null){
            length1++;
            temp1 = temp1.next;
        }
        int length2 = 0;
        while(temp2 != null){
            length2++;
            temp2 = temp2.next;
        }
        temp1 = head1;
        temp2 = head2;
        if(length1 > length2){
            int steps = length1 - length2;
            for(int i=0; i<steps; i++){
                temp1 = temp1.next;
            }
        }else{
            int steps = length2 - length1;
            for(int i=0; i<steps; i++){
                temp2 = temp2.next;
            }
        }
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }
    public static Node middleNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){  //when condition get false we will get left medium
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    } 
    public static void deleteMidNode(Node head){ 
        if(head.next == null){
            head = null;
            return;
        }
        Node fast = head;
        Node slow = head;
        while(fast.next.next != null && fast.next.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
    }
    public static boolean returnHasCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public static Node returnCycleNode(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next;
            if(fast == slow) break;
        }
        if(fast == null || fast.next == null){
            return null;
        }else{
            Node temp = head;
            while(temp != slow){
                temp = temp.next;
                slow = slow.next;
            }
        }
        return slow;
    }
    public static Node mergeTwoLists(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        Node head = new Node(99);
        Node temp = head;
        while(temp1 != null && temp2 != null){
            if(temp1.data < temp2.data){
                Node a = new Node(temp1.data);
                temp.next = a;
                temp = a;
                temp1 = temp1.next;
            }else{
                Node a = new Node(temp2.data);
                temp.next = a;
                temp = a;
                temp2 = temp2.next;
            }
        }
        if(temp1 == null){
            temp.next = temp2;
        }else{
            temp.next = temp1;
        }
        return temp.next;
    }
    public static void oddEvenlist(Node head){
       Node curr = head;
       Node even = new Node(2), odd = new Node(2);
       while(curr != null){
        if(curr.data %2 == 0){
            even.next = curr;
            even = curr;
        }else{
            odd.next = curr;
            odd = curr;
        }
        curr = curr.next;
       }
       display(even);
       display(odd);
    }
    public static void removeDuplicates(Node head){
        Node temp = head;
        Node prev = head;
        while(temp != null){
           if(temp.data != prev.data){
            temp = temp.next;
            prev.next = temp;
            prev = temp;
           }
           temp = temp.next;
        }
        if(prev != temp) prev.next = null;
    }
    public static Node removeDuplicates2(Node head){
        Node temp = head;
        while(temp != null && temp.next != null){
            if(temp.data != temp.next.data){
                temp = temp.next;
            }
            if(temp.next == null) return head;
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }
        }
        return head;
    }
    public static Node reverseList(Node head){ //with recursion
        if(head.next == null){
            return head;
        }
        Node newHead =  reverseList(head.next);  //it representing returned node value
        //keep in mind difference between newhead and head
        head.next.next = head;  //interchanging the connections
        head.next = null;
        return newHead;
    }
    public static Node reverseList2(Node head){ //with iteration
        Node curr = head, prev = null, agla = null;
        while(curr != null){
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }
    public static boolean checkPalidromeList(Node head){
        Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node middle = slow;
        Node curr = middle.next, prev = null, after = null;
        while(curr != null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        middle.next = prev;
        Node head2 = slow.next;
        Node head1 = head;
        while(head2 != null && head2.next != null){
            if(head1.data == head2.data){
                head1 = head1.next;
                head2 = head2.next;
            }else{
                return false;
            }
        }
        return true;
    }
    public static int maxSum(Node head){
        Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){  //find right mid 
            slow = slow.next;
            fast = fast.next.next;
        }
        // Node middle = slow; 
        Node newNode = reverseList2(slow.next);
        slow.next = newNode;
        Node head1 = head, head2 = newNode;
        int sum = 0;
        while(head2 != null){
            int check = head1.data + head2.data;
            if(check > sum){
                sum = check;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return sum;
    }
    public static Node oddEvenList2(Node head) {
        Node temp = head, even = new Node(2), odd = new Node(1);
        Node tempO = odd, tempE = even;
        while(temp != null){
           tempO.next = temp;
           temp = temp.next;
           tempO = tempO.next;  //traverse tempO

           tempE.next = temp;
           if(temp == null) break;
           temp = temp.next;  
           tempE = tempE.next;  //traverse tempE
        }
        odd = odd.next;
        even = even.next;
        tempO.next = even;
        return odd;
    }
    public static Node oddEvenList3(Node head){
       Node temp = head, odd = new Node(1), even = new Node(1);
       Node tempO = odd, tempE = even;
       while(temp != null){
        tempO.next = temp;
        temp = temp.next;
        tempO = tempO.next;

        if(temp == null) break;

        tempE.next = temp;
        temp = temp.next;
        tempE = tempE.next;
       }
       odd = odd.next;
       even = even.next;
       odd.next = even;
       return odd;
    }
    public static Node swapOddEven(Node head){
        Node even = new Node(1), odd = new Node(1);
        Node temp = head, tempE = even, tempO = odd;
        while(temp != null){
            if(temp.data %2 == 0){
                tempE.next = temp;
                temp = temp.next;
                tempE = tempE.next;
            }else{
                tempO.next = temp;
                temp = temp.next;
                tempO = tempO.next;
            }
        }
        odd = odd.next;
        even = even.next;
        tempO.next = even;
        return odd;
    }
    public static Node swapOddEven2(Node head){
        Node temp = head, odd = new Node(1), even = new Node(1);
        Node tempE = even, tempO = odd;
        while(temp != null){
            if(temp.data %2 != 0){
                tempO.next = temp;
                temp = temp.next;
                tempO = tempO.next;
            }else{
                if(temp == null) break;
                tempE.next = temp;
                temp = temp.next;
                tempE = tempE.next;
            }
        }
        odd = odd.next;
        even = even.next;
        tempO.next = even;
        return odd;
    }
    public static Node swapOddEven3(Node head){
        Node temp = head, even = new Node(1), odd = new Node(1);
        Node tempE = even, tempO = odd;
        while(temp != null){
            if(temp.data %2 == 0){
                tempE.next = temp;
                temp = temp.next;
                tempE = tempE.next;
            }else{
                if(temp == null) break;
                tempO.next = temp;
                temp = temp.next;
                tempO = tempO.next;
            }
        }
        odd = odd.next;
        even = even.next;
        tempO.next = even;
        return odd;
    }
    public static Node oddEven4(Node head){
        Node temp = head, odd = new Node(1), even = new Node(1);
        Node tempOdd = odd, tempEven = even;
        while(temp != null){
            if(temp.data %2==0){
                tempEven.next = temp;
                temp = temp.next;
                tempEven = tempEven.next;
            }else{
                tempOdd.next = temp;
                temp = temp.next;
                tempOdd = tempOdd.next;
            }
        }
        odd = odd.next;
        even = even.next;
        tempOdd.next = even;
        return odd;
    }
    public static void main(String[] args) {
        // Node head1 = new Node(10);
        // Node head2 = new Node(3);

        // Node newNode = new Node(6);
        // head2.next = newNode;

        // newNode = new Node(9);
        // head2.next.next = newNode;

        // newNode = new Node(15);
        // head1.next = newNode;
        // head2.next.next.next = newNode;

        // newNode = new Node(30);
        // head1.next.next = newNode;
        // head1.next.next.next = null;
        // display(head1);
        // display(head2);

        // System.out.println(getIntersectionNode2(head1, head2).data);
        // 1st head1 -: 10 15 30
        // 2nd head2 -: 3 6 9 15 30

        Node n1 = new Node(2);
	    Node n2 = new Node(7);
	    Node n3 = new Node(9);
	    Node n4 = new Node(11);
	    Node n5 = new Node(13);
        Node n6 = new Node(12);
	    // 5 -> 3 -> 9 -> 8 -> 16 -> 19
	    n1.next = n2;
	    n2.next = n3;
	    n3.next = n4;
	    n4.next = n5;
        n5.next = n6;


        // n5 = n2.next;
        // System.out.println(n5.data);
        // n6.next = n3;
        display(n1);
        Node a = oddEven4(n1);
        // Node a = reverse5(n1);
        display(a);
        // Node a = swapOddEven3(n1);
        // display(a);
        // display(n1);
        // Node a = oddEvenList2(n1);
        // display(a);
        // oddEvenlist(n1);
        // System.out.println(maxSum(n1));
        // System.out.println(checkPalidromeList(n1));
        // displayrev(n1);
        // Node ans = reverseList2(n1);
        // display(ans);
        // Node ans = removeDuplicates2(n1);
        // display(ans);
        // Node ans = removeDuplicates(n1);
        // display(ans);
        // oddEvenlist(n1);
        // Node ans = mergeTwoLists(n1, m1);
        // display(ans);
        // Node ans = returnCycleNode(n1);
        // System.out.println(ans.data);
        // display(ans);
        // Node ans = midNode2(n1);
        // System.out.println(ans.data);
        // deleteMidNode2(n1);
        // display(n1);
        // System.out.println(middleNode(n1).data);
        // // Node ans = lastNthNode(n1, 2);
        // // Node ans = lastNthNode3(n1, 2);
        // Node ans = removeNthNode(n1, 4);
        // display(ans);
        // System.out.println(n1);
        // deleteNode(n3);
        // display(n1);
        // linkedlist ll = new linkedlist();
        // ll.insertAtEnd(23);
        // ll.insertAtEnd(25);
        // ll.insertAtEnd(26);
        // ll.insertAtEnd(28);
        // ll.insertAtEnd(29);
        // ll.display();
        // System.out.println(ll.size);
    }
}