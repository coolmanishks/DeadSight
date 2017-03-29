package model;

/**
 * Created by subham on 3/27/2017.
 */
public class supervisor_model {

    String supervisor_email;
    String supervisor_username;
    String supervisor_organization;

    public supervisor_model() {
    }

    public supervisor_model(String supervisor_email, String supervisor_username, String supervisor_organization) {
        this.supervisor_email = supervisor_email;
        this.supervisor_username = supervisor_username;
        this.supervisor_organization = supervisor_organization;
    }

    public String getSupervisor_email() {
        return supervisor_email;
    }


    public String getSupervisor_username() {
        return supervisor_username;
    }

    public String getSupervisor_organization() {
        return supervisor_organization;
    }
}
