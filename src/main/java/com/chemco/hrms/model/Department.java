package com.chemco.hrms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int Id;
    public String name;

    public Department() { }

    public Department(int id, String name) { Id = id; this.name = name; }

    public int getId() { return Id; }

    public void setId(int id) { Id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Id == that.Id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() { return Objects.hash(Id, name); }
}
