package com.bezina.my_spring_app.component;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterLoadEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class MongoEventListener extends AbstractMongoEventListener<Object>  {

        @Override
        public void onAfterSave(AfterSaveEvent<Object> event) {
            System.out.println("Saved document: " + event.getSource());
            System.out.println("Database operation: " + event.getDocument());
        }


    @Override
    public void onAfterLoad(AfterLoadEvent<Object> event) {
     //   super.onAfterLoad(event);
        System.out.println("Load source: " + event.getSource());
        System.out.println("Database operation: " + event.getDocument());
    }
}
