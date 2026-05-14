import java.util.*;

class pali
{
    public static boolean find(String s)
    {
        Integer bmask=0;

        for(int i=0;i<s.length();i++)
        {
            bmask^=1<<(s.charAt(i)-'a'+1);
        }
         System.out.println(bmask);
        return Integer.bitCount(bmask)<=1;
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        String s=sc.next();

        System.out.println(find(s));
    }
}