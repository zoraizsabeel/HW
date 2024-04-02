import java.util.Arrays;
import java.util.Scanner;

public class HW1 {

public static String removeDigitsLower(String holder)
{
    int size = holder.length();
    String temp = "";

    for(int i = 0; i < size; i++)
    {
        if(!Character.isDigit(holder.charAt(i)))
        {
            temp = temp + holder.charAt(i);
        }
    }

    return temp;
}

public static Boolean palindrome(String holder) //assume removeDigitsLower is called on param
{
    int last = holder.length();
    for(int i = 0; i < holder.length(); i++)
    {
        if(holder.charAt(i) == holder.charAt(last-1-i))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    return false;
}
public static void main(String[] args)
{
    Scanner holder = new Scanner(System.in);
    System.out.println("enter the string pls: ");
    String statement = holder.next();

    statement = removeDigitsLower(statement);
    Boolean pal = palindrome(statement);
    System.out.println("this statement is a palindrome: " + pal);

}
}
