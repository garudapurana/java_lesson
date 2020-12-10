package garuda.dndz.ua.tests;

import garuda.dndz.ua.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase{
  @Test
  public void testContactPhone(){
    app.goTO().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhone(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTest::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]]","");
  }
}
