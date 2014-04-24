package com.example.a2icontacts.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by mukla on 4/23/14.
 */
@DatabaseTable
public class A2IContact {
    @DatabaseField(id = true)
    private String mobile;
    @DatabaseField
    private String name;
    @DatabaseField
    private String email;
    @DatabaseField
    private String designation;
    @DatabaseField
    private long subTeamId;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public long getSubTeamId() {
        return subTeamId;
    }

    public void setSubTeamId(long subTeamId) {
        this.subTeamId = subTeamId;
    }
}
