package serenityswag.inventory;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class ViewProductDetailsActions  extends UIInteractionSteps {
    
    //el 0 en el bracket significa que va a tomar el primer valor de los parámetros, en este caso firsItemName
    @Step("View products details for product '{0}")

    public void forProductWithName(String firstItemName) {
        find(ProductList.productDetailsLinkFor(firstItemName)).click();


    }


}