public class MapDataExamples {

    
    public static char[][] getMap1() {
        return new char[][] {
                {'A', '.', '.', '.', '#', '.'},
                {'.', '#', '.', '.', '#', '.'},
                {'.', '#', '#', '#', '#', '.'},
                {'.', '.', '.', '.', '.', 'B'}
        };
    }

    public static char[][] getMap2() {
        return new char[][] {
                {'.', '.', '.', '.', '.', 'B'},
                {'.', '#', '#', '#', '#', '.'},
                {'A', '.', '.', '#', '.', '.'}
        };
    }

    public static char[][] getMap3() {
        return new char[][] {
                {'.', '.', '.', 'A', '#'},
                {'#', '#', '#', '#', '#'},
                {'.', '.', '.', 'B', '#'}
        };
    }

    public static char[][] getMap4() {
        return new char[][]{
                {'.', '#', '.', '.', '.', '#', '.'},
                {'.', '#', '#', '.', '.', '.', 'B'},
                {'.', '.', '.', '.', '.', '#', '#'},
                {'.', '#', '#', '#', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '#', '.'},
                {'.', '#', '#', '.', '.', '#', '.'},
                {'A', '.', '.', '.', '.', '.', '.'}
        };
    }
}