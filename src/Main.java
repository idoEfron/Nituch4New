
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
        //todo notice to add here all of the objects we are creating in the program

        System.out.println("Hello, Welcome to our application" + "\n" + "press 1 to create a new user" + "\n" +
                "press 2 to register a new kid" + "\n" + "press 3 to follow a registered kid" + "\n" + "enter 'Exit' in order to log out");
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
                    System.out.println("LOG IN");
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

    private static void registerKids(SystemManagment systemManagment) {
        List<Kid> kids = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert your ID");
        String guardianID = sc.nextLine();
        String chilName = "";
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
                    chilName = sc.nextLine();
                    System.out.println("Please insert child age");
                    childAge = sc.nextLine();
                    systemManagment.fillInfo(chilName, childAge);
                    kids.add(new Kid("0",Integer.parseInt(childAge),0,"0",childAge,guardian));
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
        systemManagment.insertPayment(creditCard,maxBilling,guardian);//todo change uml
        credit.setCreditNumber(Integer.parseInt(creditCard));
        System.out.println("fuccccccccccccccccccccckkkkkkkkkkkkkkkkkkkkkkkkkkk");
        Account account = new Account(Integer.parseInt(maxBilling),0,guardian);
        System.out.println("TOMER");
        guardian.setAccount(account);
        systemManagment.addGuardian(guardian);
        for (Kid kid:kids) {
            Kid newKid = new Kid(kid.getName(),kid.getAge(),0,String.valueOf(systemManagment.numberOfEtickets()+1),kid.getName(),guardian);
            Eticket eticket = new Eticket(kid,systemManagment);
            systemManagment.addEticket(eticket);
            int sum = systemManagment.numberOfEtickets();
            kid.setPassword(String.valueOf(sum));
            kid.setEticket(eticket);
            guardian.addKid(kid);
            System.out.println("the user name for "+kid.getName() + " is: " + kid.getName() + ", and the password is: "+ kid.getPassword());
            System.out.println("Please enter child weight and height");
            System.out.println("Please enter child weight");
            String childWeight = sc.nextLine();
            System.out.println("Please enter child height");
            String childHeight = sc.nextLine();
            systemManagment.insertChildInfo(childWeight,childHeight);
            System.out.println("all the children were added successful");
        }
    }
    public void tomer(){
        System.out.println("kds");
    }
}


