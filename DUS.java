import java.util.*;
import java.io.*;
//Disjoint Union Set
public class DUS {
    static int[] parent;
    static int[] size;
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        parent = new int[v];
        for(int i = 0; i < v; ++i) {
            make(i);
        }
        size = new int[v];
        Arrays.fill(size,-1);
        Wpair[] pair = new Wpair[e];
        for(int i = 0; i < e; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            pair[i] = new Wpair(a,b,c);
        }
        sc.close();
        Arrays.sort(pair);
        // for(int i = 0; i < v; ++i) {
        //     if(parent[i] == i) count ++;
        // }
        for(int i = 0; i < e; ++i) {
            union(pair[i]);
        }
        System.out.print(sum);


    }
    
    static void make(int i) {
        parent[i] = i;
    }
    static int find(int node) {
        if(parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    static void union(Wpair pair) {
        int parent1 = find(pair.src);
        int parent2 = find(pair.des);
        if(parent1 != parent2) {
            if(size[parent2] > size[parent1]) {
                parent[parent1] = parent2;
                size[parent2] += size[parent1];
            } else {
                parent[parent2] = parent1;
                size[parent1] += size[parent2];
            }
            sum += pair.w;
            System.out.println(pair.src+" to "+ pair.des);
        }
    }
    // static void union(int src, int des) {
    //     int parent1 = find(src);
    //     int parent2 = find(des);
    //     if(parent1 != parent2) {
    //         if(size[parent2] > size[parent1]) {
    //             parent[parent1] = parent2;
    //             size[parent2] += size[parent1];
    //         } else {
    //             parent[parent2] = parent1;
    //             size[parent1] += size[parent2];
    //         }
            
    //     }
    // }
}
class Wpair implements Comparable<Wpair>{
    int src;
    int des;
    int w;
    Wpair(int src,int des, int w) {
        this.src = src;
        this.des = des;
        this.w = w;
    }
    public int compareTo(Wpair that) {
        return this.w - that.w;
    }
}
