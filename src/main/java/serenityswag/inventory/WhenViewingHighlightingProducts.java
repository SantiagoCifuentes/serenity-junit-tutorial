package serenityswag.inventory;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.User;
import serenityswag.authentication.LoginActions;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;


@ExtendWith(SerenityJUnit5Extension.class)
public class WhenViewingHighlightingProducts {


    @Managed
    WebDriver driver;
    //la anotación steps le dice al serenity que lo que se va a instanciar son actionsClasses

    @Steps

    ViewProductDetailsActions viewProductDetails;

    LoginActions login;

    ProductList productList;

    ProductDetails productDetails;


    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage(){


        login.as(User.STANDARD_USER);


        List<String> productsOnDisplay = productList.titles();

        assertThat(productsOnDisplay).hasSize(6)
                .contains("Sauce Labs Backpack");

    }


    @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        // Se abre la página del detalle del producto
        login.as(User.STANDARD_USER);

        //Encuentra el primer titulo del primer producto
        String firstItemName = productList.titles().get(0);

        //Una vez en la página se busca por linkText
//        productListPageObject.openProductDetailsFor(firstItemName);
        viewProductDetails.forProductWithName(firstItemName);


        Serenity.reportThat("The product name should be correctly",
                ()->   assertThat(productDetails.productName()).isEqualTo(firstItemName));
        //checkea si la nueva página es igual al de la lista original

        Serenity.reportThat("The product name should be correctly",
                ()->   productDetails.productImageWithAltValueOf(firstItemName).shouldBeVisible());


    }


    //deprecado el método getAtritube
//    @Test
//    public void highlightedProductsShouldDisplayTheCorrespondingImages(){
//
//        login.as(User.STANDARD_USER);
//        List<String> productsOnDisplay = productList.titles();
//
//        productsOnDisplay.forEach(
//                productName-> assertThat(productList.imageTextForProduct(productName)).isEqualToIgnoringCase()
//        );
//    }

}


