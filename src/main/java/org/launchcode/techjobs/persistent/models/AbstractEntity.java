package org.launchcode.techjobs.persistent.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

//Created mappedsuperclass annotation
@MappedSuperclass
public abstract class AbstractEntity {

//    Created correct annotations for AbstractEntity.id
@Id
@GeneratedValue
private int id;



    @NotBlank(message = "Name is required")
    @Size(min = 5, max = 60, message = "Name must be between 3 and 60 characters")
    public String name;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}