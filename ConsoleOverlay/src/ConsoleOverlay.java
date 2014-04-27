/**
 * Created by harold on 27.04.14.
 */
public class ConsoleOverlay
{
    public static void main(String args[])
    {
        System.out.println("BiomorphGenerate - ConsoleOverlay");

        Biomorph bm = new Biomorph(12,21);
        Biomorph bsm = new Biomorph(2,2);

      //  System.out.println(bm.toString());



        System.out.println(bm.GetGrid());
    }
}
