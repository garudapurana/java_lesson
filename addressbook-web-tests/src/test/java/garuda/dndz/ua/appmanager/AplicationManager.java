package garuda.dndz.ua.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AplicationManager {

  WebDriver wd;

  private  NavigationHelper navigationHelper;
  private  GroupHelper groupHelper;
  private  SessionManager sessionManager;
  public void init() {
    wd = new ChromeDriver();
    wd.manage().window().setSize(new Dimension(1060, 1030));
    wd.get("http://localhost/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionManager = new SessionManager(wd);
    sessionManager.login("admin", "secret");
  }


  public void stop() {
    wd.quit();
  }



  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public SessionManager getSessionManager() {
    return sessionManager;
  }
}
