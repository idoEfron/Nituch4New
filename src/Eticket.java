
/*This code was generated using the UMPLE 1.29.1.4753.5a97eca04 modeling language!*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// line 28 "model.ump"
// line 97 "model.ump"
public class Eticket
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Eticket Associations
  private Kid kid;
  private SystemManagment systemManagment;
  private List<Device> devices;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Eticket(Kid aKid, SystemManagment aSystemManagment)
  {
    if (aKid == null || aKid.getEticket() != null)
    {
      throw new RuntimeException("Unable to create Eticket due to aKid. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    kid = aKid;
    boolean didAddSystemManagment = setSystemManagment(aSystemManagment);
    if (!didAddSystemManagment)
    {
      throw new RuntimeException("Unable to create eticket due to systemManagment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    devices = new ArrayList<Device>();
  }

  public Eticket(String aKidIDForKid, int aAgeForKid, int aWeightForKid, String aPasswordForKid, String aNameForKid, Guardian aGuardianForKid, SystemManagment aSystemManagment)
  {
    kid = new Kid(aKidIDForKid, aAgeForKid, aWeightForKid, aPasswordForKid, aNameForKid, aSystemManagment, aGuardianForKid);
    boolean didAddSystemManagment = setSystemManagment(aSystemManagment);
    if (!didAddSystemManagment)
    {
      throw new RuntimeException("Unable to create eticket due to systemManagment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    devices = new ArrayList<Device>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Kid getKid()
  {
    return kid;
  }
  /* Code from template association_GetOne */
  public SystemManagment getSystemManagment()
  {
    return systemManagment;
  }
  /* Code from template association_GetMany */
  public Device getDevice(int index)
  {
    Device aDevice = devices.get(index);
    return aDevice;
  }

  public List<Device> getDevices()
  {
    List<Device> newDevices = Collections.unmodifiableList(devices);
    return newDevices;
  }

  public int numberOfDevices()
  {
    int number = devices.size();
    return number;
  }

  public boolean hasDevices()
  {
    boolean has = devices.size() > 0;
    return has;
  }

  public int indexOfDevice(Device aDevice)
  {
    int index = devices.indexOf(aDevice);
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
      existingSystemManagment.removeEticket(this);
    }
    systemManagment.addEticket(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDevices()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDevice(Device aDevice)
  {
    boolean wasAdded = false;
    if (devices.contains(aDevice)) { return false; }
    devices.add(aDevice);
    if (aDevice.indexOfEticket(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDevice.addEticket(this);
      if (!wasAdded)
      {
        devices.remove(aDevice);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDevice(Device aDevice)
  {
    boolean wasRemoved = false;
    if (!devices.contains(aDevice))
    {
      return wasRemoved;
    }

    int oldIndex = devices.indexOf(aDevice);
    devices.remove(oldIndex);
    if (aDevice.indexOfEticket(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDevice.removeEticket(this);
      if (!wasRemoved)
      {
        devices.add(oldIndex,aDevice);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDeviceAt(Device aDevice, int index)
  {  
    boolean wasAdded = false;
    if(addDevice(aDevice))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDevices()) { index = numberOfDevices() - 1; }
      devices.remove(aDevice);
      devices.add(index, aDevice);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDeviceAt(Device aDevice, int index)
  {
    boolean wasAdded = false;
    if(devices.contains(aDevice))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDevices()) { index = numberOfDevices() - 1; }
      devices.remove(aDevice);
      devices.add(index, aDevice);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDeviceAt(aDevice, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Kid existingKid = kid;
    kid = null;
    if (existingKid != null)
    {
      existingKid.delete();
    }
    SystemManagment placeholderSystemManagment = systemManagment;
    this.systemManagment = null;
    if(placeholderSystemManagment != null)
    {
      placeholderSystemManagment.removeEticket(this);
    }
    while (devices.size() > 0)
    {
      Device aDevice = devices.get(devices.size() - 1);
      aDevice.delete();
      devices.remove(aDevice);
    }
    
  }

  // line 33 "model.ump"
   public String checkDetails(String arg0){

    return null;
  }

  // line 36 "model.ump"
   public void addEntry(String arg0, String arg1){
    
  }

}