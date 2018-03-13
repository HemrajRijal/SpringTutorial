package com.hemraj.demo.aopdemo;

/**
 * Author: hemraj
 * Date:  3/8/18.
 */
public class Account {
    private String name;

    private String level;


    public Account() {
    }

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        System.out.println(getClass() + " IN getter--->");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " IN setter--->");
        this.name = name;
    }

    public String getLevel() {
        System.out.println(getClass() + " IN getter--->");
        return level;
    }

    public void setLevel(String level) {
        System.out.println(getClass() + " IN setter--->");
        this.level = level;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
