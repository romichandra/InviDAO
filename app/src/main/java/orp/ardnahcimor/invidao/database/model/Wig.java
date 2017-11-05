package orp.ardnahcimor.invidao.database.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by romichandra on 11/5/17.
 */

/*
* Step 1: Class defined using greenDAO 3.2 annotations
* Step 2: Rebuild project for greenDAO to generate constructors, getters and setters
* */

@Entity(nameInDb = "wig")
public class Wig {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "gender")
    private String gender;

    @Property(nameInDb = "subType")
    private String subType;

    @Property(nameInDb = "info")
    private String info;

    @Property(nameInDb = "type")
    private String type;

    @Generated(hash = 1656872216)
    public Wig(Long id, String name, String gender, String subType, String info,
            String type) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.subType = subType;
        this.info = info;
        this.type = type;
    }

    @Generated(hash = 1733383566)
    public Wig() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSubType() {
        return this.subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.valueOf(getId())
                + " " + getName()
                + " " + getGender()
                + " " + getSubType()
                + " " + getInfo()
                + " " + getType();
    }
}
