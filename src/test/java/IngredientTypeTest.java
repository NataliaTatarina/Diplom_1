import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeSauceExistsTest() {
        Assert.assertEquals("SAUCE", IngredientType.valueOf("SAUCE").toString());
    }

    @Test
    public void ingredientTypeFillingExistsTest() {
        Assert.assertEquals("FILLING", IngredientType.valueOf("FILLING").toString());
    }

    @Test
    public void ingredientTypeListIsWithoutExtraElementsTest() throws Exception {
        for (IngredientType ingredientType : IngredientType.values()) {
            switch (ingredientType) {
                case SAUCE:
                    break;
                case FILLING:
                    break;
                default:
                    throw new IllegalArgumentException(ingredientType.toString());
            }
        }
    }
}
