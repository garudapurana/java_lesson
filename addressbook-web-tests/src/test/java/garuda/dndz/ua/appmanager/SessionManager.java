package garuda.dndz.ua.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionManager {
  private WebDriver wd;
  public SessionManager(WebDriver wd) {
    this.wd =wd;
  }
  public void login(String ussername, String password) {
    wd.findElement(By.name("user")).sendKeys(ussername);
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.cssSelector("input:nth-child(7)")).click();
  }
  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }
}
