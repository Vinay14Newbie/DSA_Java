package java1;

import java.util.*;

public class stack{
    public static Stack<Integer> countSubSeq(int arr[]){
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        for(int i=1; i<arr.length; i++){
          if(s.peek() == arr[i]){
            if(i == arr.length-1 || s.peek() != arr[i+1]){
                s.pop();
            }
          }else{
            s.push(arr[i]);
          }
        }
        return s;
    }
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void nextGreaterEle(int arr[], int ans[]){
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && arr[i] > s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = s.peek();
            }
            s.push(arr[i]);
        }
    }
    public static int infixExp(String str){
        Stack<Integer> nums = new Stack<>();
        Stack<Character> oper = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char currCh = str.charAt(i);
            int ascii = (int) currCh;
            if(ascii >= 48 && ascii < 58){
                nums.push(ascii-48);
            }else if(oper.size() == 0 || currCh == '(' || oper.peek() == '('){
                oper.push(currCh);
            }
            else if(currCh == ')'){
                while(oper.peek() != '('){
                    //work
                    int val2 = nums.pop();
                    int val1 = nums.pop();
                    if(oper.peek() == '-'){
                        nums.push(val1-val2);
                    }else if(oper.peek() == '+'){
                        nums.push(val1+val2);
                    }else if(oper.peek() == '/'){
                        nums.push(val1/val2);
                    }else if(oper.peek() == '*'){
                        nums.push(val1*val2);
                    }
                    oper.pop();
                }
                oper.pop();
            }
            else{
                if(currCh == '+' || currCh == '-'){
                    //work
                    int val2 = nums.pop();
                    int val1 = nums.pop();
                    if(oper.peek() == '-'){
                        nums.push(val1-val2);
                    }else if(oper.peek() == '+'){
                        nums.push(val1+val2);
                    }else if(oper.peek() == '/'){
                        nums.push(val1/val2);
                    }else if(oper.peek() == '*'){
                        nums.push(val1*val2);
                    }
                    oper.pop();
                    oper.push(currCh);
                }
                if(currCh == '*' || currCh == '/'){
                    if(oper.peek() == '*' || oper.peek() == '/'){
                        //work
                        int val2 = nums.pop();
                        int val1 = nums.pop();
                        if(oper.peek() == '/'){
                        nums.push(val1/val2);
                        }else if(oper.peek() == '*'){
                           nums.push(val1*val2);
                        }
                        oper.pop();
                        //push
                        oper.push(currCh);
                    }
                    else{
                        oper.push(currCh);
                    }
                }
            }
        }
        while(nums.size() > 1){
            int val2 = nums.pop();
            int val1 = nums.pop();
            if(oper.peek() == '-'){
                nums.push(val1-val2);
            }else if(oper.peek() == '+'){
                nums.push(val1+val2);
            }else if(oper.peek() == '/'){
                nums.push(val1/val2);
            }else if(oper.peek() == '*'){
                nums.push(val1*val2);
            }
            oper.pop();
        }
        return nums.pop();
    }
    public static int infixExp2(String str){
        Stack<Integer> nums = new Stack<>();
        Stack<Character> oper = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char currCh = str.charAt(i);
            int ascii = (int) currCh;
            if(ascii >= 48 && ascii < 58){
                nums.push(ascii-48);
            }else if(oper.isEmpty()){
                oper.push(currCh);
            }else if(currCh == '(' || oper.peek() == '('){
                oper.push(currCh);
            }else if(currCh == ')'){
                while(oper.peek() != '('){
                    int val1 = nums.pop();
                    int val2 = nums.pop();
                    if(oper.peek() == '+'){
                        nums.push(val2+val1);
                    }else if(oper.peek() == '-'){
                        nums.push(val2-val1);
                    }else if(oper.peek() == '*'){
                        nums.push(val2*val1);
                    }else if(oper.peek() == '/'){
                        nums.push(val2/val1);
                    }
                    oper.pop();
                }
                oper.pop();
            }
            else if(currCh == '+' || currCh == '-'){
                if(oper.peek() == '+' || oper.peek() == '-' || oper.peek() == '*' || oper.peek() == '/'){
                //work
                int val1 = nums.pop();
                int val2 = nums.pop();
                if(oper.peek() == '+'){
                    nums.push(val2+val1);
                }else if(oper.peek() == '-'){
                    nums.push(val2-val1);
                }else if(oper.peek() == '*'){
                    nums.push(val2*val1);
                }else if(oper.peek() == '/'){
                    nums.push(val2/val1);
                }
                oper.pop();
                oper.push(currCh);
            }
            }else if(currCh == '*' || currCh == '/'){
                if(oper.peek() == '+' || oper.peek() == '-'){
                    oper.push(currCh);
                }
                else if(oper.peek() == '*' || oper.peek() == '/'){
                    //work
                    int val1 = nums.pop();
                    int val2 = nums.pop();
                    if(oper.peek() == '*'){
                        nums.push(val2*val1);
                    }else if(oper.peek() == '/'){
                        nums.push(val2/val1);
                    }
                    oper.pop();
                    oper.push(currCh);
                }
            }
        }
        while(nums.size() > 1){
            int val1 = nums.pop();
            int val2 = nums.pop();
            if(oper.peek() == '*'){
                nums.push(val2*val1);
            }else if(oper.peek() == '/'){
                nums.push(val2/val1);
            }else if(oper.peek() == '+'){
                nums.push(val2+val1);
            }else if(oper.peek() == '-'){
                nums.push(val2-val1);
            }
            oper.pop();
        }
        return nums.peek();
    }
    public static void infixToPrefix(String str){
        Stack<String> strNums = new Stack<>();
        Stack<Character> oper = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char currCh = str.charAt(i);
            int ascii = (int) currCh;
            if(ascii >= 48 && ascii < 58){
                String s = "" + currCh;
                strNums.push(s);
            }else if(oper.isEmpty() || currCh == '(' || oper.peek() == '('){
                oper.push(currCh);
            }else if(currCh == ')'){
                while(oper.peek() != '('){
                    String v1 = strNums.pop();
                    String v2 = strNums.pop();
                    char op = oper.pop();
                    String s = op + v2 + v1;
                    strNums.push(s);
                }
                oper.pop();
            }else{
                if(currCh == '+' || currCh == '-'){
                    String v1 = strNums.pop();
                    String v2 = strNums.pop();
                    char op = oper.pop();
                    String s = op + v2 + v1;
                    strNums.push(s);
                    oper.push(currCh);
                }
                else if(currCh == '*' || currCh == '/'){
                    if(oper.peek() == '*' || oper.peek() == '/'){
                        String v1 = strNums.pop();
                        String v2 = strNums.pop();
                        char op = oper.pop();
                        String s = op + v2 + v1;
                        strNums.push(s);
                        oper.push(currCh);
                    }
                    else{
                        oper.push(currCh);
                    }
                }
            }
        }
        while(strNums.size() > 1){
            String v1 = strNums.pop();
            String v2 = strNums.pop();
            char op = oper.pop();
            String s = op + v2 + v1;
            strNums.push(s);
        }
        System.out.println(strNums.peek());
    }
    public static void infixToPostfix(String str){
        Stack<String> strNums = new Stack<>();
        Stack<Character> oper = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char currch = str.charAt(i);
            int ascii = (int) currch;
            if(ascii >= 48 && ascii < 58){
                String s ="" + currch;
                strNums.push(s);
            }else if(oper.isEmpty() || currch == '(' || oper.peek() == '('){
                oper.push(currch);
            }else if(currch == ')'){
                while(oper.peek() != '('){
                    String s1 = strNums.pop();
                    String s2 = strNums.pop();
                    char op = oper.pop();
                    String s = s2 + s1 + op;
                    strNums.push(s);
                }
                oper.pop();
            }else if(currch == '+' || currch == '-'){
                if(oper.peek() == '+' || oper.peek() == '-'){
                    String v1 = strNums.pop();
                    String v2 = strNums.pop();
                    char op = oper.pop();
                    String s = v2 + v1 + op;
                    strNums.push(s);
                }
                oper.push(currch);
            }else if(currch == '*' || currch == '/'){
                if(oper.peek() == '*' || oper.peek() == '/'){
                    String v1 = strNums.pop();
                    String v2 = strNums.pop();
                    char op = oper.pop();
                    String s = v2 + v1 + op;
                    strNums.push(s);
                }
                oper.push(currch);
            }
        }
        while(strNums.size() > 1){
            String v1 = strNums.pop();
            String v2 = strNums.pop();
            char op = oper.pop();
            String s = v2 + v1 + op;
            strNums.push(s);
        }
        System.out.println(strNums.peek());
    }
    public static int calculate(String str) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> oper = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char currCh = str.charAt(i);
            int ascii = (int) currCh;
            if(ascii >= 48 && ascii < 58){
                nums.push(currCh - 48);
            }else if(oper.isEmpty() || currCh == '(' || oper.peek() == '('){
                oper.push(currCh);
            }else if(currCh == ')'){
                while(oper.peek() != '('){
                    int val1 = nums.pop();
                    int val2 = nums.pop();
                    if(oper.peek() == '+'){
                        nums.push(val2 + val1);
                    }else if(oper.peek() == '-'){
                        nums.push(val2 - val1);
                    }
                    oper.pop();
                }
                oper.pop();
            }else{
                int val1 = nums.pop();
                int val2 = nums.pop();
                if(oper.peek() == '+'){
                    nums.push(val2 + val1);
                }if(oper.peek() == '-'){
                    nums.push(val2 - val1);
                }
                oper.pop();
                oper.push(currCh);
            }
        }
        while(nums.size() > 1){
            int val1 = nums.pop();
            int val2 = nums.pop();
            if(oper.peek() == '+'){
                nums.push(val2 + val1);
            }if(oper.peek() == '-'){
                nums.push(val2 - val1);
            }
            oper.pop();
        }
        return nums.peek();
    }
    public static int postfixEva(String str){
        Stack<Integer> nums = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char currCh = str.charAt(i);
            int ascii = (int) currCh;
            if(ascii >= 48 && ascii < 58){
                nums.push(ascii - 48);
            }else{
                int val1 = nums.pop();
                int val2 = nums.pop();
                if(currCh == '-'){
                    nums.push(val2 - val1);
                }else if(currCh == '+'){
                    nums.push(val2 + val1);
                }else if(currCh == '*'){
                    nums.push(val2 * val1);
                }else if(currCh == '/'){
                    nums.push(val2 / val1);
                }
            }
        }
        return nums.peek();
    }
    public static int prefixEva(String str){
        Stack<Integer> nums = new Stack<>();
        for(int i=str.length()-1; i>=0; i--){
            char currCh = str.charAt(i);
            int ascii = (int) currCh;
            if(ascii >= 48 && ascii < 58){
                nums.push(ascii - 48);
            }else{
                int val1 = nums.pop();
                int val2 = nums.pop();
                if(currCh == '+'){
                    nums.push(val1 + val2);
                }else if(currCh == '-'){
                    nums.push(val1 - val2);
                }else if(currCh == '*'){
                    nums.push(val1 * val2);
                }else if(currCh == '/'){
                    nums.push(val1 / val2);
                }

            }
        }
        return nums.peek();
    }
    public static void prefixToPostfix(String str){
        Stack<String> s = new Stack<>();
        for(int i=str.length()-1; i>=0; i--){
            char currCh = str.charAt(i);
            int ascii = (int) currCh;
            if(ascii >= 48 && ascii < 58){
                String temp = "" + currCh;
                s.push(temp);
            }else{
                String v1 = s.pop();
                String v2 = s.pop();
                char op = currCh;
                String temp = v1 + v2 + op;
                s.push(temp);
            }
        }
        System.out.println(s.peek());
    }
    public static void postfixToPrefix(String str){
        Stack<String> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char currCh = str.charAt(i);
            int ascii = (int) currCh;
            if(ascii >= 48 && ascii < 58){
                String temp = "" + currCh;
                s.push(temp);
            }else{
                String v1 = s.pop();
                String v2 = s.pop();
                char op = currCh;
                String temp = op + v2 + v1;
                s.push(temp);
            }
        }
        System.out.println(s.peek());
    }
    public static void postfixToInfix(String str){
        Stack<String> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char currCh = str.charAt(i);
            int ascii = (int) currCh;
            if(ascii >= 48 && ascii < 58){
                s.push("" + currCh);
            }else{
                String v1 = s.pop();
                String v2 = s.pop();
                char op = currCh;
                String temp = '(' + v2 + op + v1 + ')';
                s.push(temp);
            }
        }
        System.out.println(s.peek());
    }
    public static void prefixToInfix(String str){
        Stack<String> s = new Stack<>();
        for(int i=str.length()-1; i>=0; i--){
            char currCh = str.charAt(i);
            int ascii = (int) currCh;
            if(ascii >= 48 && ascii < 58){
                s.push(currCh + "");
            }else{
                String v1 = s.pop();
                String v2 = s.pop();
                char op = currCh;
                String temp = '(' + v1 + op + v2 + ')';
                s.push(temp);
            }
        }
        System.out.println(s.peek());
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
    public static void main(String args[]){
        // System.out.println(infixExp("(9-(((5+3)*4)/6))"));
        // infixToPostfix("9-(5+3)*4/6");
        // prefixToInfix("-9/*+5346");
        int arr[][] = {{0, 1, 0},
                       {0, 0, 0},
                       {0, 1, 0}};
        System.out.println(findCelebrity(arr, arr.length));
        // postfixToInfix("95-34*6/+");
        // prefixToPostfix( "-9/*+5346");
        // System.out.println(prefixEva("-9/*+5346"));
        // System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        // int arr[] = {1, 3, 6, 2, 9};
        // int ans[] = new int[arr.length];
        // nextGreaterEle(arr, ans);
        // printArr(ans);
        // int arr[] = {1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3};
        // System.out.println(countSubSeq(arr));
        // System.out.println(reverseSTringByStack("naruto"));
        // Stack<Integer> s1 = new Stack<>();
        // Stack<Integer> s2 = new Stack<>();
        // Stack2 s1 = new Stack2();
        // s1.push(1);
        // s1.push(2);
        // s1.push(3);
        // s1.push(4);
        // s1.push(5);
        // s1.push(6);
        // System.out.println(s1.peek());
        // s1.display();
        // System.out.println(s1);
        // System.out.println("s1" +s1);
        // System.out.println("s2 "+ s2);
        // moveStack(s1, s2);
        // System.out.println("s1 " +s1);
        // System.out.println("s2" +s2);
        // System.out.println(s1);
    }
}