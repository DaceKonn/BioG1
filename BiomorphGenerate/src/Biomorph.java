import java.util.Arrays;

/**
 *
 */
public class Biomorph
{
    private int size;
    private int[][] grid;
    private int iterations;

    Biomorph(int size, int iterations)
    {
        SetSize(size);
        SetIterations(iterations);
        makeGrid();
    }

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

    public int[][] GetGrid()
    { return grid; }
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

    public int GetSize()
    { return size; }
    private void SetSize(int value)
    { size = value; }

    public int GetIterations()
    {return iterations;}
    private void SetIterations(int value)
    {iterations = value;}

}
