package managers;

public class ResourceDistributionManager {
    private int populationPool;
    private int goodsPool;
    private int lifestylePool;

    public ResourceDistributionManager() {
        this.populationPool = 0;
        this.goodsPool = 0;
        this.lifestylePool = 0;
    }
    public void addPopulationPool(int amount) {
        this.populationPool += amount;
    }
    public void addGoodsPool(int amount) {
        this.goodsPool += amount;
    }
    public void addLifestylePool(int amount) {
        this.lifestylePool += amount;
    }
    public void distributeResources(){

    }

    public int getPopulationPool() {
        return populationPool;
    }

    public void setPopulationPool(int populationPool) {
        this.populationPool = populationPool;
    }

    public int getGoodsPool() {
        return goodsPool;
    }

    public void setGoodsPool(int goodsPool) {
        this.goodsPool = goodsPool;
    }

    public int getLifestylePool() {
        return lifestylePool;
    }

    public void setLifestylePool(int lifestylePool) {
        this.lifestylePool = lifestylePool;
    }
}
