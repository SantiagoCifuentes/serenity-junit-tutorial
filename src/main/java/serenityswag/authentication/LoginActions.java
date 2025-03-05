package serenityswag.authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class LoginActions  extends UIInteractionSteps {

    @Step("Log in as a {0}")

    public void as(User user) {
        openUrl("https://www.saucedemo.com/");

//        find("[data-test=username]").sendKeys(user.getUsername());
//        find("[data-test=password]").sendKeys(user.getPassword());
//        find("[data-test=login-button]").click();

        // with ID alocators

        find(LoginForm.USER_NAME).sendKeys(user.getUsername());
        find(LoginForm.PASSWORD).sendKeys(user.getPassword());
        find(LoginForm.LOGIN_BUTTON).click();



        //con el signo dollar
     /*   $(("#user-name")).sendKeys(user.getUsername());
        $(("#password")).sendKeys(user.getPassword());
        $(("#login-button")).click();*/
    }



}
