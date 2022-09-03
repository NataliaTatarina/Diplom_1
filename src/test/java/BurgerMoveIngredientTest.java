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
public class BurgerMoveIngredientTest {
    private final int index;
    private final int newIndex;


    private Burger burger;

    private boolean mockInitialized = false;
    @Mock
    static Ingredient ingredient;

   public BurgerMoveIngredientTest(int index, int newIndex) {
        this.index = index;
        this.newIndex = newIndex;
    }

    @Before
    public void setUp() {
        if (!mockInitialized) {
            MockitoAnnotations.initMocks(this);
            mockInitialized = true;
        }
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        for (int j = 0; j < 3; j++) {
            if (j == index) {
                burger.addIngredient(ingredient);
            } else {
                burger.addIngredient(null);
            }
        }
    }

    @Parameterized.Parameters(name = "Тестовые данные: индекс перемещаемого элемента - {0}," +
            "новый индекс - {1}")
    public static Object[][] getInOutCounts() {
        return new Object[][]{
                {0, 2},
                {2, 1},
                {1, 0},
                {1, 1},
                {2, 0}
        };
    }

    // Проверка корректного перемещения элементов по списку ингредиентов
    @Test
    public void burgerRemoveSuccessTest() {
        burger.moveIngredient(index, newIndex);
        List<Ingredient> expectedListOfIngredients = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            if (j == newIndex) {
                expectedListOfIngredients.add(ingredient);
            } else {
                expectedListOfIngredients.add(null);
            }
        }
        List<Ingredient> actualListOfIngredients = burger.ingredients;
        Assert.assertEquals(expectedListOfIngredients, actualListOfIngredients);
    }

}
