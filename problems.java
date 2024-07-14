import java.util.*;


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
    public static int miniTotInTriPath(int arr[][], int dp[][], int n, int i, int j){
        if(i == n || j >= arr[i].length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int down = arr[i][j]+miniTotInTriPath(arr, dp, n, i+1, j);
        int donwR = arr[i][j]+miniTotInTriPath(arr, dp, n, i+1, j+1);
        return dp[i][j] = Math.min(down, donwR); 
    }

    public static class pair implements Comparable<pair> {
        int row;
        int col;
        int dis;
        pair(int row, int col, int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
        public int compareTo(pair temp){
            return this.dis - temp.dis;
        }
    }
    public static int shortestPath(int arr[][], int n, int m){
        if(arr[0][0] != 0 || arr[n-1][m-1] != 0) return -1;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0, 0, 0));
        int dis[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1) dis[i][j] = -1;
                else{
                    dis[i][j] = (int) 1e9;
                }
            }
        }
        int dRow[] = {-1, 0, +1, 0, -1, +1, -1, +1};
        int dCol[] = {0, +1, 0, -1, -1, -1, +1, +1};
        dis[0][0] = 0;
        while (!pq.isEmpty()) {
            int row = pq.peek().row;
            int col = pq.peek().col;
            int wt = pq.peek().dis;
            pq.remove();
            for(int i=0; i<8; i++){
                int tR = row + dRow[i];
                int tC = col + dCol[i];
                if(tR >= 0 && tC >= 0 && tR < n && tC < m && dis[tR][tC] > wt+1){
                    dis[tR][tC] = wt+1;
                    pq.add(new pair(tR, tC, dis[tR][tC]));
                }
            }
        }
        if(dis[n-1][m-1] == 1e9) return -1;
        return dis[n-1][m-1]+1; 
    }
    public static class pair2 implements Comparable<pair2>{
        int v;
        int wt;
        pair2(int v, int wt){
            this.v = v;
            this.wt = wt;
        }
        public int compareTo(pair2 temp){  //access modifier is required for this function
            return this.wt - temp.wt;
        }
    }
    public static int[] Dijkstra(int arr[][][], int src){
        int n = arr.length;
        int dis[] = new int[n];
        Arrays.fill(dis, (int) 1e9);
        dis[src] = 0;
        PriorityQueue<pair2> pq = new PriorityQueue<>();
        pq.add(new pair2(src, 0));
        while (pq.size() != 0) {
            int v = pq.peek().v;
            int wt = pq.peek().wt;
            pq.remove();
            for(var i : arr[v]){     //here 'i' is the arr inside arr indside arr
                int tV = i[0];
                int tWt = i[1];
                if(tWt + wt < dis[tV]){
                    dis[tV] = tWt + wt;
                    pq.add(new pair2(tV, dis[tV]));   
                }
            }
        }
        return dis;
    }

    public static int frogJump(int arr[], int idx, int dp[]){ //8-7-24
        if(idx == arr.length-1) return 0;
        if(dp[idx] != -1) return dp[idx];
        int oneJump = frogJump(arr, idx+1, dp) + Math.abs(arr[idx]-arr[idx+1]);
        int twoJump = (int) 1e9;
        if(idx < arr.length-2)
            twoJump = frogJump(arr, idx+2, dp) + Math.abs(arr[idx]-arr[idx+2]);
        return dp[idx] = Math.min(oneJump, twoJump);
    }

    public static void butterfly(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print('*');
            }
            for(int j=1; j<((n-i)*2)-1; j++){
                System.out.print(' ');
            }
            for(int j=n-i-1; j<n; j++){
                System.out.print('*');
            }
            System.out.println();
        }
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                System.out.print('*');
            }
            for(int j=0; j<(i*2); j++){
                System.out.print(' ');
            }
            for(int j=0; j<n-i; j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
    public static int minPath(int arr[][], int dp[][], int n, int m, int r, int c){
        if(r==n || c==m) return (int) -1e9;
        if(r==n-1 && c==m-1) return arr[n-1][m-1];
        if(dp[r][c] != -1) return dp[r][c];
        int right = minPath(arr, dp, n, m, r, c+1) + arr[r][c];
        int down = minPath(arr, dp, n, m, r+1, c) + arr[r][c];
        return dp[r][c] = Math.max(right, down);
    }
    
    public static int longestSubSeq(int dp[][], String s1, String s2, int n, int m){
        if(n < 0 || m < 0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(s1.charAt(n) == s2.charAt(m)){
            return longestSubSeq(dp, s1, s2, n-1, m-1) + 1;
        }
        int first = longestSubSeq(dp, s1, s2, n-1, m);
        int second = longestSubSeq(dp, s1, s2, n, m-1);
        return dp[n][m] = Math.max(first, second);
    }
    public static void main(String args[]){
        
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        int n = str1.length(), m = str2.length();
        int dp[][] = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(longestSubSeq(dp, str1, str2, n-1, m-1));

        // butterfly(5);
        // int dp[] = new int[arr.length];
        // Arrays.fill(dp, -1);
        // System.out.println(frogJump(arr, 0, dp));
        // int arr[] = {2, 4, 6, 8, 10};
        // printSubarrays(arr);
        // int arr[][][] = [[[1, 1], [2, 6]], [[2, 3], [0, 1]], [[1, 3], [0, 6]]];
        // ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        // int arr[][] = {{0,0,0},{1,0,0},{1,1,0}};
        // int n = arr.length;
        // System.out.println(solve(arr, n, n));
        // int m = n;
        // int arr[][][] = {{{1, 1},{2, 6}},{{2, 3},{0, 1}},{{1, 3}, {0, 6}}};
        // int ans[] = Dijkstra(arr, 2);
        // for(int i : ans){
        //     System.out.print(i+" ");
        // }

        // System.out.println(solve(arr, 0, 0));

        // int dp[][] = new int[arr.length][arr.length];
        // for(int i=0; i<arr.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }

    }
}