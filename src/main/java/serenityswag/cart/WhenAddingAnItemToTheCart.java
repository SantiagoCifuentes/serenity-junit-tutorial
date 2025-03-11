package serenityswag.cart;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;
import serenityswag.inventory.CartActions;
import serenityswag.inventory.ProductList;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;


@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart {


    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @BeforeEach
    public  void login(){
        login.as(STANDARD_USER);

    }

    ShoppingCartIcon shoppingCartIcon;

    @Steps
    CartActions cart;

    @Test
    public void theCorrectItemCountShouldBeShown() {

        //check that the shopping cart badge is empty

        Serenity.reportThat("The shopping cart badge should be empty",
                ()-> assertThat(shoppingCartIcon.badgeCount()).isEmpty());

        //adding 1 item to the cart
        cart.addItem("Sauce Labs Backpack");

        //the shopping cart badge should be 1:
        Serenity.reportThat("The shopping cart badge should be now '1'",
                ()->  assertThat(shoppingCartIcon.badgeCount()).isEqualTo("1"));





    }

    ProductList productList;

    @Test
    public void allTheItemsShouldAppearInTheCart() {

        //add several items to the cart
        List<String> selectedItems = firstThreeProductTitlesDisplayed();

        //open the cart page
        cart.items(selectedItems);

        String cartBadgeCount= Integer.toString(selectedItems.size());
        Serenity.reportThat("The shopping cart badge should now be" + cartBadgeCount,
        ()->assertThat(shoppingCartIcon.badgeCount()).isEqualTo(cartBadgeCount));


        cart.openCart();

        //should see all of the items liste
        Serenity.reportThat("Should see all of thei tems listed",
                ()-> assertThat(cart.displayedItems()).containsExactlyElementsOf(selectedItems));

    }


    private List<String> firstThreeProductTitlesDisplayed() {
        return productList.titles().subList(0, 2);
    }
}
