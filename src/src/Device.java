package src;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4753.5a97eca04 modeling language!*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// line 58 "model.ump"
// line 116 "model.ump"
public class Device
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Device Attributes
  private String deviceID;
  private int minAge;
  private int minWeight;
  private boolean isExtreme;
  private int price;
  private int minHight; //todo add to uml

  //Device Associations
  private SystemManagment systemManagment;
  private List<Eticket> etickets;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Device(String aDeviceID, int aMinAge, int aMinWeight, int minHight, boolean aIsExtreme, int aPrice, SystemManagment aSystemManagment)
  {
    deviceID = aDeviceID;
    minAge = aMinAge;
    minWeight = aMinWeight;
    this.minHight=minHight;
    isExtreme = aIsExtreme;
    price = aPrice;
    boolean didAddSystemManagment = setSystemManagment(aSystemManagment);
    if (!didAddSystemManagment)
    {
      throw new RuntimeException("Unable to create device due to systemManagment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    etickets = new ArrayList<Eticket>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDeviceID(String aDeviceID)
  {
    boolean wasSet = false;
    deviceID = aDeviceID;
    wasSet = true;
    return wasSet;
  }

  public boolean setMinAge(int aMinAge)
  {
    boolean wasSet = false;
    minAge = aMinAge;
    wasSet = true;
    return wasSet;
  }

  public boolean setMinWeight(int aMinWeight)
  {
    boolean wasSet = false;
    minWeight = aMinWeight;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsExtreme(boolean aIsExtreme)
  {
    boolean wasSet = false;
    isExtreme = aIsExtreme;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrice(int aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public String getDeviceID()
  {
    return deviceID;
  }

  public int getMinAge()
  {
    return minAge;
  }

  public int getMinWeight()
  {
    return minWeight;
  }

  public boolean getIsExtreme()
  {
    return isExtreme;
  }

  public int getPrice()
  {
    return price;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsExtreme()
  {
    return isExtreme;
  }
  /* Code from template association_GetOne */
  public SystemManagment getSystemManagment()
  {
    return systemManagment;
  }
  /* Code from template association_GetMany */
  public Eticket getEticket(int index)
  {
    Eticket aEticket = etickets.get(index);
    return aEticket;
  }

  public List<Eticket> getEtickets()
  {
    List<Eticket> newEtickets = Collections.unmodifiableList(etickets);
    return newEtickets;
  }

  public int numberOfEtickets()
  {
    int number = etickets.size();
    return number;
  }

  public boolean hasEtickets()
  {
    boolean has = etickets.size() > 0;
    return has;
  }

  public int indexOfEticket(Eticket aEticket)
  {
    int index = etickets.indexOf(aEticket);
    return index;
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
      existingSystemManagment.removeDevice(this);
    }
    systemManagment.addDevice(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEtickets()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addEticket(Eticket aEticket)
  {
    boolean wasAdded = false;
    if (etickets.contains(aEticket)) { return false; }
    etickets.add(aEticket);
    if (aEticket.indexOfDevice(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEticket.addDevice(this);
      if (!wasAdded)
      {
        etickets.remove(aEticket);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeEticket(Eticket aEticket)
  {
    boolean wasRemoved = false;
    if (!etickets.contains(aEticket))
    {
      return wasRemoved;
    }

    int oldIndex = etickets.indexOf(aEticket);
    etickets.remove(oldIndex);
    if (aEticket.indexOfDevice(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEticket.removeDevice(this);
      if (!wasRemoved)
      {
        etickets.add(oldIndex,aEticket);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addEticketAt(Eticket aEticket, int index)
  {  
    boolean wasAdded = false;
    if(addEticket(aEticket))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEtickets()) { index = numberOfEtickets() - 1; }
      etickets.remove(aEticket);
      etickets.add(index, aEticket);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEticketAt(Eticket aEticket, int index)
  {
    boolean wasAdded = false;
    if(etickets.contains(aEticket))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEtickets()) { index = numberOfEtickets() - 1; }
      etickets.remove(aEticket);
      etickets.add(index, aEticket);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEticketAt(aEticket, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    SystemManagment placeholderSystemManagment = systemManagment;
    this.systemManagment = null;
    if(placeholderSystemManagment != null)
    {
      placeholderSystemManagment.removeDevice(this);
    }
    ArrayList<Eticket> copyOfEtickets = new ArrayList<Eticket>(etickets);
    etickets.clear();
    for(Eticket aEticket : copyOfEtickets)
    {
      aEticket.removeDevice(this);
    }
  }

  // line 67 "model.ump"
   public String[] showAllowedDevices(String arg0, String arg1){
      return null;
  }

  // line 70 "model.ump"
   public Boolean isExtreme(String arg0){
        return isExtreme;
  }

  public boolean isLegalDevice(Eticket eticket){ //todo add to SD
    if(eticket==null){
      return false;
    }
    else{
      Kid tempKid = eticket.getKid();
      int age = tempKid.getAge();
      int weight = tempKid.getWeight();
      int hight = tempKid.getHight();
      if(this.minAge <= age && minWeight <= weight && minHight <= hight){
        return true;
      }
    }
    return false;
  }

  public String toString()
  {
    return super.toString() + "["+
            "deviceID" + ":" + getDeviceID()+ "," +
            "minAge" + ":" + getMinAge()+ "," +
            "minWeight" + ":" + getMinWeight()+ "," +
            "isExtreme" + ":" + getIsExtreme()+ "," +
            "price" + ":" + getPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "systemManagment = "+(getSystemManagment()!=null?Integer.toHexString(System.identityHashCode(getSystemManagment())):"null");
  }
}