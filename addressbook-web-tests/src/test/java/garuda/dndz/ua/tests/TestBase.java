package garuda.dndz.ua.tests;

import garuda.dndz.ua.appmanager.AplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {

  protected static final AplicationManager app
          = new AplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws IOException {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
