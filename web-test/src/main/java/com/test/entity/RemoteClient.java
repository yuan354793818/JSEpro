package com.test.entity;

import java.util.Date;

public class RemoteClient {
    private String host;
    private String port;

    private Date lastVisitTime;

    public RemoteClient(String host, String port, Date lastVisitTime) {
        this.host = host;
        this.port = port;
        this.lastVisitTime = lastVisitTime;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Date getLastVisitTime() {
        return lastVisitTime;
    }

    public void setLastVisitTime(Date lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public RemoteClient(String host, String port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public String toString() {
        return "RemoteClient{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", lastVisitTime=" + lastVisitTime +
                '}';
    }
}
