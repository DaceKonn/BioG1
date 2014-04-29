/**
 * Created by harold on 27.04.14.
 */

public class ConsoleOverlay
{
    public static void main(String args[])
    {
        System.out.println("BiomorphGenerate - ConsoleOverlay");

        Biomorph bm = new Biomorph(12,21);

      //  System.out.println(bm.toString());
        BiomorphGenerate bg = new BiomorphGenerate();
        //bg.test();
       // System.out.println(bg.tst);
        System.out.println(bm.GetGridString());
    }
}
