package Components;
import processing.core.PApplet;
/**
 * Created by harold on 21.05.14.
 */
public class Palette extends PApplet
{
    private int iterations = 30;
    private int mode = 0;
    private int negativeMode = 1;
    private int[] range;

    public Palette(int iterations, int mode, int negativeMode, int[] range)
    {
        this.iterations = iterations;
        this.mode = mode;
        this.negativeMode = negativeMode;
        this.range = range;
    }

    public int Paint(int value)
    {
        if (value == -2) return color(255, 0, 255);
        if (value < range[0] || value > range[1]) value = -1;

        if ((negativeMode!=0)&&(value==-1))
        {
            switch(negativeMode)
            {
                case 1:
                    return color(0, 0, 0);
                case 2:
                    return color(255,255,255);
                case 3:
                    return color(255,0,0);
                case 4:
                    return color(0,255,0);
                case 5:
                    return color(0,0,255);
            }
        }

        int level = 0;
        level = value*(255/iterations);
        switch(mode)
        {
            case 1:
                return color(level,level,level);
            case 2:
                level = value*(105/iterations);
                return color(105-level,105-level,105-level);
            case 3:
                return color(0,0,0);
            case 4:
                return color(255,255,255);
            case 5:
                level = value*(205/iterations);
                return color(50+level,50+level,50+level);
            case 6:
                return color(level,level*2-255,100-level*3);
            case 7:
                return color(level*2-255,level,100-level*3);
            case 8:
                return color(level,level*2-255,0);
            case 9:
                return color(level*2-255,level,0);
            case 10:
                return color(0,level*2-255,level);

        }
        return value;
    }
}
