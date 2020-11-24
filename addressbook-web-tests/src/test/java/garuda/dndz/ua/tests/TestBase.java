package garuda.dndz.ua.tests;

import garuda.dndz.ua.appmanager.AplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {

  protected final AplicationManager app = new AplicationManager();

  @Before
  public void setUp() {
    app.init();
  }

  @After
  public void tearDown() {
    app.stop();
  }

}
