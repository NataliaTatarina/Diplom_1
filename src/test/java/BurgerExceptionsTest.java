import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


public class BurgerExceptionsTest {
    private Burger burger;
    private final int VALID_INDEX = 1;
    private final int NEGATIVE_INDEX = -1;
    private final int OUT_OF_RANGE_INDEX = 3;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Тестовый ингредиент 1", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Тестовый ингредиент 2", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Тестовый ингредиент 3", 300));
    }

    // Проверка некорректного перемещения элементов из списка ингредиентов
    // Старый индекс меньше нуля
    @Test (expected = IndexOutOfBoundsException.class)
    public void negativeIndexMoveThrowsExceptionTest ()
    {
        burger.moveIngredient(NEGATIVE_INDEX, VALID_INDEX);
    }

    // Новый индекс меньше нуля
    @Test (expected = IndexOutOfBoundsException.class)
    public void negativeNewIndexMoveThrowsExceptionTest ()
    {
        burger.moveIngredient(VALID_INDEX, NEGATIVE_INDEX);
    }

    // Старый индекс больше длины списка
    @Test (expected = IndexOutOfBoundsException.class)
    public void indexOutOfRangeMoveThrowsExceptionTest ()
    {
        burger.moveIngredient(OUT_OF_RANGE_INDEX, VALID_INDEX);
    }

    // Новый индекс больше длины списка
    @Test (expected = IndexOutOfBoundsException.class)
    public void newIndexOutOfRangeMoveThrowsExceptionTest ()
    {
        burger.moveIngredient(VALID_INDEX, OUT_OF_RANGE_INDEX);
    }

    // Попытка перестановки в пустом списке
    @Test (expected = IndexOutOfBoundsException.class)
    public void moveInEmptyList() {
       Burger burger = new Burger();
       burger.moveIngredient(0,0);
    }

    // Проверка некорректного удаления элементов из списка ингредиентов
    // Попытка удалить ингредиент по индексу большему, чем размер списка
    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfRangeIndexRemoveThrowsExceptionTest() {
        burger.removeIngredient(burger.ingredients.size());
    }

    // Попытка удалить ингредиент по индексу меньшему, чем индекс начала списка
    @Test(expected = IndexOutOfBoundsException.class)
    public void negativeIndexRemoveThrowsExceptionTest() {
        burger.removeIngredient(NEGATIVE_INDEX);
    }

    // Попытка удалить ингредиент по индексу первого элемента из пустого списка
    @Test(expected = IndexOutOfBoundsException.class)
    public void firstIndexInEmptyListRemoveThrowsExceptionTest() {
        Burger burger = new Burger();
        burger.removeIngredient(VALID_INDEX);
    }


}
