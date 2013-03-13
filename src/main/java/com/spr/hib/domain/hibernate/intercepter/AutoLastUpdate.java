package com.spr.hib.domain.hibernate.intercepter;

import java.util.Date;
//INTERCEPTOR
public interface AutoLastUpdate {

    public void setLastUpdated(Date date);
    public Date getLastUpdated();
}