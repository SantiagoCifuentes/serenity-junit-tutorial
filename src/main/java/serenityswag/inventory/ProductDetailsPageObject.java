package serenityswag.inventory;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


public class ProductDetailsPageObject extends PageObject {

    public String productName() {
        return  find(By.className("inventory_details_name")).getText();
    }
}
