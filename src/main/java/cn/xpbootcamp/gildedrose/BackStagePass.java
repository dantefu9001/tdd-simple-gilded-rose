package cn.xpbootcamp.gildedrose;

public class BackStagePass extends Product {

    private final Integer SINGLE_RATE_DATE = 10;
    private final Integer DOUBLE_RATE_DATE = 5;

    public BackStagePass(Integer sellIn, Integer quality) {
        super(sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (sellIn >= SINGLE_RATE_DATE) {
            this.quality += RATE;
        } else if (sellIn >= DOUBLE_RATE_DATE) {
            this.quality += 2 * RATE;
        } else if (sellIn >= 0) {
            this.quality += 3 * RATE;
        } else {
            this.quality = 0;
        }
    }
}
