package me.zbl.fullstack.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Addr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "addr")
    private String addr;
    @Column(name = "req_date")
    private Date req_date;

    public Date getReq_date() {
        return req_date;
    }

    public void setReq_date(Date req_date) {
        this.req_date = req_date;
    }

    public int getId() {
        return id;
    }

    public Addr() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Addr(String addr) {
        this.addr = addr;
    }
}
