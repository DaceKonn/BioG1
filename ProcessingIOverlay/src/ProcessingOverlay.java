import BiomorphGenerate.BiomorphGenerate;
import Components.Drawer;
import Exceptions.CustomException;
import processing.core.PApplet;
import controlP5.*;
import processing.core.PShape;
/**
 * Created by harold on 20.05.14.
 */
public class ProcessingOverlay extends PApplet
{
    private Drawer d;
    private boolean initiated = false;

    static public void main(String args[])
    {
        PApplet.main(new String[] {"ProcessingOverlay"});
    }


    public void setup()
    {
        size(730,700);

        BiomorphGenerate bg = new BiomorphGenerate();


        d = new Drawer();
        d.GenerateTest();

        d.MakeGrid();
        d.GenerateImage(1, 1, new int[]{0,30});
        initiated = true;
    }

    public void draw()
    {

        background(color(0, 0, 0, 255));
        if (initiated) image(d.GetImage(), 0,0);
    }
}
