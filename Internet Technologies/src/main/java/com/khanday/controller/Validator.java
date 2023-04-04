package com.khanday.controller;

import com.khanday.model.DBValues;

public class Validator {

    public static final boolean validateUpdateForm(String existingRollNo, String rollNo, String name, String address,
            String phoneNo) {
        if (validRollNo(existingRollNo) && validateSearchForm(rollNo, name, address, phoneNo))
            return true;
        return false;
    }

    public static final boolean validateDeleteForm(String rollNo, String name, String address, String phoneNo) {
        return validateSearchForm(rollNo, name, address, phoneNo);
    }

    public static final boolean validateSearchForm(String rollNo, String name, String address, String phoneNo) {
        if (rollNo == "" && name == "" && address == "" && phoneNo == "") {
            return false;
        }
        boolean isRollNoValid = true;
        boolean isNameValid = true;
        boolean isAddressValid = true;
        boolean isPhoneNoValid = true;

        isRollNoValid = rollNo != "" ? validRollNo(rollNo) : true;
        isNameValid = name != "" ? validName(name) : true;
        isAddressValid = address != "" ? validAddress(address) : true;
        isPhoneNoValid = phoneNo != "" ? validPhoneNo(phoneNo) : true;

        if (isRollNoValid && isNameValid && isAddressValid && isPhoneNoValid)
            return true;
        return false;
    }

    public static final boolean validateAddForm(String rollNo, String name, String address, String phoneNo) {
        if (validRollNo(rollNo) && validName(name) && validAddress(address) && validPhoneNo(phoneNo))
            return true;
        return false;
    }

    public static boolean validRollNo(String rollNo) {
        if (!validStringOfNumbersOnly(rollNo) || rollNo.length() < 1 || rollNo.length() > DBValues.maxRollNoLength)
            return false;
        return true;
    }

    public static boolean validName(String name) {
        if (name.length() < 1 || name.length() > DBValues.maxNameLength)
            return false;
        return true;
    }

    public static boolean validAddress(String address) {
        if (address.length() < 1 || address.length() > DBValues.maxAddressLength)
            return false;
        return true;
    }

    public static boolean validPhoneNo(String phoneNo) {
        if (validStringOfNumbersOnly(phoneNo) && phoneNo.length() == DBValues.maxPhoneNoLength)
            return true;
        return false;

    }

    public static boolean validStringOfNumbersOnly(String numbersOnly) {
        char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        for (int i = 0; i < numbersOnly.length(); i++) {
            char ch = numbersOnly.charAt(i);
            boolean isCharValid = false;
            for (int j = 0; j < num.length; j++) {
                if (ch == num[j]) {
                    isCharValid = true;
                    break;
                }
            }
            if (!isCharValid)
                return false;
        }
        return true;
    }
}
