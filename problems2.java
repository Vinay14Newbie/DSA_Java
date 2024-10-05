import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class problems2{
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void printMatrix(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
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
    
    public static class pair implements Comparable<pair>{
        int val;
        int idx;
        pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        public int compareTo(pair temp){
            return temp.val-this.val;   //highes to lowest  
        }
    }
    public static int[] slidingWindow(int arr[], int k){
        int n = arr.length;
        int ans[] = new int[n-k+1];
        int j = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(new pair(arr[i], i));
            while (!pq.isEmpty() && pq.peek().idx <= i-k) {
                pq.poll();
            }
            if(i+1 >= k){
                ans[j++] = pq.peek().val;
            }
        }   
        return ans; 
    }
    
    public static int bestTimeForStock(int arr[], int n, int idx, int stat){
        //  -1 == already buy time to sell
        if(idx == n)return 0;

        if(stat != -1){
            int sell = (arr[idx] - arr[stat]) + bestTimeForStock(arr, n, idx+1, -1);
            int notsell = bestTimeForStock(arr, n, idx+1, stat);
            return Math.max(sell, notsell);
        }
        else{
            int buy = bestTimeForStock(arr, n, idx+1, idx);
            int notbuy = bestTimeForStock(arr, n, idx+1, -1);
            return Math.max(buy, notbuy);
        }

        // int notsell = 0;
        // int sell = 0;
        // int buy = 0;
        // if(stat != -1){
        //     notsell = bestTimeForStock(arr, n, idx+1, stat);
        //     if(arr[idx] > arr[stat]){
        //         sell = (arr[idx] - arr[stat]) + bestTimeForStock(arr, n, idx+1, -1); 
        //     }
        // }
        // if((stat != -1 && arr[idx] < arr[stat] || stat == -1)){
        //     buy = bestTimeForStock(arr, n, idx+1, idx);
        // }
        // return Math.max(notsell, Math.max(sell, buy));
    }
    public static boolean check(int arr[], int dp[][], int idx, int target){
        if(target == 0) return true;
        if(idx == 0) return arr[idx] == target;
        if(dp[idx][target] != -1){
            return dp[idx][target] == 1;
        }

        boolean pick = false; 
        if(arr[idx] <= target) pick = check(arr, dp, idx-1, target-arr[idx]);
        boolean notpick = check(arr, dp, idx-1, target);
        if(pick || notpick) dp[idx][target] = 1;
        else dp[idx][target] = 0;
        return pick || notpick;
    }
    public static int maxSubSeq(String s1, String s2, int dp[][], int n, int m){
        if(n<0 || m<0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(s1.charAt(n) == s2.charAt(m)){
            return maxSubSeq(s1, s2, dp, n-1, m-1)+1;
        }
        int first = maxSubSeq(s1, s2, dp, n-1, m);
        int second = maxSubSeq(s1, s2, dp, n, m-1);
        return dp[n][m] = Math.max(first, second);
    }
    
    public static void ratInMaze(boolean flag[][], int arr[][], int r, int c, int n, int m, int step, String s){
        if(r==n-1 && c==m-1){
            arr[r][c] = step;
            for(var i : arr){
                System.out.println(Arrays.toString(i));
            }
            System.out.println(s);
            return;
        }
        if(flag[r][c]) return;
        flag[r][c] = true;
        if(arr[r][c] == -1) return;
        arr[r][c] = step;
        // right
        if(c<m-1)
            ratInMaze(flag, arr, r, c+1, n, m, step+1, s+"R");

        // down
        if(r<n-1)
            ratInMaze(flag, arr, r+1, c, n, m, step+1, s+"D");
        
        // left
        if(c>0)
            ratInMaze(flag, arr, r, c-1, n, m, step+1, s+"L");

        //up
        if(r>0){
            ratInMaze(flag, arr, r-1, c, n, m, step+1, s+"U");
        }

        flag[r][c] = false;
        arr[r][c] = 0;
    }
    
    public static void swap(int arr[], int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void permutation(int arr[], int idx, ArrayList<ArrayList<Integer>> list){
        if(idx == arr.length-1){
            ArrayList<Integer> t = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                t.add(arr[i]);
            }
            list.add(new ArrayList<>(t));
            return;
        }
        for(int i=idx; i<arr.length; i++){
            swap(arr, idx, i);
            permutation(arr, idx+1, list);
            swap(arr, idx, i);
        }
    }
    public static void permutation2(int arr[], ArrayList<ArrayList<Integer>> list, ArrayList<Integer> t, boolean flag[]){
        if(t.size() == arr.length){
            list.add(new ArrayList<>(t));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(flag[i]) continue;
            flag[i] = true;
            t.add(arr[i]);
            permutation2(arr, list, t, flag);
            t.remove(t.size()-1);
            flag[i] = false;
        }
    }

    public static int stringMatch(String s, String t, int n, int m){
        if(n<0) return 0;
        if(m<0) return 1;
        if(s.charAt(n) == t.charAt(m)){
            return stringMatch(s, t, n-1, m-1)+stringMatch(s, t, n-1, m);
        }
        else{
            return stringMatch(s, t, n-1, m);
        }
    }

    public static int knapsack(int w, int value[], int wt[], int idx){
        if(idx==0){
            if(w>=wt[idx]) return value[idx];
            return 0;
        }
        int notpick = knapsack(w, value, wt, idx-1);
        int pick = 0;
        if(w - wt[idx] >= 0){
            pick = knapsack(w-wt[idx], value, wt, idx-1)+value[idx];
        }
        return Math.max(notpick, pick);
    }

    public static boolean subsetSum(int arr[], int sum, int idx){
        if(idx == 0){
            if(sum==0) return true;
            return false;
        }
        boolean notpick = subsetSum(arr, sum, idx-1);
        boolean pick = subsetSum(arr, sum-arr[idx], idx-1);
        if(notpick || pick){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int visit[], int node, int path[]){
        visit[node] = 1;
        path[node] = 1;
        for(var i : adj.get(node)){
            if(visit[i] == 0){
                if(checkCycle(adj, visit, i, path)) return true;
            }
            else if(path[i] == 1){
                return true;
            }
        }
        path[node] = 0;
        return false;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 4;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(3);
        // System.out.println(adj);
        int visit[] = new int[adj.size()];
        int path[] = new int[adj.size()];
        for(int i=0; i<adj.size(); i++){
            if(visit[i] != 1){
                if(checkCycle(adj, visit, i, path)){
                    System.out.println("cycle");
                }
            }
        }
        System.out.println("no cycle");

        // int sum = 17;
        // int arr[] = {3, 34, 4, 12, 5, 2};
        // int n = arr.length;
        // System.out.println(subsetSum(arr, sum, n-1));


        // int w = 5;
        // int n = 3;
        // int values[] = {1,2,3};
        // int weight[] = {4,5,1};
        // System.out.println(knapsack(w, values, weight, n-1));


        // String s = "rabbbit";
        // String t = "rabbit";
        // System.out.println("ans will be: "+stringMatch(s, t, s.length()-1, t.length()-1));

        // int arr[] = {1, 2, 3};
        // ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        // // permutation(arr, 0, ls);
        // boolean flag[] = new boolean[arr.length];
        // permutation2(arr, ls, new ArrayList<Integer>(),flag);
        // System.out.println(ls);

        // int n = 4, m = 6;
        // int arr[][] =  {{0,  0, 0},
        //                 {0, -1, 0},
        //                 {0,  0, 0}};
        // int n = arr.length, m = arr[0].length;
        // boolean flag[][] = new boolean[n][m];
        // int arr[][] =  {{0, 0, -1, 0, 0, 0},
        //                 {0, -1, 0, 0, 0, -1},
        //                 {0, 0, 0, 0, 0, -1},
        //                 {-1, -1, 0, -1, 0, 0}};

        // String s1 = "ABCDGH";
        // String s2 = "ACDGHR";
        // int n = s1.length(), m = s2.length();
        // int dp[][] = new int[n][m];
        // for (int i = 0; i < dp.length; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // System.out.println("max subsequence is: "+maxSubSeq(s1, s2, dp, s1.length()-1, s2.length()-1, 0));

        // String arr[][] =   {{"X","X","X","X"},
        //                     {"X","O","O","X"},
        //                     {"X","X","O","X"},
        //                     {"X","O","X","X"}};
        // int sum = 9;
        // int n = arr.length; 
        // int dp[][] = new int[n][sum+1];
        // System.out.println("is sum possible for given array : "+check(arr, dp, n-1, sum));
        // System.out.println("Max profit is "+bestTimeForStock(arr, arr.length, 0, -1));
        // System.out.println(slidingWindow_maxValue(arr, 3));
        // int ans[] = slidingWindow_usingLoops(arr, 3);
        // int ans[] = slidingWindow(arr, 3);
        // printArr(ans);
    }
}