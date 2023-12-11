package com.book;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public boolean validateName(String data){
         final String regex = "^[A-Z][a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(data);
        boolean result=matcher.matches();
        return result;
    }

    public boolean validateZip(String data){
        final String regex = "^\\d{6,}$";
        Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(data);
        boolean result=matcher.matches();
        return result;
    }

    public boolean validatePlace(String data ){
        final String regex = "^[A-Za-z]+$";
        Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(data);
        boolean result=matcher.matches();
        return result;
    }

    public boolean validatePhone(String data){
        final String phoneRegex="^91 [1-9]\\d{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);
         Matcher matcher = pattern.matcher(data);
        boolean result=matcher.matches();
        return result;
    }

    public boolean validateEmail(String data){
        final String emailRegex = "^[a-zA-Z0-9.$&%_+-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+$";
        Pattern pattern = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
         Matcher matcher = pattern.matcher(data);
        boolean result=matcher.matches();
        return result;
    }
}