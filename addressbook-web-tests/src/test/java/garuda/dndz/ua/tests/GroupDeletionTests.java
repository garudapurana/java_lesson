package garuda.dndz.ua.tests;

import garuda.dndz.ua.model.GroupData;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ansurePreconditions(){
    app.goTO().groupPage();
    if(app.group().all().size() == 0){
      app.group().create(new GroupData().withName("test1"));
    }
  }
  @Test
  public void deleteGroup() {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(deletedGroup);
    Assert.assertEquals(before,after);
  }



}
