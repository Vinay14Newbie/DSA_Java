public class problems2{
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int slidingWindow_maxValue(int arr[], int k){
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<k+i && i<=n-k; j++){
                sum += arr[j];
            }
            if(max < sum){
                max = sum;
            }
        }
        return max;
    }
    
    public static int[] slidingWindow_usingLoops(int arr[], int k){
        int n = arr.length;
        int ans[] = new int[n-k+1];
        for(int i=0; i<=n-k; i++){
            int sum = 0;
            for(int j=i; j<i+k; j++){
                sum = Math.max(sum, arr[j]);
            }
            ans[i] = sum;
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        // System.out.println(slidingWindow_maxValue(arr, 3));
        int ans[] = slidingWindow_usingLoops(arr, 3);
        printArr(ans);
    }
}