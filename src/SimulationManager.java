public class SimulationManager {
    private int populationPool;
    private int goodsPool;
    private int lifestylePool;



    public void runSimulation(int totalTicks , char[][] cityMap){
        for(int tick=1;tick <= totalTicks ; tick++){
            System.out.println();
            System.out.println("Tick " + tick + " started.");

            System.out.println("City Map currently :");
            printMap(cityMap);
            System.out.println();

            distributeServices();
            distributeUtilities();
            if(tick > 1 )  {
                distributePreviousProduction();
            }else{
                System.out.println("Step 3 skipped first tick is warm - up ");
            }
            updateZones();

            collectProduction();
            System.out.println("\nTick " + tick + " is over!!!");
        }

    }


    public void distributeServices()
    {
        System.out.println("\nServices are distributed!");
    }
    public void distributeUtilities(){


        System.out.println("Utilities are distributed!");
    }
    public void distributePreviousProduction(){
        System.out.println("Distributing population : " + this.populationPool +", Goods : " + this.goodsPool + " , Lifestyle : " + this.lifestylePool);
        System.out.println("Previous productions are distributed");
    }
    public void updateZones(){

        System.out.println("Zones upgraded");
    }
    public void collectProduction(){
        int currentPop  = 5;
        int currentGoods = 10;
        int currentLife = 20;
        this.populationPool += currentPop;
        this.goodsPool += currentGoods;
        this.lifestylePool += currentLife;
        System.out.println("Production collected -> Total Population: " + this.populationPool +
                ", Goods: " + this.goodsPool + ", Lifestyle: " + this.lifestylePool);

    }
    public void printMap(char[][] map){
        for (int i = 0 ; i< map.length ; i++){
            for (int j = 0; j< map[i].length; j++ ){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}
