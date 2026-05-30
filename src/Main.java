import io.MapReader;
import model.City;
import model.MapConfigException;

// Main entry point of the simulation, handles command line arguments and initialization
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
    }
}