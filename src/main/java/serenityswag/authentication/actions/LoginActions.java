package serenityswag.authentication.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import serenityswag.authentication.User;

public class LoginActions  extends UIInteractionSteps {

    @Step("Log in as a {0}")

    public void as(User user) {
        openUrl("https://www.saucedemo.com/");

//        find("[data-test=username]").sendKeys(user.getUsername());
//        find("[data-test=password]").sendKeys(user.getPassword());
//        find("[data-test=login-button]").click();

        // with ID alocators

        find(By.id("user-name")).sendKeys(user.getUsername());
        find(By.id("password")).sendKeys(user.getPassword());
        find(By.id("login-button")).click();



        //con el signo dollar
     /*   $(("#user-name")).sendKeys(user.getUsername());
        $(("#password")).sendKeys(user.getPassword());
        $(("#login-button")).click();*/
    }



}
