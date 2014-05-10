import BiomorphGenerate.*;

/**
 * Created by harold on 27.04.14.
 */

public class ConsoleOverlay
{
    public static void main(String args[])
    {
        System.out.println("BiomorphGenerate.BiomorphGenerate - ConsoleOverlay");

        Biomorph bm = new Biomorph(12,21);
        System.out.println(bm.GetGridString());
      //  System.out.println(bm.toString());

        long time = System.nanoTime();
        BiomorphGenerate bg = new BiomorphGenerate();
        bg.Default();
        bm = bg.GetBiomorph(true);
        System.out.println("Generated multicore: "+((System.nanoTime() - time)/1000000));
        bm.GetGridString();
        System.out.println();
        time = (System.nanoTime() - time)/1000000;
        System.out.println("Miliseconds elapsed: "+time);

        System.out.println();

        time = System.nanoTime();
        bg = new BiomorphGenerate();
        bg.Default();
        bm = bg.GetBiomorph(false);
        System.out.println("Generated singlecore: "+((System.nanoTime() - time)/1000000));
        bm.GetGridString();
        System.out.println();
        time = (System.nanoTime() - time)/1000000;
        System.out.println("Miliseconds elapsed: "+time);
    }
}
