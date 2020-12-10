package garuda.dndz.ua.model;

public class ContactData {
  private int id;
  private String firstname;
  private String lastname;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String allPhone;

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
}
