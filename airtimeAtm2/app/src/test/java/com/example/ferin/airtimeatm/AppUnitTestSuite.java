package com.example.ferin.airtimeatm;

import com.example.ferin.airtimeatm.appUser.AppUserTest;
import com.example.ferin.airtimeatm.network.CellphoneNetworkTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Ferin on 2016-04-16.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AppUserTest.class,
        CellphoneNetworkTest.class,
        //HandleRequestTest.class
})

public class AppUnitTestSuite {
}
