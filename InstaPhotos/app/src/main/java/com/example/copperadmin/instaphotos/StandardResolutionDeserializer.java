package com.example.copperadmin.instaphotos;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Copper Admin on 10/6/2014.
 */

public class StandardResolutionDeserializer implements JsonDeserializer<StandardResolution> {
    @Override
    public StandardResolution deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        final StandardResolution standard = new StandardResolution();

        final String url = jsonObject.get("url").getAsString();
        final int width = jsonObject.get("width").getAsInt();
        final int height = jsonObject.get("height").getAsInt();

        standard.setUrl(url);
        standard.setWidth(width);
        standard.setHeight(height);

        return standard;
    }
}

