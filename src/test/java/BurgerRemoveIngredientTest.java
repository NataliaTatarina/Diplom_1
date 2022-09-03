import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class BurgerRemoveIngredientTest {
    private final int index;
    private Burger burger;

    @Mock
    static Ingredient ingredient;

    private boolean mockInitialized = false;

    @Before
    public void setUp() {
        if (!mockInitialized) {
            MockitoAnnotations.initMocks(this);
            mockInitialized = true;
        }
        burger = new Burger();
        for (int j=0; j<3; j++)
        {
            if (j==index) {
                burger.addIngredient(ingredient);
            } else {
                burger.addIngredient(null);
            }
        }
    }

    public BurgerRemoveIngredientTest(int index) {
        this.index = index;
    }

    @Parameterized.Parameters(name = "Тестовые данные: индекс удаляемого элемента - {0}")
    public static Object[][] getInOutCounts() {
        return new Object[][]{
                {0},
                {1},
                {2}
        };
    }

    // Проверка корректного удаления элементов из списка ингредиентов -
    // удаление первого элемента, последнего элемента, элемента из середины списка
    @Test
    public void burgerRemoveSuccessTest() {
        burger.removeIngredient(index);
        List<Ingredient> expectedListOfIngredients = new ArrayList<>();
        expectedListOfIngredients.add(0,null);
        expectedListOfIngredients.add(1,null);
        List<Ingredient> actualListOfIngredients = burger.ingredients;
        Assert.assertEquals(expectedListOfIngredients, actualListOfIngredients);
    }
}
