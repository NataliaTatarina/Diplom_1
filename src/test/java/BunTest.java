import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    @Test
    public void getPriceReturnsRightValueTest() {
        Bun bun = new Bun("Плутонский мякиш", (float) 895.68);
        Assert.assertEquals(895.68f, bun.getPrice(), 0.0001);
    }

    @Test
    public void getNameReturnsRightValueTest() {
        Bun bun = new Bun("Тестировочная булочка", (float) 100);
        Assert.assertEquals("Тестировочная булочка", bun.getName());
    }
}
