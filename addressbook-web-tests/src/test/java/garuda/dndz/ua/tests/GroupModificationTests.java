package garuda.dndz.ua.tests;

import garuda.dndz.ua.model.GroupData;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase{
  @BeforeMethod
  public void ansurePreconditions(){
    app.goTO().groupPage();
    if(app.group().list().size() == 0){
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void modificationTest(){
    List<GroupData> before = app.group().list();
    int index = before.size()-1;
    GroupData group = new GroupData().withId(before.get(index).getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(index,group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(before.size(),after.size());

    before.remove(index);
    before.add(group);
    //Comparator<? super GroupData> byId = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }


}
