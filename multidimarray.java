public class multidimarray{
  public static int firstOccurance(int arr[], int target){
    int start = 0, end = arr.length-1, ans = -1;
    while(start <= end){
      int mid = start + (end-start) /2;
      if(arr[mid] == target){
        ans = mid;
        end = mid-1;
      }else if(arr[mid] > target){
        end = mid-1;
      }else{
        start = mid+1;
      }
    }
    return ans;
  }
  public static int squareRoot(int n){
    int start=1, end=n, ans=-1;
    while(start <= end){
      int mid = start+(end-start)/2;
      int value = mid*mid;
      if(value == n){
        return mid;
      }else if(value > n){
        end = mid-1;
      }else{
        start = mid+1;
        ans = mid;
      }
    }
    return ans;
  }
  public static int findMin(int arr[]){
    int start=0, end=arr.length-1, ans=-1;
    while(start<=end){
      int mid = start+(end-start)/2;
      if(arr[mid] <= arr[arr.length-1]){
        ans = mid;
        end = mid-1;
      }else{
        start = mid+1;
      }
    }
    return ans;
  }
  public static int find(int arr[], int target){
    int start=0, end=arr.length-1;
    while(start<=end){
      int mid = start+(end-start)/2;
      if(arr[mid] == target){
        return mid;
      }
      if(arr[mid] > arr[start]){
        if(target < arr[mid] && target >= arr[start]){
          end = mid-1;
        }else{
          start = mid+1;
        }
      }else{
        if(target > arr[mid] && target <= arr[end]){
          start = mid+1;
        }else{
          end = mid-1;
        }
      }
    }
    return -1;
  }
  public static boolean find2(int arr[], int target){
    int start=0, end=arr.length-1;
    while(start <= end){
      int mid = start+(end-start)/2;
      if(arr[mid] ==  target)return true;
      if(arr[start] == arr[mid] && arr[end] == arr[mid]){
        start++;
        end--;
      }else if(arr[mid] > arr[start]){
        if(arr[start] <= target && arr[mid] > target){
          end = mid-1;
        }else{
          start = mid+1;
        }
      }else{
        if(arr[mid] < target && arr[end] >= target){
          start = mid+1;
        }else{
          end = mid-1;
        }
      }
    }
    return false;
  }
  public static int peakIndex(int arr[]){
    int n = arr.length;
   int start=0, end=arr.length-1;
   while(start<=end){
        int mid = start + (end - start) / 2;
        if((mid == 0 || arr[mid] > arr[mid-1]) && (mid == n-1 || arr[mid] > arr[mid+1])){
            return mid;
        }
        if(arr[mid] < arr[mid+1]){
            start = mid+1;
        }else{
            end = mid-1;
        }
    }
    return -1;
  }
  public static boolean findTarget(int matrix[][], int target){
    int row=matrix.length, col=matrix[0].length;
    int start=0, end=row*col-1;
    while(start <= end){
      int mid = start+(end-start)/2;
      int midEle = matrix[mid/col][mid%col];
      if(midEle == target){
        return true;
      }
      if(midEle < target){
        start = mid+1;
      }else{
        end = mid-1;
      }
    }
    return false;
  }
  public static boolean findTarget2(int matrix[][], int target){
    int row = matrix.length, col = matrix[0].length;
    int i=0, j=col-1;
    while(i<row && j>=0){
      if(matrix[i][j] == target){
        return true;
      }
      if(matrix[i][j] < target){
        i++;
      }else{
        j--;
      }
    }
    return false;
  }
  public static int peakmountain(int arr[]){
    int start=0, end=arr.length-1, ans=-1;
    while(start<=end){
      int mid = start+(end-start)/2;
      if(arr[mid] < arr[mid+1]){
        ans = mid+1;
        start = mid+1;
      }else{
        end = mid-1;
      }
    }
    return ans;
 }
  public static int peakEle(int num[]){
    int arr[] = num;
    int start = 0, end = arr.length-1, ans = -1;
    while(start <= end){
      int mid = start+(end-start)/2;
      if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
        return mid;
      }
      if(arr[mid] < arr[mid+1]){
        ans = mid+1;
        start = mid+1;
      }else{
        end = mid-1;
      }
    }
    return ans;
  }
  public static int distributeChocolates(int arr[], int n){
    int start=0, end=(int)1e9, ans=-1;
    while(start <= end){
      int mid = start+(end-start)/2;
      if(isDivisionPossible2(arr, mid, n)){
        ans = mid;
        end = mid-1;
      }else{
        start = mid+1;
      }
    }
    return ans;
  }
  public static boolean isDivisionPossible(int arr[], int chocolatesAllow, int noOfStudents){
    int currStudents = 1, chocolates = 0;
    for(int i=0; i<arr.length; i++){
      if(arr[i] > chocolatesAllow) return false;
      if(arr[i]+chocolates <= chocolatesAllow){
        chocolates += arr[i];
      }else{
        currStudents++;
        chocolates = arr[i];
      }
    }
    return currStudents <= noOfStudents;
  }
  public static boolean isDivisionPossible2(int arr[], int chocolatesAllow, int noOfStudents){
    int totalStudents = 1, chocolates = arr[0];
    for(int i=1; i<arr.length; i++){
      if(arr[i] > chocolates) return false;
      if(arr[i]+chocolates <= chocolatesAllow){
        chocolates += arr[i];
      }else{
        totalStudents++;
        chocolates = arr[i];
      }
    }
    return totalStudents <= noOfStudents;
  }
  public static int spaceInTracks(int arr[], int n){
    int start=0, end=(int)1e9, ans=-1;
    while(start <= end){
      int mid = start+(end-start)/2;
      if(isSpaceAllow2(mid, arr, n)){
        ans = mid;
        start = mid+1;
      }else{
        end = mid-1;
      }
    }
    return ans;
  }
  public static boolean isSpaceAllow(int Givenspace, int arr[], int students){
    int currSpace = arr[0];
    int noOfStudents = 1;
    for(int i=1; i<arr.length; i++){
      if(arr[i]-currSpace >= Givenspace){
        currSpace = arr[i];
        noOfStudents++;
      }
    }
    return noOfStudents >= students;
  }
  public static boolean isSpaceAllow2(int Givenspace, int arr[], int students){
    int noOfStudents = 1, currSpace = 0;
    for(int i=0; i<arr.length; i++){
      if(arr[i]-arr[currSpace] >= Givenspace){
        noOfStudents++;
        currSpace = i;
      }
    }
    return noOfStudents >= students;
  }
  public static int spaceInTracks2(int arr[], int n){
    int start=0, end=arr.length-1, ans=-1;
    while(start <= end){
      int mid = start+(end-start)/2;
      if(isSpaceAllow3(mid, arr, n)){
        ans = mid;
        start = mid+1;
      }else{
        end = mid-1;
      }
    }
    return ans;
  }
  public static boolean isSpaceAllow3(int Givenspace, int arr[], int students){
    int noOfStudents = 1, spaceInTracks = 0;
    for(int i=0; i<arr.length; i++){
      if(arr[i] - arr[spaceInTracks] >= Givenspace){
        spaceInTracks = i;
        noOfStudents++;
      }
    }
    return noOfStudents >= students;
  }
  public static void main(String args[]){
    // int arr[] = {5,3,1,4,2};
    int arr[] = {1,2,4,8,9};
    int n = 3;
    System.out.println(spaceInTracks2(arr, n));
    // int matrix[][] = {{1,3,5,7},
    //                   {2,11,16,20},
    //                   {5,30,34,60}};
    // System.out.print(findTarget2(matrix, 10));
  }
}