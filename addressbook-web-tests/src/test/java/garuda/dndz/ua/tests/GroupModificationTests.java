package garuda.dndz.ua.tests;

import garuda.dndz.ua.model.GroupData;
import garuda.dndz.ua.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase{
  @BeforeMethod
  public void ansurePreconditions(){
    if (app.db().groups().size() == 0){
      app.goTO().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }
  @Test
  public void modificationTest(){

    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.goTO().groupPage();
    app.group().modify(group);
    assertThat(app.group().count(),equalTo(before.size()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    VerifyGroupListInUI();
  }


}
