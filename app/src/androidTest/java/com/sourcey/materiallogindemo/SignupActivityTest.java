package com.sourcey.materiallogindemo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.sourcey.materiallogindemo.utils.ToastMatcher;

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
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.endsWith;

/**
 * Created by geetikag on 29/3/2018 AD.
 */

    @RunWith(AndroidJUnit4.class)
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public class SignupActivityTest {

    private String getResourceString(int id) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        return targetContext.getResources().getString(id);
    }

    @Rule
    public ActivityTestRule<SignupActivity> mSignUpActivity = new ActivityTestRule<>(SignupActivity.class);

    @Before
    public void Before_test_method() {
        Log.e("@Before", "Hi this is run before every test function");
    }

    @Test
    public void A_EmptyNameValidation(){
        Log.e("@Test", "Performing Empty Name validation Test");
        onView((withId(R.id.input_name))).perform(typeText(" "),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo(),ViewActions.click());
        onView(withId(R.id.input_name)).check(matches(hasErrorText("at least 3 characters")));
    }

    @Test
    public void B_InvalidNameValidation() {
        Log.e("@Test", "Performing Small Name validation Test");
        onView((withId(R.id.input_name))).perform(typeText(TestData.testUser1.getInvalid_name()),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo(),ViewActions.click());
        onView(withId(R.id.input_name)).check(matches(hasErrorText("at least 3 characters")));
    }

    @Test
    public void C_AddressValidation() {
        Log.e("@Test", "Performing Address validation Test");
        onView((withId(R.id.input_address))).perform(typeText(" "),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo(),ViewActions.click());
        onView(withText("Login failed")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void D_EmptyEmailValidation() {
        Log.e("@Test", "Performing Email validation Test");
        onView((withId(R.id.input_email))).perform(typeText(" "),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo(),ViewActions.click());
        onView(withId(R.id.input_email)).check(matches(hasErrorText("enter a valid email address")));
    }

    @Test
    public void E_InvalidEmailValidation() {
        Log.e("@Test", "Performing Invalid Email validation Test");
        onView((withId(R.id.input_email))).perform(typeText(TestData.testUser1.getIncorrectEmail()),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo(),ViewActions.click());
        onView(withId(R.id.input_email)).check(matches(hasErrorText("enter a valid email address")));
    }

    @Test
    public void F_MobileNoValidation1() {
        Log.e("@Test", "Performing Mobile Number validation Test");
        onView((withId(R.id.input_mobile))).perform(typeText(TestData.testUser1.getInvalidMobile()),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo(),ViewActions.click());
        onView(withId(R.id.input_mobile)).check(matches(hasErrorText("Enter Valid Mobile Number")));
    }

    @Test
    public void G_MobileNoValidation2() {
        Log.e("@Test", "Performing Emplty Mobile Number validation Test");
        onView((withId(R.id.input_mobile))).perform(typeText(" "),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo(),ViewActions.click());
        onView(withId(R.id.input_mobile)).check(matches(hasErrorText("Enter Valid Mobile Number")));
    }

    @Test
    public void H_PasswordValidation(){
        Log.e("@Test", "Performing Password validation Test");
        onView((withId(R.id.input_password))).perform(typeText(TestData.testUser1.getIncorrectPass()),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo(),ViewActions.click());
        onView(withText("Login failed")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void I_RePasswordValidation(){
        Log.e("@Test", "Performing Password validation Test");
        onView((withId(R.id.input_password))).perform(typeText(TestData.testUser1.getPassword()),closeSoftKeyboard());
        onView((withId(R.id.input_reEnterPassword))).perform(typeText(TestData.testUser1.getIncorrectPass()),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo(),ViewActions.click());
        onView(withId(R.id.input_reEnterPassword)).check(matches(hasErrorText("Password Do not match")));
    }

    @Test
    public void J_SuccessSignup(){
        Log.e("@Test", "Performing Successful Signup Test");
        onView((withId(R.id.input_name))).perform(typeText(TestData.testUser1.getValid_name()),closeSoftKeyboard());
        onView((withId(R.id.input_address))).perform(typeText(TestData.testUser1.getValid_address()),closeSoftKeyboard());
        onView((withId(R.id.input_email))).perform(typeText(TestData.testUser1.getEmail()),closeSoftKeyboard());
        onView((withId(R.id.input_mobile))).perform(typeText(TestData.testUser1.getValidMobile()),closeSoftKeyboard());
        onView((withId(R.id.input_password))).perform(typeText(TestData.testUser1.getPassword()),closeSoftKeyboard());
        onView((withId(R.id.input_reEnterPassword))).perform(typeText(TestData.testUser1.getPassword()),closeSoftKeyboard());
        Intents.init();
        onView(withId(R.id.btn_signup)).perform(scrollTo(),ViewActions.click());
        onView(withText(endsWith("Creating Account..."))).check(matches(isDisplayed()));
        //Intents.init();
    }

    @Test
    public void K_LoginPageNavigationTest(){
        Log.e("@Test", "Performing Navigation to Login Page Test");
        onView(withId(R.id.link_login)).perform(scrollTo(),ViewActions.click());
        onView(withId(R.id.input_email)).check(matches(isDisplayed()));
    }
}




