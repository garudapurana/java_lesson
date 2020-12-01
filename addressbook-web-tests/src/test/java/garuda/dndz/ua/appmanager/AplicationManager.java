package garuda.dndz.ua.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;


public class AplicationManager {

  WebDriver wd;

  private  NavigationHelper navigationHelper;
  private  GroupHelper groupHelper;
  private  SessionManager sessionManager;
  private String browser;
  private ContactHelper contactHelper;

  public AplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {

    if(browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    }else if(browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    }else if(browser.equals(BrowserType.IE)){
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

    wd.manage().window().setSize(new Dimension(1060, 1030));

    wd.get("http://localhost/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionManager = new SessionManager(wd);
    contactHelper = new ContactHelper(wd);
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

  public ContactHelper getContactHelper() {return contactHelper; }
}
