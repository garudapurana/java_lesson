package garuda.dndz.ua.tests;


import garuda.dndz.ua.model.GroupData;
import org.junit.Test;

public class CreateGroupTest extends TestBase {

  @Test
  public void addgroupTest() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().gotoGroupPage();
    app.getSessionManager().logout();
  }

}

