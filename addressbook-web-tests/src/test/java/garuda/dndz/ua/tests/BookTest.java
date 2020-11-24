package garuda.dndz.ua.tests;


import garuda.dndz.ua.model.GroupData;
import org.junit.Test;

public class BookTest extends TestBase {

  @Test
  public void addgroupTest() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("asdasdasdasdasd", "123asd", "asd123"));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().gotoGroupPage();
    app.logout();
  }

}

