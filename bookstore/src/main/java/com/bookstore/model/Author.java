/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.model;

import java.util.Objects;

/**
 * Author Model class
 *
 * @author Jithendra Chikkanna
 */
public class Author {

    private String id;
    private String name;
    private String dateOfBirth;
    private String dateOfDeath;
    private String placeOfDeath;

    public Author(String id, String name, String dateOfBirth, String dateOfDeath, String placeOfDeath) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.placeOfDeath = placeOfDeath;
    }

    public Author() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", dateOfDeath=" + dateOfDeath + ", placeOfDeath=" + placeOfDeath + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 59 * hash + Objects.hashCode(this.dateOfDeath);
        hash = 59 * hash + Objects.hashCode(this.placeOfDeath);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (!Objects.equals(this.dateOfDeath, other.dateOfDeath)) {
            return false;
        }
        if (!Objects.equals(this.placeOfDeath, other.placeOfDeath)) {
            return false;
        }
        return true;
    }

}
