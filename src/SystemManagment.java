/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4753.5a97eca04 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 135 "model.ump"
public class SystemManagment {

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //SystemManagment Associations
    private List<Eticket> etickets;
    private List<Guardian> guardians;
    private List<Device> devices;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public SystemManagment() {
        etickets = new LinkedList<Eticket>();
        guardians = new LinkedList<Guardian>();
        devices = new LinkedList<Device>();
    }

    //------------------------
    // INTERFACE
    //------------------------
    /* Code from template association_GetMany */
    public Eticket getEticket(int index) {
        Eticket aEticket = etickets.get(index);
        return aEticket;
    }

    public List<Eticket> getEtickets() {
        List<Eticket> newEtickets = Collections.unmodifiableList(etickets);
        return newEtickets;
    }

    public int numberOfEtickets() {
        int number = etickets.size();
        return number;
    }

    public boolean hasEtickets() {
        boolean has = etickets.size() > 0;
        return has;
    }

    public int indexOfEticket(Eticket aEticket) {
        int index = etickets.indexOf(aEticket);
        return index;
    }

    /* Code from template association_GetMany */
    public Guardian getGuardian(int index) {
        Guardian aGuardian = guardians.get(index);
        return aGuardian;
    }

    public List<Guardian> getGuardians() {
        List<Guardian> newGuardians = Collections.unmodifiableList(guardians);
        return newGuardians;
    }

    public int numberOfGuardians() {
        int number = guardians.size();
        return number;
    }

    public boolean hasGuardians() {
        boolean has = guardians.size() > 0;
        return has;
    }

    public int indexOfGuardian(Guardian aGuardian) {
        int index = guardians.indexOf(aGuardian);
        return index;
    }

    /* Code from template association_GetMany */
    public Device getDevice(int index) {
        Device aDevice = devices.get(index);
        return aDevice;
    }

    public List<Device> getDevices() {
        List<Device> newDevices = Collections.unmodifiableList(devices);
        return newDevices;
    }

    public int numberOfDevices() {
        int number = devices.size();
        return number;
    }

    public boolean hasDevices() {
        boolean has = devices.size() > 0;
        return has;
    }

    public int indexOfDevice(Device aDevice) {
        int index = devices.indexOf(aDevice);
        return index;
    }

    /* Code from template association_MinimumNumberOfMethod */
    public static int minimumNumberOfEtickets() {
        return 0;
    }

    /* Code from template association_AddManyToOne */
    public Eticket addEticket(Kid aKid) {
        return new Eticket(aKid, this);
    }

    public boolean addEticket(Eticket aEticket) {
        boolean wasAdded = false;
        if (etickets.contains(aEticket)) {
            return false;
        }
        SystemManagment existingSystemManagment = aEticket.getSystemManagment();
        boolean isNewSystemManagment = existingSystemManagment != null && !this.equals(existingSystemManagment);
        if (isNewSystemManagment) {
            aEticket.setSystemManagment(this);
        } else {
            etickets.add(aEticket);
        }
        wasAdded = true;
        return wasAdded;
    }

    public boolean removeEticket(Eticket aEticket) {
        boolean wasRemoved = false;
        //Unable to remove aEticket, as it must always have a systemManagment
        if (!this.equals(aEticket.getSystemManagment())) {
            etickets.remove(aEticket);
            wasRemoved = true;
        }
        return wasRemoved;
    }

    /* Code from template association_AddIndexControlFunctions */
    public boolean addEticketAt(Eticket aEticket, int index) {
        boolean wasAdded = false;
        if (addEticket(aEticket)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfEtickets()) {
                index = numberOfEtickets() - 1;
            }
            etickets.remove(aEticket);
            etickets.add(index, aEticket);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveEticketAt(Eticket aEticket, int index) {
        boolean wasAdded = false;
        if (etickets.contains(aEticket)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfEtickets()) {
                index = numberOfEtickets() - 1;
            }
            etickets.remove(aEticket);
            etickets.add(index, aEticket);
            wasAdded = true;
        } else {
            wasAdded = addEticketAt(aEticket, index);
        }
        return wasAdded;
    }

    /* Code from template association_MinimumNumberOfMethod */
    public static int minimumNumberOfGuardians() {
        return 0;
    }

    /* Code from template association_AddManyToOne */
    public Guardian addGuardian(String aGuardianID) {
        return new Guardian(aGuardianID, this);
    }

    public boolean addGuardian(Guardian aGuardian) {
        boolean wasAdded = false;
        if (guardians.contains(aGuardian)) {
            return false;
        }
        SystemManagment existingSystemManagment = aGuardian.getSystemManagment();
        boolean isNewSystemManagment = existingSystemManagment != null && !this.equals(existingSystemManagment);
        if (isNewSystemManagment) {
            aGuardian.setSystemManagment(this);
        } else {
            guardians.add(aGuardian);
        }
        wasAdded = true;
        return wasAdded;
    }

