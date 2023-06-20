import java.util.List;

public class Map {

    private char[][] map;

    public Map(char[][] mapData) {
        this.map = mapData;
    }

    public char[][] getMap() {
        return map;
    }

    private void printLine()
    {
        System.out.println("-------------------------------------");
    }

    public void print()
    {
        printLine();
        int numRows = map.length;
        int numCols = map[0].length;

        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++){
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void printMapWithPath(List<Node> path)
    {
        printLine();

        char[][] mapCopy = copyMapData();

        for (Node node:path)
        {
            if(mapCopy[node.getX()][node.getY()] != 'A' && mapCopy[node.getX()][node.getY()] != 'B')
            {
                mapCopy[node.getX()][node.getY()] = Direction.directionConvert(node.getDirectionToNext());
            }
        }

        for (int x = 0; x < map.length; x++)
        {
            for (int y = 0; y < map[0].length; y++)
            {

                System.out.print(mapCopy[x][y] + "  ");
            }
            System.out.println("");
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

}
