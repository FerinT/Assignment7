package com.example.ferin.airtimeatm.factories.transaction;

/**
 * Created by Ferin on 2016-04-17.
 */
public abstract class TransactionDataFactory {

    public static String setTransactionData(String request, String value) // value being the number or pin user typed in
    {
        String updatedRequest = request;

        if(request.contains("M"))
            updatedRequest = request.replaceAll("M", value);
        if(request.contains("Y"))
            updatedRequest = request.replaceAll("Y", value);
        if(request.contains("P"))
            updatedRequest = request.replaceAll("P", value);
        if(request.contains("AMT"))
            updatedRequest = request.replaceAll("AMT", value);

        return updatedRequest;
    }
}
