package com.java.mytutos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Formatter;

public class StringFormatExamples {

    public void mostCommonStringFormat() {

        //1
        String outPut = String.format("%s =  %d", "Mehdi", 23);

        //2
        String outPut2 = String.format("My name is %s%n", "Mehdi");

        System.out.println(outPut);
        System.out.print(outPut2);


        //3
        //Create a Formatter and link it to a StringBuilder.
        // Output formatted using the format() method will be appended to the StringBuilder.

        StringBuilder sBuilder = new StringBuilder();
        Formatter formatter = new Formatter(sBuilder);
        formatter.format("PI = %f%n", Math.PI);
        System.out.print(sBuilder.toString());

        // you can continue to append data to sBuilder here.
        formatter.format("The biggest number between %f and %f is %f", 12.5, 17.99,
                Math.max(12.5, 17.99));

        System.out.println(sBuilder.toString());


        //4
        // Dates
        System.out.println();
        System.out.println("--- Dates ----");
        System.out.printf("Hours: %tH%n", new Date());
        System.out.printf("Mins: %tM%n", new Date());
        System.out.printf("Secs: %tS%n", new Date());

        //Another way to do it
        System.out.println();
        System.out.println("--- Dates : Another way to do it----");
        Date date = new Date();
        System.out.printf("%tH:%tM:%tS%n", date, date, date);
        //using index references
        System.out.printf("%1$tH:%1$tM:%1$tS%n", date);

        //Finally
        System.out.printf("Finally, to show the date with one formatter : %tT%n", new Date());


        //5
        //Time zone with %z or %Z
        System.out.printf("Time Zone : %1$tT %1$tZ%n", new Date());

        //6
        //Representing Month
        //B - full month name
        //b - abbreviated month name
        //m - year of month number 01 - 12

        Date dt = Date.from(ZonedDateTime.of(LocalDate.of(2017, 2, 1).atStartOfDay(),
                ZoneId.systemDefault()).toInstant());

        System.out.printf("%tB%n", dt);
        System.out.printf("%tb%n", dt);
        System.out.printf("%tm%n", dt);

        //7
        //Days
        //A - full name
        //a - abbreviated
        //d - day of month, 01 - 31

        System.out.println();
        System.out.println("--- Days ----");

        System.out.printf("%tA%n", new Date());
        System.out.printf("%ta%n", new Date());
        System.out.printf("%td%n", new Date());

        //8
        //Common formats shortcuts
        //R - %tH:%tM
        //T - %tH:%tM:%tS
        //r - %tI:%tM:%tS %Tp
        //D - %tm/%td/%ty
        //F - %tY-%tm-%td
        //c - %ta %tb %td %tT %tZ %tY, e.g. Sun Jul 20 16:17:00 EDT 1969.

        System.out.println();
        System.out.println("--- Years ----");
        System.out.printf("%tR%n", new Date());
        System.out.printf("%tT%n", new Date());
        System.out.printf("%tr%n", new Date());
        System.out.printf("%tD%n", new Date());
        System.out.printf("%tF%n", new Date());
        System.out.printf("%tc%n", new Date());


    }

}
