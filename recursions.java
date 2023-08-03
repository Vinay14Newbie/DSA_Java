import java.util.ArrayList;

public class recursions{
    public static void printNo(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        printNo(n-1);
    }
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        return factorial(n-1) * n;
    }
    public static int fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static int sum(int n){
        if(n == 0){
            return 0;
        }
        return sum(n-1) + n;
    }
    public static int count(int n){
        if(n > 0 && n < 10){
            return 1;
        }
        return count(n/10)+1;
    }
    public static int pow(int p, int q){
        if(q == 0){
            return 1;
        }
        return pow(p, q-1) * p;
    }
    public static void multipleOfK(int n, int k){
        if(k == 0){
            return;
        }
        multipleOfK(n, k-1);
        System.out.print(n*k+" ");
    }
    public static int sumOfN(int n){
        if(n == 0) return 0;
        if(n%2==0){
            return sumOfN(n-1) - n;
        }else{
            return sumOfN(n-1) + n;
        }
    }
    public static int seriesSum(int n){
        if(n == 0) return 0;
        int sum = seriesSum(n-1);
        if(n%2==0){
            return sum - n;
        }else{
            return sum + n;
        }
    }
    public static int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x%y);
    }
    public static void printArr(int arr[], int index){
        if(index == arr.length){
            // System.out.print(arr[index]+" ");
            return;
        }
        System.out.print(arr[index]+" ");
        printArr(arr, index+1);
    }
    public static int maxValue(int arr[], int index){
        if(index == arr.length-1){
            return arr[index];
        }
       int max = maxValue(arr, index+1);
       return Math.max(arr[index], max);
    }
    public static int sumofArr(int arr[], int index){
        if(index == arr.length-1){
            return arr[index];
        }
        int max = sumofArr(arr, index+1);
        return max + arr[index];
    }
    public static boolean checkPalindrome(int arr[], int index){
        if(index == arr.length/2){
            return true;
        }
        if(arr[index] == arr[arr.length-(index+1)]){
            return checkPalindrome(arr, index+1);
        }else{
            return false;
        }
    }
    public static boolean checkTarget(int arr[], int index, int target){
        if(index == arr.length) return false;
        if(arr[index] == target) return true;
        else{
            return checkTarget(arr, index+1, target);
        }
    }
    public static int checkTarget2(int arr[], int index, int target){
        if(index == arr.length) return -1;
        if(arr[index] == target) return index;
        else{
            return checkTarget2(arr, index+1, target);
        }
    }
    public static void checkTarget3(int arr[], int index, int target){
        if(index == arr.length-1) return;
        if(arr[index] == target){
            System.out.print(index+" ");
        }else{
            checkTarget3(arr, index+1, target);
        }
    }
    public static ArrayList<Integer> checkTarget5(int arr[], int index, int target){
        ArrayList<Integer> ans = new ArrayList<>();
        if(index == arr.length){
            return ans;
        }
        if(arr[index] == target){
            ans.add(index);
        }
        ans.addAll(checkTarget5(arr, index+1, target));
        return ans;
    }
    public static boolean checkSorted(int arr[], int index){
        if(index == arr.length-1) return true;
        if(arr[index] > arr[index+1]){
            return false;
        }
        return checkSorted(arr, index+1);
    }
    public static int checkTarget6(int arr[], int index, int target){
        if(index == arr.length) return -1;
        int smallans = checkTarget6(arr, index+1, target);
        if(smallans == -1 && arr[index] == target){
            return index;
        }
        return smallans;
    }
    public static String removeAccurance(String str){
        if(str.length() == 0){
            return "";
        }
       String s = removeAccurance(str.substring(1));
       if(str.charAt(0) != 'a'){
        return str.charAt(0) + s;
       }else{
        return s;
       }
    }
    public static String reveString(String str){
        if(str.length() == 0) return "";
        String s = reveString(str.substring(1));
        s += str.charAt(0);
        return s;
    }
    public static boolean checkPalindromeString(String str){
        if(str.length()-1 == 0) return true;
        if(str.charAt(0) != str.charAt(str.length()-1)){
            return false;
        }
        return checkPalindromeString(str.substring(1, str.length()-1));
    }
    public static ArrayList<String> returnsubsequence(String str, String currans){
        ArrayList<String> ans = new ArrayList<>();
        if(str.length() == 0){
            ans.add(currans);
            return ans;
        }
        ArrayList<String> smallans = returnsubsequence(str.substring(1), currans);
        for(String i : smallans){
            ans.add(i);
            ans.add(str.charAt(0)+i);
        }
        return ans;
    }
    public static void subsequence(String str, String ans){
        if(str.length() == 0){
            System.out.print(ans+" ");
            return;
        }
        subsequence(str.substring(1), ans+str.charAt(0));
        subsequence(str.substring(1), ans);
    }
    public static void telephoneKeypad(String digits, String keypad[], String ans){
        if(digits.length() == 0){
            System.out.print(ans+" ");
            return;
        }
        int index = digits.charAt(0) - '0';
        String keypad1 = keypad[index];
        for(int i=0; i<keypad1.length(); i++){
            telephoneKeypad(digits.substring(1), keypad, ans+keypad1.charAt(i));
        }
    }
    public static int frogJump(int arr[], int index){
        if(index == arr.length-1){
            return 0;
        }
        int option1 = frogJump(arr, index+1) + Math.abs(arr[index+1] - arr[index]);
        if(index == arr.length-2) return option1;
        int option2 = frogJump(arr, index+2) + Math.abs(arr[index+2] - arr[index]);
        return Math.min(option1, option2);
    }
    public static void main(String[] args) {
        // printNo(11);
        // multipleOfK(5, 10);
        // int arr[] = {1, 2, 3, 4, 5, 6, 9};
        // System.out.println(checkPalindromeString("miheyehim"));
        // subsequence("abc", "");
        // String keypad[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // telephoneKeypad("23", keypad, "");
        int arr[] = {10, 30, 40, 20};
        System.out.println(frogJump(arr, 0));
    }
}