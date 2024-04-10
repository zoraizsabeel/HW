import java.util.*;

public class EverythingEC
{
    //get the size of the length to find how wide the matrix needs to be
    //go through the list and add true for for index that exists within a row
    //false for any index that doesnt exits
    public static Boolean [][] convert (int [][] thingy)
    {
        // [1, 2, 4, 5]
        // [2, 3, 1, 4]
        // [2, 3, 1, 4]
        // [2, 3, 1, 4]

        int size = thingy.length;
        Boolean [][] holder = new Boolean[size][size];
        
        for(int i = 0; i < size; i++)
        {
            for(int thing: thingy[i])
            {
                if(thing == i+1)
                {
                    holder[i][thing-1] = false;
                }
                else
                {
                    holder[i][thing-1] = true;
                }
            }
        }

        return holder;
    }

    public static ArrayList<LinkedList<Integer>> reverse (int [][] thingy)
    {
        int size = thingy.length;
        ArrayList<LinkedList<Integer>> holder = new ArrayList<>(size); 

        for(int i = 0; i < size; i++)
        {
            holder.add(new LinkedList<Integer>());
        }

        for(int i = 0; i < size-1; i++)
        {
            for(int j = 0; j < size-1; j++)
            {
                holder.get(thingy[i][j]).add(i+1);
            }
        }
        
        // 1 2 3 4  [    ]
        // 2 1 3 4
        // 3 1 2 4
        // 4 1 2 3

        return holder;
    }

    public static ArrayList<LinkedList<Integer>>  convert (Boolean [][] thingy)
    {
        // false true true true
        // true false true true
        // true true false true
        // true true true false

        int size = thingy.length;
        ArrayList<LinkedList<Integer>> holder = new ArrayList<>(size);
        
        for(int i = 0; i < size; i++)
        {
            //dont need to look for false in order for the list
            //can just add to 2d array by the truths [ , true, true, true] .. like this
            //jus put the numbers later.
            holder.add(new LinkedList<>());
            holder.get(i).add(i+1);
            
            for(int j = 0; j < size; j++)
            {
                if(thingy[i][j] == true)
                {
                    holder.get(i).add(j+1);
                }
            }

        }
        return holder;
    }
    



    
    public static void main(String[] args)
    {
        int[][] holder = {{1, 2, 3, 4},  {2, 1, 3, 4}, {3, 1, 2, 4}, {4, 1, 2, 3}};
        Boolean [][] holder1 = convert(holder);
        ArrayList<LinkedList<Integer>> list = convert(holder1);
        ArrayList<LinkedList<Integer>> reversed = reverse(holder);

        for( Boolean [] holder2 : holder1)
        {
            System.out.println("");
            for(Boolean holder3: holder2)
            {
                System.out.print(holder3 + " ");
            }
        }

        for( LinkedList<Integer> list2 : list)
        {
            System.out.println("");
            for(int list3: list2)
            {
                System.out.print(list3 + " ");
            }
        }

        
    }
}
