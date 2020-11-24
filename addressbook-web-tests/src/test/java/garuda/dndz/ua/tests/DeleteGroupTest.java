package garuda.dndz.ua.tests;

import org.junit.Test;

public class DeleteGroupTest extends TestBase {

  @Test
  public void deleteGroup() {
    app.gotoGroupPage();
    app.selectGroup();
    app.deleteSelectedGroups();
    app.gotoGroupPage();
    app.logout();

  }

}
