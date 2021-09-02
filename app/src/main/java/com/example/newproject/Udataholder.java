package com.example.newproject;

public class Udataholder {

    String code, Filename, Codersname;

    Udataholder() {
    }

    public Udataholder(String code, String filename, String codersname) {
        this.code = code;
        Filename = filename;
        Codersname = codersname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }

    public String getCodersname() {
        return Codersname;
    }

    public void setCodersname(String codersname) {
        Codersname = codersname;
    }
}
