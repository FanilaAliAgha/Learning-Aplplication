package com.example.newproject;

public class model {
    String code,codersname,filename;
    model()
    {

    }
    public model(String code, String codersname, String filename) {
        this.code = code;
        this.codersname = codersname;
        this.filename = filename;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodersname() {
        return codersname;
    }

    public void setCodersname(String codersname) {
        this.codersname = codersname;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}