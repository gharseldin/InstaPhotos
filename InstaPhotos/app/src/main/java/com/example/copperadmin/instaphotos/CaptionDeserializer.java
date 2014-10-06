package com.example.copperadmin.instaphotos;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Copper Admin on 10/5/2014.
 */
public class CaptionDeserializer implements JsonDeserializer<Caption> {

    @Override
    public Caption deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        final Caption caption = new Caption();
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        final String text = jsonObject.get("text").getAsString();

        caption.setCaption(text);

        return caption;
    }
}
