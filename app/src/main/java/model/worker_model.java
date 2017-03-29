package model;

/**
 * Created by subham on 3/27/2017.
 */
public class worker_model{

    String worker_name;
    int worker_type;

    public worker_model() {
    }

    public worker_model(String worker_name, int worker_type) {
        this.worker_name = worker_name;
        this.worker_type = worker_type;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public int getWorker_type() {
        return worker_type;
    }
}
