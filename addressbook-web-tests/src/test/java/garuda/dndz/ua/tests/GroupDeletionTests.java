package garuda.dndz.ua.tests;

import garuda.dndz.ua.model.GroupData;
import org.junit.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void deleteGroup() {
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    app.getSessionManager().logout();

  }

}
