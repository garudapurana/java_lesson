package garuda.dndz.ua.tests;

import garuda.dndz.ua.appmanager.AplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  protected static final AplicationManager app = new AplicationManager(BrowserType.CHROME);

  @BeforeSuite
  public void setUp() {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
