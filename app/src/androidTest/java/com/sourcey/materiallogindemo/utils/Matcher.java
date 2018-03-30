//package com.sourcey.materiallogindemo.utils;
//
//
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import org.hamcrest.Description;
//import org.hamcrest.TypeSafeMatcher;
//
//
///**
// * Created by geetikag on 29/3/2018 AD.
// */
//
//public final class Matcher {
//    Matcher<View> isEditTextValueEqualTo(final String content) {
//
//        return new TypeSafeMatcher<View>() {
//
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("Match Edit Text Value with View ID Value : :  " + content);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                if (!(view instanceof TextView) && !(view instanceof EditText)) {
//                    return false;
//                }
//                if (view != null) {
//                    String text;
//                    if (view instanceof TextView) {
//                        text =((TextView) view).getText().toString();
//                    } else {
//                        text =((EditText) view).getText().toString();
//                    }
//
//                    return (text.equalsIgnoreCase(content));
//                }
//                return false;
//            }
//        };
//    }
//}
