package garuda.dndz.ua.tests;

import garuda.dndz.ua.model.GroupData;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void addGroupTest() {
    app.goTO().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    assertThat(after.size(),equalTo(before.size()+1));

    group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    before.add(group);

    assertThat(after, equalTo(before));

  }

}

