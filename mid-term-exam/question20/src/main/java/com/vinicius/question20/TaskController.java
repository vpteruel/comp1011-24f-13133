package com.vinicius.question20;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TaskController {
    private TaskModel model;

    @FXML
    private ListView<String> taskListView;

    @FXML
    private TextField taskInput;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    public TaskController(TaskModel model) {
        this.model = model;
    }

    public void setModel(TaskModel model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
        //updateTaskListView();
    }

    @FXML
    private void handleAddTask() {
        String taskName = taskInput.getText();
        if (!taskName.isEmpty()) {
            model.addTask(new Task(taskName));
            updateTaskListView();
            taskInput.clear();
        }
    }

    @FXML
    private void handleRemoveTask() {
        int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
        model.removeTask(selectedIndex);
        updateTaskListView();
    }

    @FXML
    private void updateTaskListView() {
        ObservableList<String> taskNames = FXCollections.observableArrayList();
        for (Task task : model.getTasks()) {
            taskNames.add(task.getName());
        }
        taskListView.setItems(taskNames);
    }
}
