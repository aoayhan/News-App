package com.anil.newsapplication.model;

public class CategoryItemModel {
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "CategoryItemModel{" +
                        ",id = '" + id + '\'' +
                        "name = '" + name + '\'' +
                        "}";
    }
}
