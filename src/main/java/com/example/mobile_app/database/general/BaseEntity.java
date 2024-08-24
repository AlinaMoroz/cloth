package com.example.mobile_app.database.general;

import java.io.Serializable;

public interface BaseEntity <T extends Serializable>{

    T getId();
    void setId(T id);
}
