package garuda.dndz.ua.tests;

import garuda.dndz.ua.appmanager.AplicationManager;
import garuda.dndz.ua.model.GroupData;
import garuda.dndz.ua.model.Groups;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final AplicationManager app
          = new AplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws IOException {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m,Object[] p){
    logger.info("Start test " + m.getName() + "with parameters" + Arrays.asList(p));
  }
  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("Stop test " + m.getName());
  }

  public void VerifyGroupListInUI() {
    if(Boolean.getBoolean("verifyUI")){
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups,equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }

  }
}
