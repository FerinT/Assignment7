package com.example.ferin.airtimeatm;


import android.content.Intent;
import android.net.Uri;

import com.example.ferin.airtimeatm.domain.appUser.AppUser;
import com.example.ferin.airtimeatm.domain.networkCode.NetworkCodes;
import com.example.ferin.airtimeatm.factories.networkCode.NetworkCodeFactory;
import com.example.ferin.airtimeatm.factories.transaction.TransactionDataFactory;


public class HandleRequest {

    private static NetworkCodes networkCodes;
    private static String transaction;

    public static NetworkCodes getNetwork(AppUser appUser)
    {
        networkCodes = NetworkCodeFactory.returnNetworkCode(appUser.getCellphoneNetwork().getNetworkName());
        return networkCodes;
    }

    public static String prepareString(int request, String value)
    {
        switch(request)
        {
            case 0 :  transaction = networkCodes.getBalanceEnquiry();
                break;
            case 1 : transaction = networkCodes.getMenu();
                break;
            case 2 : transaction = networkCodes.getPcm();
                break;
            case 3 : transaction = networkCodes.getRecharge();
                break;
            case 4 : transaction = networkCodes.getTransfer();
        }
         transaction = TransactionDataFactory.setTransactionData(transaction, value);
        return transaction;
    }

}
