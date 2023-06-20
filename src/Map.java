import java.util.List;

public class Map {

    private char[][] map;

    public Map(char[][] mapData) {
        this.map = mapData;
    }

    public char[][] getMap() {
        return map;
    }

    public void print()
    {
        print(map);
    }

    public void printMapWithPath(List<Node> path)
    {
        printLine();

        char[][] mapCopy = copyMapData();

        for (Node n:path)
        {
            if(mapCopy[n.getX()][n.getY()] != 'A' && mapCopy[n.getX()][n.getY()] != 'B')
            {
                mapCopy[n.getX()][n.getY()] = Direction.directionConvert(n.getDirectionToNext());
            }
        }

        print(mapCopy);

    }

    private void print(char[][] mapData)
    {
        printLine();

        for (int i = 0; i < mapData.length; i++)
        {
            for (int j = 0; j < mapData[0].length; j++){
                System.out.print(mapData[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private char[][] copyMapData()
    {
        int rows = map.length;
        int cols = map[0].length;

        char[][] mapCopy = new char[rows][cols];

        for (int x = 0; x < rows; x++)
        {
            for (int y = 0; y < cols; y++)
            {
                mapCopy[x][y] = map[x][y];
            }
        }

        return  mapCopy;
    }

    private void printLine()
    {
        System.out.println("-------------------------------------");
    }

}
