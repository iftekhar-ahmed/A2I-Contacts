package com.example.a2icontacts.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by mukla on 4/23/14.
 */
@DatabaseTable
public class SubTeam {
    @DatabaseField(id=true)
    private long _id;
    @DatabaseField
    private String _name;
    @DatabaseField
    private long _teamId;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public long get_teamId() {
        return _teamId;
    }

    public void set_teamId(long _teamId) {
        this._teamId = _teamId;
    }
}
