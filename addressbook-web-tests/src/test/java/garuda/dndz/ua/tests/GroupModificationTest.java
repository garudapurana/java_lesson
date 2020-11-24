package garuda.dndz.ua.tests;

import garuda.dndz.ua.model.GroupData;
import org.junit.Test;

public class GroupModificationTest extends TestBase{
  @Test
  public void modificationTest(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("asdasdasdasdasd", "123asd", "asd123"));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().gotoGroupPage();
    app.getSessionManager().logout();
  }
}
