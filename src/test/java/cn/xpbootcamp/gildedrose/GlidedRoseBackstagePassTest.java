package cn.xpbootcamp.gildedrose;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static java.util.Optional.ofNullable;

public class GlidedRoseBackstagePassTest {

    @Test
    public void should_increase_by_one_everyday_until_ten_days_before_due(){
        BackStagePass backStagePass = new BackStagePass(15, 20);
        backStagePass.updateSellIn();
        backStagePass.updateQuality();
        Assert.assertEquals(ofNullable(backStagePass.getSellIn()), Optional.of(14));
        Assert.assertEquals(ofNullable(backStagePass.getQuality()), Optional.of(21));
    }

    @Test
    public void should_increase_by_double_everyday_from_ten_days_to_five_days_before_due(){
        BackStagePass backStagePass = new BackStagePass(10, 20);
        backStagePass.updateSellIn();
        backStagePass.updateQuality();
        Assert.assertEquals(ofNullable(backStagePass.getSellIn()), Optional.of(9));
        Assert.assertEquals(ofNullable(backStagePass.getQuality()), Optional.of(22));
    }

    @Test
    public void should_increase_by_triple_everyday_five_days_before_due(){
        BackStagePass backStagePass = new BackStagePass(5, 20);
        backStagePass.updateSellIn();
        backStagePass.updateQuality();
        Assert.assertEquals(ofNullable(backStagePass.getSellIn()), Optional.of(4));
        Assert.assertEquals(ofNullable(backStagePass.getQuality()), Optional.of(23));
    }

    @Test
    public void should_become_0_immediately_after_due(){
        BackStagePass backStagePass = new BackStagePass(-1, 20);
        backStagePass.updateSellIn();
        backStagePass.updateQuality();
        Assert.assertEquals(ofNullable(backStagePass.getSellIn()), Optional.of(-2));
        Assert.assertEquals(ofNullable(backStagePass.getQuality()), Optional.of(0));
    }
}
