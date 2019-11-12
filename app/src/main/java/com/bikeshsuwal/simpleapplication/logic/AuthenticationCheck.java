package com.bikeshsuwal.simpleapplication.logic;


import com.bikeshsuwal.simpleapplication.model.UsersDetails;

import java.util.List;

public class AuthenticationCheck {

    private String loginemail, loginpassword;
    private static List<UsersDetails> usersDetailsList;
    boolean isEqual = false;


    public boolean check() {
        if (getUsersDetailsList() != null) {
            for (int i = 0; i < getUsersDetailsList().size(); i++) {
                final UsersDetails details = getUsersDetailsList().get(i);
                isEqual = loginemail.equals(details.getEmail()) && loginpassword.equals(details.getPassword());
            }
        }
        return isEqual;
    }


    public List<UsersDetails> getUsersDetailsList() {
        return usersDetailsList;
    }

    public void setUsersDetailsList(List<UsersDetails> usersDetailsList) {
        this.usersDetailsList = usersDetailsList;
    }

    public String getLoginemail() {
        return loginemail;
    }

    public void setLoginemail(String loginemail) {
        this.loginemail = loginemail;
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword;
    }
}
