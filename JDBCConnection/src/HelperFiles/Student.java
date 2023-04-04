package HelperFiles;

import java.util.Scanner;

public class Student {
    private int roll_no;
    private String name;
    private String address;
    private String phone_no;

    // GETTERS AND SETTERS

    public int getRoll_no() {
        return this.roll_no;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhone_no() {
        return this.phone_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void printStudentDetails() {
        System.out.println("STUDENT DETAILS");
        System.out.println("roll_no:\t" + this.roll_no);
        System.out.println("name:\t\t" + this.name);
        System.out.println("address:\t" + this.address);
        System.out.println("phone_no:\t" + this.phone_no);
    }

    public void setStudentDetails(int roll_no, String name, String address, String phone_no) {
        this.roll_no = roll_no;
        this.name = name;
        this.address = address;
        this.phone_no = phone_no;
    }

    public static int scanRoll_no() {
        Scanner scan = new Scanner(System.in);
        boolean invalid;
        int roll_no = 0;
        System.out.print("Enter roll_no:\t");
        do {
            invalid = true;
            try {
                roll_no = scan.nextInt();
            } catch (Exception e) {
                System.err.println(" ----> Error occurred");
                scan.next();
                roll_no = 429496726;
            }
            if (roll_no > 429496725) {
                System.out.print("Enter valid roll_no:\t");
            } else
                invalid = false;
        } while (invalid);

        return roll_no;
    }

    public static String scanName() {
        Scanner scan = new Scanner(System.in);
        boolean invalid;
        String name;
        System.out.print("Enter name:\t");
        do {
            invalid = true;
            name = scan.nextLine();
            if (name.length() > 45) {
                System.out.print("Enter valid name (<45 character):\t");
            } else
                invalid = false;
        } while (invalid);
        return name;
    }

    public static String scanAddress() {
        Scanner scan = new Scanner(System.in);
        boolean invalid;
        String address;
        System.out.print("Enter address:\t");
        do {
            invalid = true;
            address = scan.nextLine();
            if (address.length() > 45) {
                System.out.print("Enter valid address (<45 character):\t");
            } else
                invalid = false;
        } while (invalid);
        return address;
    }

    public static String scanPhone_no() {
        Scanner scan = new Scanner(System.in);
        boolean invalid;
        String phone_no;
        System.out.print("Enter phone_no:\t");
        do {
            invalid = true;
            phone_no = scan.nextLine();
            if (phone_no.length() > 15) {
                System.out.print("Enter valid phone_no (<15 character):\t");
            } else
                invalid = false;
        } while (invalid);
        return phone_no;
    }

    public void askStudentDetails() {

        System.out.println("ENTER THE DETAILS OF A STUDENT");
        this.roll_no = scanRoll_no();

        this.name = scanName();

        this.address = scanAddress();

        this.phone_no = scanPhone_no();

    }
}
