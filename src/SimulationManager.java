
public class SimulationManager {

    private int populationPool;
    private int goodsPool;
    private int lifestylePool;

    public void runSimulation(int totalTicks , BaseZone[][] cityMap){
        for(int tick=1;tick <= totalTicks ; tick++){
            System.out.println();
            System.out.println("Tick " + tick + " started.");

            System.out.println("City Map currently :");
            printMap(cityMap);
            System.out.println();

            distributeServices(cityMap);
            distributeUtilities(cityMap);

            if(tick > 1 )  {
                distributePreviousProduction();
            } else {
                System.out.println("Step 3 skipped first tick is warm - up ");
            }

            updateZones(cityMap);

            collectProduction(cityMap);
            System.out.println("\nTick " + tick + " is over!!!");
        }
    }
    public void distributeServices(BaseZone[][] cityMap) {
        System.out.println("\nServices are distributed!");
        CityManager manager = new CityManager(cityMap);
        manager.applyPolice();
        manager.applySchool();
        manager.applyHospital();
    }

    public void distributeUtilities(BaseZone[][] cityMap) {
        int rows = cityMap.length;
        int cols = cityMap[0].length;

        CityManager manager = new CityManager(cityMap);
        manager.resetInfrastructure();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cityMap[i][j] != null) {
                    if (cityMap[i][j] instanceof PowerPlant ||
                            cityMap[i][j] instanceof WaterPumpingStation ||
                            cityMap[i][j] instanceof InternetHub) {

                        manager.spreadUtilityFrom(i, j);
                    }
                }
            }
        }
    }

    public void distributePreviousProduction(){
        System.out.println("Distributing population : " + this.populationPool +", Goods : " + this.goodsPool + " , Lifestyle : " + this.lifestylePool);
        System.out.println("Previous productions are distributed");
    }

    public void updateZones(BaseZone[][] cityMap){
        System.out.println("Zones upgraded");
        int rows = cityMap.length;
        int cols = cityMap[0].length;
        int totalScore = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cityMap[i][j] != null) {
                    cityMap[i][j].updateLevel();
                    totalScore += cityMap[i][j].calculateOutput();
                }
            }
        }
        System.out.println("Total output this turn: " + totalScore);
    }

    public void collectProduction(BaseZone[][] cityMap){
        int currentPop  = 0;
        int currentGoods = 0;
        int currentLife = 0;

        for (int i = 0; i < cityMap.length; i++) {
            for (int j = 0; j < cityMap[i].length; j++) {
                if (cityMap[i][j] != null) {
                    if (cityMap[i][j].getClass().getSimpleName().equals("Housing")) {
                        currentPop += cityMap[i][j].calculateOutput();
                    } else if (cityMap[i][j].getClass().getSimpleName().equals("Industrial")) {
                        currentGoods += cityMap[i][j].calculateOutput();
                    } else if (cityMap[i][j].getClass().getSimpleName().equals("Commercial")) {
                        currentLife += cityMap[i][j].calculateOutput();
                    }
                }
            }
        }

        this.populationPool += currentPop;
        this.goodsPool += currentGoods;
        this.lifestylePool += currentLife;

        System.out.println("Production collected -> Total Population: " + this.populationPool +
                ", Goods: " + this.goodsPool + ", Lifestyle: " + this.lifestylePool);
    }

    public void printMap(BaseZone[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == null) {
                    System.out.print("E ");
                } else {
                    System.out.print(map[i][j].getClass().getSimpleName().charAt(0) + " ");
                }
            }
            System.out.println();
        }
    }
}