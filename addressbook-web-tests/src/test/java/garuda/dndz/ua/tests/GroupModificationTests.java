package garuda.dndz.ua.tests;

import garuda.dndz.ua.model.GroupData;
import org.junit.Test;

public class GroupModificationTests extends TestBase{
  @Test
  public void modificationTest(){
    app.getNavigationHelper().gotoGroupPage();

    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }

    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    app.getSessionManager().logout();
  }
}
