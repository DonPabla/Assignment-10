package com.example.assignment10;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeData {
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleDoubleProperty salary;

    public EmployeeData(String name, String type, double salary) {
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.salary = new SimpleDoubleProperty(salary);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public SimpleDoubleProperty salaryProperty() {
        return salary;
    }
}
