import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



// // There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.

// For each house i, we can either build a well inside it directly with cost wells[i - 1] (note the -1 due to 0-indexing), or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes where each pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j and house2j together using a pipe. Connections are bidirectional, and there could be multiple valid connections between the same two houses with different costs.

// Return the minimum total cost to supply water to all houses.

/**
  2 <= n <= 104
  wells.length == n
 0 <= wells[i] <= 105
  1 <= pipes.length <= 104
 pipes[j].length == 3
 1 <= house1j, house2j <= n
 0 <= costj <= 105
 house1j != house2j
 */

public class HW12 {
//dont need this function since im not doing prims anymore
    public static int findMin(int n, Boolean contains [], ArrayList<int []> pipes)
    {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(contains[i] == false && pipes.get(i)[2] < min)
            {
                min = i;
            }
        }

        return min;
    }
//dont need this little shitter either 
    public static Boolean checkwells(int val, int [] wells, int [] pipeEdge)
    {
        if(val-wells[val] < pipeEdge[2] )
        {
            return true;
        }
        return false;
    }

    public static void mergeSort(ArrayList<int[]> edges) {
        if (edges == null || edges.size() <= 1) {
            return;
        }
        mergeSortHelper(edges, 0, edges.size() - 1);
    }

    private static void mergeSortHelper(ArrayList<int[]> edges, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSortHelper(edges, start, mid);
            mergeSortHelper(edges, mid + 1, end);
            merge(edges, start, mid, end);
        }
    }

    private static void merge(ArrayList<int[]> edges, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[][] left = new int[n1][];
        int[][] right = new int[n2][];

        for (int i = 0; i < n1; ++i) {
            left[i] = edges.get(start + i);
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = edges.get(mid + 1 + j);
        }

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (left[i][2] <= right[j][2]) {
                edges.set(k, left[i]);
                i++;
            } else {
                edges.set(k, right[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            edges.set(k, left[i]);
            i++;
            k++;
        }

        while (j < n2) {
            edges.set(k, right[j]);
            j++;
            k++;
        }
    }

       
    
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // Your code here
        ArrayList<int []> edges = new ArrayList<>(); //holds edges in arraylist instead of arr -- not rerally needed but done for convenience
        
        for(int pipe []: pipes){
            edges.add(pipe);
        }

        for(int i = 0; i < n; i++)
        {
            edges.add(new int[] {0, i+1, wells[i]});
        }

        mergeSort(edges);

        int [] MST = new int [n+1];

        for(int i = 0; i <= n; i++)
        {
            MST[i] = i;
        }

        int count = 0;
        int cost = 0;

        for (int [] edge: edges)
        {
            int from = edge[0];
            int to = edge[1];
            int forCost = edge[2];
            
            if(find(MST, from) != find(MST, to))
            {
                union(MST, from, to);
                cost += forCost;
                count++;

                if(count == n){
                     break;
                }

            
            }
        }

        return cost;




     }

        // Find for finding the set of the node 'i'
    private static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    
    // Union for adding an edge to the MST
    private static void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }



     public static void main(String[] args)
     {
        int[] wells1 = {1,1};
        int[][] pipes1 = {{1,2,1},{1,2,2}};
        System.out.println(minCostToSupplyWater(2, wells1, pipes1)); // Should be 2

        // Test Case 3: Pipe is cheaper
        int[] wells2 = {10, 20, 30};
        int[][] pipes2 = {{1, 2, 5}, {2, 3, 5}, {1, 3, 20}};
        System.out.println(minCostToSupplyWater(3, wells2, pipes2)); // Should 20

        // Test Case 4: Cheap pipe tiebreak
        int[] wells3 = {50, 50, 50, 50};
        int[][] pipes3 = {{1, 2, 10}, {2, 3, 10}, {3, 4, 10}, {1, 3, 30}};
        System.out.println(minCostToSupplyWater(4, wells3, pipes3)); // Should be 80
     }
}
