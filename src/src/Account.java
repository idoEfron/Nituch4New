package src;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4753.5a97eca04 modeling language!*/



// line 83 "model.ump"
// line 129 "model.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private int maxBilling;
  private int currBilling;

  //Account Associations
  private Guardian guardian;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(int aMaxBilling, int aCurrBilling, Guardian aGuardian)
  {
    maxBilling = aMaxBilling;
    currBilling = aCurrBilling;
    boolean didAddGuardian = setGuardian(aGuardian);
    if (!didAddGuardian)
    {
      throw new RuntimeException("Unable to create account due to guardian. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMaxBilling(int aMaxBilling)
  {
    boolean wasSet = false;
    maxBilling = aMaxBilling;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrBilling(int aCurrBilling)
  {
    boolean wasSet = false;
    currBilling = aCurrBilling;
    wasSet = true;
    return wasSet;
  }

  public int getMaxBilling()
  {
    return maxBilling;
  }

  public int getCurrBilling()
  {
    return currBilling;
  }
  /* Code from template association_GetOne */
  public Guardian getGuardian()
  {
    return guardian;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setGuardian(Guardian aNewGuardian)
  {
    boolean wasSet = false;
    if (aNewGuardian == null)
    {
      //Unable to setGuardian to null, as account must always be associated to a guardian
      return wasSet;
    }
    
    Account existingAccount = aNewGuardian.getAccount();
    if (existingAccount != null && !equals(existingAccount))
    {
      //Unable to setGuardian, the current guardian already has a account, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Guardian anOldGuardian = guardian;
    guardian = aNewGuardian;
    guardian.setAccount(this);

    if (anOldGuardian != null)
    {
      anOldGuardian.setAccount(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Guardian existingGuardian = guardian;
    guardian = null;
    if (existingGuardian != null)
    {
      existingGuardian.setAccount(null);
    }
  }

  // line 89 "model.ump"
   public Integer finalBilling(){

    return currBilling;
  }


  public String toString()
  {
    return super.toString() + "["+
            "maxBilling" + ":" + getMaxBilling()+ "," +
            "currBilling" + ":" + getCurrBilling()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "guardian = "+(getGuardian()!=null?Integer.toHexString(System.identityHashCode(getGuardian())):"null");
  }
}