package com.java.mytutos;

import org.apache.commons.lang3.StringUtils;

public class ApacheCommonsExamples {

    public void stringUtilExamples() {

        String nullString = null;

        //Case 1

        //StringUtils.isEmpty(myString)
        //Before we do this
        if (nullString == null || nullString.isEmpty()) {
            //do something
        }

        //Now with StringUtils, only isEmpty is enough.
        if (StringUtils.isEmpty(nullString)) {
            System.out.println("indeed, StringUtils.isEmpty(testString) checks NULL values");
        }

        //Case 2

        // NPE avoidance with equals(CharSequence str1, CharSequence str2)
        doStuffWithString(nullString); // NPE

        //this will not throw NPE - but not elegant solutions
        safeDoStuffWithString1(nullString);
        safeDoStuffWithString2(nullString);

        // this is better with StringUtils
        safeDoStuffWithStringUtils(nullString);


        //Case 3
        String someWhiteSpace = "    \t  \n";
        System.out.println(StringUtils.isEmpty(someWhiteSpace)); // false
        System.out.println(StringUtils.isBlank(someWhiteSpace)); // true

        //Case 4

        // String.split() and StringUtils.split()
        possiblyNotWhatYouWant();


        //Case 5

        //Join array Strings into one String..
        String[] numbers = {"one", "two", "three"};
        String joinString = StringUtils.join(numbers, ",");// returns "one,two,three"
        System.out.println(joinString);


    }

    public void doStuffWithString(String stringParam) {
        try {
            if (stringParam.equals("MyStringValue")) {
                // do stuff
            }
        } catch (NullPointerException e) {
            System.out.println("Error !! This has thrown a NPE ! ");
        }

    }

    public void safeDoStuffWithString1(String stringParam) {
        if (stringParam != null && stringParam.equals("MyStringValue")) {
            // do stuff
        }
    }

    public void safeDoStuffWithString2(String stringParm) {
        if ("MyStringValue".equals(stringParm)) {
            // do stuff
        }
    }


    public void safeDoStuffWithStringUtils(String stringParam) {
        if (StringUtils.equals(stringParam, "MyStringValue")) {
            // do stuff
        }
    }

    public void possiblyNotWhatYouWant() {
        String contrivedExampleString = "one.two.three.four";
        String[] result = contrivedExampleString.split(".");
        System.out.println(result.length); // 0

        String[] resultStringUtils =
                StringUtils.split(contrivedExampleString, ".");

        System.out.println(resultStringUtils.length); // 4
    }
}

