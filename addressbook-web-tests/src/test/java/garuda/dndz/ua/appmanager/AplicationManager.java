package garuda.dndz.ua.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class AplicationManager {

  private final Properties properties;
  WebDriver wd;

  private  NavigationHelper navigationHelper;
  private  GroupHelper groupHelper;
  private  SessionManager sessionManager;
  private String browser;
  private ContactHelper contactHelper;
  private DbHelper dbHelper;

  public AplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();


  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

    dbHelper = new DbHelper();

    if(browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    }else if(browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    }else if(browser.equals(BrowserType.IE)){
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);

    wd.manage().window().setSize(new Dimension(1060, 1030));

    wd.get(properties.getProperty("web.baseUrl"));
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionManager = new SessionManager(wd);
    contactHelper = new ContactHelper(wd);
    sessionManager.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
  }


  public void stop() {
    wd.quit();
  }

  public GroupHelper group() { return groupHelper; }
  public NavigationHelper goTO() { return navigationHelper; }
  public SessionManager getSessionManager() { return sessionManager; }
  public ContactHelper contact() {return contactHelper; }
  public DbHelper db (){return dbHelper;}
}
