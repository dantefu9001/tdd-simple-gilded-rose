package cn.xpbootcamp.gildedrose;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

public class GlidedRoseNormalTest {
    @Test
    public void should_the_value_between_0_and_50() {
        Product product = new Product(10, 10);
        Product product1 = new Product(-1, -1);
        Product product2 = new Product(100, 51);
        Assert.assertEquals(ofNullable(product.getQuality()), Optional.of(10));
        Assert.assertEquals(ofNullable(product1.getQuality()), Optional.of(0));
        Assert.assertEquals(ofNullable(product2.getQuality()), Optional.of(50));
    }

    @Test
    public void should_the_quality_drop_by_one_everyday_before_due() {
        int sellIn = 10;
        int quality = 20;
        Product product = new Product(sellIn, quality);
        product.updateSellIn();
        product.updateQuality();
        Assert.assertEquals(ofNullable(product.getSellIn()), of(9));
        Assert.assertEquals(ofNullable(product.getQuality()), of(19));
    }

    @Test
    public void should_the_quality_drop_by_double_everyday_after_due() {
        int sellIn = -1;
        int quality = 20;
        Product product = new Product(sellIn, quality);
        product.updateSellIn();
        product.updateQuality();
        Assert.assertEquals(ofNullable(product.getSellIn()), of(-2));
        Assert.assertEquals(ofNullable(product.getQuality()), of(18));
    }
}
