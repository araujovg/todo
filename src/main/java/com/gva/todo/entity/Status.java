package com.gva.todo.entity;

import lombok.Getter;

public enum Status {

    PENDING("Pending"),
    STARTED("Started"),
    DONE("Done");

    @Getter private String description;

    Status(String description) {
        this.description = description;
    }

}
