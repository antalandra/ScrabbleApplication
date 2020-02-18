import java.util.Arrays;

public class Frame
{
    private char[] tiles;

    public Frame()
    {
        this.tiles = new char[7];

        // Filling array with empty tiles, represented as ' '
        Arrays.fill( tiles, ' ' );

        // The frame object is filled automatically when created
        fillFrame();
    }

    public Frame(Frame anotherFrame)    // copy Constructor
    {
        this.tiles = anotherFrame.tiles;
    }

    public char getTile(int index)
    {
        if(index >= 0 && index < 7)
        {
            return tiles[index];
        }

        return ' ';
    }

    public char[] getFrame()
    {
        return tiles;
    }

    public char removeTile(char tileToBeRetrieved)
    {
        // If the tile cannot be set to blank because it does not exist
        if(!setBlank(tileToBeRetrieved))
        {
           return ' ';
        }

        // If we reach here, the tile has been set to blank

        // Filling that space in the frame with a tile, if pool still contains tiles
        if(!Pool.isEmpty())
        {
            fillFrame();
        }

        return tileToBeRetrieved;
    }

    private boolean setBlank(char tileFromPool)
    {
        // Storing index of tile to be blanked
        int tileToBeBlanked = getIndexOfTile(tileFromPool);

        // If tile to be removed is not in the frame
        if(tileToBeBlanked == -1)
        {
            return false;
        }

        // Setting tile to empty tile ' '
        tiles[tileToBeBlanked] = ' ';

        return true;
    }

    public boolean isEmpty()
    {
        for(char tile : tiles)
        {
            if(tile != ' ')
            {
                return false;
            }
        }

        return true;
    }

    public int getIndexOfTile(char tileToBeFound)
    {
        if(isEmpty())
        {
            return -1;
        }

        for(int i = 0; i < tiles.length; i++)
        {
            if(tiles[i] == tileToBeFound)
            {
                // Return index of tile found in the frame
                return i;
            }
        }

        return -1;
    }

    public void displayFrame()
    {
        System.out.println(Arrays.toString(tiles));
    }

    private void fillFrame()
    {
       for(int i = 0; i < tiles.length; i++)
       {
           if(tiles[i] == ' ')
           {
               // Replacing the empty tile in the frame with the drawn tile from the pool
               tiles[i] = Pool.drawTile();
           }
       }
    }

    public void reset()
    {
        // Fill the frame with empty tiles
        Arrays.fill( tiles, ' ' );

        // Filling the frame with tiles from pool.
        fillFrame();
    }

}
