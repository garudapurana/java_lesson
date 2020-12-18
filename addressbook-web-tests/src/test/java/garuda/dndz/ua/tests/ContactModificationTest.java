package garuda.dndz.ua.tests;

import garuda.dndz.ua.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModification(){
    app.goTO().gotoHomePage();
    app.contact().initContactModification();
    app.contact().fillContactForm(new ContactData("test_name","test_surname"),false);
    app.contact().submitContactModification();
    app.contact().returnToHomePage();
  }
}
