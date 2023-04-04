package HelperFiles;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainUI {
    public static void presentMainUI(Connection con) throws SQLException {
        Scanner scan = new Scanner(System.in);
        boolean stopLoop = false;
        do {
            int choice = 5;
            System.out.println(
                    "\n**********************************************************************************************************************");
            System.out.println("                                                    ENTER OPTION");
            System.out.println("Enter 0 for DELETING  a record");
            System.out.println("Enter 1 for INSERTING a new record");
            System.out.println("Enter 2 for SEARCHING a record");
            System.out.println("Enter 3 for UPDATING  an existing record");
            System.out.println("Enter 4 for DISPLAYING all records");
            System.out.println("Enter 5 for EXITING the program");

            choice = UtilityFunctions.getInt(0, 5);

            switch (choice) {
                case 0:
                    int deleteChoice = 0;
                    System.out.println("\n<<<<<<<<<< DELETE >>>>>>>>>>");
                    System.out.println("Delete by searching:");
                    System.out.println("0. roll_no");
                    System.out.println("1. name");

                    deleteChoice = UtilityFunctions.getInt(0, 1);

                    switch (deleteChoice) {
                        case 0:
                            // delete by roll_no
                            int roll_no = Student.scanRoll_no();
                            DatabaseManipulation.deleteRecord(con, roll_no);
                            break;
                        case 1:
                            // delete by name
                            String name = Student.scanName();
                            DatabaseManipulation.deleteRecord(con, name);
                            break;
                        default:
                            System.err.println(" ----> Error occurred");
                            break;
                    }
                    System.out.println("<<<<<<<<<<  >>>>>>>>>>\n");
                    break;
                case 1:
                    System.out.println("\n<<<<<<<<<< INSERT >>>>>>>>>>");
                    DatabaseManipulation.insertRecord(con);
                    System.out.println("<<<<<<<<<<  >>>>>>>>>>\n");
                    break;

                case 2:
                    int searchChoice = 0;
                    System.out.println("\n<<<<<<<<<< SEARCH >>>>>>>>>>");
                    System.out.println("Search by:");
                    System.out.println("0. roll_no");
                    System.out.println("1. name");
                    System.out.println("2. address");
                    System.out.println("3. phone_no");

                    searchChoice = UtilityFunctions.getInt(0, 3);

                    switch (searchChoice) {
                        case 0:
                            int roll_no = Student.scanRoll_no();
                            DatabaseManipulation.searchRoll_no(con, roll_no);
                            break;

                        case 1:
                            String name = Student.scanName();
                            DatabaseManipulation.searchName(con, name);
                            break;

                        case 2:
                            String address = Student.scanAddress();
                            DatabaseManipulation.searchAddress(con, address);
                            break;

                        case 3:
                            String phone_no = Student.scanPhone_no();
                            DatabaseManipulation.searchPhone_no(con, phone_no);
                            break;

                        default:
                            System.err.println("----> Error occurred");
                            break;
                    }

                    break;

                case 3:
                    int updateChoice = 0;
                    System.out.println("\n<<<<<<<<<< UPDATE >>>>>>>>>>");
                    System.out.println("Search by roll_no");
                    int roll_no = Student.scanRoll_no();
                    System.out.println("Which field to update:");
                    System.out.println("0. roll_no");
                    System.out.println("1. name");
                    System.out.println("2. address");
                    System.out.println("3. phone_no");

                    updateChoice = UtilityFunctions.getInt(0, 3);

                    switch (updateChoice) {
                        case 0:
                            int new_roll_no = Student.scanRoll_no();
                            DatabaseManipulation.updateRoll_no(con, roll_no, new_roll_no);
                            break;

                        case 1:
                            String name = Student.scanName();
                            DatabaseManipulation.updateName(con, roll_no, name);
                            break;

                        case 2:
                            String address = Student.scanAddress();
                            DatabaseManipulation.updateAddress(con, roll_no, address);
                            break;

                        case 3:
                            String phone_no = Student.scanPhone_no();
                            DatabaseManipulation.updatePhone_no(con, roll_no, phone_no);

                        default:
                            System.err.println("----> Error occurred");
                            break;
                    }

                    System.out.println("<<<<<<<<<<  >>>>>>>>>>\n");
                    break;

                case 4:
                    DatabaseManipulation.displayAllRecords(con);
                    break;

                case 5:
                    stopLoop = true;
                    break;

                default:
                    System.err.println("----> Error occurred");
                    break;
            }

        } while (!stopLoop);
        scan.close();

    }

}