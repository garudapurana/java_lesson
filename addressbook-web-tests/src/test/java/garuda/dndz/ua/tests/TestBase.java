package garuda.dndz.ua.tests;

import garuda.dndz.ua.appmanager.AplicationManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {

  protected final AplicationManager app = new AplicationManager(BrowserType.CHROME);

  @Before
  public void setUp() {
    app.init();
  }

  @After
  public void tearDown() {
    app.stop();
  }

}
