/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4753.5a97eca04 modeling language!*/


import java.util.*;

// line 41 "model.ump"
// line 104 "model.ump"
public class Guardian
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Guardian Attributes
  private String guardianID;

  //Guardian Associations
  private List<Kid> kids;
  private SystemManagment systemManagment;
  private CreditCard creditCard;
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Guardian(String aGuardianID, SystemManagment aSystemManagment)
  {
    guardianID = aGuardianID;
    kids = new ArrayList<Kid>();
    boolean didAddSystemManagment = setSystemManagment(aSystemManagment);
    if (!didAddSystemManagment)
    {
      throw new RuntimeException("Unable to create guardian due to systemManagment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setGuardianID(String aGuardianID)
  {
    boolean wasSet = false;
    guardianID = aGuardianID;
    wasSet = true;
    return wasSet;
  }

  public String getGuardianID()
  {
    return guardianID;
  }
  /* Code from template association_GetMany */
  public Kid getKid(int index)
  {
    Kid aKid = kids.get(index);
    return aKid;
  }

  public List<Kid> getKids()
  {
    List<Kid> newKids = Collections.unmodifiableList(kids);
    return newKids;
  }

  public int numberOfKids()
  {
    int number = kids.size();
    return number;
  }

  public boolean hasKids()
  {
    boolean has = kids.size() > 0;
    return has;
  }

  public int indexOfKid(Kid aKid)
  {
    int index = kids.indexOf(aKid);
    return index;
  }
  /* Code from template association_GetOne */
  public SystemManagment getSystemManagment()
  {
    return systemManagment;
  }
  /* Code from template association_GetOne */
  public CreditCard getCreditCard()
  {
    return creditCard;
  }

  public boolean hasCreditCard()
  {
    boolean has = creditCard != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Account getAccount()
  {
    return account;
  }

  public boolean hasAccount()
  {
    boolean has = account != null;
    return has;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfKids()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Kid addKid(String aKidID, int aAge, int aWeight, String aPassword, String aName)
  {
    return new Kid(aKidID, aAge, aWeight, aPassword, aName, this);
  }

  public boolean addKid(Kid aKid)
  {
    boolean wasAdded = false;
    if (kids.contains(aKid)) { return false; }
    Guardian existingGuardian = aKid.getGuardian();
    boolean isNewGuardian = existingGuardian != null && !this.equals(existingGuardian);
    if (isNewGuardian)
    {
      aKid.setGuardian(this);
    }
    else
    {
      kids.add(aKid);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeKid(Kid aKid)
  {
    boolean wasRemoved = false;
    //Unable to remove aKid, as it must always have a guardian
    if (this.equals(aKid.getGuardian()))
    {
      kids.remove(aKid);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addKidAt(Kid aKid, int index)
  {  
    boolean wasAdded = false;
    if(addKid(aKid))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfKids()) { index = numberOfKids() - 1; }
      kids.remove(aKid);
      kids.add(index, aKid);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveKidAt(Kid aKid, int index)
  {
    boolean wasAdded = false;
    if(kids.contains(aKid))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfKids()) { index = numberOfKids() - 1; }
      kids.remove(aKid);
      kids.add(index, aKid);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addKidAt(aKid, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setSystemManagment(SystemManagment aSystemManagment)
  {
    boolean wasSet = false;
    if (aSystemManagment == null)
    {
      return wasSet;
    }

    SystemManagment existingSystemManagment = systemManagment;
    systemManagment = aSystemManagment;
    if (existingSystemManagment != null && !existingSystemManagment.equals(aSystemManagment))
    {
      existingSystemManagment.removeGuardian(this);
    }
    systemManagment.addGuardian(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setCreditCard(CreditCard aNewCreditCard)
  {
    boolean wasSet = false;
    if (creditCard != null && !creditCard.equals(aNewCreditCard) && equals(creditCard.getGuardian()))
    {
      //Unable to setCreditCard, as existing creditCard would become an orphan
      return wasSet;
    }

    creditCard = aNewCreditCard;
    Guardian anOldGuardian = aNewCreditCard != null ? aNewCreditCard.getGuardian() : null;

    if (!this.equals(anOldGuardian))
    {
      if (anOldGuardian != null)
      {
        anOldGuardian.creditCard = null;
      }
      if (creditCard != null)
      {
        creditCard.setGuardian(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  /**
   * ido add equals ask him
   * @param o
   * @return
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Guardian guardian = (Guardian) o;
    return Objects.equals(guardianID, guardian.guardianID) &&
            Objects.equals(systemManagment, guardian.systemManagment) &&
            Objects.equals(creditCard, guardian.creditCard);
  }


  /* Code from template association_SetOptionalOneToOne */
  public boolean setAccount(Account aNewAccount)
  {
    boolean wasSet = false;
    if (account != null && !account.equals(aNewAccount) && equals(account.getGuardian()))
    {
      //Unable to setAccount, as existing account would become an orphan
      return wasSet;
    }

    account = aNewAccount;
    Guardian anOldGuardian = aNewAccount != null ? aNewAccount.getGuardian() : null;

    if (!this.equals(anOldGuardian))
    {
      if (anOldGuardian != null)
      {
        anOldGuardian.account = null;
      }
      if (account != null)
      {
        account.setGuardian(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=kids.size(); i > 0; i--)
    {
      Kid aKid = kids.get(i - 1);
      aKid.delete();
    }
    SystemManagment placeholderSystemManagment = systemManagment;
    this.systemManagment = null;
    if(placeholderSystemManagment != null)
    {
      placeholderSystemManagment.removeGuardian(this);
    }
    CreditCard existingCreditCard = creditCard;
    creditCard = null;
    if (existingCreditCard != null)
    {
      existingCreditCard.delete();
    }
    Account existingAccount = account;
    account = null;
    if (existingAccount != null)
    {
      existingAccount.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "guardianID" + ":" + getGuardianID()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "systemManagment = "+(getSystemManagment()!=null?Integer.toHexString(System.identityHashCode(getSystemManagment())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "creditCard = "+(getCreditCard()!=null?Integer.toHexString(System.identityHashCode(getCreditCard())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}