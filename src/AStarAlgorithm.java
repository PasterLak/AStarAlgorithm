import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AStarAlgorithm
{
    private static final int  DIAGONAL_COST = 14;
    private static final int VERTICAL_HORIZONTAL_COST = 10;
    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
    };

    public static List<Node> findPath(Map map) {
        char[][] grid = map.getMap();
        int numRows = grid.length;
        int numCols = grid[0].length;

        Node startNode = null;
        Node targetNode = null;

        for (int i = numRows - 1; i >= 0; i--) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 'A') {
                    startNode = new Node(i, j);
                } else if (grid[i][j] == 'B') {
                    targetNode = new Node(i, j);
                }
            }
        }


        if (startNode == null || targetNode == null) {
            throw new IllegalArgumentException("Start or target node not found in the map");
        }

        PriorityQueue<Node> openSet = new PriorityQueue<>();
        List<Node> closedSet = new ArrayList<>();
        openSet.add(startNode);

        while (!openSet.isEmpty()) {
            Node currentNode = openSet.poll();

            if (currentNode.equals(targetNode)) {
                return reconstructPath(currentNode);
            }

            closedSet.add(currentNode);

            for (int[] direction : DIRECTIONS) {
                int neighborX = currentNode.getX() + direction[0];
                int neighborY = currentNode.getY() + direction[1];

                if (!isValidCoordinate(neighborX, neighborY, numRows, numCols)) {
                    continue;
                }

                if (grid[neighborX][neighborY] == '#') {
                    continue;
                }

                Node neighborNode = new Node(neighborX, neighborY);
                double tentativeGCost = currentNode.getGCost() + calculateDistance(currentNode, neighborNode);

                if (closedSet.contains(neighborNode) && tentativeGCost >= neighborNode.getGCost()) {
                    continue;
                }
                if (!openSet.contains(neighborNode) || tentativeGCost < neighborNode.getGCost()) {
                    neighborNode.setParent(currentNode);
                    neighborNode.setGCost(tentativeGCost);
                    neighborNode.setHCost(calculateDistance(neighborNode, targetNode));
                    neighborNode.setFCost(neighborNode.getGCost() + neighborNode.getHCost());

                    if (!openSet.contains(neighborNode)) {
                        openSet.add(neighborNode);
                    }
                }
            }
        }

        return Collections.emptyList();
    }

    private static boolean isValidCoordinate(int x, int y, int numRows, int numCols) {
        return x >= 0 && x < numRows && y >= 0 && y < numCols;
    }

    private static int calculateDistance(Node nodeA, Node nodeB) {
        int dx = Math.abs(nodeA.getX() - nodeB.getX());
        int dy = Math.abs(nodeA.getY() - nodeB.getY());
        return DIAGONAL_COST * Math.min(dx, dy) + VERTICAL_HORIZONTAL_COST * Math.abs(dx - dy);
    }

    private static List<Node> reconstructPath(Node currentNode) {
        List<Node> path = new ArrayList<>();
        while (currentNode != null) {
            path.add(currentNode);
            currentNode = currentNode.getParent();
        }
        Collections.reverse(path);
        return path;
    }
}
