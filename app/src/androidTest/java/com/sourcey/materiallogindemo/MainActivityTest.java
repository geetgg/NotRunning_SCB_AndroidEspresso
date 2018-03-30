package com.sourcey.materiallogindemo;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by geetikag on 29/3/2018 AD.
 */

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainActivityTest {

    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<MainActivity> mMainActivity = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void Before_test_method(){
        Log.e("@Before","Hi this is run before every test function");
    }

    @Test
    public void A_MainLoginAndLogout() {
        Log.e("@Test", "Performing Login Success Test");
        onView((withId(R.id.input_email))).perform(typeText(TestData.testUser1.getEmail()),closeSoftKeyboard());
        onView((withId(R.id.input_password))).perform(typeText(TestData.testUser1.getPassword()),closeSoftKeyboard());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).check(matches(isClickable())).perform(scrollTo(),ViewActions.click());
        //Espresso.onView(withText("Hello world!")).check(matches(isDisplayed()));
        //Espresso.onView(withId(R.id.btn_logout)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_logout)).check(matches(isDisplayed())).check(matches(isClickable())).perform(scrollTo(),ViewActions.click());
    }

    }
