package com.sourcey.materiallogindemo;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ScrollToAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.sourcey.materiallogindemo.utils.ToastMatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.unregisterIdlingResources;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by geetikag on 28/3/2018 AD.
 */

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mLoginActivity = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void Before_test_method() {
        Log.e("@Before", "Hi this is run before every test function");
    }

    @Test
    public void A_EmailValidation() throws InterruptedException {
        Log.e("@Test", "Performing Email validation Test");
        onView((withId(R.id.input_email))).perform(typeText(TestData.testUser1.getIncorrectEmail()), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).check(matches(isClickable())).perform(scrollTo(), ViewActions.click());
        onView(withId(R.id.input_email)).check(matches(hasErrorText("enter a valid email address")));

    }

    @Test
    public void B_EmailAndPasswordValidation() {
        Log.e("@Test", "Performing Email & Password validation Test");
        onView((withId(R.id.input_email))).perform(typeText(TestData.testUser1.getEmail()), closeSoftKeyboard());
        onView((withId(R.id.input_password))).perform(typeText(TestData.testUser1.getIncorrectPass()), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).check(matches(isClickable())).perform(scrollTo(), ViewActions.click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText("enter a valid email address or password")));
    }

    @Test
    public void C_PasswordValidation() {
        Log.e("@Test", "Performing Password validation Test");
        onView((withId(R.id.input_email))).perform(typeText(TestData.testUser1.getEmail()), closeSoftKeyboard());
        onView((withId(R.id.input_password))).perform(typeText(TestData.testUser1.getInvalidPass()), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).check(matches(isClickable())).perform(scrollTo(), ViewActions.click());
        onView(withText("Login failed")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void D_LoginFailure() {
        Log.e("@Test", "Performing Login Failure Test");
        onView(withId(R.id.input_email)).perform(typeText(TestData.testUser1.getEmail()), closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(typeText(TestData.testUser1.getIncorrectPass()), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).check(matches(isClickable())).perform(scrollTo(), ViewActions.click());
        onView(withText("Login failed")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));

    }

    @Test
    public void E_LoginSuccess() {
        Log.e("@Test", "Performing Login Success Test");
        onView((withId(R.id.input_email))).perform(ViewActions.typeText(TestData.testUser1.getEmail()), closeSoftKeyboard());
        onView((withId(R.id.input_password))).perform(ViewActions.typeText(TestData.testUser1.getPassword()), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).check(matches(isClickable())).perform(scrollTo(), ViewActions.click());
        //onView(withText("Hello world!")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
        // Espresso.onView(withText("Hello World!")).check(matches(isDisplayed()));
    }

    @Test
    public void F_SignupPageNavigation() {
        Log.e("@Test", "Performing Navigation to Signup Page Test");
        onView(withId(R.id.link_signup)).check(matches(isDisplayed())).check(matches(isClickable())).perform(scrollTo(), ViewActions.click());
        onView(withId(R.id.input_name)).check(matches(isDisplayed()));
    }
}
