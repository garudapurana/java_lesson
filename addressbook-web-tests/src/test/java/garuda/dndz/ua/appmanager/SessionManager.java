package garuda.dndz.ua.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionManager extends HelperBase{

  public SessionManager(WebDriver wd) {

    super(wd);
  }
  public void login(String ussername, String password) {
    type(By.name("user"),ussername);
    type(By.name("pass"),password);
    click(By.cssSelector("input:nth-child(7)"));
  }
  public void logout() {
    click(By.linkText("Logout"));
  }
}
