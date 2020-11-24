package garuda.dndz.ua;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

import java.util.concurrent.TimeUnit;


public class BookTest {
  WebDriver wd;

  @Before
  public void setUp() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.manage().window().setSize(new Dimension(1060, 1030));
    wd.get("http://localhost/");
    login("admin", "secret");
  }

  private void login(String ussername, String password) {
    wd.findElement(By.name("user")).sendKeys(ussername);
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.cssSelector("input:nth-child(7)")).click();
  }

  @Test
  public void addgroupTest() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("asdasdasdasdasd", "123asd", "asd123"));
    submitGroupCreation();
    gotoGroupPage();
    logout();
  }

  private void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  private void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  private void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  private void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  private void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  @After
  public void tearDown() {
    wd.quit();
  }
}

