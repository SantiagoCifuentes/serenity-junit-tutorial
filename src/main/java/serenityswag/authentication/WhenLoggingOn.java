package serenityswag.authentication;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.inventory.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.*;


@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOn {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    InventoryPage inventoryPage;


    @Test
    public void usersCanLogOnViaTheHomePage(){

        login.as(STANDARD_USER);
        Serenity.reportThat("The inventory page should be displayed with the correct tittle",
                ()->  assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products"));





    }


}
