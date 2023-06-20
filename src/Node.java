import java.util.Objects;

class Node implements Comparable<Node>
{
    private int x;
    private int y;
    private double gCost;
    private double hCost;
    private double fCost;
    private Node parent;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.gCost = 0;
        this.hCost = 0;
        this.fCost = 0;
        this.parent = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getGCost() {
        return gCost;
    }

    public void setGCost(double gCost) {
        this.gCost = gCost;
    }

    public double getHCost() {
        return hCost;
    }

    public void setHCost(double hCost) {
        this.hCost = hCost;
    }

    public double getFCost() {
        return fCost;
    }

    public void setFCost(double fCost) {
        this.fCost = fCost;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(Node other) {
        return Double.compare(this.fCost, other.fCost);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;

        if (!(obj instanceof Node otherNode)) return false;

        return this.x == otherNode.x && this.y == otherNode.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
