public enum Direction
{
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1),
    UPRIGHT(-1, 1),
    DOWNRIGHT(1, 1),
    UPLEFT(-1, -1),
    DOWNLEFT(1, -1);

    private int x;
    private int y;

    Direction(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public static Direction coordToDirection(int x, int y)
    {
        for (Direction direction : Direction.values())
        {
            if (direction.getX() == x && direction.getY() == y)
            {
                return direction;
            }
        }

        return DOWN;
    }

    public static char directionConvert(Direction dir)
    {
        switch (dir)
        {
            case UPLEFT:
                return '↖';
            case UP:
                return '↑';
            case UPRIGHT:
                return '↗';
            case LEFT:
                return '←';
            case RIGHT:
                return '→';
            case DOWNLEFT:
                return '↙';
            case DOWN:
                return '↓';
            case DOWNRIGHT:
                return '↘';
        }

        return 'E';
    }

}
