package com.example.arjun.androidnotesprofessional;

import com.google.gson.annotations.SerializedName;

public class Robot {
    //OPTIONAL - this annotation allows for the key to be different from the field name, and can be
    // omitted if key and field name are same . Also this is good coding practice as it decouple your
    //  variable names with server keys name


    public Robot(String version, int age, String name) {
        this.version = version;
        this.age = age;
        this.name = name;
    }

    @SerializedName("version")
    private String version="";

    @SerializedName("age")
    private int age;

    @SerializedName("robotName")
    private String name="";


    // optional : Benefit it allows to set default values and retain them, even if key is missing
    //from Json response. Not required for primitive data types.
    // public Robot{ version = ""; name = "";
    // }
}
