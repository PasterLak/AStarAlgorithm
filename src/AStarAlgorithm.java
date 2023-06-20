import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AStarAlgorithm
{
    private static final int  DIAGONAL_COST = 14;
    private static final int VERTICAL_HORIZONTAL_COST = 10;

    public static List<Node> findPath(Map map)
    {
        char[][] grid = map.getMap();
        int numRows = grid.length;
        int numCols = grid[0].length;

        Node startNode = null;
        Node targetNode = null;

        for (int i = numRows - 1; i >= 0; i--)
        {
            for (int j = 0; j < numCols; j++)
            {
                switch (grid[i][j])
                {
                    case 'A' -> startNode = new Node(i, j);
                    case 'B' -> targetNode = new Node(i, j);
                }
            }
        }

        if (startNode == null || targetNode == null) {
            throw new IllegalArgumentException("Start or target node not found in the map");
        }

        PriorityQueue<Node> openSet = new PriorityQueue<>();
        List<Node> closedSet = new ArrayList<>();

        openSet.add(startNode);

        while (!openSet.isEmpty())
        {
            Node currentNode = openSet.poll();

            if (currentNode.equals(targetNode)) {
                return reconstructPath(currentNode);
            }

            closedSet.add(currentNode);

            сheckNeighboringNodes(currentNode, targetNode, grid, openSet, closedSet);
        }

        return Collections.emptyList();
    }

    private static void сheckNeighboringNodes(Node current,Node target, char[][] grid,PriorityQueue<Node> openSet,List<Node> closedSet )
    {
        for (Direction direction : Direction.values())
        {
            int neighborX = current.getX() + direction.getX();
            int neighborY = current.getY() + direction.getY();

            if (!isValidCoordinate(neighborX, neighborY, grid.length, grid[0].length)) {
                continue;
            }

            if (grid[neighborX][neighborY] == '#') {
                continue;
            }

            Node neighborNode = new Node(neighborX, neighborY);

            float tentativeGCost = current.getGCost() + calculateDistance(current, neighborNode);

            if (closedSet.contains(neighborNode) && tentativeGCost >= neighborNode.getGCost()) {
                continue;
            }
            if (!openSet.contains(neighborNode) || tentativeGCost < neighborNode.getGCost()) {

                setNeighborNodeParameters(neighborNode, current, target, tentativeGCost);

                if (!openSet.contains(neighborNode))
                {
                    openSet.add(neighborNode);
                }
            }
        }
    }

    private static void setNeighborNodeParameters(Node neighbor, Node current, Node target, float tentativeGCost)
    {
        neighbor.setParent(current);
        neighbor.setGCost(tentativeGCost);
        neighbor.setHCost(calculateDistance(neighbor, target));
        neighbor.setFCost(neighbor.getGCost() + neighbor.getHCost());
    }

    private static boolean isValidCoordinate(int x, int y, int numRows, int numCols) {
        return x >= 0 && x < numRows && y >= 0 && y < numCols;
    }

    private static int calculateDistance(Node nodeA, Node nodeB)
    {
        int dx = Math.abs(nodeA.getX() - nodeB.getX());
        int dy = Math.abs(nodeA.getY() - nodeB.getY());

        return DIAGONAL_COST * Math.min(dx, dy) + VERTICAL_HORIZONTAL_COST * Math.abs(dx - dy);
    }

    private static List<Node> reconstructPath(Node currentNode)
    {
        List<Node> path = new ArrayList<>();

        while (currentNode != null)
        {
            path.add(currentNode);

            if(currentNode.getParent() != null)
            {

                int x = currentNode.getParent().getX() - currentNode.getX();
                int y = currentNode.getParent().getY() - currentNode.getY();

                currentNode.getParent().setDirectionToNext(Direction.coordToDirection(-x,-y));
            }

            currentNode = currentNode.getParent();
        }

        Collections.reverse(path);

        return path;
    }
}
