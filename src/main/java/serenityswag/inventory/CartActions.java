package serenityswag.inventory;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import serenityswag.cart.ShoppingCartIcon;

import java.util.List;

public class CartActions extends UIInteractionSteps {


    ShoppingCartIcon  shoppingCartIcon;

    @Step ("Add {0} to the cart" )
    public void addItem(String itemName) {
        $(ProductList.addToCartButtonFor(itemName)).click();
    }

    @Step("Add {0} to the cart")
    public void items(List<String> items) {

        //iterando cada elemento de la lista
        items.forEach(this::addItem);
    }

    @Step("Open the shopping cart")
    public void openCart(){
        $(shoppingCartIcon.link()).click();

    }

    public List<String> displayedItems() {
        return findAll(".inventory_item_name").texts();
    }
}
