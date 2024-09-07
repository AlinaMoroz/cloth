package com.example.mobile_app.database.comments;

import com.example.mobile_app.database.general.Mapper;
import com.example.mobile_app.database.general.MapperUpdate;
import org.springframework.stereotype.Component;

@Component
public class CommentUpdateMapper implements MapperUpdate<CommentUpdateDto,Comment> {


    @Override
    public Comment map(CommentUpdateDto object, Comment toObject) {
        toObject.setText(object.getText());
        return toObject;
    }
}
