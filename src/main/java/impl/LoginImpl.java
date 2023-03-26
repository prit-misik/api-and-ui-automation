package impl;

import base.BasePage;
import pages.LoginPage;
import util.TestUtils;
import util.WebDriverUtils;

public class LoginImpl extends BasePage {


  LoginPage loginPage = new LoginPage();
  HomePageImpl homePageImpl = new HomePageImpl();

  public LoginImpl enterUser(){
    WebDriverUtils.setText(loginPage.email, TestUtils.getPropFileValues().get("profile.email"));
      return this;
    }

  public LoginImpl enterPassword(){
    WebDriverUtils.setText(loginPage.password, TestUtils.getPropFileValues().get("profile.password"));
    return this;
  }
  public HomePageImpl clickSignInButton(){
    WebDriverUtils.click(loginPage.signIn);
    return homePageImpl;
  }
}
