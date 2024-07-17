package java1;
import java.util.*;

public class graph_implementation{
    public static class DisjointSet{
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> rank = new ArrayList<>();
        DisjointSet(int n){  // size of graph
            for(int i=0; i<=n; i++){
                parent.add(i);
                rank.add(1);
            }
        }
        int findUltPar(int n){
            if(parent.get(n) == n) return n;
            int t = findUltPar(parent.get(n));
            parent.set(n, t);
            return t;
        }
        void unionByRank(int u, int v){
            int uParU = findUltPar(u);
            int uParV = findUltPar(v);
            if(uParU == uParV) return;
            if(rank.get(uParV) < rank.get(uParU)){
                parent.set(uParV, uParU);
            }
            else if(rank.get(uParV) > rank.get(uParU)){
                parent.set(uParU, uParV);
            }
            else{
                parent.set(uParV, uParU);
                rank.set(uParU, rank.get(uParU)+1);
            }
        }
    }
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);  
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        
        //if 3 and 7 same or not
        if(ds.findUltPar(3) == ds.findUltPar(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not Same And ultimate parent of 3 is :- "+ds.findUltPar(3)+" and ultimate parent of 7 is :- "+ds.findUltPar(7));
        }
        ds.unionByRank(3, 7);
        if(ds.findUltPar(3) == ds.findUltPar(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not same");
        }



        int arr[][][] = {{{1, 2, 3},{4, 5, 6}}, {{2,5,6}, {9, 3,0}}};
        // for(int i=0; i<arr[0].length; i++){
        //     for(int j=0; j<arr[0][i].length; j++){
        //         System.out.println(arr[0][i][j]);
        //     }
        // }
        for(var i : arr[0]){
            System.out.println(i[2]);
        }
    }
}