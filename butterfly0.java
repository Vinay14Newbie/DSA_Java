import java.util.Scanner;

public class butterfly0{
    public static void prefixSum(int matrix[][]){
        int row = matrix.length;
        int column = matrix[0].length;

        for(int i=0; i<row; i++){
            for(int j=1; j<column; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }

        for(int j=0; j<column; j++){
            for(int i=1; i<row; i++){
                matrix[i][j] += matrix[i-1][j];
            }
        }
    }
    public static int rectangleSum(int matrix[][], int l1, int r1, int l2, int r2){
       prefixSum(matrix);
       int up = 0, left = 0, common = 0;
       int sum = matrix[l2][r2];
       if(l1 >= 1){
       up = matrix[l1-1][r2];
       }
       if(r1 >= 1){
       left = matrix[l2][r1-1];
       }
       if(l1 >=1 && r1 >= 1){
       common = matrix[l1-1][r1-1];
       }
       int ans = sum - left - up + common;
       return ans;
}
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("enter an size of an row and column :");
    int row = sc.nextInt();
    int column = sc.nextInt();
    int matrix[][] = new int[row][column];
    System.out.println("enter an matrix :");
    for(int i=0; i<row; i++){
        for(int j=0; j<column; j++){
            matrix[i][j] = sc.nextInt();
        }
    }

    System.out.println("enter number of querries :");
    int q = sc.nextInt();

    prefixSum(matrix);
    
    for(; q>0; q--){
    System.out.println("enter an first row and column :");
    int l1 = sc.nextInt();
    int r1 = sc.nextInt();
    System.out.println("enter an second row and column :");
    int l2 = sc.nextInt(); 
    int r2 = sc.nextInt();

    // int ans = rectangleSum(matrix, l1, r1, l2, r2);
    // System.out.println("sum of rectangle is : "+ans);

       int up = 0, left = 0, common = 0;
       int sum = matrix[l2][r2];
       if(l1 >= 1){
       up = matrix[l1-1][r2];
       }
       if(r1 >= 1){
       left = matrix[l2][r1-1];
       }
       if(l1 >=1 && r1 >= 1){
       common = matrix[l1-1][r1-1];
       }
       int ans = sum - left - up + common;
       System.out.println("rectangel sum is : "+ans);
    }
}
}