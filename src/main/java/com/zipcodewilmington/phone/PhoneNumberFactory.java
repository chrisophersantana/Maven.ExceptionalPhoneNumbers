package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger LOGGER = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {

        PhoneNumber [] randomPhoneNumber = new PhoneNumber[phoneNumberCount];
        for (int i = 0 ; i < phoneNumberCount; i ++){
            PhoneNumber phoneNumber = createRandomPhoneNumber();
            randomPhoneNumber[i] = phoneNumber;
        }



        return randomPhoneNumber;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        PhoneNumber phoneNumber;
        Integer areaCode = RandomNumberFactory.createInteger(100, 999);
        Integer centralOfficeAreaCode = RandomNumberFactory.createInteger(100, 999);
        Integer phoneLineCode = RandomNumberFactory.createInteger(1000, 9999);
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(areaCode).append(")-").append(centralOfficeAreaCode).append("-").append(phoneLineCode);

        try
        {

            phoneNumber = createPhoneNumber(sb.toString());


        } catch (InvalidPhoneNumberFormatException ex) {

            return null;
        }
        return phoneNumber;
    }

    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
            PhoneNumber phoneNumber;
            StringBuilder sb = new StringBuilder();
        sb.append("(").append(areaCode).append(")-").append(centralOfficeCode).append("-").append(phoneLineCode);
        String phoneNumberString = sb.toString();
            try {
                phoneNumber  = createPhoneNumber(sb.toString());
        } catch (InvalidPhoneNumberFormatException ex) {

            LOGGER.info(phoneNumberString + " Phone number not valid");
           return null;

        }


        return phoneNumber;

    }
    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberString);

        LOGGER.info("Attemting to create a new PhoneNumber of" + phoneNumberString);

       return phoneNumber;



    }


    }