    public Guardian getGuardianOnId(String id) {
        for (Guardian guard : guardians) {
            if (guard.getGuardianID().equals(id)) {
                return guard;
            }
        }
        System.out.println("this guardian doesnt exist");
        return null;
    }

    public boolean removeGuardian(Guardian aGuardian) {
        boolean wasRemoved = false;
        //Unable to remove aGuardian, as it must always have a systemManagment
        if (!this.equals(aGuardian.getSystemManagment())) {
            guardians.remove(aGuardian);
            wasRemoved = true;
        }
        return wasRemoved;
    }

    /* Code from template association_AddIndexControlFunctions */
    public boolean addGuardianAt(Guardian aGuardian, int index) {
        boolean wasAdded = false;
        if (addGuardian(aGuardian)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfGuardians()) {
                index = numberOfGuardians() - 1;
            }
            guardians.remove(aGuardian);
            guardians.add(index, aGuardian);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveGuardianAt(Guardian aGuardian, int index) {
        boolean wasAdded = false;
        if (guardians.contains(aGuardian)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfGuardians()) {
                index = numberOfGuardians() - 1;
            }
            guardians.remove(aGuardian);
            guardians.add(index, aGuardian);
            wasAdded = true;
        } else {
            wasAdded = addGuardianAt(aGuardian, index);
        }
        return wasAdded;
    }

    /* Code from template association_MinimumNumberOfMethod */
    public static int minimumNumberOfDevices() {
        return 0;
    }

    /* Code from template association_AddManyToOne */
    public Device addDevice(String aDeviceID, int aMinAge, int aMinWeight, int minHight, boolean aIsExtreme, int aPrice) {
        return new Device(aDeviceID, aMinAge, aMinWeight, minHight, aIsExtreme, aPrice, this);
    }

    public boolean addDevice(Device aDevice) {
        boolean wasAdded = false;
        if (devices.contains(aDevice)) {
            return false;
        }
        SystemManagment existingSystemManagment = aDevice.getSystemManagment();
        boolean isNewSystemManagment = existingSystemManagment != null && !this.equals(existingSystemManagment);
        if (isNewSystemManagment) {
            aDevice.setSystemManagment(this);
        } else {
            devices.add(aDevice);
        }
        wasAdded = true;
        return wasAdded;
    }

    public boolean removeDevice(Device aDevice) {
        boolean wasRemoved = false;
        //Unable to remove aDevice, as it must always have a systemManagment
        if (!this.equals(aDevice.getSystemManagment())) {
            devices.remove(aDevice);
            wasRemoved = true;
        }
        return wasRemoved;
    }

    /* Code from template association_AddIndexControlFunctions */
    public boolean addDeviceAt(Device aDevice, int index) {
        boolean wasAdded = false;
        if (addDevice(aDevice)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfDevices()) {
                index = numberOfDevices() - 1;
            }
            devices.remove(aDevice);
            devices.add(index, aDevice);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveDeviceAt(Device aDevice, int index) {
        boolean wasAdded = false;
        if (devices.contains(aDevice)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfDevices()) {
                index = numberOfDevices() - 1;
            }
            devices.remove(aDevice);
            devices.add(index, aDevice);
            wasAdded = true;
        } else {
            wasAdded = addDeviceAt(aDevice, index);
        }
        return wasAdded;
    }

    public void delete() {
        while (etickets.size() > 0) {
            Eticket aEticket = etickets.get(etickets.size() - 1);
            aEticket.delete();
            etickets.remove(aEticket);
        }

        while (guardians.size() > 0) {
            Guardian aGuardian = guardians.get(guardians.size() - 1);
            aGuardian.delete();
            guardians.remove(aGuardian);
        }

        while (devices.size() > 0) {
            Device aDevice = devices.get(devices.size() - 1);
            aDevice.delete();
            devices.remove(aDevice);
        }

    }

