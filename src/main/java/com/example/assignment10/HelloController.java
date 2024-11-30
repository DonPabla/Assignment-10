package com.example.assignment10;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private TableView<EmployeeData> employeeTable;
    @FXML
    private TableColumn<EmployeeData, String> nameColumn;
    @FXML
    private TableColumn<EmployeeData, String> typeColumn;
    @FXML
    private TableColumn<EmployeeData, Double> salaryColumn;

    @FXML
    private TextField nameField;
    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private TextField hourlyRateField;
    @FXML
    private TextField hoursWorkedField;

    private final ObservableList<EmployeeData> employeeList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Настраиваем отображение колонок
        nameColumn.setCellValueFactory(data -> data.getValue().nameProperty());
        typeColumn.setCellValueFactory(data -> data.getValue().typeProperty());
        salaryColumn.setCellValueFactory(data -> data.getValue().salaryProperty().asObject());

        // Устанавливаем данные для ComboBox
        typeComboBox.setItems(FXCollections.observableArrayList("Full-time", "Part-time", "Contractor"));

        // Привязываем список сотрудников к таблице
        employeeTable.setItems(employeeList);
    }

    @FXML
    private void onAddEmployee() {
        try {
            // Получаем данные из полей ввода
            String name = nameField.getText();
            String type = typeComboBox.getValue();
            double hourlyRate = Double.parseDouble(hourlyRateField.getText());
            int hoursWorked = Integer.parseInt(hoursWorkedField.getText());

            if (name.isEmpty() || type == null) {
                showAlert("Error", "All fields must be filled.");
                return;
            }

            // Создаем нового сотрудника
            EmployeeData employee;
            switch (type) {
                case "Full-time" -> employee = new EmployeeData(name, "Full-time", hourlyRate * 40); // 40 часов в неделю
                case "Part-time" -> employee = new EmployeeData(name, "Part-time", hourlyRate * hoursWorked);
                case "Contractor" -> employee = new EmployeeData(name, "Contractor", hourlyRate * hoursWorked);
                default -> throw new IllegalArgumentException("Unknown employee type");
            }

            // Добавляем сотрудника в таблицу
            employeeList.add(employee);

            // Очищаем поля ввода
            nameField.clear();
            hourlyRateField.clear();
            hoursWorkedField.clear();
            typeComboBox.getSelectionModel().clearSelection();

        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter valid numbers for Hourly Rate and Hours Worked.");
        }
    }

    @FXML
    private void onRemoveEmployee() {
        // Получаем выбранный элемент
        EmployeeData selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            // Удаляем его из списка
            employeeList.remove(selectedEmployee);
        } else {
            showAlert("No Selection", "Please select an employee to remove.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
