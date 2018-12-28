package com.example.mm.resturant.Util;

import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Pattern;

public class InputValidation {

    /**
     *
     * @InputValidation Class Constants
     *
     *  (?=.*\d)      #   must contains one digit from 0-9
     *  (?=.*[a-z])   #   must contains one lowercase characters
     *  (?=.*[A-Z])   #   must contains one uppercase characters
     *  (?=.*[@#$%])  #   must contains one special symbols in the list "@#$%"
     *          .     #   match anything with previous condition checking
     *  {6,20}        #   length at least 6 characters and maximum of 20
     * */

    public static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z]).{6,20})";

    // public static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    //"(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
    //"((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,})";
    //public static final String PASSWORD_PATTERN ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
    //String password_pattern = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

    private Pattern pattern;
    //private Matcher matcher;


    public boolean isValidMail(EditText emailInput) {
        String value = emailInput.getText().toString().trim();

        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            return false;

        }else {
            return true;
        }
    }

    public boolean isValidPassword(EditText passwordInput) {
        String value = passwordInput.getText().toString().trim();
//|| !Constants.PASSWORD_PATTERN.matches(value)

        // pattern = Pattern.compile(PASSWORD_PATTERN);

        if (value.isEmpty() || !Pattern.compile(PASSWORD_PATTERN).matcher(value).matches()){
            return false;
        }else {
            return true;
        }
    }

    public boolean isValidRePassword (EditText rePassword,EditText password){
        String value = rePassword.getText().toString().trim();
        String value1 = password.getText().toString().trim();

        if (value.isEmpty() || !value.contentEquals(value1)){
            return false;
        }else {
            return true;
        }
    }

    public boolean isValidMobile (EditText number){
        String value = number.getText().toString().trim();

        if (value.isEmpty() || !Patterns.PHONE.matcher(value).matches() || value.length() < 10 || value.length() > 11){
            return false;

        }else {
            return true;
        }
    }

    public boolean isValidName (EditText name){
        String value = name.getText().toString().trim();

        if (value.isEmpty() || value.length() < 3 || value.length() > 20){
            return false;

        }else {
            return true;
        }
    }
}