    // line 7 "model.ump"
    public void fillInfo(String name, String age) {
        Scanner scanner = new Scanner(System.in);
        double correctAge = 0;
        if (isNumeric(age)) {
            correctAge = Double.parseDouble(age);
        }
        while (correctAge < 0 || correctAge > 14 || age == null) {
            System.out.println("please insert correct age");
            correctAge = Double.parseDouble(scanner.nextLine());
        }
        while (name.length() < 0 || name == null || !isAlpha(name)) {
            System.out.println("please insert correct name");
            name = scanner.nextLine();
        }
        System.out.println("all of the child details are correct!");
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // line 10 "model.ump"
    public void insertPayment(String creditCard, String maxBilling, Guardian guardian) {
        Scanner scanner = new Scanner(System.in);
        while (!isNumeric(creditCard)) {
            System.out.println("credit card is not valid");
            System.out.println("good bye :)");
            System.exit(0);
        }
        int amount = guardian.getCreditCard().getAmountInBank();
        while (!isNumeric(maxBilling) || Integer.parseInt(maxBilling) > amount) {
            System.out.println("Please enter a correct amount to bill");
            maxBilling = scanner.nextLine();
        }
        System.out.println("all the credit card details and the billing are verified and OK!");
    }

    // line 13 "model.ump"
    public void insertChildInfo(String weight, String height,Kid kid) {
        if(isNumeric(weight)&&isNumeric(height)){
            kid.setWeight(Integer.parseInt(weight));
            kid.setHeight(Integer.parseInt(height));
        }

    }

  // line 16 "model.ump"
   public void followEticket(String eticketID){
    if(etickets.size()<1){
      System.out.println("The eTicket doesn't exists in the system");
    }
    else{
      for(Eticket eticket : etickets){
        if(eticket.getKid().getKidID().equals(eticketID)){
          System.out.println(eticket.checkDetails());
          return;
        }
      }
      System.out.println("The eTicket doesn't exists in the system");
    }
  }

  // line 19 "model.ump"
  public void addEntries(String eticketID) {
    if (etickets.size() < 1) {
      System.out.println("The eTicket doesn't exists in the system");
    }
    else {
      System.out.println("Here are all of the optional devices:" + "\n");
      if(containsEticket(eticketID)) {
        Eticket eticket = getEticket(eticketID);
          for (Device device : devices) {
            if (device.isLegalDevice(eticket)) {
              System.out.println(device.toString());
            }
          }
          //until here the guardian can see all of his options
        }
      else{
        System.out.println("The eTicket doesn't exists in the system");
        return;
      }
      //finishes the loop, waiting for the client respond
      boolean flag = false;
      while (!flag) {
        System.out.println("Please enter the deviceID you want to add" + "\n" + " enter 'Stop' in order to stop adding");
        Scanner sc = new Scanner(System.in);
        String deviceName = sc.nextLine();
        if (deviceName.equals("Stop")) {
          flag = true;
        }
        else {
          if(containsDevice(deviceName)){
            Device tempDevice = getDevice(deviceName);
            if(tempDevice.isLegalDevice(getEticket(eticketID))){
              //now we will check if the device is extreme or not
              if(tempDevice.getIsExtreme()){
                System.out.println("This device is extreme and we need your approval"+"\n"
                        +"please insert 'Y' for approve or 'N' to disapprove");
                String answer = sc.nextLine();
                if(answer.equals("Y")){
                  //add the extreme device
                  if(passAccountLimit(tempDevice.getPrice(),eticketID)){
                    Eticket temp = getEticket(eticketID);
                    temp.addDevice(tempDevice);
                    updateAccountAdd(tempDevice,getEticket(eticketID));
                    System.out.println("The device"+tempDevice.getDeviceID()+"added successfully");
                  }
                  else{
                    System.out.println("You have reached the limitation of your account"+"\n"+
                            "The device wasn't added");
                  }
                }
                //if the user didn't approve the extreme device
                else{
                  System.out.println("You didn't confirm the extreme"+"\n"+"The device wasn't added");
                }
              }
              //if the device is not extreme
              else{
                if(passAccountLimit(tempDevice.getPrice(),eticketID)){
                  Eticket temp = getEticket(eticketID);
                  temp.addDevice(tempDevice);
                  updateAccountAdd(tempDevice,getEticket(eticketID));
                  System.out.println("The device"+tempDevice.getDeviceID()+"added successfully");
                }
                else{
                  System.out.println("You passed your account balance"+"\n"+"The device wasn't added");
                }
              }
            }
            else {
              System.out.println("The device you chose is not a legal option for your children, the device wasn't added");
            }
          }
          else {
            System.out.println("The device doesn't exist in the system, the device wasn't added");
          }
        }
      }
    }
  }

  private void updateAccountAdd(Device device, Eticket eticket){
     int price = device.getPrice();
     int currBilling = eticket.getKid().getGuardian().getAccount().getCurrBilling();
     eticket.getKid().getGuardian().getAccount().setCurrBilling(price+currBilling);
  }

  private void updateAccountRemove(Device device, Eticket eticket){
    int price = device.getPrice();
    int currBilling = eticket.getKid().getGuardian().getAccount().getCurrBilling();
    eticket.getKid().getGuardian().getAccount().setCurrBilling(currBilling-price);
  }

  public void removeEntry(String eticketID, String deviceID){
    if(containsEticket(eticketID)){
      if(containsDevice(deviceID)){
        Eticket temp = getEticket(eticketID);
        List<Device> tempDevices = temp.getDevices();
        boolean flag=false;
        Device tempDevice=null;
        int counter=0;
        for(Device device : tempDevices){
          if(device.getDeviceID().equals(deviceID)){
            flag=true;
            tempDevice = device;
            break;
          }
          counter++;
        }
        if(flag) {
          int price = tempDevice.getPrice();
          Account tempAcc = temp.getKid().getGuardian().getAccount();
          int currSum = temp.getKid().getGuardian().getAccount().getCurrBilling();
          tempAcc.setCurrBilling(currSum - price);
          //temp.getDevices().remove(counter);
          temp.removeDevice(tempDevice);
          System.out.println("Entry was removed successfully");
        }
      }
      else{
        System.out.println("This deviceID doesn't exist in the system");
        return;
      }
    }
    else{
      System.out.println("This eTicket ID doesn't exist in the system");
    }
  }

    private boolean passAccountLimit(int price, String eticketID) {
        Eticket eticket = getEticket(eticketID);
        if (eticket != null) {
            int currPrice = eticket.getKid().getGuardian().getAccount().getCurrBilling();
            int maxPrice = eticket.getKid().getGuardian().getAccount().getMaxBilling();
            if (currPrice + price <= maxPrice) {
                return true;
            }
        }
        return false;
    }

  private boolean containsEticket(String eticketID){
    if(etickets==null){
      return false;
    }
    if(etickets.size()>=1){
      for(Eticket eticket : etickets){
        if(eticket.getKid().getKidID().equals(eticketID)){
          return true;
        }
      }
    }
    return false;
  }

  private Eticket getEticket (String eticketID){
    if(etickets!=null){
      if(etickets.size()>=1){
        for(Eticket eticket : etickets){
          if(eticket.getKid().getKidID().equals(eticketID)){
            return eticket;
          }
        }
      }
    }
    return null;
  }

  private boolean containsDevice(String deviceID){
    if(devices!=null){
      if(devices.size()>=1){
        for(Device device : devices){
          if(device.getDeviceID().equals(deviceID)){
            return true;
          }
        }
      }
    }
    return false;
  }

  private Device getDevice(String deviceID){
    if(devices==null){
      return null;
    }
    else{
      if(devices.size()>=1){
        for(Device device : devices){
          if(device.getDeviceID().equals(deviceID)){
            return device;
          }
        }
      }
      return null;
    }
  }

    // line 22 "model.ump"
    public void confirmExtreme(String arg0) {

    }

    // line 25 "model.ump"
    public void leavePark() {//todo remove string from function in uml
        Scanner scanner = new Scanner(System.in);
        System.out.println("please return the Ebracelet of the kid by pressing any key");
        scanner.nextLine();
        System.out.println("please insert the user name of the returning Ebracelet of the child");
        String userName = scanner.nextLine();
        System.out.println("please insert the password of the returning Ebracelet of the child");
        String password = scanner.nextLine();
        Eticket eticket = eticketInSystem(userName, password);
        while (eticket == null) {
            System.out.println("incorrect user name/ password please renter kid user name:");
            userName = scanner.nextLine();
            System.out.println("please renter kid password");
            password = scanner.nextLine();
            eticket = eticketInSystem(userName, password);
        }
        Guardian guardian = eticket.getKid().getGuardian();
        removeKid(guardian, eticket);
        System.out.println("press 1 to remove another child or press any key to return to main menu");
        String choice = scanner.nextLine();
        if(choice.equals("1")){
            leavePark();
        }
    }

    /**
     * ido add ask him
     * a helper function for leavepark to remove the kid from the system
     *
     * @param guardian
     */
    private void removeKid(Guardian guardian, Eticket eticket) {
        Kid kid = eticket.getKid();
        if (guardian.removeKid(kid)) {
            Main.systemObjects.remove(kid);
            System.out.println("the child: " + kid.getName() + " was removed from the system");
            int sumToPay = 0;
            for (Device device : eticket.getDevices()) {
                sumToPay = sumToPay + device.getPrice();
            }
            System.out.println("the amount that needed to be payed for "+kid.getName() + "is : " + sumToPay );
            guardian.getCreditCard().setAmountInBank(guardian.getCreditCard().getAmountInBank()-sumToPay);
            System.out.println("your account has been charge for the amount " +sumToPay + " and your current balance is:" +
                    guardian.getCreditCard().getAmountInBank());
        }
    }

    private Eticket eticketInSystem(String userName, String password) {
        for (Eticket eticket : etickets) {
            String kidId = eticket.getKid().getKidID();
            String kidPassword = eticket.getKid().getPassword();
            if (kidId.equals(userName) && kidPassword.equals(password)) {
                return eticket;
            }
        }
        return null;
    }
}