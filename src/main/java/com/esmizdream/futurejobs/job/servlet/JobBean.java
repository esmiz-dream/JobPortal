/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.esmizdream.futurejobs.job.servlet;

import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author hp
 */
public class JobBean {

    private int id;
    private int employer;
    private String employer_name;
    private String title;
    private String vacancy_id;
    private Timestamp post_date;
    private Timestamp deadline;
    private int min_experiance;
    private int max_experiance;
    private int salary;
    private String description;
    private String attachment;
    private String image;
    private String work_place;
    private int category;
    private String category_name;
    private String job_modality;
    private String applied_in;
    private String status;
    private Timestamp created_at;
    private Timestamp last_modified;

    public String getEmployer_name() {
        return employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployer() {
        return employer;
    }

    public void setEmployer(int employer) {
        this.employer = employer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVacancy_id() {
        return vacancy_id;
    }

    public void setVacancy_id(String vacancy_id) {
        this.vacancy_id = vacancy_id;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public int getMin_experiance() {
        return min_experiance;
    }

    public void setMin_experiance(int min_experiance) {
        this.min_experiance = min_experiance;
    }

    public int getMax_experiance() {
        return max_experiance;
    }

    public void setMax_experiance(int max_experiance) {
        this.max_experiance = max_experiance;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWork_place() {
        return work_place;
    }

    public void setWork_place(String work_place) {
        this.work_place = work_place;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getJob_modality() {
        return job_modality;
    }

    public void setJob_modality(String job_modality) {
        this.job_modality = job_modality;
    }

    public String getApplied_in() {
        return applied_in;
    }

    public void setApplied_in(String applied_in) {
        this.applied_in = applied_in;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Timestamp last_modified) {
        this.last_modified = last_modified;
    }
}
