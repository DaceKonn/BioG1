package Components;
import BiomorphGenerate.BiomorphGenerate;
import BiomorphGenerate.Biomorph;
import Exceptions.CustomException;
import processing.core.PImage;

/**
 * Created by harold on 21.05.14.
 */
public class Drawer
{
    private Biomorph b;
    private int[][] grid;
    private PImage img;

    //<editor-fold desc="With Section">

    public Drawer WithBiomorph(Biomorph biomorph)
    {
        b = biomorph;
        return this;
    }

    //</editor-fold>

    public void GenerateTest()
    {
        BiomorphGenerate bg = new BiomorphGenerate();
        bg.Default();
        b = bg.GetBiomorph(false);
      //  return this;
    }

    public void MakeGrid()
    {
        grid = b.GetGrid();
       // return this;
    }

    public void GenerateImage(int palette, int negative, int[] range)
    {
        Palette p = new Palette(b.GetIterations(), palette, negative, range);
        img = new PImage(b.GetSize(), b.GetSize());
        img.loadPixels();
        int index = -1;



        for (int j = 0; j < b.GetSize(); j++)
        {
            for (int i = 0; i < b.GetSize(); i++)
            {
                index++;
                img.pixels[index] = p.Paint(grid[i][j]);
            }
        }

        img.updatePixels();
        // img.save("/home/harold/1.png");
       // return this;

    }

    public PImage GetImage()
    {
        return img;
    }
}
