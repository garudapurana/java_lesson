package garuda.dndz.ua.tests;


import garuda.dndz.ua.model.GroupData;
import org.junit.Test;

public class BookTest extends TestBase {

  @Test
  public void addgroupTest() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("asdasdasdasdasd", "123asd", "asd123"));
    app.submitGroupCreation();
    app.gotoGroupPage();
    app.logout();
  }

}

