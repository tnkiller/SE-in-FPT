package Model.employee;


import Model.Person;

import java.text.ParseException;

public class Boss extends Person {

    public Boss(String userName, String password, String lastName, String firstName, String address, String phoneNum, String dob) throws ParseException {
        super(userName, password, lastName, firstName, address, phoneNum, dob);
    }

}

