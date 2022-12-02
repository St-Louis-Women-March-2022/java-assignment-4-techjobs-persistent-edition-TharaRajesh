package org.launchcode.techjobs.persistent.models;

import java.util.ArrayList;

// This is a change made in sandbox.

/**
 * Created by LaunchCode
 */
public class JobData extends AbstractEntity{


    /**
     * Returns the results of searching the Jobs data by field and search term.
     *
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column Job field that should be searched.
     * @param value Value of the field to search for.
     * @param allJobs The list of jobs to search.
     * @return List of all jobs matching the criteria.
     */
    public static ArrayList<Job> findByColumnAndValue(String column, String value, Iterable<Job> allJobs) {

        ArrayList<Job> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Job>) allJobs;
        }

        if (column.equals("all")){
            results = findByValue(value, allJobs);
            return results;
        }
        for (Job job : allJobs) {

            String aValue = getFieldValue(job, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(job);
            }
        }

        return results;
    }

    public static String getFieldValue(Job job, String fieldName){
        String theValue = "";
        //fieldName name not required(Not search by Name)
        if (fieldName.equals("name")){
            theValue = job.getName();
        } else if (fieldName.equals("employer")){
            //theValue = job.getEmployer().toString();
            theValue = job.getEmployer().name.toString();
        } else {
            //theValue = job.getSkills().toString();
            for (Skill skill : job.getSkills()) {
                theValue+=skill.name +",";
            }
        }

        return theValue;
    }

    /**
     * Search all Job fields for the given term.
     *
     * @param value The search term to look for.
     * @param allJobs The list of jobs to search.
     * @return      List of all jobs with at least one field containing the value.
     */
    public static ArrayList<Job> findByValue(String value, Iterable<Job> allJobs) {
        String lower_val = value.toLowerCase();

        ArrayList<Job> results = new ArrayList<>();
        String skills = "";

        for (Job job : allJobs) {
            skills = "";
            for (Skill skill : job.getSkills()) {
                skills+=skill.name +",";
            }
            if (job.getName().toLowerCase().contains(lower_val)) {
                results.add(job);
            } else if (job.getEmployer().name.toString().toLowerCase().contains(lower_val)) {
                results.add(job);
            } else if (skills.toLowerCase().contains(lower_val)) {
                results.add(job);
            } else if (job.toString().toLowerCase().contains(lower_val)) {
                results.add(job);
            }

        }

        return results;
    }


}

