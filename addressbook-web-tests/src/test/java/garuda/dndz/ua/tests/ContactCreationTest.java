package garuda.dndz.ua.tests;

import garuda.dndz.ua.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation(){
    app.goTO().gotoHomePage();
    app.contact().initContactCreation();
    app.contact().fillContactForm(new ContactData("test_name","test_surname","test1"),true);
    app.contact().submitContactCreation();
    app.contact().returnToHomePage();
  }
}
