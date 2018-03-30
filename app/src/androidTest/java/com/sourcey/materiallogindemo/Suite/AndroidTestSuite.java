package com.sourcey.materiallogindemo.Suite;

import com.sourcey.materiallogindemo.LoginActivityTest;
import com.sourcey.materiallogindemo.MainActivityTest;
import com.sourcey.materiallogindemo.SignupActivityTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by geetikag on 29/3/2018 AD.
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({
        SignupActivityTest.class,
        MainActivityTest.class,
        LoginActivityTest.class})
public class AndroidTestSuite {
}
