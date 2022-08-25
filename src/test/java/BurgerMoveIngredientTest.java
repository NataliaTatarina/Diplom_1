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
public class BurgerMoveIngredientTest {

    private final int index;
    private final int newIndex;
    private final List<Ingredient> expectedListOfIngredients;
    private Burger burger;
    static Ingredient ingredient1 = new Ingredient(IngredientType.FILLING,
            "Тестовый ингредиент 1", 100);
    static Ingredient ingredient2 = new Ingredient(IngredientType.FILLING,
            "Тестовый ингредиент 2", 200);
    static Ingredient ingredient3 = new Ingredient(IngredientType.FILLING,
            "Тестовый ингредиент 3", 300);

    public BurgerMoveIngredientTest(int index, int newIndex, List<Ingredient> expectedListOfIngredients) {
        this.index = index;
        this.newIndex = newIndex;
        this.expectedListOfIngredients = expectedListOfIngredients;
    }

    @Before
    public void setUp() {
        burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
    }

    @Parameterized.Parameters
    public static Object[][] getInOutCounts() {
        return new Object[][]{
                {0, 2, List.of(ingredient2, ingredient3, ingredient1)},
                {2, 1, List.of(ingredient1, ingredient3, ingredient2)},
                {1, 0, List.of(ingredient2, ingredient1, ingredient3)},
                {1, 1, List.of(ingredient1, ingredient2, ingredient3)},
                {2, 0, List.of(ingredient3, ingredient1, ingredient2)}
        };
    }

    // Проверка корректного перемещения элементов по списку ингредиентов
    @Test
    public void burgerRemoveSuccessTest() {
        burger.moveIngredient(index, newIndex);
        List<Ingredient> actualListOfIngredients = burger.ingredients;
        Assert.assertEquals(expectedListOfIngredients, actualListOfIngredients);
    }

}
