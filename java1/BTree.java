package java1;

import java.util.*;

public class BTree{
    public static class Node{
        int data;
        Node left;
        Node right;

        Node (int data){
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
    public static void preorderTraversal(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    public static void inorderTraversal(Node root){
        if(root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.data+" ");
        inorderTraversal(root.right);
    }
    public static void postorderTraversal(Node root){
        if(root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data+" ");
    }
    public static Node buildTree2(Node root){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter data :");
        int n = sc.nextInt();
        if(n == -1){
            return null;
        }
        root = new Node(n);
        System.out.println("enter the left side data for root :"+root.data);
        root.left = buildTree2(root);
        System.out.println("enter the right side data for root :"+root.data);
        root.right = buildTree2(root);
        return root;
    }
    public static void levelOrderTraversal(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(! q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()) break;
                else{
                    q.add(null);
                }
            }else{
            System.out.print(currNode.data+" ");
            if(currNode.left != null){
                q.add(currNode.left);
            }
            if(currNode.right != null){
                q.add(currNode.right);
            }
            }
        } 
    }
    public static int countLeafNodes(Node root){
       if(root == null) return 0;
       if(root.left == null && root.right == null){
        System.out.println("leaf Nodes : "+ root.data);
        return 1;
       }
       int left = countLeafNodes(root.left);
       int right = countLeafNodes(root.right);
       return left + right;
    }
    public static int countNodes(Node root){
        if(root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }
    public static int sumOfNodes(Node root){
        if(root == null) return 0;
        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);
        return left + right + root.data;
    }
    public static int heightOfTree(Node root){
        if(root == null) return 0;
        int left = heightOfTree(root.left)+1;
        int right = heightOfTree(root.right)+1;
        return Math.max(left, right);
    }
    public static int diameterOfATree(Node root){
        if(root == null){
            return 0;
        }
        // int left = diameterOfATree(root.left);
        // int right = diameterOfATree(root.right);
        int dia = (heightOfTree(root.left)) + (heightOfTree(root.right)) + 1;
        int left = diameterOfATree(root.left);
        int right = diameterOfATree(root.right);
        return Math.max(dia, Math.max(left, right));
    }
    public static class TreeInfo{
        int height;
        int dia;
        TreeInfo(int height, int dia){
            this.height = height;
            this.dia = dia;
        }
    } 
    public static TreeInfo diameter(Node root){
        if(root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo leftInfo = diameter(root.left);
        TreeInfo rightInfo = diameter(root.right);

        int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.height + rightInfo.height + 1);
        int height = Math.max(leftInfo.height, rightInfo.height);
        return new TreeInfo(height, dia);
    }   
    public static void printKthLevel(int k, Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int count = 1;
        while(!q.isEmpty()){
            Node temp = q.remove();
            if(temp != null){
                if(count == k){
                    System.out.print(temp.data+" ");
                }
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }else{
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    count++;
                }
            }
        }
    }
    public static void printKthLevel2(int k, Node root, int level){
        if(root == null) return;
        if(level == k){
            System.out.print(root.data+" ");
            return;
        }
        printKthLevel2(k, root.left, level+1);
        printKthLevel2(k, root.right, level+1);
    }
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        //last common ancestor
        int i=0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        //last equal node -> i-1th
        Node lca = path1.get(i-1);
        return lca;
    }
    public static Node lca3(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2) return root;
        Node left = lca3(root.left, n1, n2);
        Node right = lca3(root.right, n1, n2);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
    public static int lcaDistance(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDis = lcaDistance(root.left, n);
        int rightDis = lcaDistance(root.right, n);

        if(leftDis == -1 && rightDis == -1){
            return -1;
        }else if(leftDis == -1){
            return rightDis + 1;
        }else{
            return leftDis + 1;
        }
    }
    public static int minDistance(Node root, int n1, int n2){
        Node lca = lca3(root, n1, n2);
        int dis1 = lcaDistance(lca, n1);
        int dis2 = lcaDistance(lca, n2);
        return dis1 + dis2;
    }
    public static int sumOfKthNOdes(Node root, int k, int idx){
        if(root == null) return 0;
        if(idx == k){
            return root.data;
        }
        int left = sumOfKthNOdes(root.left, k, idx+1);
        int right = sumOfKthNOdes(root.right, k, idx+1);
        return left + right;
    }
    public static boolean searchInBst(Node root, int n){
        if(root == null) return false;
        if(root.data == n) return true;
        if(root.data > n){
            return searchInBst(root.left, n);
        }else{
            return searchInBst(root.right, n);
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static Node deleteNode(Node root, int val){
        if(root == null) return null;
        if(root.data == val){
            //case 1
            if(root.left == null && root.right == null){
                return null;
            }

            //case 2
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        if(root.data > val){
            root.left = deleteNode(root.left, val);
        }else{
            root.right = deleteNode(root.right, val);
        }
        return root;
    }
    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public static Node deleteNode2(Node root, int val){
        if(root == null) return null;
        if(root.data == val){
            //case 1
            if(root.left == null && root.right == null){
                return null;
            }

            //case 2
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //case 3
            Node RIS = rightInorderSuccessor(root.right);
            root.data = RIS.data;
            root.right = deleteNode2(root.right, RIS.data);
        }
        if(root.data > val){
            root.left =  deleteNode2(root.left, val);
        }else{
            root.right = deleteNode2(root.right, val);
        }
        return root;
    }
    public static Node rightInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public static void printRange(Node root, int n1, int n2){
        if(root == null) return;
        // if((root.data <= n1 && root.data >= n2) || (root.data >= n1 && root.data <= n2)){
        //     System.out.print(root.data+" ");
        // }
        if(root.data >= n1 && root.data <= n2){
            printRange(root.left, n1, n2);
            System.out.print(root.data+" ");
            printRange(root.right, n1, n2);
        }else if(root.data >= n1 && root.data >= n2){
            printRange(root.left, n1, n2);
        }else{
            printRange(root.right, n1, n2);
        }
    }
    public static ArrayList<Integer> inRange(Node root, int n1, int n2){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            // ans.add(null);
            return ans;
        }
        if(root.data == n1 || root.data == n2){
            ans.add(root.data);
            return ans;
        }
        if((root.data < n1 && root.data > n2) || (root.data > n1 && root.data < n2)){
            ans.add(root.data);
        }
        // ArrayList<Integer> currAns = new ArrayList<>();
         if(root.data > n1 && root.data < n2){
            ans.addAll(inRange(root.left, n1, n2));
            ans.addAll(inRange(root.right, n1, n2));
        }else if(root.data > n1 && root.data > n2){
            ans.addAll(inRange(root.left, n1, n2));
        }else{
            ans.addAll(inRange(root.right, n1, n2));
        }
        return ans;
    }
    public static void printRange2(Node root, int n1, int n2){
        if(root == null) return;
        if(root.data >= n1 && root.data <= n2){
            printRange2(root.left, n1, n2);
            System.out.print(root.data+" ");
            printRange2(root.right, n1, n2);
        }else if(root.data >= n1 && root.data >= n2){
            printRange2(root.left, n1, n2);
        }else{
            printRange2(root.right, n1, n2);
        }
    }
    public static void printRootPath(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            System.out.println(path);
        }else{
            printRootPath(root.left, path);
            printRootPath(root.right, path);
        }
        path.remove(path.size()-1);
    }
    public static void printRootPath2(Node root, ArrayList<Integer> path){
        if(root == null) return;
        path.add(root.data);
        if(root.left == null && root.right == null){
            System.out.println(path);
        }else{
            printRootPath2(root.left, path);
            printRootPath2(root.right, path);
        }
        path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        // int arr[] = {1, 2, 4, -1, -1, 5, -1, 8, -1, -1, 3, 7, -1, -1, 6, -1, -1};
        // int arr1[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        /*  
          BST
         *              4
         *            /   \
         *           2     5
         *          / \     \
         *         1   3     6 
        */
        /* 
         *              8
         *            /   \
         *          3      10
         *        /   \       \
         *       1      6       14
         *             /  \     /
         *            4    7   13
         */
        // int arr2[] = {4, 2, 1, -1, -1, 3, -1, -1, 5, -1, 6, -1, -1};
        int arr3[] = {8, 3, 1, -1, -1, 6, 4, -1, -1, 7, -1, -1, 10, -1, 14, 13, -1, -1, -1};
        Node root = BinaryTree.buildTree(arr3);
        ArrayList<Integer> ans = new ArrayList<>();
        printRootPath2(root, ans);
        // printRange(root, 6, 14);
        // System.out.println(inRange(root, 6, 14));
        // inorderTraversal(root);
        // System.out.println();
        // Node deleteNode = deleteNode(root, 6);
        // inorderTraversal(deleteNode);
        // System.out.println(searchInBst(root, 9));
        // int arr3[] = {5, 1, 3, 4, 2, 7};
        // Node root = null;
        // for(int i=0; i<arr3.length; i++){
        //     root = insert(root, arr3[i]);
        // }
        // inorderTraversal(root);
        /*
         *             5
         *            / \
         *           1   7
         *            \
         *             3 
         *            / \
         *           2   4
         */
        // inorderTraversal(root);
        // System.out.println(lca3(root, 5, 6).data);
        // printKthLevel2(2, root, 1);
    }
}