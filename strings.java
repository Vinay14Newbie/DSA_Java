public class strings{
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
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(slidingWindow(arr, 2));

        // int a = 5;
        // int b = a;
        // b = b+1;
        // System.out.println(b);
        // System.out.println(a);
    }
}