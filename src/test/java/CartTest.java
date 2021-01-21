import shopping.Cart;
import org.junit.Before;
import org.junit.Test;
import shopping.Item;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTest {
    private Cart cart;

    @Before
    public void init() {
         cart = new Cart();
    }

    @Test
    public void testIfCartIsEmpty() {

        assertTrue(cart.isEmpty());
    }

    @Test
    public void addItemInToAEmptyCart() {

        cart.addItem(new Item(100, " Juice", true));
        assertEquals(100, cart.getSubTotal());

    }

    @Test
    public void addMultipleItemsAndCheckSubTotal() {
        cart.addItem(new Item(100, "Pasta", false));
        cart.addItem(new Item(200, "Cheese", true));
        cart.addItem(new Item(300, "Rice", true));
        assertEquals(600, cart.getSubTotal());

    }

    @Test
    public void addingItemShouldUpdateTheCartQuantity() {

        Item soup = new Item(20, "soup" , true);
        cart.addItem(soup);
        cart.addItem(soup);

        assertEquals(2, cart.getItems().get(soup).intValue());
    }
    @Test
    public void getItemizedListWithPriceAndQuantity() {
        Item footBall = new Item(60, "FootBall", true);
        Item basketBall = new Item(80, "BasketBall" , false);
        cart.addItem(footBall);
        cart.addItem(basketBall);

        List<String> itemizedList = new ArrayList<>();
        itemizedList.add("Name = FootBall, Price = 60, Quantity = 1");
        itemizedList.add("Name = BasketBall, Price = 80, Quantity = 1");

        assertEquals(itemizedList, cart.getItemizedList());


    }
    @Test
    public void updateItemizedListAfterRemovingItem() {
        Item footBall = new Item(60, "FootBall", true);
        Item basketBall = new Item(80, "BasketBall" , false);
        Item baseBall = new Item(50, "BaseBall", true);
        cart.addItem(footBall);
        cart.addItem(basketBall);
        cart.addItem(baseBall);
        cart.removeItem(baseBall);
        List<String> itemizedList = new ArrayList<>();
        itemizedList.add("Name = FootBall, Price = 60, Quantity = 1");
        itemizedList.add("Name = BasketBall, Price = 80, Quantity = 1");

        assertEquals(itemizedList, cart.getItemizedList());


    }
    @Test
    public void cartSizeShouldDecreaseAfterTheRemovalOfItem() {
        Item footBall = new Item(60, "FootBall", true);
        Item basketBall = new Item(80, "BasketBall" , false);
        Item baseBall = new Item(50, "BaseBall", true);
        cart.addItem(footBall);
        cart.addItem(basketBall);
        cart.addItem(baseBall);
        cart.removeItem(baseBall);

        assertEquals(2, cart.getItems().size());


    }
    @Test
    public void getParameterizedListForSaleItems() {
        Item footBall = new Item(60, "FootBall", true);
        Item basketBall = new Item(80, "BasketBall" , false);
        cart.addItem(footBall);
        cart.addItem(basketBall);

        List<String> itemizedList = new ArrayList<>();
        itemizedList.add("Name = FootBall, Price = 60, Quantity = 1");


        assertEquals(itemizedList, cart.getOnSaleItems());


    }

}
