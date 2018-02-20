package com.hem.mvcdemo;

import com.hem.mvcdemo.validation.CourseCode;

import javax.validation.constraints.*;
import java.util.LinkedHashMap;

/**
 * Author: hemraj
 * Date:  2/3/18.
 */
public class Student {
    private String firstName;

    @NotNull(message = "Required")
    @Size(min = 1, message = "Required")
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private String[] operatingSystem;

    @CourseCode
    private String courseCode;

    @NotNull(message = "Required")
    @Min(value = 0, message = "value must be greater or less than 0")
    @Max(value = 10, message = "value must be less than or equal to 10")
    private Integer freePases;

    @NotNull(message = "Required")
    @Pattern(regexp = "[a-zA-z0-9]{5}", message = "Must be 5 digit/character")
    private String postalCode;

    public LinkedHashMap<String, String> countryList;
    public LinkedHashMap<String, String> languageOptions;
    public LinkedHashMap<String, String> favOs;

    public Student() {
        countryList = new LinkedHashMap<>();
        languageOptions = new LinkedHashMap<>();
        favOs = new LinkedHashMap<>();
        countryList.put("np", "Nepal");
        countryList.put("in", "India");
        countryList.put("ch", "China");
        countryList.put("bz", "Brazil");
        countryList.put("hk", "HonKong");
        languageOptions.put("Java", "Java");
        languageOptions.put("PHP", "PHP");
        languageOptions.put("C", "C");
        languageOptions.put("Python", "Python");
        favOs.put("Linux", "Linux");
        favOs.put("Mac", "Mac");
        favOs.put("Windows", "Windows");
    }


    public LinkedHashMap<String, String> getCountryList() {
        return countryList;
    }

    public LinkedHashMap<String, String> getLanguageOptions() {
        return languageOptions;
    }

    public LinkedHashMap<String, String> getFavOs() {
        return favOs;
    }

    public String[] getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Integer getFreePases() {
        return freePases;
    }

    public void setFreePases(Integer freePases) {
        this.freePases = freePases;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
