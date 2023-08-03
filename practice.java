import java.util.*;

import java1.stack;
public class practice{
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    public static class BinaryTree{
        static int index = -1;
        public static Node buildTree(int arr[]){
            index++;
            if(arr[index] == -1){
                return null;
            }
            Node temp = new Node(arr[index]);
            temp.left = buildTree(arr);
            temp.right = buildTree(arr);
            return temp;
        }
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static int change(int n){
        return 2;
    }
    public static int findCelebrity(int M[][], int n){
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
            s.push(i);
        }
        while(s.size() > 1){
            int val1 = s.pop();
            int val2 = s.pop();
            if(M[val1][val2] == 0){
                s.push(val2);
            }else if(M[val2][val1] == 0){
                s.push(val1);
            }
        }
        if(s.isEmpty()) return -1;
        int candidate = s.peek();
        for(int i=0; i<n; i++){
            if(M[candidate][i] == 1) return -1;
        }
        for(int i=0; i<n; i++){
            if(i == candidate) continue;
            if(M[i][candidate] == 0) return -1;
        }
        return candidate;
    }
    public static int slidingWindow(int arr[], int k){
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n && j<=k; j++){
                sum += arr[j];
            }
            if(max < sum){
                max = sum;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        // System.out.println("1");
        // int arr[] = {1, 2, 3, 4, 5};
        // System.out.println(slidingWindow(arr, 2));
        // int arr[][] = {{0, 1, 0},
        //                 {0, 0, 0},
        //                 {0, 1, 0}};
        // System.out.println(findCelebrity(arr, arr.length));

        // int n = 1;
        // change(n);
        // System.out.println(change(n));
        // System.out.println(n);
        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // preOrder(root);
        // System.out.println(root.data);
        // char s[] = {'h','e','l','l','o'};
        // Stack<Character> str = new Stack<>();
        // for(int i=0; i<s.length; i++){
        //     str.push(s[i]);
        // }   
        // String ans = "";
        // while(!str.empty()){
        //     ans += str.pop();
        // }
        // System.out.print(ans);
        // Stack<Integer> s = new Stack();
        // s.push()
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.remove();
        // System.out.println(q);
    }
}