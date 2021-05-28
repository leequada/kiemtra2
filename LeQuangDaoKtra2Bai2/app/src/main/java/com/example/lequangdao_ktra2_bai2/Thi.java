package com.example.lequangdao_ktra2_bai2;

public class Thi
{
    public String id,name,dates,times,ischecked;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDates() {
        return dates;
    }

    public String getTimes() {
        return times;
    }

    public String getIschecked() {
        return ischecked;
    }

    public Thi(String id, String name, String dates, String times, String ischecked) {
        this.id = id;
        this.name = name;
        this.dates = dates;
        this.times = times;
        this.ischecked = ischecked;
    }

    public Thi() {
    }
}

