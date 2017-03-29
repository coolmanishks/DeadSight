package model;

/**
 * Created by subham on 3/28/2017.
 */

/*

* this will be filled by admin
*
* */
public class project_model {
    String project_name;
    String contracter_id;
    String project_start_date;
    String project_end_date;

    public project_model() {
    }

    public project_model(String project_name, String contracter_id, String project_start_date,String project_end_date) {
        this.project_name = project_name;
        this.contracter_id = contracter_id;
        this.project_start_date = project_start_date;
        this.project_end_date = project_end_date;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getContracter_id() {
        return contracter_id;
    }

    public String getProject_start_date() {
        return project_start_date;
    }

    public String getProject_end_date() {
        return project_end_date;
    }
}
