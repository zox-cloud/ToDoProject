package com.example.ToDoProject.status;

public enum ToDoStatus {
    NOT_COMPLETED ("не выполнена"),
    IN_PROGRESS ("в процессе"),
    COMPLETED("выполнена");

    private final String displayName;
    ToDoStatus(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
