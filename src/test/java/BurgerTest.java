import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    // Проверка получения стоимости
    @Test
    public void getPriceTest() {
        // Создать список из ингридиентов
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        ingredients.add(ingredient);
        ingredients.add(ingredient);
        ingredients.add(ingredient);
        // Создать бургер с булочкой и 4 ингредиентами
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        // Посчитать ожидаемую цену
        // Назначим ожидаемую цену одной булочки - 100
        // Назначим ожидаемую цену одного ингредиенту - 200
        float expectedPrice = 100 * 2 + 200 * 4;
        // Перехватить запрос стоимости булочки
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        // Получить цену методом getPrice
        float actualPrice = burger.getPrice();
        // Сравнить цены
        Assert.assertEquals(expectedPrice, actualPrice, 0.000001);
    }

    @Test
    public void setBunTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("Тестовая булочка", 100);
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    // Проверка функции формирования рецепта
    @Test
    public void getReceiptTest() {
        String actualString;
        String expectedString;
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        // Сформировать ожидаемую строку
        StringBuilder receipt = new StringBuilder
                (String.format("(==== %s ====)%n", "Test bun"));
        for (int i = 0; i < 4; i++) {
            receipt.append(String.format("= %s %s =%n",
                    "sauce",
                    "Test ingredient"));
        }
        receipt.append(String.format("(==== %s ====)%n", "Test bun"));
        receipt.append(String.format("%nPrice: %f%n", 0F));
        expectedString = receipt.toString();
        // Перехватить метод bun.getName
        Mockito.when(bun.getName()).thenReturn("Test bun");
        // Перехватить метод ingredient.getType
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        // Перехватить метод ingredient.getName
        Mockito.when(ingredient.getName()).thenReturn("Test ingredient");
        // Сформировать рецепт
        actualString = burger.getReceipt();
        // Сравнить строки
        Assert.assertEquals(expectedString, actualString);
    }

    // Перестановка пустых элементов
    @Test
    public void moveNullIngredientsCorrectTest() {
        Burger burger = new Burger();
        burger.addIngredient(null);
        burger.addIngredient(null);
        burger.moveIngredient(0, 1);
        for (Ingredient ingredient : burger.ingredients) {
            Assert.assertTrue(ingredient == null);
        }
    }
}
