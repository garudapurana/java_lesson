package garuda.dndz.ua.tests;


import garuda.dndz.ua.model.GroupData;
import org.junit.Assert;
import org.junit.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void addGroupTest() {

    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before+1);

    app.getSessionManager().logout();
  }

}

