package model;

/**
 * Created by subham on 3/27/2017.
 */
public class admin_model {
    String admin_email;
    String admin_username;
    String admin_organization;

    public admin_model(String admin_email, String admin_username, String admin_organization) {
        this.admin_email = admin_email;
        this.admin_username = admin_username;
        this.admin_organization = admin_organization;
    }

    public admin_model() {
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public String getAdmin_organization() {
        return admin_organization;
    }
}
