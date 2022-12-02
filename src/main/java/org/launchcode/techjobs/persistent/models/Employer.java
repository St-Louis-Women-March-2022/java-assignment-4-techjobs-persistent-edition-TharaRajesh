package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "location is required")
    @Size(min = 5, max = 50, message = "Location must be between 5 and 50 characters")
    private String location;

   @OneToMany
   @JoinColumn(name = "employer_id")
    private List<Job> jobs = new ArrayList<>();

    public List<Job> getJobs() {
        return jobs;
    }

    public Employer(@Size(min =5, message = "Location must be atleast 5 characters long") String location){
        this.location = location;

}
    public Employer(){};
    public String getLocation() {
        return location;
    }
    public String getName() { return this.name; }


    public void setLocation(String location) {
        this.location = location;
    }
    public void setName(String name) {
        this.name = name;
    }


}
