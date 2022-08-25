import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(Parameterized.class)
public class BurgerRemoveIngredientTest {
    private final int index;
    private final List<Ingredient> expectedListOfIngredients;
    private Burger burger;
    @Before
    public void setUp() {
        burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
    }
    public BurgerRemoveIngredientTest(int index, List<Ingredient> expectedListOfIngredients) {
        this.index = index;
        this.expectedListOfIngredients = expectedListOfIngredients;
    }
    static Ingredient ingredient1 = new Ingredient(IngredientType.FILLING,
            "Тестовый ингредиент 1", 100);
    static Ingredient ingredient2 = new Ingredient(IngredientType.FILLING,
            "Тестовый ингредиент 2", 200);
    static Ingredient ingredient3 = new Ingredient(IngredientType.FILLING,
            "Тестовый ингредиент 3", 300);
    @Parameterized.Parameters
    public static Object[][] getInOutCounts() {
        return new Object[][]{
                {2, List.of(ingredient1, ingredient2)},
                {1, List.of(ingredient1, ingredient3)},
                {0, List.of(ingredient2, ingredient3)}
        };
    }
    // Проверка корректного удаления элементов из списка ингредиентов -
    // удаление первого элемента, последнего элемента, элемента из середины списка
    @Test
    public void burgerRemoveSuccessTest() {
        burger.removeIngredient(index);
        List<Ingredient> actualListOfIngredients = burger.ingredients;
        Assert.assertEquals(expectedListOfIngredients, actualListOfIngredients);
    }
}
