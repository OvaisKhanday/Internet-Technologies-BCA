package com.khanday.model;

// This class contains the collection of some constants, which this web app intends to use frequently. The constants make is a lot easier to make some changes in the future or adapt the codebase on another system with different preferences. It provides code the power of reusability.
public class DBValues {

    public static final String author = "Ovais Ahmad Khanday";
    public static final String username = "root";
    public static final String password = "Khanday@927";
    public static final String url = "jdbc:mysql://127.0.0.1:3306/";
    public static final String database = "college";
    public static final String table = "students";
    public static final String colRollNo = "roll_no";
    public static final String colName = "name";
    public static final String colAddress = "address";
    public static final String colPhoneNo = "phone_no";
    public static final int maxRollNoLength = 18; // long is used in java to avoid conflict.
    public static final int maxNameLength = 25;
    public static final int maxAddressLength = 45;
    public static final int maxPhoneNoLength = 10;

}
