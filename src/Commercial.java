public class Commercial extends BaseZone {
    private int populationReceived;
    private int goodsReceived;

    public Commercial() {
        super();
    }

    //şehir havuzundan gelenleri almak için
    public void setResourcesReceived(int population, int goods) {
        this.populationReceived = population;
        this.goodsReceived = goods;
    }

    //üretim hesabı
    @Override
    public int calculateOutput() {
        int m = getM();
        int level = getLevel();

        if (level == 0) {
            return 0;
        }  if (level == 1) {
            return m;
        }  if (level == 2) {
            return 2 * m;
        }  if (level == 3) {
            // hangi kaynak daha azsa onunla topla
            if (populationReceived < goodsReceived) {
                return (2 * m) + populationReceived;
            } else {
                return (2 * m) + goodsReceived;
            }
        }
        return 0;
    }

    //seviye atlama düşme
    @Override
    public void updateLevel() {
        //altyapı kesilirse sıfırla
        if (getM() == 0 && getLevel() > 0) {
            setLevel(0);
            return;
        }

        int currentLevel = getLevel();

        if (currentLevel == 0) {
            //altyapı var, population good geliyorsa
            if (getM() > 0 && populationReceived > 0 && goodsReceived > 0) {
                setLevel(1);
            }
        } else if (currentLevel == 1) {
            //sadece security
            if (hasSecurity()) {
                setLevel(2);
            }
        } else if (currentLevel == 2) {
            //ekstra good,population
            if (populationReceived > 0 && goodsReceived > 0) {
                setLevel(3);
            }
        }
    }
}