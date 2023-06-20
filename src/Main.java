public class Main
{

    public static void main(String[] args)
    {

        Map map = new Map(MapDataExamples.getMap4());

        System.out.println("Map legend: . air, # wall, A start, B finish");

        map.print();
        System.out.println("Map with path: ");
        map.printMapWithPath(AStarAlgorithm.findPath(map));

    }

}