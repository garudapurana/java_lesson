package garuda.dndz.ua.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
@Entity
@Table(name = "addressbook")
public class ContactData {
  @Id
  @Column(name = "id")
  private int id;
  @Column(name = "firstname")
  private String firstname;
  @Column(name = "lastname")
  private String lastname;
  @Transient
  private String group;
  @Column(name = "home")
  @Type(type ="text")
  private String homePhone;
  @Column(name = "mobile")
  @Type(type ="text")
  private String mobilePhone;
  @Column(name = "work")
  @Type(type ="text")
  private String workPhone;
  @Transient
  private String allPhone;
  @Column(name = "photo")
  @Type(type ="text")
  private String photo;

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public ContactData() {

  }

  public String getFirstname(){return firstname;}
  public String getLastname(){return lastname;}
  public String getGroup() {
    return group;
  }
  public int getId() { return id; }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public String getWorkPhone(){return workPhone;}
  public ContactData withWorkPhone(String workPhone){
    this.workPhone = workPhone;
    return this;
  }
  public String getHomePhone(){return homePhone;}
  public ContactData withHomePhone(String homePhone){
    this.homePhone = homePhone;
    return this;
  }
  public String getMobilePhone(){return mobilePhone;}
  public ContactData withMobilePhone(String mobilePhone){
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData(String firstname,String lastname,String group){
    this.firstname = firstname;
    this.lastname = lastname;
    this.group = group;
  }


  public ContactData withId(int id) {
    this.id =id;
    return this;
  }


  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public String getAllPhone() {
    return allPhone;
  }

  public ContactData withAllPhone(String allPhone) {
    this.allPhone = allPhone;
    return this;
  }

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }
}
