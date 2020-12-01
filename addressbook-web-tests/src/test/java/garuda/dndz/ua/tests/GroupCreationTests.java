package garuda.dndz.ua.tests;


import garuda.dndz.ua.model.GroupData;
import org.junit.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void addGroupTest() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    app.getSessionManager().logout();
  }

}

