package managers;

import cells.Cell;
import zones.Zone;
import services.Service;
import services.PoliceStation;
import services.Hospital;
import services.School;

public class ServiceManager {

    public void distributeServices(Cell[][] grid){

        clearServices(grid);

    }
    private void clearServices(Cell[][] grid){
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[row].length; column++){
                if(grid[row][column] instanceof Zone){
                    Zone zone = (Zone) grid[row][column];

                    zone.resetServices();
                }
            }
        }
    }

    private int manhattanDistance(int row1, int row2, int column1, int column2){
        return Math.abs(row1 - row2) + Math.abs(column1 - column2);
    }

    private void applyServices(Cell[][] grid){
        for(int row = 0; row < grid.length; row++){}
    }

    private void applyService(Service service, Zone zone){
        if (service instanceof PoliceStation){
            zone.setHasSecurity(true);
        }
        if (service instanceof Hospital){
            zone.setHasHealth(true);
        }
        if (service instanceof School){
            zone.setHasEducation(true);
        }
    }
}
