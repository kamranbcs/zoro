package uk.co.zoro.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.co.zoro.pages.HomePage;
import uk.co.zoro.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginStep {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("I am on home page")
    public void i_am_on_home_page() {

        assertThat(homePage.currentUrl(), endsWith("co.uk/"));
    }

    @When("^I click on Log in \"([^\"]*)\"$")
    public void i_click_on_log_in_something(String loginTxt) {

        homePage.clickTopNav(loginTxt);
    }

    @When("^I see login pop up saying \"([^\"]*)\"$")
    public void i_see_login_pop_up_saying_something(String loginPopupTitle) throws Throwable {

        assertThat(homePage.getLoginPopupTitle(), is(equalToIgnoringCase(loginPopupTitle)));
    }

    @When("^I enter email (.+)$")
    public void i_enter_email(String emailTxt) {

        loginPage.enterEmail(emailTxt);
    }

    @When("^I enter password (.+)$")
    public void i_enter_password(String passwordTxt) {

        loginPage.enterPassword(passwordTxt);
    }

    @When("I click on Sign in button")
    public void i_click_on_sign_in_button() {

        loginPage.clickSubmitButton();
    }

    @Then("^I see the welcome message (.+)$")
    public void i_see_the_welcome_message(String loginMessage) {

        assertThat(loginPage.getLoginMessage(), is(equalToIgnoringWhiteSpace(loginMessage)));
    }

    @Then("^I see My Account icon \"([^\"]*)\"$")
    public void i_see_my_account_icon_something(String myAccountTxt) throws Throwable {

        assertThat(homePage.getMyAccountIconTxt(), is(equalToIgnoringCase(myAccountTxt)));
    }

    @Then("^I see the invalid email or password message (.+)$")
    public void i_see_the_invalid_email_or_password_message(String loginFailMessage) throws Throwable {

        assertThat(loginPage.getInvalidUserPassMessage(), is(containsString(loginFailMessage)));
    }
}
