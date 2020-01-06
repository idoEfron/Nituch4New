import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //todo notice to add here all of the objects we are creating in the program

        System.out.println("Hello, Welcome to our application" + "\n" + "press 1 to create a new user" + "\n" +
                "press 2 to follow a registered kid" + "\n" + "enter 'Exit' in order to log out");
        SystemManagment systemManagment = new SystemManagment();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        boolean flag = false;
        while (!flag) {
            switch (line) {
                case "1":
                    registerKids(systemManagment);

                    System.out.println("You are now registered." + "\n" + "please follow the instructions in order to register a new kid" + "\n");
                    break;
                case "2":
                    System.out.println("Press 3 in order to check the kid's eTicket"+"\n"+"Press 4 in order to add a new entry"
                    +"\n"+"Press 5 in order to remove an entry"+"\n"+"Press 6 in order to return to the main menu");
                    subMenu(systemManagment);
                    break;
                case "Exit":
                    flag = true;
                    break;
            }
            System.out.println("press 1 to create a new user" + "\n" +
                    "press 2 to register a new kid" + "\n" + "press 3 to follow a registered kid" + "\n" + "enter 'Exit' in order to log out");
            line = sc.nextLine();
        }

    }

    private static void subMenu(SystemManagment systemManagment){

        boolean flag=false;
        while(!flag){
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            String answer;
            switch (line){
                case "3":
                    System.out.println("Please insert the eTicket ID of your kid into the system");
                    answer = sc.nextLine();
                    systemManagment.followEticket(answer);
                    break;
                case "4":
                    System.out.println("Please insert the eTicket ID of your kid into the system");
                    answer = sc.nextLine();
                    systemManagment.addEntries(answer);
                    break;
                case "5":
                    System.out.println("Please insert the eTicket ID of your kid into the system");
                    answer = sc.nextLine();
                    System.out.println("Please insert the device name you want to remove");
                    String secAnswer = sc.nextLine();
                    systemManagment.removeEntry(answer,secAnswer);
                    break;
                case "6":
                    flag=true;
                    break;
            }
        }
    }


    private static void registerKids(SystemManagment systemManagment) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert your ID");
        String guardianID = sc.nextLine();
        String childName = "";
        String childAge = "";
        Guardian guardian = new Guardian(guardianID, systemManagment);
        //systemManagment.addGuardian(guardian);
        boolean addKids = false;
        String kidChoice = "1";
        while (!addKids) {
            switch (kidChoice) {
                case "1":
                    System.out.println("Please insert child form including name and age:");
                    System.out.println("Please insert child name");
                    childName = sc.nextLine();
                    System.out.println("Please insert child age");
                    childAge = sc.nextLine();
                    systemManagment.fillInfo(childName, childAge);
                    break;

                case "2":
                    addKids = true;
                    break;
            }
            if (kidChoice.equals("2")) {
                break;
            }
            System.out.println("press 1 to enter child details" + "\n" + "press 2 to finish adding childs");
            if (sc.hasNextLine()) {
                kidChoice = sc.nextLine();
            }
        }
        System.out.println("Please enter credit card number and max billing amount to charge the account:");
        System.out.println("Please enter credit card number:");
        String creditCard = sc.nextLine();
        System.out.println("Please enter max billing amount:");
        String maxBilling = sc.nextLine();
        CreditCard credit = new CreditCard(0,true,10000,guardian);
        guardian.setCreditCard(credit);
        systemManagment.insertPayment(creditCard,maxBilling,guardian);
        credit.setCreditNumber(Integer.parseInt(creditCard));
        Account account = new Account(Integer.parseInt(maxBilling),0,guardian);
        guardian.setAccount(account);
        systemManagment.addGuardian(guardian);
        Kid kid = new Kid(childName,Integer.parseInt(childAge),0,String.valueOf(systemManagment.numberOfEtickets()+1),childName,guardian);
        Eticket eticket = new Eticket(kid,systemManagment);
        kid.setEticket(eticket);
        guardian.addKid(kid);

    }



}


