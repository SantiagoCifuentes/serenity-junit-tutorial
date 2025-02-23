package serenityswag.inventory;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.User;
import serenityswag.authentication.actions.LoginActions;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;


@ExtendWith(SerenityJUnit5Extension.class)
public class WhenViewingHighlightingProducts {


    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    ProductListPageObject productListPageObject;

    ProductDetailsPageObject productDetailsPageObject;


    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage(){


        login.as(User.STANDARD_USER);


        List<String> productsOnDisplay = productListPageObject.titles();

        assertThat(productsOnDisplay).hasSize(6)
                .contains("Sauce Labs Backpack");

    }


    @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        // Se abre la página del detalle del producto
        login.as(User.STANDARD_USER);

        //Encuentra el primer titulo del primer producto
        String firstItemName = productListPageObject.titles().getFirst();

        //Una vez en la página se busca por linkText
        productListPageObject.openProductDetailsFor(firstItemName);

        //checkea si la nueva página es igual al de la lista original
        assertThat(productDetailsPageObject.productName()).isEqualTo(firstItemName);

        productDetailsPageObject.productImageWithAltValueOf(firstItemName).shouldBeVisible();

    }

}


