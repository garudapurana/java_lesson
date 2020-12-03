package garuda.dndz.ua.tests;


import garuda.dndz.ua.model.GroupData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void addGroupTest() {

    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size()+1);
    app.getSessionManager().logout();
  }

}

