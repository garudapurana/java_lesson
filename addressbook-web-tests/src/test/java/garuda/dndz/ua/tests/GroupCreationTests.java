package garuda.dndz.ua.tests;

import garuda.dndz.ua.model.GroupData;
import garuda.dndz.ua.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void addGroupTest() {
    app.goTO().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    assertThat(app.group().count(),equalTo(before.size()+1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));

  }
  @Test
  public void addGroupBadTest() {
    app.goTO().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test'");
    app.group().create(group);
    assertThat(app.group().count(),equalTo(before.size()));
    Groups after = app.group().all();

    assertThat(after, equalTo(before));
  }

}

