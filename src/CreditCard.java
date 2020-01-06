/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4753.5a97eca04 modeling language!*/



// line 75 "model.ump"
// line 123 "model.ump"
public class CreditCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CreditCard Attributes
  private int creditNumber;
  private boolean isValid;
  private int amountInBank;

  //CreditCard Associations
  private Guardian guardian;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CreditCard(int aCreditNumber, boolean aIsValid, int aAmountInBank, Guardian aGuardian)
  {
    creditNumber = aCreditNumber;
    isValid = aIsValid;
    amountInBank = aAmountInBank;
    boolean didAddGuardian = setGuardian(aGuardian);
    if (!didAddGuardian)
    {
      throw new RuntimeException("Unable to create creditCard due to guardian. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCreditNumber(int aCreditNumber)
  {
    boolean wasSet = false;
    creditNumber = aCreditNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsValid(boolean aIsValid)
  {
    boolean wasSet = false;
    isValid = aIsValid;
    wasSet = true;
    return wasSet;
  }

  public boolean setAmountInBank(int aAmountInBank)
  {
    boolean wasSet = false;
    amountInBank = aAmountInBank;
    wasSet = true;
    return wasSet;
  }

  public int getCreditNumber()
  {
    return creditNumber;
  }

  public boolean getIsValid()
  {
    return isValid;
  }

  public int getAmountInBank()
  {
    return amountInBank;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsValid()
  {
    return isValid;
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
      //Unable to setGuardian to null, as creditCard must always be associated to a guardian
      return wasSet;
    }
    
    CreditCard existingCreditCard = aNewGuardian.getCreditCard();
    if (existingCreditCard != null && !equals(existingCreditCard))
    {
      //Unable to setGuardian, the current guardian already has a creditCard, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Guardian anOldGuardian = guardian;
    guardian = aNewGuardian;
    guardian.setCreditCard(this);

    if (anOldGuardian != null)
    {
      anOldGuardian.setCreditCard(null);
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
      existingGuardian.setCreditCard(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "creditNumber" + ":" + getCreditNumber()+ "," +
            "isValid" + ":" + getIsValid()+ "," +
            "amountInBank" + ":" + getAmountInBank()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "guardian = "+(getGuardian()!=null?Integer.toHexString(System.identityHashCode(getGuardian())):"null");
  }
}