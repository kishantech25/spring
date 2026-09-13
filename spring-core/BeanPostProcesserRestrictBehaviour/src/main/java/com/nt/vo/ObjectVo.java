package com.nt.vo;

import java.util.Date;

public class ObjectVo {

    protected Date createDate;
    protected  String createBy;
    protected  Date instModifiedDate;
    protected  String lastModifiedBy;
    //setters and getters

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getInstModifiedDate() {
        return instModifiedDate;
    }

    public void setInstModifiedDate(Date instModifiedDate) {
        this.instModifiedDate = instModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
