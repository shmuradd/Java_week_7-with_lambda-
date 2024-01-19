package Helpers;

public class Helper {

    public static int tryParseInt( String choice)
    {
        int input=0;
        try {
            input= Integer.parseInt(choice);

        }
        catch(Exception exception)
        {
            System.out.println("Zehmet olmasa reqem daxil edin!");

        }
        return input;
    }



}
