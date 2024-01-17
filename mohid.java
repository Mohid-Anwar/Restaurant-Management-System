
//import muji.java.*;
//import rana.java.*;
//import projectJava.java.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.SocketPermission;

public class mohid {
// Making Global scanner object
public static Scanner input = new Scanner(System.in);
public static String[][] soupRestaurant = new String[10][2];
public static String[][] pizzaRestaurant = new String[10][2];
public static String[][] desiRestaurant = new String[10][2];
public static String[][] randomRestaurant4 = new String[10][2];
public static String[][] randomRestaurant5 = new String[10][2];
public static String[][] randomRestaurant6 = new String[10][2];
public static String[][] randomRestaurant7 = new String[10][2];

public static void main(String[] args) throws IOException {
    try {
        create_file("soup_restauraunt_menu");
        create_file("pizza_restauraunt_menu");
        create_file("desi_restauraunt_menu");
        create_file("random_restauraunt_4_menu");
        create_file("random_restauraunt_5_menu");
        create_file("random_restauraunt_6_menu");
        create_file("random_restauraunt_7_menu");
        create_file("restauraunt_login_data");
        // Asks Whether you want to login or signup
        soupRestaurant = projectJava.reciept_file_reader("soup_restauraunt_menu", soupRestaurant);
        pizzaRestaurant = projectJava.reciept_file_reader("pizza_restauraunt_menu", pizzaRestaurant);
        desiRestaurant = projectJava.reciept_file_reader("desi_restauraunt_menu", desiRestaurant);
        randomRestaurant4 = projectJava.reciept_file_reader("random_restauraunt_4_menu", randomRestaurant4);
        randomRestaurant5 = projectJava.reciept_file_reader("random_restauraunt_5_menu", randomRestaurant5);
        randomRestaurant6 = projectJava.reciept_file_reader("random_restauraunt_6_menu", randomRestaurant6);
        randomRestaurant7 = projectJava.reciept_file_reader("random_restauraunt_7_menu", randomRestaurant7);

        login_or_signup();

    } catch (Exception e) {
        e.getStackTrace();
    }

}

public static void create_file(String file_name) throws Exception {

    File xyz = new File(file_name + ".txt");
    xyz.createNewFile();

    // xyz.close();

}

public static void login_or_signup() throws Exception {
    int x = 0;

    System.out.printf("%5s%s%5s \nPress\n1-To Signup \n2-To Login\n", "-----", "Welcome to food management System",
            "-----");
    do {

        try {
            x = input.nextInt();
            if (x == 1) {
                // ------------------Signup Fuction Called-------------------------
                signup();
                break;

            } else if (x == 2) {
                // -------------------Login Function called-------------------------
                login();
                break;
            } else {
                System.out.println("Invalid option entered.Re-try");
                x = input.nextInt();
            } // else block
        } // Try block
        catch (Exception e) {
            // System.out.println(e.getMessage());
            System.out.println("Invalid Input.Re-enter option:");
            // Discard current input
            input.nextLine();
        } // Catch Block to catch error(InputMismatch)
    } while (true);// Do while to repeat until desired input recieved
}// login_or_signup bracket

// ------------ Determines User Login Or Restauraunt Login --------------
public static void login() throws Exception {
    System.out.printf(
            "%5s%s%5s \nPress\n1-If you want to login as a customer \n2-If you want to login as a restauraunt owner\n3-If you want to login as a rider\n4-If you want to login as an admin\n",
            "-----", "Welcome to Login", "-----");

    // Catching error
    int owner_or_user;
    do {
        try {

            // -----------------------------------------------------------------------------------------------
            owner_or_user = input.nextInt();
            // --------------------------------------------------------
            // 1 or 2 or 3 or 4 input recieved
            input.nextLine();
            if (owner_or_user == 1)

                custumer_login();
            else if (owner_or_user == 2)
                restauraunt_login();
            else if (owner_or_user == 3)
                rider_login();
            // ------------------------------- MAKE A FUNCTION FOR RIDER
            else if (owner_or_user == 4)
                // -------------------------------- ADMIN FUNCTION LOGIN BNAO
                admin_login();
            else
                System.out.println("out of bounds");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("You have Entered a Charachter instead of a Number. Retry. Re enter 1 2 3 or 4.");
            input.nextLine();

        }

    } while (true);

}// login() Bracket

public static void admin_login() throws Exception {
    String admin_username = "Rizwan Rashid", admin_password = "riz@1234";

    System.out.println("Enter Admin Name");
    String user_login = input.nextLine();
    System.out.println("Enter Password");
    String user_password = input.nextLine();

    Boolean usr_found = false, pass_found = false;

    do {
        if (user_login.equalsIgnoreCase(admin_username) &&
                user_password.equals(admin_password)) {
            usr_found = true;
            pass_found = true;

        } else {
            System.out.println("Invalid Credentials. Re-enter\nUsername:");
            user_login = input.nextLine();
            System.out.println("Password:");
            user_password = input.nextLine();
        }

    } while (!usr_found && !pass_found);
    System.out.println("Welcome Admin Sir Rizwan Rashid");
    int restaraunt_option;
    // _______________________________ ADMIN
    // FUNCTIONALITIES_________________________________
    while (true) {
        System.out.println("\n\n[1] To look at menus of restaraunts.\n[2] Look at login data\n[3] Exit\n");
        try {

            do {
                restaraunt_option = input.nextInt();
                if (restaraunt_option < 1 || restaraunt_option > 3)
                    System.out.println("Custumer Option Out of bounds. Enter a proper Value. Re-try");
            } while (restaraunt_option < 1 || restaraunt_option > 3);

            if (restaraunt_option == 1) {

                System.out.println("Restaraunt 1 Menu\n");
                if (soupRestaurant[0][0] == null) {
                    System.out.println("The restaraunt has yet to be opened");
                } else {
                    projectJava.printMatrix(soupRestaurant, projectJava.matrixLength(soupRestaurant));
                    System.out.println("\n");
                }

                System.out.println("Restaraunt 2 Menu\n");

                if (pizzaRestaurant[0][0] == null) {
                    System.out.println("The restaraunt has yet to be opened\n");
                } else {
                    projectJava.printMatrix(pizzaRestaurant, projectJava.matrixLength(pizzaRestaurant));
                    System.out.println("\n");
                }

                System.out.println("Restaraunt 3 Menu\n");
                if (desiRestaurant[0][0] == null) {
                    System.out.println("The restaraunt has yet to be opened\n");
                } else {
                    projectJava.printMatrix(desiRestaurant, projectJava.matrixLength(desiRestaurant));
                    System.out.println("\n");
                }

                System.out.println("Restaraunt 4 Menu\n");
                if (randomRestaurant4[0][0] == null) {
                    System.out.println("The restaraunt has yet to be opened\n");
                } else {
                    projectJava.printMatrix(randomRestaurant4, projectJava.matrixLength(randomRestaurant4));
                    System.out.println("\n");
                }

                System.out.println("Restaraunt 5 Menu\n");

                if (randomRestaurant5[0][0] == null) {
                    System.out.println("The restaraunt has yet to be opened\n");
                } else {
                    projectJava.printMatrix(randomRestaurant5, projectJava.matrixLength(randomRestaurant5));
                    System.out.println("\n");
                }

                System.out.println("Restaraunt 6 Menu\n");

                if (randomRestaurant6[0][0] == null) {
                    System.out.println("The restaraunt has yet to be opened\n");
                } else {
                    projectJava.printMatrix(randomRestaurant6, projectJava.matrixLength(randomRestaurant6));
                    System.out.println("\n");
                }

                System.out.println("Restaraunt 7 Menu\n");

                if (randomRestaurant7[0][0] == null) {
                    System.out.println("The restaraunt has yet to be opened\n");
                } else {
                    projectJava.printMatrix(randomRestaurant7, projectJava.matrixLength(randomRestaurant7));
                    System.out.println("\n");
                }

            }

            else if (restaraunt_option == 2) {
                // Login data display

                // Display Data of Restaraunt Usernames

                File file = new File("restauraunt_login_data.txt");
                Scanner sc = new Scanner(file);
                int count = get_lines("restauraunt_login_data.txt");

                count /= 4;// No Of Usernames / Passwords
                if (count == 0) {
                    System.out.println("---No Restaraunts have registered with us---");
                } else {
                    System.out.println("\n---Data of Restaraunts registered with us---");
                    String[] passwords = new String[count];
                    String[] usernames = new String[count];
                    String[] ipAdress = new String[count];

                    for (int i = 0; i < count; i++) {
                        usernames[i] = sc.nextLine().strip();

                        passwords[i] = sc.nextLine().strip();

                        ipAdress[i] = sc.nextLine().strip();
                        sc.nextLine();
                    }

                    // Acquired login data data
                    for (int i = 0; i < passwords.length; i++) {
                        usernames[i] = usernames[i].strip();
                        passwords[i] = passwords[i].strip();
                        ipAdress[i] = ipAdress[i].strip();

                    }

                    for (int i = 0; i < passwords.length; i++) {
                        System.out.println("\n--Data of Restaraunt # " + (i + 1) + "--");
                        System.out.println();
                        System.out.println(usernames[i]);
                        System.out.println(passwords[i]);
                        System.out.println(ipAdress[i]);

                    }
                    // CHECK
                    // System.out.println(Arrays.toString(usernames));
                    // System.out.println(Arrays.toString(passwords));

                }
                System.out.println("\n\n");

                sc.close();

                File file_user = new File("user_data.txt");
                Scanner sc_user = new Scanner(file_user);
                int count_user = get_lines("user_data.txt");

                count_user /= 4;// No Of Usernames / Passwords
                if (count_user == 0) {
                    System.out.println("---No custumers have registered with us---");
                } else {
                    System.out.println("\n---Data of Custumers registered with us---");
                    String[] passwords_user = new String[count_user];
                    String[] usernames_user = new String[count_user];
                    String[] ipAdress_user = new String[count_user];

                    for (int i = 0; i < count_user; i++) {
                        usernames_user[i] = sc_user.nextLine().strip();

                        passwords_user[i] = sc_user.nextLine().strip();

                        ipAdress_user[i] = sc_user.nextLine().strip();
                        sc_user.nextLine();
                    }

                    // Acquired login data data
                    for (int i = 0; i < passwords_user.length; i++) {
                        usernames_user[i] = usernames_user[i].strip();
                        passwords_user[i] = passwords_user[i].strip();
                        ipAdress_user[i] = ipAdress_user[i].strip();

                    }

                    for (int i = 0; i < passwords_user.length; i++) {
                        System.out.println("\n--Data of Custumer # " + (i + 1) + "--");
                        System.out.println();
                        System.out.println(usernames_user[i]);
                        System.out.println(passwords_user[i]);
                        System.out.println(ipAdress_user[i]);

                    }
                    // CHECK
                    // System.out.println(Arrays.toString(usernames_user));
                    // System.out.println(Arrays.toString(passwords_user));

                }

                sc_user.close();

                System.out.println("\n\n");

                File file_rider = new File("rider_data.txt");
                Scanner sc_rider = new Scanner(file_rider);
                int count_rider = get_lines("rider_data.txt");

                count_rider /= 3;// No Of Usernames / Passwords
                if (count_rider == 0) {
                    System.out.println("---We have no riders registered with us---");
                } else {
                    System.out.println("\n---Data of riders registered with us---");
                    String[] passwords_rider = new String[count_rider];
                    String[] usernames_rider = new String[count_rider];

                    for (int i = 0; i < count_rider; i++) {
                        usernames_rider[i] = sc_rider.nextLine().strip();

                        passwords_rider[i] = sc_rider.nextLine().strip();

                        sc_rider.nextLine();
                    }

                    // Acquired login data data
                    for (int i = 0; i < passwords_rider.length; i++) {
                        usernames_rider[i] = usernames_rider[i].strip();
                        passwords_rider[i] = passwords_rider[i].strip();

                    }

                    for (int i = 0; i < passwords_rider.length; i++) {
                        System.out.println("\n--Data of Rider # " + (i + 1) + "--");
                        System.out.println();
                        System.out.println(usernames_rider[i]);
                        System.out.println(passwords_rider[i]);

                    }
                    // CHECK
                    // System.out.println(Arrays.toString(usernames_rider));
                    // System.out.println(Arrays.toString(passwords_rider));

                }

                sc_rider.close();

            } else if (restaraunt_option == 3) {
                System.out.println("Allah Hafz.");
                System.exit(0);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nEnter Valid value. Ty\n" + e.getMessage());

        }
    }
}// admin_login Bracket

public static void restauraunt_login() throws Exception {

    File file = new File("restauraunt_login_data.txt");
    Scanner sc = new Scanner(file);
    int count = get_lines("restauraunt_login_data.txt");

    count /= 4;// No Of Usernames / Passwords

    String[] passwords = new String[count];
    String[] usernames = new String[count];
    String[] ipAdress = new String[count];

    for (int i = 0; i < count; i++) {
        sc.next();
        usernames[i] = sc.nextLine().strip();
        sc.next();
        passwords[i] = sc.nextLine().strip();
        sc.next();
        ipAdress[i] = sc.nextLine().strip();
        sc.nextLine();
    }
    // CHECK 1
    // System.out.println(Arrays.toString(usernames));
    // System.out.println(Arrays.toString(passwords));

    for (int i = 0; i < passwords.length; i++) {
        usernames[i] = usernames[i].strip();
        passwords[i] = passwords[i].strip();
        ipAdress[i] = ipAdress[i].strip();

    }
    String ipAdress_value = null;
    // Now we get custumer login credentials...
    System.out.println("Enter Restauraunt Name");
    String user_login = input.nextLine();
    System.out.println("Enter Password");
    String user_password = input.nextLine();

    boolean usernamefound = false, passwordfound = false;
    while (usernamefound == false && passwordfound == false) {
        for (int i = 0; i < passwords.length; i++) {
            if (usernames[i].equalsIgnoreCase(user_login)) {
                usernamefound = true;
                if (passwords[i].equals(user_password)) {
                    usernamefound = true;
                    passwordfound = true;
                    ipAdress_value = ipAdress[i];
                } else {
                    while (!passwordfound) {
                        System.out.println("Invalid Password. Re-enter:");
                        user_password = input.nextLine();
                        passwordfound = passwords[i].equals(user_password);
                    }
                }
            }

        }
        if (usernamefound == false) {
            System.out.println("Username not found re-enter data\nUsername:");
            user_login = input.nextLine();
            System.out.println("Password:");
            user_password = input.nextLine();
        }

    }
    System.out.println("Welcome " + user_login.toUpperCase());
    int restaraunt_option;

    while (true) {
        System.out.println("\n\n[1] For New items to menu.\n[2] Update Items\n[3] Delete items\n[4] Exit\n");
        try {

            do {
                restaraunt_option = input.nextInt();
                if (restaraunt_option < 1 || restaraunt_option > 4)
                    System.out.println("Custumer Option Out of bounds. Enter a proper Value. Re-try");
            } while (restaraunt_option < 1 || restaraunt_option > 4);
            // 1 2 3 4
            if (restaraunt_option == 1) {
                if (ipAdress_value.equals("123.456.001")) {

                    soupRestaurant = projectJava.newItems(projectJava.soupRestaurant());
                    projectJava.menu_file(soupRestaurant, "soup_restauraunt_menu");
                    soupRestaurant = projectJava.reciept_file_reader("soup_restauraunt_menu", soupRestaurant);

                } else if (ipAdress_value.equals("123.456.002")) {

                    pizzaRestaurant = projectJava.newItems(projectJava.pizzaRestaurant());
                    projectJava.menu_file(soupRestaurant, "pizza_restauraunt_menu");
                    pizzaRestaurant = projectJava.reciept_file_reader("pizza_restauraunt_menu", pizzaRestaurant);

                } else if (ipAdress_value.equals("123.456.003")) {

                    desiRestaurant = projectJava.newItems(projectJava.desiRestaurant());
                    projectJava.menu_file(desiRestaurant, "desi_restauraunt_menu");
                    desiRestaurant = projectJava.reciept_file_reader("desi_restauraunt_menu", desiRestaurant);

                } else if (ipAdress_value.equals("123.456.004")) {

                    randomRestaurant4 = projectJava.newItems(projectJava.randomRestaurant4());
                    projectJava.menu_file(randomRestaurant4, "random_restauraunt_4_menu");
                    randomRestaurant4 = projectJava.reciept_file_reader("random_restauraunt_4_menu",
                            randomRestaurant4);

                } else if (ipAdress_value.equals("123.456.005")) {

                    randomRestaurant5 = projectJava.newItems(projectJava.randomRestaurant5());
                    projectJava.menu_file(randomRestaurant5, "random_restauraunt_5_menu");
                    randomRestaurant5 = projectJava.reciept_file_reader("random_restauraunt_5_menu",
                            randomRestaurant5);

                } else if (ipAdress_value.equals("123.456.006")) {

                    randomRestaurant6 = projectJava.newItems(projectJava.randomRestaurant6());
                    projectJava.menu_file(randomRestaurant6, "random_restauraunt_6_menu");
                    randomRestaurant6 = projectJava.reciept_file_reader("random_restauraunt_6_menu",
                            randomRestaurant6);

                } else if (ipAdress_value.equals("123.456.007")) {

                    randomRestaurant7 = projectJava.newItems(projectJava.randomRestaurant7());
                    projectJava.menu_file(randomRestaurant7, "random_restauraunt_7_menu");
                    randomRestaurant7 = projectJava.reciept_file_reader("random_restauraunt_7_menu",
                            randomRestaurant7);
                }

            } else if (restaraunt_option == 2) {
                if (ipAdress_value.equals("123.456.001")) {

                    soupRestaurant = projectJava.updateItems(projectJava.soupRestaurant());
                    projectJava.menu_file(soupRestaurant, "soup_restauraunt_menu");
                    soupRestaurant = projectJava.reciept_file_reader("soup_restauraunt_menu", soupRestaurant);

                } else if (ipAdress_value.equals("123.456.002")) {
                    pizzaRestaurant = projectJava.updateItems(projectJava.pizzaRestaurant());
                    projectJava.menu_file(pizzaRestaurant, "pizza_restauraunt_menu");
                    pizzaRestaurant = projectJava.reciept_file_reader("pizza_restauraunt_menu", pizzaRestaurant);

                } else if (ipAdress_value.equals("123.456.003")) {
                    desiRestaurant = projectJava.updateItems(projectJava.desiRestaurant());
                    projectJava.menu_file(desiRestaurant, "desi_restauraunt_menu");
                    desiRestaurant = projectJava.reciept_file_reader("desi_restauraunt_menu", desiRestaurant);

                } else if (ipAdress_value.equals("123.456.004")) {

                    randomRestaurant4 = projectJava.updateItems(projectJava.randomRestaurant4());
                    projectJava.menu_file(randomRestaurant4, "random_restauraunt_4_menu");
                    randomRestaurant4 = projectJava.reciept_file_reader("random_restauraunt_4_menu",
                            randomRestaurant4);

                } else if (ipAdress_value.equals("123.456.005")) {
                    randomRestaurant5 = projectJava.updateItems(projectJava.randomRestaurant5());
                    projectJava.menu_file(randomRestaurant5, "random_restauraunt_5_menu");
                    randomRestaurant5 = projectJava.reciept_file_reader("random_restauraunt_5_menu",
                            randomRestaurant5);

                } else if (ipAdress_value.equals("123.456.006")) {
                    randomRestaurant6 = projectJava.updateItems(projectJava.randomRestaurant6());
                    projectJava.menu_file(randomRestaurant6, "random_restauraunt_6_menu");
                    randomRestaurant6 = projectJava.reciept_file_reader("random_restauraunt_6_menu",
                            randomRestaurant6);

                } else if (ipAdress_value.equals("123.456.007")) {
                    randomRestaurant7 = projectJava.updateItems(projectJava.randomRestaurant7());
                    projectJava.menu_file(randomRestaurant7, "random_restauraunt_7_menu");
                    randomRestaurant7 = projectJava.reciept_file_reader("random_restauraunt_7_menu",
                            randomRestaurant7);

                }
            } else if (restaraunt_option == 3) {
                if (ipAdress_value.equals("123.456.001")) {
                    soupRestaurant = projectJava.removeArrayElements(projectJava.soupRestaurant());
                    projectJava.menu_file(soupRestaurant, "soup_restauraunt_menu");
                    soupRestaurant = projectJava.reciept_file_reader("soup_restauraunt_menu", soupRestaurant);

                } else if (ipAdress_value.equals("123.456.002")) {
                    pizzaRestaurant = projectJava.removeArrayElements(projectJava.pizzaRestaurant());
                    pizzaRestaurant = projectJava.updateItems(projectJava.pizzaRestaurant());
                    pizzaRestaurant = projectJava.reciept_file_reader("pizza_restauraunt_menu", pizzaRestaurant);

                } else if (ipAdress_value.equals("123.456.003")) {
                    desiRestaurant = projectJava.removeArrayElements(projectJava.desiRestaurant());
                    projectJava.menu_file(desiRestaurant, "desi_restauraunt_menu");
                    desiRestaurant = projectJava.reciept_file_reader("desi_restauraunt_menu", desiRestaurant);

                } else if (ipAdress_value.equals("123.456.004")) {
                    randomRestaurant4 = projectJava.removeArrayElements(projectJava.randomRestaurant4());
                    projectJava.menu_file(randomRestaurant4, "random_restauraunt_4_menu");
                    randomRestaurant4 = projectJava.reciept_file_reader("random_restauraunt_4_menu",
                            randomRestaurant4);

                } else if (ipAdress_value.equals("123.456.005")) {
                    randomRestaurant5 = projectJava.removeArrayElements(projectJava.randomRestaurant5());
                    projectJava.menu_file(randomRestaurant5, "random_restauraunt_5_menu");
                    randomRestaurant5 = projectJava.reciept_file_reader("random_restauraunt_5_menu",
                            randomRestaurant5);

                } else if (ipAdress_value.equals("123.456.006")) {
                    randomRestaurant6 = projectJava.removeArrayElements(projectJava.randomRestaurant6());
                    projectJava.menu_file(randomRestaurant6, "random_restauraunt_6_menu");
                    randomRestaurant6 = projectJava.reciept_file_reader("random_restauraunt_6_menu",
                            randomRestaurant6);

                } else if (ipAdress_value.equals("123.456.007")) {
                    randomRestaurant7 = projectJava.removeArrayElements(projectJava.randomRestaurant7());
                    projectJava.menu_file(randomRestaurant7, "random_restauraunt_7_menu");
                    randomRestaurant7 = projectJava.reciept_file_reader("random_restauraunt_7_menu",
                            randomRestaurant7);
                }
            } else {
                System.out.println("Goodbye!!");
                System.exit(0);
            }

        } catch (Exception e) {
            // System.out.println("Charachter not accepted. Enter 1 2 3");

            input.nextLine();

        }
    }

}

public static void custumer_login() throws Exception {
    String ipAdress_value = "";
    File file = new File("user_data.txt");
    Scanner sc = new Scanner(file);
    int count = get_lines("user_data.txt");

    count /= 4;// No Of Usernames / Passwords

    String[] passwords = new String[count];
    String[] usernames = new String[count];
    String[] ipAdress = new String[count];

    for (int i = 0; i < count; i++) {
        sc.next();
        usernames[i] = sc.nextLine().strip();
        sc.next();
        passwords[i] = sc.nextLine().strip();
        sc.next();
        ipAdress[i] = sc.nextLine().strip();
        sc.nextLine();

    }
    // CHECK 1
    // System.out.println(Arrays.toString(usernames));
    // System.out.println(Arrays.toString(passwords));

    for (int i = 0; i < passwords.length; i++) {
        usernames[i] = usernames[i].strip();
        passwords[i] = passwords[i].strip();
        ipAdress[i] = ipAdress[i].strip();
    }

    // Now we get custumer login credentials...
    System.out.println("Enter Name");
    String user_login = input.nextLine();
    System.out.println("Enter Password");
    String user_password = input.nextLine();

    boolean usernamefound = false, passwordfound = false;
    while (usernamefound == false && passwordfound == false) {
        for (int i = 0; i < passwords.length; i++) {
            if (usernames[i].equalsIgnoreCase(user_login)) {
                usernamefound = true;
                if (passwords[i].equals(user_password)) {
                    usernamefound = true;
                    passwordfound = true;
                    ipAdress_value = ipAdress[i];
                } else {
                    while (!passwordfound) {
                        System.out.println("Invalid Password. Re-enter:");
                        user_password = input.nextLine();
                        passwordfound = passwords[i].equals(user_password);
                    }
                }
            }

        }
        if (usernamefound == false) {
            System.out.println("Username not found re-enter data\nUsername:");
            user_login = input.nextLine();
            System.out.println("Password:");
            user_password = input.nextLine();
        }

    }

    System.out.println("Welcome " + user_login);
    int custumer_option;
    int restaurant_selection;

    while (true) {
        System.out.println("\n\n[1] For Order.\n[2] Give Your Valuable Feedback\n[3] Exit\n");

        try {

            do {
                custumer_option = input.nextInt();
                if (custumer_option < 1 || custumer_option > 3)
                    System.out.println("Custumer Option Out of bounds. Enter Proper Value. Re-try");
            } while (custumer_option < 1 || custumer_option > 3);
            // 1 2 3
            if (custumer_option == 1) {
                while (true) {
                    System.out.println(
                            "\nWe have 7 restaurants avaliable in G-10\nEnter 1 - 7 to view their menus\n");
                    restaurant_selection = input.nextInt();
                    if (restaurant_selection > 7) {
                        System.out.println("Enter a valid Value between 1 - 7");
                        continue;
                    }
                    if (restaurant_selection == 1) {
                        if (soupRestaurant[0][0] == null) {
                            System.out.println("This restaurant yet to be constructed! Good Bye!");
                            break;
                        }
                        String[][] data = soupRestaurant;
                        String[][] recepit = projectJava.orderGeneration();
                        projectJava.soupRestaurantMenu();
                        projectJava.printMatrix(data, projectJava.matrixLength(data));

                        int order_or_not;

                        System.out.println("\nWould you like to order\n[1] To Order\n[2] For No\n");
                        order_or_not = input.nextInt();

                        if (order_or_not == 1) {

                            String[][] for_order_storage = projectJava.generatingReceipt(recepit, data);
                            while (true) {
                                System.out.println(
                                        "\nWould you like to cancel your order\nPress [1] to YES\nPress [2] to NO");
                                int choice = input.nextInt();
                                if (choice == 1) {
                                    break;
                                } else if (choice == 2) {
                                    projectJava.Receipt_file(for_order_storage, "soup_restauraunt", "123.456.001",
                                            ipAdress_value,
                                            user_login.toLowerCase());
                                    break;
                                } else {
                                    System.out.println("Please Enter proper Value!");
                                }
                            }

                        } else if (order_or_not == 2)
                            break;
                        else {
                            System.out.println("\nPlease enter 1 or 2\n");
                            continue;
                        }

                        break;
                    } // if customer option == 2
                    if (restaurant_selection == 2) {
                        if (pizzaRestaurant[0][0] == null) {
                            System.out.println("This restaurant yet to be constructed! Good Bye!");
                            break;
                        }
                        String[][] data = pizzaRestaurant;
                        String[][] recepit = projectJava.orderGeneration();
                        projectJava.pizzaRestaurantMenu();
                        projectJava.printMatrix(data, projectJava.matrixLength(data));
                        int order_or_not;
                        System.out.println("\nWould you like to order\n[1] To Order\n[2] For No\n");
                        order_or_not = input.nextInt();
                        if (order_or_not == 1) {
                            String[][] for_order_storage = projectJava.generatingReceipt(recepit, data);
                            while (true) {
                                System.out.println(
                                        "\nWould you like to cancel your order\nPress [1] to YES\nPress [2] to NO");
                                int choice = input.nextInt();

                                if (choice == 1) {
                                    break;
                                } else if (choice == 2) {
                                    projectJava.Receipt_file(for_order_storage, "pizza_restauraunt", "123.456.002",
                                            ipAdress_value,
                                            user_login.toLowerCase());
                                    break;
                                } else {
                                    System.out.println("Please Enter proper Value!");
                                }
                            }
                        } else if (order_or_not == 2)
                            break;
                        else {
                            System.out.println("\nPlease enter 1 or 2\n");
                            continue;
                        }

                        break;
                    } // if customer option == 3

                    if (restaurant_selection == 3) {
                        if (desiRestaurant[0][0] == null) {
                            System.out.println("This restaurant yet to be constructed! Good Bye!");
                            break;
                        }
                        String[][] data = desiRestaurant;
                        String[][] recepit = projectJava.orderGeneration();
                        projectJava.desiRestaurantMenu();
                        projectJava.printMatrix(data, projectJava.matrixLength(data));
                        int order_or_not;
                        System.out.println("\nWould you like to order\n[1] To Order\n[2] For No\n");
                        order_or_not = input.nextInt();

                        if (order_or_not == 1) {
                            String[][] for_order_storage = projectJava.generatingReceipt(recepit, data);
                            while (true) {
                                System.out.println(
                                        "\nWould you like to cancel your order\nPress [1] to YES\nPress [2] to NO");
                                int choice = input.nextInt();

                                if (choice == 1) {
                                    break;
                                } else if (choice == 2) {

                                    projectJava.Receipt_file(for_order_storage, "desi_restauraunt", "123.456.003",
                                            ipAdress_value,
                                            user_login.toLowerCase());
                                    break;
                                } else {
                                    System.out.println("Please Enter proper Value!");
                                }
                            }

                        } else if (order_or_not == 2)
                            break;
                        else {
                            System.out.println("\nPlease enter 1 or 2\n");
                            continue;
                        }

                        break;
                    } // if restauraunt selection 4
                    if (restaurant_selection == 4) {
                        if (randomRestaurant4[0][0] == null) {
                            System.out.println("This restaurant yet to be constructed! Good Bye!");
                            break;
                        }
                        String[][] data = randomRestaurant4;
                        String[][] recepit = projectJava.orderGeneration();
                        projectJava.desiRestaurantMenu();
                        projectJava.printMatrix(data, projectJava.matrixLength(data));
                        int order_or_not;
                        System.out.println("\nWould you like to order\n[1] To Order\n[2] For No\n");
                        order_or_not = input.nextInt();

                        if (order_or_not == 1) {
                            String[][] for_order_storage = projectJava.generatingReceipt(recepit, data);
                            while (true) {
                                System.out.println(
                                        "\nWould you like to cancel your order\nPress [1] to YES\nPress [2] to NO");
                                int choice = input.nextInt();

                                if (choice == 1) {
                                    break;
                                } else if (choice == 2) {

                                    projectJava.Receipt_file(for_order_storage, "random_restauraunt_4",
                                            "123.456.004", ipAdress_value,
                                            user_login.toLowerCase());
                                    break;
                                } else {
                                    System.out.println("Please Enter proper Value!");
                                }
                            }

                        } else if (order_or_not == 2)
                            break;
                        else {
                            System.out.println("\nPlease enter 1 or 2\n");
                            continue;
                        }

                        break;
                    } // if restauraunt selection 5
                    if (restaurant_selection == 5) {
                        if (randomRestaurant5[0][0] == null) {
                            System.out.println("This restaurant yet to be constructed! Good Bye!");
                            break;
                        }
                        String[][] data = randomRestaurant5;
                        String[][] recepit = projectJava.orderGeneration();
                        projectJava.desiRestaurantMenu();
                        projectJava.printMatrix(data, projectJava.matrixLength(data));
                        int order_or_not;
                        System.out.println("\nWould you like to order\n[1] To Order\n[2] For No\n");
                        order_or_not = input.nextInt();

                        if (order_or_not == 1) {
                            String[][] for_order_storage = projectJava.generatingReceipt(recepit, data);
                            while (true) {
                                System.out.println(
                                        "\nWould you like to cancel your order\nPress [1] to YES\nPress [2] to NO");
                                int choice = input.nextInt();

                                if (choice == 1) {
                                    break;
                                } else if (choice == 2) {

                                    projectJava.Receipt_file(for_order_storage, "random_restauraunt_5",
                                            "123.456.005", ipAdress_value,
                                            user_login.toLowerCase());
                                    break;
                                } else {
                                    System.out.println("Please Enter proper Value!");
                                }
                            }

                        } else if (order_or_not == 2)
                            break;
                        else {
                            System.out.println("\nPlease enter 1 or 2\n");
                            continue;
                        }

                        break;
                    } // if restauraunt selection 6
                    if (restaurant_selection == 6) {
                        if (randomRestaurant6[0][0] == null) {
                            System.out.println("This restaurant yet to be constructed! Good Bye!");
                            break;
                        }
                        String[][] data = randomRestaurant6;
                        String[][] recepit = projectJava.orderGeneration();
                        projectJava.desiRestaurantMenu();
                        projectJava.printMatrix(data, projectJava.matrixLength(data));
                        int order_or_not;
                        System.out.println("\nWould you like to order\n[1] To Order\n[2] For No\n");
                        order_or_not = input.nextInt();

                        if (order_or_not == 1) {
                            String[][] for_order_storage = projectJava.generatingReceipt(recepit, data);
                            while (true) {
                                System.out.println(
                                        "\nWould you like to cancel your order\nPress [1] to YES\nPress [2] to NO");
                                int choice = input.nextInt();

                                if (choice == 1) {
                                    break;
                                } else if (choice == 2) {

                                    projectJava.Receipt_file(for_order_storage, "random_restauraunt_6",
                                            "123.456.006", ipAdress_value,
                                            user_login.toLowerCase());
                                    break;
                                } else {
                                    System.out.println("Please Enter proper Value!");
                                }
                            }

                        } else if (order_or_not == 2)
                            break;
                        else {
                            System.out.println("\nPlease enter 1 or 2\n");
                            continue;
                        }

                        break;
                    } // if restauraunt selection 7
                    if (restaurant_selection == 7) {
                        if (randomRestaurant7[0][0] == null) {
                            System.out.println("This restaurant yet to be constructed! Good Bye!");
                            break;
                        }
                        String[][] data = randomRestaurant7;
                        String[][] recepit = projectJava.orderGeneration();
                        projectJava.desiRestaurantMenu();
                        projectJava.printMatrix(data, projectJava.matrixLength(data));
                        int order_or_not;
                        System.out.println("\nWould you like to order\n[1] To Order\n[2] For No\n");
                        order_or_not = input.nextInt();

                        if (order_or_not == 1) {
                            String[][] for_order_storage = projectJava.generatingReceipt(recepit, data);
                            while (true) {
                                System.out.println(
                                        "\nWould you like to cancel your order\nPress [1] to YES\nPress [2] to NO");
                                int choice = input.nextInt();

                                if (choice == 1) {
                                    break;
                                } else if (choice == 2) {

                                    projectJava.Receipt_file(for_order_storage, "random_restauraunt_7",
                                            "123.456.007", ipAdress_value,
                                            user_login.toLowerCase());
                                    break;
                                } else {
                                    System.out.println("Please Enter proper Value!");
                                }
                            }

                        } else if (order_or_not == 2)
                            break;
                        else {
                            System.out.println("\nPlease enter 1 or 2\n");
                            continue;
                        }
                        break;
                    } // out of range
                    if (restaurant_selection < 1) {
                        System.out.println("Please respect the range given. Thanks");
                        continue;
                    }
                }
            } else if (custumer_option == 2) {
                try {
                    rana.myFed();
                } catch (Exception e) {
                    System.out.println("We were unable to store feeback. Erro");
                } // =======================================================================================================
                    // Feedback Taken
            } else {
                System.out.print("Good Bye!");
                System.exit(0);
            }

        } catch (Exception e) {
            System.out.println("Charachter not accepted. Enter appropriate value!");
            input.nextLine();
        }

    }

}

public static int get_lines(String filename) throws Exception {

    File file = new File(filename);
    Scanner sc = new Scanner(file);
    int count = 0;
    while (sc.hasNextLine()) {
        count++;
        sc.nextLine();
    }
    return count;
}

public static void signup() throws Exception {
    System.out.printf(
            "%5s%s%5s \nPress\n1-If you want to signup as a customer \n2-If you want to signup as a restauraunt owner\n3-If you want to signup as a rider\n",
            "-----", "Welcome to Signup", "-----");
    // Catching error
    int owner_or_user;
    do {// -----------------------------------------------------------------------------------------------
        while (!input.hasNextInt()) {
            System.out.println("Invalid charachter. Entered re-try."); // For not int charachter
            input.next(); // Skipping wrong input
        }
        owner_or_user = input.nextInt();
        if (owner_or_user > 3 || owner_or_user < 1)
            System.out.println("Wrong option. Re-enter");
    } while (owner_or_user > 3 || owner_or_user < 1);// --------------------------------------------------------
    // 1 or 2 or 3 input recieved
    input.nextLine();
    if (owner_or_user == 1)
        custumer_signup();
    else if (owner_or_user == 2)
        restauraunt_signup();
    else
        rider_signup();

}// Signup() Bracket

// LOCATION REMAINING

// Restauraunt Name, Password, food items with price, location
public static void restauraunt_signup() throws Exception {
    try {

        String name, password;// Required Variables
        String filename = "restauraunt_login_data.txt";
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        int count = get_lines(filename);

        count /= 4;// No Of Usernames / Passwords
        String[] passwords = new String[count];
        String[] usernames = new String[count];
        String[] ipAdress = new String[count];
        while (true) {
            if (count < 7) {

                System.out.println("What is your restauraunt name ");
                name = input.nextLine();
                while (true) {
                    if (((name.matches("^[a-zA-Z\s]{1,}$") == false) || name.equals(" ") || name.isEmpty())// word
                    // check

                    ) {

                        System.out.println("Re-try. Invalid restauraunt name");
                        name = input.nextLine();

                    } else
                        break;
                } // While bracket*/

                System.out.println("What is your password. Between (8-32 charachters)");
                password = input.nextLine();
                while (true) {
                    if (password.length() < 8 || password.length() > 32 || password.equals(" ")
                            || password.isEmpty()) {

                        System.out.println("Re-Enter. Password");
                        password = input.nextLine();

                    } else
                        break;
                }

                for (int i = 0; i < count; i++) {
                    sc.next();
                    usernames[i] = sc.nextLine().strip();
                    sc.next();
                    passwords[i] = sc.nextLine().strip();
                    sc.next();
                    ipAdress[i] = sc.nextLine().strip();
                    sc.nextLine();
                }

                for (int i = 0; i < passwords.length; i++) {
                    usernames[i] = usernames[i].strip();
                    passwords[i] = passwords[i].strip();
                    ipAdress[i] = ipAdress[i].strip();

                }

                for (int i = 0; i < passwords.length; i++) {
                    if (name.equals(usernames[i])) {
                        System.out.println("This restauraunt has already been built! Goodbye ");
                        System.exit(0);

                    }

                }

                String res_ip = rana.ipLocationRes(name);

                FileWriter myWriter = new FileWriter(filename, true);
                myWriter.write("name: " + name + "\nPassword: " + password + "\nIP: " + res_ip);
                myWriter.write("\n\n");

                myWriter.close();

                System.out.print(
                        "Account Created Successfully. Looking forward to Working With you in the Near future. \nAllah Hafiz!");
                System.exit(0);

            } else {
                System.out.println("All restauraunt spaces taken. Goodbye!!");
                System.exit(0);

            }
        }
    } catch (Exception e) {

        System.out.println(e.getCause());
        System.out.println(e.getMessage());

    }
}

// Takes data...Makes file and stores them in a text file

public static void custumer_signup() throws IOException {
    String name, password;// Required Variables
    String filename = "user_data.txt";
    File file = new File(filename);

    FileWriter myWriter = new FileWriter(filename, true);

    System.out.println("What is your full name (1st and last name only)");
    name = input.nextLine();
    while (true) {
        if ((name.matches("^[a-zA-Z]{1,}\s[a-zA-Z]{1,}$") == false)// word<> word check
        ) {

            System.out.println("Re-try. Wrong name");
            name = input.nextLine();

        } else
            break;
    } // While bracket*/

    System.out.println("What is your password. Between (8-32 charachters)");
    password = input.nextLine();
    while (true) {
        if (password.length() < 8 || password.length() > 32) {

            System.out.println("Re-try. Password requirements not met");
            password = input.nextLine();

        } else
            break;
    } // While bracket*/

    String custumer_house_ip = rana.ipLocationHouse();
    myWriter.write("Name: " + name + "\nPassword: " + password + "\nIP: " + custumer_house_ip + "\n\n");
    myWriter.close();

}// custumer_signup() bracket

public static void rider_signup() throws IOException {
    String name, password;// Required Variables

    System.out.println("What is your full name (1st and last name only)");
    name = input.nextLine();
    while (true) {
        if ((name.matches("^[a-zA-Z]{1,}\s[a-zA-Z]{1,}$") == false)// word<> word check
        ) {

            System.out.println("Re-try. Wrong name");
            name = input.nextLine();

        } else
            break;
    } // While bracket*/

    System.out.println("What is your password. Between (8-32 charachters)");
    password = input.nextLine();
    while (true) {
        if (password.length() < 8 || password.length() > 32) {

            System.out.println("Re-try. Password requirements not met");
            password = input.nextLine();

        } else
            break;
    } // While bracket*/

    String filename = "rider_data.txt";
    File file = new File(filename);

    FileWriter myWriter = new FileWriter(filename, true);

    myWriter.write("Name: " + name + "\nPassword: " + password + "\n\n");
    myWriter.close();

}

// rider_signup() bracket
public static void rider_login() throws Exception {

    File file = new File("rider_data.txt");
    Scanner sc = new Scanner(file);
    int count = get_lines("rider_data.txt");

    count /= 3;// No Of Usernames / Passwords

    String[] passwords = new String[count];
    String[] usernames = new String[count];

    for (int i = 0; i < count; i++) {
        sc.next();
        usernames[i] = sc.nextLine().strip();
        sc.next();
        passwords[i] = sc.nextLine().strip();
        sc.nextLine();
    }
    // CHECK 1
    // System.out.println(Arrays.toString(usernames));
    // System.out.println(Arrays.toString(passwords));

    for (int i = 0; i < passwords.length; i++) {
        usernames[i] = usernames[i].strip();
        passwords[i] = passwords[i].strip();

    }
    // Now we get custumer login credentials...
    System.out.println("Enter Your Name");
    String user_login = input.nextLine();
    System.out.println("Enter Password");
    String user_password = input.nextLine();

    boolean usernamefound = false, passwordfound = false;
    while (usernamefound == false && passwordfound == false) {
        for (int i = 0; i < passwords.length; i++) {
            if (usernames[i].equalsIgnoreCase(user_login)) {
                usernamefound = true;
                if (passwords[i].equals(user_password)) {
                    usernamefound = true;
                    passwordfound = true;

                } else {
                    while (!passwordfound) {
                        System.out.println("Invalid Password. Re-enter:");
                        user_password = input.nextLine();
                        passwordfound = passwords[i].equals(user_password);
                    }
                }
            }

        }
        if (usernamefound == false) {
            System.out.println("Username not found re-enter data\nUsername:");
            user_login = input.nextLine();
            System.out.println("Password:");
            user_password = input.nextLine();
        }

    }
    System.out.println("Welcome " + user_login.toUpperCase());

    // -----------------------------------------------------------------------

    int restaraunt_option;

    while (true) {
        System.out.println(
                "\nGet Order from Restaurant\nPress [1 - 7] to pick your order from\n");
        try {
            do {
                restaraunt_option = input.nextInt();
                if (restaraunt_option < 1 || restaraunt_option > 7)
                    System.out.println("Restaurant Option Out of bounds. Respect the given range. Re-try!");
            } while (restaraunt_option < 1 || restaraunt_option > 7);
            // [1 - 7 Optios]
            if (restaraunt_option == 1) {
                if (soupRestaurant[0][0] == null) {
                    System.out.println("This restaurant yet to be constructed! Try looking other restaurants!");
                    continue;
                } else {
                    projectJava.rider_reader("soup_restauraunt");
                    System.out.println("\n\nGo and deliver this order. Thank you for logging in. ");
                    System.exit(0);
                }
            } else if (restaraunt_option == 2) {
                if (pizzaRestaurant[0][0] == null) {
                    System.out.println("This restaurant yet to be constructed! Try looking other restaurants!");
                    continue;
                } else {
                    projectJava.rider_reader("pizza_restauraunt");
                    System.out.println("\n\nGo and deliver this order. Thank you for logging in. ");
                    System.exit(0);
                }
            } else if (restaraunt_option == 3) {
                if (desiRestaurant[0][0] == null) {
                    System.out.println("This restaurant yet to be constructed! Try looking other restaurants!");
                    continue;
                } else {
                    projectJava.rider_reader("desi_restauraunt");
                    System.out.println("\n\nGo and deliver this order. Thank you for logging in. ");
                    System.exit(0);
                }
            } else if (restaraunt_option == 4) {
                if (randomRestaurant4[0][0] == null) {
                    System.out.println("This restaurant yet to be constructed! Try looking other restaurants!");
                    continue;
                } else {
                    projectJava.rider_reader("random_restauraunt_4");
                    System.out.println("\n\nGo and deliver this order. Thank you for logging in. ");
                    System.exit(0);
                }
            } else if (restaraunt_option == 5) {
                if (randomRestaurant5[0][0] == null) {
                    System.out.println("This restaurant yet to be constructed! Try looking other restaurants!");
                    continue;
                } else {
                    projectJava.rider_reader("random_restauraunt_5");
                    System.out.println("\n\nGo and deliver this order. Thank you for logging in. ");
                    System.exit(0);
                }
            } else if (restaraunt_option == 6) {
                if (randomRestaurant6[0][0] == null) {
                    System.out.println("This restaurant yet to be constructed! Try looking other restaurants!");
                    continue;
                } else {
                    projectJava.rider_reader("random_restauraunt_6");
                    System.out.println("\n\nGo and deliver this order. Thank you for logging in. ");
                    System.exit(0);
                }
            } else if (restaraunt_option == 7) {
                if (randomRestaurant7[0][0] == null) {
                    System.out.println("This restaurant yet to be constructed! Try looking other restaurants!");
                    continue;
                } else {
                    projectJava.rider_reader("random_restauraunt_7");
                    System.out.println("\n\nGo and deliver this order. Thank you for logging in. ");
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            // System.out.println("Charachter not accepted. Enter 1 2 3");
            System.out.println("Wrong input. Retry.");
            input.nextLine();

        }
    }

}
}// class bracket