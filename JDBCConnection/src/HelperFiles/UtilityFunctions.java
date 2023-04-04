package HelperFiles;

import java.util.Scanner;

public class UtilityFunctions {
    public static int getInt(int min, int max) {
        Scanner scan = new Scanner(System.in);
        int integer = min - 1;
        while (integer < min || integer > max) {
            System.out.print("-> Enter [" + min + "-" + max + "]: ");
            try {
                integer = scan.nextInt();
            } catch (Exception e) {
                System.err.println(" ----> Error occurred");
                scan.next();
            }
        }
        return integer;
    }
}
