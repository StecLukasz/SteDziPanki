package com.example.SteDziPanki.model;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    private Long id;
    private String uuid = UUID.randomUUID().toString();

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Version
    private long version;

    public BaseEntity() {
    }

    public BaseEntity(Long id, String uuid, long version) {
        this.id = id;
        this.uuid = uuid;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}