package garuda.dndz.ua.appmanager;

import garuda.dndz.ua.model.ContactData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd){super(wd);}
  public void initContactCreation(){
    click(By.linkText("add new"));
  }
  public void fillContactForm(ContactData contactData,boolean creation){
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("lastname"),contactData.getLastname());
    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }


  public void submitContactCreation(){
    click(By.name("submit"));
  }
  public void returnToHomePage(){
    click(By.linkText("home page"));
  }
  public void initContactModification(){
    click(By.cssSelector("img[alt='Edit']"));
  }
  public void submitContactModification(){
    click(By.name("update"));
  }
}
