package com.example.copperadmin.instaphotos;

import android.util.Log;

import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Copper Admin on 10/5/2014.
 */
public class PictureDeserializer implements JsonDeserializer<Picture[]> {


    @Override
    public Picture[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {


        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        final JsonElement jsonElement1 = jsonObject.get("data");
        final JsonArray jsonPictureArray = jsonElement1.getAsJsonArray();
        Log.d("CHECK", "Recieved a Json Object and coverted it to JSONArray successfully");

        Picture[] pictures = new Picture[jsonPictureArray.size()];

        for(int i=0; i<jsonPictureArray.size();i++){
            final JsonElement jsonPicture = jsonPictureArray.get(i);
            JsonObject jsonPictureObject = jsonPicture.getAsJsonObject();
            final String mId = jsonPictureObject.get("id").toString();
            final String mType = jsonPictureObject.get("type").toString();
            final String mFilter = jsonPictureObject.get("filter").toString();

            final ImageSizes mImageSizes = jsonDeserializationContext.deserialize(jsonObject.get("images"),ImageSizes.class );
            final Caption mCaption = jsonDeserializationContext.deserialize(jsonObject.get("text"),Caption.class);

            pictures[i].setId(mId);
            pictures[i].setType(mType);
            pictures[i].setFilter(mFilter);

            pictures[i].setCaption(mCaption);
            pictures[i].setImageSizes(mImageSizes);
        }

        return pictures;
    }
}
