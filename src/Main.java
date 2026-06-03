import io.MapReader;
import model.City;
import model.MapConfigException;

public class Main {
    public static void main(String[] args) throws MapConfigException {
        if (args.length != 2) {
            throw new MapConfigException("Invalid command line arguments. Expected: <map_file> <ticks>");
        }

        String fileName = args[0];
        int ticks;

        try {
            ticks = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new MapConfigException("Tick count must be a valid integer number.");
        }

        MapReader mapReader = new MapReader();
        City city = mapReader.readMap(fileName);

        SimulationManager sm1 = new SimulationManager();
        System.out.println("Running Objectville Simulation for " + ticks + " ticks.");

        sm1.runSimulation(ticks, city.getGrid());

        System.out.println("\nSimulation completed.");
    }
}