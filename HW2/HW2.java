package HW.HW2;


public class HW2 {
    
    public static void main(String[] args)
    {
        int [] holder = {2, 4, 3, 7, 9, 10};
        System.out.println(findFirst(holder));
    }

    public static int findFirst(int [] holder)
{
    int left = 0;
    int right = holder.length -1;
    while(left < right)
    {
        int m = ((right-left)+left)/2;
        if(isBadVersion(holder[m]))
        {
            right = m;
        }
        else
        {
            left = m+1;
        }
    }
    return holder[left];
}
public static boolean isBadVersion(int version)
{
    return version % 2 == 1;
}
}


