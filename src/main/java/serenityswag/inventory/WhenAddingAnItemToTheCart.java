package serenityswag.inventory;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;
import serenityswag.cart.ShoppingCartBadge;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;


@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart {


    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @Before
    public  void login(){
        login.as(STANDARD_USER);

    }

    ShoppingCartBadge shoppingCartBadge;

    @Test
    public void theCorrectItemCountShouldBeShown() {
        //check that the shopping cart badge is empty and thenadd 1 item to the cart
        //then the shopping cart badge should be "1"
        assertThat(shoppingCartBadge.count()).isEmpty();

    }

    @Test
    public void allTheItemsShouldAppearInTheCart() {

    }
}
