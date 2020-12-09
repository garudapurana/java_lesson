package garuda.dndz.ua.tests;

import garuda.dndz.ua.model.GroupData;
import garuda.dndz.ua.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class GroupModificationTests extends TestBase{
  @BeforeMethod
  public void ansurePreconditions(){
    app.goTO().groupPage();
    if(app.group().all().size() == 0){
      app.group().create(new GroupData().withName("test1"));
    }
  }
  @Test
  public void modificationTest(){
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    Groups after = app.group().all();
    assertEquals(before.size(),after.size());
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }
}
