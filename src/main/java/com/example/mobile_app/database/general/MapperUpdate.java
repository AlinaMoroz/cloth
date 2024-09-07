package com.example.mobile_app.database.general;

import org.springframework.stereotype.Component;


public interface MapperUpdate<F, T>{

    T map(F object, T toObject);
}
