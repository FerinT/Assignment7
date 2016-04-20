package com.example.ferin.airtimeatm;

import android.content.Context;
import android.telephony.TelephonyManager;

public class ReadPhoneData {

    private static String phoneNumber;

    private static String hasNumber(){

        Context mAppContext = null;

        TelephonyManager telManager = (TelephonyManager)mAppContext.getSystemService(Context.TELEPHONY_SERVICE);
        phoneNumber = telManager.getLine1Number(); // primary sim number if dual sim phone

        return phoneNumber;
    }

    public static boolean validateNumber(String userPhoneNumber) // validates the user defined number is the same as retried one
    {
        hasNumber();
        return phoneNumber.equals(userPhoneNumber);
    }

}
