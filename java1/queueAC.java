package java1;

import java.util.*;

public class queueAC{
    public static class Queue1{
        static int arr[];
        static int rear = -1;
        static int size;
        Queue1(int size){
            this.size = size;
            arr = new int[size];
        }

        //empty
        public static boolean isEmpty(){
            return rear == -1;
        }

        //enque
        public static void add(int data){
            if(rear == size-1){
                System.out.println("arr is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        //dequeue
        public static int remove(){
            if(isEmpty()){
                System.out.println("arr is empty");
                return -1;
            }
            int data = arr[0];
            for(int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return data;
        }

        //front
        public static int peek(){
            if(isEmpty()){
                System.out.println("arr is empty :");
                return -1;
            }
            return arr[0];
        }
    }
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static class Queue2{
        static Node head;
        static Node tail;
        //empty
        public static boolean isEmpty(){
            return head==null;
        }

        //add
        public static void add(int data){
            Node temp = new Node(data);
            if(isEmpty()){
                head = tail =temp;
                return;
            }
            tail.next = temp;
            tail = temp;
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty :");
                return -1;
            }
            int temp = head.data;
            head = head.next;
            return temp;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty :");
                return -1;
            }
            return head.data;
        }
    }
    public static class Queue3{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        //empty
        public static boolean isEmpty(){
            return s1.isEmpty() && s2.empty();
        }

        //add
        public static void add(int data){
            if(s1.isEmpty()){
                s1.push(data);
                return;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        //remove
        public static int remove(){
            if(s1.empty()){
                System.out.println("queue is empty now :");
                return -1;
            }
            return s1.pop();
        }

        //peek
        public static int peek(){
            if(s1.empty()){
                System.out.println("queue is empty now :");
                return -1;
            }
            return s1.peek();
        }
    }
    public static class stack2{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        //empty
        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        //add
        public static void push(int data){
            if(q1.isEmpty()){
                q1.add(data);
                return;
            }
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
            q1.add(data);
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }

        //remove
        public static int pop(){
            if(q1.isEmpty()){
                System.out.println("stack is empty :");
                return -1;
            }
            return q1.remove();
        }

        //peek
        public static int peek(){
            if(q1.isEmpty()){
                System.out.println("stack is empty :");
                return -1;
            }
            return q1.peek();
        }
    }
    public static void printNonRepeating(String str){
        int freq[] = new int[26];   //'a' - 'z'
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<str.length(); i++){
            char currCh = str.charAt(i);
            q.add(currCh);
            freq[currCh-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }
    public static void printNonRepeating2(String str){
        Queue<Character> q = new LinkedList<>();
        char freq[] = new char[26];
        for(int i=0; i<str.length(); i++){
            char currCh = str.charAt(i);
            freq[currCh-'a']++;
            q.add(currCh);
            while(!q.isEmpty() && freq[q.peek()-'a']  > 1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }
    public static Queue<Integer> interleave(Queue<Integer> q){
        int size = q.size();
        Queue<Integer> q2 = new LinkedList<>();
        while(q.size() != size/2){
            q2.add(q.remove());
        }
        Queue<Integer> q3 = new LinkedList<>();
        while(!q.isEmpty() && !q2.isEmpty()){
            q3.add(q2.remove());
            q3.add(q.remove());
        }
        return q3;
    }
    public static void interleave2(Queue<Integer> q1){
        Queue<Integer> q2 = new LinkedList<>();
        int size = q1.size();
        while(q1.size() != size/2){
            q2.add(q1.remove());
        }
        while(!q2.isEmpty()){
            q1.add(q2.remove());
            q1.add(q1.remove());
        }
    }
    public static void reverse(Queue<Integer> q){
        if(q.isEmpty()){
            return;
        }
        int top = q.remove();
        reverse(q);
        q.add(top);;
    }
    public static void reverse2(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static class stack4{
        static Deque<Integer> dq = new LinkedList<>();

        //empty
        public static boolean isEmpty(){
            return dq.isEmpty();
        }

        //push
        public static void push(int data){
            dq.addFirst(data);
        }

        //pop
        public static int pop(){
            return dq.removeFirst();
        }

        //peek
        public static int peek(){
            return dq.peek();
        }
    }
    public static class queue4{
        static Deque<Integer> dq = new LinkedList<>();

        //empty
        public static boolean isEmpty(){
            return dq.isEmpty();
        }

        //add
        public static void add(int data){
            dq.addLast(data);
        }

        //remove
        public static int remove(){
            return dq.removeFirst();
        }

        //peek
        public static int peek(){
            return dq.peek();
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating2(str);
        // stack4 s = new stack4();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // s.push(5);
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }
        // System.out.println(s);
        // Queue<Integer> q = new LinkedList<>();
        // Deque<Integer> dq = new LinkedList<>();
        // queue4 q = new queue4();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // System.out.println(q.peek());
        // while(!q.isEmpty()){
        //     System.out.println(q.remove());
        // }
        // dq.add(6);
        // dq.add(7);
        // dq.add(8);
        // dq.add(9);
        // dq.add(10);
        
        // Queue<Integer> ansQ = interleave(q);
        // interleave2(q);
        // reverse2(q);
        // System.out.println(dq.getLast());
        // System.out.println(dq);
        // while(!dq.isEmpty()){
        //     System.out.print(dq.remove()+" ");
        // }

        // String str = "aabccxb";
        // printNonRepeating2(str);
        // stack2 q = new stack2();
        // q.push(1);
        // q.push(2);
        // q.push(3);
        // q.push(5);
        // q.push(7);
        // System.out.println("pop : "+q.pop());
        // q.push(8);
        // System.out.println(q.peek());
        // while(!q.isEmpty()){
        //     System.out.println(q.pop());
        // }
    }
}