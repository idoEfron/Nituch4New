package src;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4753.5a97eca04 modeling language!*/



// line 48 "model.ump"
// line 111 "model.ump"
public class Kid
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Kid Attributes
  private String kidID; //todo change in UML
  private int age;
  private int weight;
  private String password;
  private String name;
  private int hight; //todo change in UML

  //Kid Associations
  private Eticket eticket;
  private Guardian guardian;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Kid(String aKidID, int aAge, int aWeight, String aPassword, String aName, Guardian aGuardian)
  {
    kidID = aKidID;
    age = aAge;
    weight = aWeight;
    password = aPassword;
    name = aName;
   // if (aEticket == null || aEticket.getKid() != null)
   // {
     // throw new RuntimeException("Unable to create Kid due to aEticket. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    //}
  //  eticket = aEticket;
    boolean didAddGuardian = setGuardian(aGuardian);
    if (!didAddGuardian)
    {
      throw new RuntimeException("Unable to create kid due to guardian. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public Kid(String aKidID, int aAge, int aWeight, String aPassword, String aName, SystemManagment aSystemManagmentForEticket, Guardian aGuardian)
  {
    kidID = aKidID;
    age = aAge;
    weight = aWeight;
    password = aPassword;
    name = aName;
    eticket = new Eticket(this, aSystemManagmentForEticket);
    boolean didAddGuardian = setGuardian(aGuardian);
    if (!didAddGuardian)
    {
      throw new RuntimeException("Unable to create kid due to guardian. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setKidID(String aKidID)
  {
    boolean wasSet = false;
    kidID = aKidID;
    wasSet = true;
    return wasSet;
  }

  public void setEticket(Eticket eticket) {
    this.eticket = eticket;
  }

  public boolean setAge(int aAge)
  {
    boolean wasSet = false;
    age = aAge;
    wasSet = true;
    return wasSet;
  }

  public boolean setWeight(int aWeight)
  {
    boolean wasSet = false;
    weight = aWeight;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }


  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }



  public String getKidID()
  {
    return kidID;
  }

  public int getAge()
  {
    return age;
  }

  public int getWeight()
  {
    return weight;
  }

  public String getPassword()
  {
    return password;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetOne */
  public Eticket getEticket()
  {
    return eticket;
  }

  public int getHight(){ //todo changed it
    return hight;
  }

  /* Code from template association_GetOne */
  public Guardian getGuardian()
  {
    return guardian;
  }
  /* Code from template association_SetOneToMany */
  public boolean setGuardian(Guardian aGuardian)
  {
    boolean wasSet = false;
    if (aGuardian == null)
    {
      return wasSet;
    }

    Guardian existingGuardian = guardian;
    guardian = aGuardian;
    if (existingGuardian != null && !existingGuardian.equals(aGuardian))
    {
      existingGuardian.removeKid(this);
    }
    guardian.addKid(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Eticket existingEticket = eticket;
    eticket = null;
    if (existingEticket != null)
    {
      existingEticket.delete();
    }
    Guardian placeholderGuardian = guardian;
    this.guardian = null;
    if(placeholderGuardian != null)
    {
      placeholderGuardian.removeKid(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "kidID" + ":" + getKidID()+ "," +
            "age" + ":" + getAge()+ "," +
            "weight" + ":" + getWeight()+ "," +
            "password" + ":" + getPassword()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "eticket = "+(getEticket()!=null?Integer.toHexString(System.identityHashCode(getEticket())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "guardian = "+(getGuardian()!=null?Integer.toHexString(System.identityHashCode(getGuardian())):"null");
  }
}