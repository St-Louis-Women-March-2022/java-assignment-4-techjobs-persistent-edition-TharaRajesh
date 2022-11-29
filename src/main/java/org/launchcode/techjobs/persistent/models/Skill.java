package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {


    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs = new ArrayList<>();


    public List<Job> getJobs() {
        return jobs;
    }
//    public void setJobs(Job job) {
//        this.job = job;
//    }



    @NotBlank(message = "Description should not empty")
    @Size(max = 500, message ="Description too long!")
    private String description;

    public Skill(String description){
        this.description = description;
    }
    public Skill (){}
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}