import java.util.Arrays;

public class Biomorph
{
    private int size;
    private int[][] grid;
    private int iterations;
    private String description;

    /**
     * An object that holds am <i>array of int[][]</i> named <b>grid</b> to in, a simple way, represent a <u><b>Biomorph</b></u>
     * @param size Specifies the size of the biomorph as Size*Size square
     * @param iterations Specifies how many iterations (will be/was) used to generate the Biomorph
     */
    Biomorph(int size, int iterations)
    {
        SetSize(size);
        SetIterations(iterations);
        makeGrid();
        description = "Undescribed";
    }

    /**
     * Creates an empty <i>array int[][]</i> named <b>grid</b> based on previously defined int <b>size</b>
     */
    private void makeGrid()
    {
        grid = new int[size][size];
        for (int i = 0; i<size; i++)
        {
            for (int j = 0; j< size; j++)
            {
                grid[i][j] = 0;
            }
        }
    }

    /**
     * A Get method that returns a Biomorph as a array of int[][] named grid
     * @return private int[][] grid
     */
    public int[][] GetGrid()
    { return grid; }

    /**
     * A Get method that returns a Biomorph as a formated into string array of int[][] named grid
     * @return string that represents the grid array int[][]
     */
    public String GetGridString()
    {
        String output = new String();

        for (int i = 0; i<size; i++)
        {
            for (int j = 0; j< size; j++)
            {
                output += String.format("%d ", grid[i][j]);
            }
            output += "\n";
        }
        return output;
    }

    /**
     * A Get method
     * @return private int size
     */
    public int GetSize()
    { return size; }
    private void SetSize(int value)
    { size = value; }

    public int GetIterations()
    {return iterations;}
    private void SetIterations(int value)
    {iterations = value;}

    public String GetDescription()
    {return description;}
    private void SetDescription(String value)
    {description = value;}
}
