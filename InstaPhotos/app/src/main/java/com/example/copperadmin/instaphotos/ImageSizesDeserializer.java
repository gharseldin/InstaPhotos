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
public class ImageSizesDeserializer implements JsonDeserializer<ImageSizes> {

    @Override
    public ImageSizes deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        final ImageSizes imagesizes = new ImageSizes();

        LowResolution lowResolution = jsonDeserializationContext.deserialize(jsonObject.get("low_resolution"), LowResolution.class);
        Thumbnail thumb = jsonDeserializationContext.deserialize(jsonObject.get("thumbnail"), LowResolution.class);
        StandardResolution stand = jsonDeserializationContext.deserialize(jsonObject.get("standard_resolution"), LowResolution.class);

        imagesizes.setMlow(lowResolution);
        imagesizes.setMthumbnail(thumb);
        imagesizes.setMstandard(stand);

        return imagesizes;
    }
}
