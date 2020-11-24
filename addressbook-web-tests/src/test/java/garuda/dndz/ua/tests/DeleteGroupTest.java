package garuda.dndz.ua.tests;

import org.junit.Test;

public class DeleteGroupTest extends TestBase {

  @Test
  public void deleteGroup() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getNavigationHelper().gotoGroupPage();
    app.logout();

  }

}
