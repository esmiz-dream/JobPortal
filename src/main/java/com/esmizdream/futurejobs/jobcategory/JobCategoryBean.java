/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esmizdream.futurejobs.jobcategory;

import java.sql.Timestamp;

/**
 *
 * @author hp
 */
public class JobCategoryBean {

    private int id;
    private String title;
    private Timestamp created_at;
    private Timestamp last_modified;
    private String status;
    private static JobCategoryBean categorybean;

    public static JobCategoryBean getInstance() {
        if (categorybean == null) {
            categorybean = new JobCategoryBean();
        }
        return categorybean;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
