import java.util.List;

public class Map {

    private char[][] map;

    public Map(char[][] mapData) {
        this.map = mapData;
    }

    public char[][] getMap() {
        return map;
    }

    public void printWithPath(List<Node> path)
    {
        printMapWithPath(map, path);
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


    private void printMapWithPath(char[][] map, List<Node> path)
    {
        printLine();
        int numRows = map.length;
        int numCols = map[0].length;

        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                Node currentNode = new Node(i, j);
                if (path.contains(currentNode)) {
                    if (map[i][j] == 'A' || map[i][j] == 'B') {
                        System.out.print(map[i][j] + "  ");
                    } else {
                        System.out.print("X  ");
                    }
                } else {
                    System.out.print(map[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    private Node findNode(char symbol) {
        int numRows = map.length;
        int numCols = map[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (map[i][j] == symbol) {
                    return new Node(i, j);
                }
            }
        }

        return null;
    }
}
