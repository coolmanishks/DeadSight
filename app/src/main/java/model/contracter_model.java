package model;

/**
 * Created by subham on 3/27/2017.
 */

public class contracter_model {

    //String variables
    String contracter_email;
    String contracter_username;
    String contracter_organization;



    public contracter_model(String contracter_email, String contracter_username, String contracter_organization) {
        this.contracter_email = contracter_email;
        this.contracter_username = contracter_username;
        this.contracter_organization = contracter_organization;
    }

    public contracter_model() {
    }

    public String getContracter_email() {
        return contracter_email;
    }


    public String getContracter_username() {
        return contracter_username;
    }

    public String getContracter_organization() {
        return contracter_organization;
    }
}
