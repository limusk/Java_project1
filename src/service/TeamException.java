package service;

import domain.Employee;

/**
 * @auther limusk
 * @create 2020-09-23-15:43
 * @project project3
 */

public class TeamException extends Exception {
    static final long serialVersionUID = -33875169124229948L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }

}
