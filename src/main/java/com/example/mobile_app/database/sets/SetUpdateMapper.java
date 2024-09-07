package com.example.mobile_app.database.sets;

import com.example.mobile_app.database.general.MapperUpdate;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class SetUpdateMapper implements MapperUpdate<SetUpdateDto,Set> {
    @Override
    public Set map(SetUpdateDto object, Set toObject) {
        toObject.setDescription(object.getDescription());
        toObject.setName(object.getName());
        return toObject;
    }
}
