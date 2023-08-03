public class problems{
    public static void printSubarrays(int arr[]){
        for(int i=0; i<arr.length; i++){
            // System.out.print(arr[i]+" ");
            for(int j=i; j<arr.length; j++){
                for(int k=j; k<arr.length; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int arr[] = {2, 4, 6, 8, 10};
        printSubarrays(arr);
    }
}