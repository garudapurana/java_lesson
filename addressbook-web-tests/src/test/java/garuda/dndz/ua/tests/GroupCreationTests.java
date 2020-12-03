package garuda.dndz.ua.tests;


import garuda.dndz.ua.model.GroupData;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void addGroupTest() {

    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test1", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size()+1);

    int max = 0;
    for (GroupData g : after){
      if(g.getId() > max){
        max = g.getId();
      }
    }
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));


    app.getSessionManager().logout();
  }

}

