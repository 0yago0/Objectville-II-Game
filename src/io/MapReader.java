package io;

import model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Utility class responsible for reading the text file and constructing the City grid

public class MapReader {

    public City readMap(String fileName) throws MapConfigException {
        try {
            File mapFile = new File(fileName);
            Scanner scanner = new Scanner(mapFile);

            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            City city = new City(rows, cols);

            for (int row = 0; row < rows; row++) {
                if (!scanner.hasNextLine()) {
                    break;
                }
                String line = scanner.nextLine();

                for (int col = 0; col < cols && col < line.length(); col++) {
                    char cellType = line.charAt(col);
                    CityCell cell = null;

                    switch (cellType) {
                        case 'H':
                            cell = new Housing(row, col);
                            break;
                        case 'I':
                            cell = new Industrial(row, col);
                            break;
                        case 'C':
                            cell = new Commercial(row, col);
                            break;
                        case 'R':
                            cell = new Road(row, col);
                            break;
                        case 'E':
                            break;
                        default:
                            throw new MapConfigException("Unknown character found in map: " + cellType);
                    }

                    if (cell != null) {
                        city.setCell(row, col, cell);
                    }
                }
            }

            scanner.close();
            return city;

        } catch (FileNotFoundException e) {
            throw new MapConfigException("Map file could not be found: " + fileName);
        }
    }
}