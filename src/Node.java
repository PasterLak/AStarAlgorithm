class Node implements Comparable<Node>
{
    private int x;
    private int y;

    private float gCost = 0;
    private float hCost = 0;
    private float fCost = 0;

    private Node parent = null;
    private Direction directionToNext;

    public Node(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getGCost() {
        return gCost;
    }

    public void setGCost(float gCost) {
        this.gCost = gCost;
    }

    public float getHCost() {
        return hCost;
    }

    public void setHCost(float hCost) {
        this.hCost = hCost;
    }

    public float getFCost() {
        return fCost;
    }

    public void setFCost(float fCost) {
        this.fCost = fCost;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Direction getDirectionToNext()
    {
        return directionToNext;
    }

    public void setDirectionToNext(Direction directionToNext)
    {
        this.directionToNext = directionToNext;
    }

    @Override
    public int compareTo(Node other) {
        return Float.compare(this.fCost, other.fCost);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Node otherNode)) return false;

        return this.x == otherNode.x && this.y == otherNode.y;
    }

}
