package cn.xpbootcamp.gildedrose;

public class Product implements UpdateStatus {

    private final Integer QUALITY_CEILING = 50;
    private final Integer QUALITY_FLOOR = 0;
    final Integer RATE = 1;

    Integer sellIn;
    Integer quality;

    public Product(Integer sellIn, Integer quality) {
        this.sellIn = sellIn;
        this.quality = checkQuality(quality);
    }

    private Integer checkQuality(Integer quality) {
        if (quality >= QUALITY_CEILING) return QUALITY_CEILING;
        if (quality <= QUALITY_FLOOR) return QUALITY_FLOOR;
        return quality;
    }


    @Override
    public void updateSellIn() {
        this.sellIn = this.sellIn - 1;
    }

    @Override
    public void updateQuality() {
        if (this.quality == 0) return;
        Integer quality = this.quality;
        if (sellIn >= 0) {
            quality -= RATE;
        } else {
            quality -= 2 * RATE;
        }
        this.quality = quality > 0 ? quality : 0;
    }

    public Integer getSellIn() {
        return sellIn;
    }

    public Integer getQuality() {
        return quality;
    }
}
