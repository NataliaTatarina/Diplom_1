import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;

public class IngredientsTest {

    @Test
    public void getPriceReturnsRightValueTest()  {
        Ingredient ingredient = new Ingredient(FILLING, "Сартунианский бекон", 123.5f);
        Assert.assertEquals(123.5, ingredient.getPrice(), 0.0001);
    }

    @Test
    public void getNameReturnsRightValueTest()  {
        Ingredient ingredient = new Ingredient(FILLING, "Тестировочная котлета", 100);
        Assert.assertEquals("Тестировочная котлета", ingredient.getName());
    }

    @Test
    public void getTypeReturnsRightValueTest()  {
        Ingredient ingredient = new Ingredient(FILLING, "Марсианские водоросли", 206.5f);
        Assert.assertEquals(FILLING, ingredient.getType());
    }
}
