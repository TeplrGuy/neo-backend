package com.neostarteon.backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/*
https://www.baeldung.com/jpa-one-to-one
 */
@Entity
@Table(name = "location")
public class Location {
    @Id
    private Long id;
    private Date createdOn;
    private Date updatedOn;
    private Double latitude;
    private Double longitude;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId()
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Location setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Location setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public Location() {

    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    @JsonProperty
    public Location setUser(User user) {
        this.user = user;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Location setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Location setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }
}
