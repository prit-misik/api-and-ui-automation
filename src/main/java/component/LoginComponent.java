package component;

import base.BasePage;
import impl.HomePageImpl;
import impl.LoginImpl;

public class LoginComponent extends BasePage {

   LoginImpl loginPageImpl = new LoginImpl();
   HomePageImpl homePageImpl = new HomePageImpl();

   public HomePageImpl login(){
     loginPageImpl = homePageImpl.navigateToHomePage().clickOnLoginLink();
     return loginPageImpl.enterUser().enterPassword().clickSignInButton();
    }

}
