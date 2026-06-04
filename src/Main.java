import model.MapConfigException;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new MapConfigException("Invalid command line arguments. Expected: <map_file> <ticks>");
        }

        String fileName = args[0];
        int ticks = Integer.parseInt(args[1]);

        BaseZone[][] grid = MapReader.readMapFile(fileName);

        SimulationManager sm1 = new SimulationManager();
        System.out.println("Running Objectville Simulation for " + ticks + " ticks.");

        sm1.runSimulation(ticks, grid);

        System.out.println("\nSimulation completed.");
    }
}