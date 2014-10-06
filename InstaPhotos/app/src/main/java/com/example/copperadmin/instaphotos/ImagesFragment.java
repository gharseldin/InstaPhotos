package com.example.copperadmin.instaphotos;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ImagesFragment extends android.support.v4.app.Fragment {


    private String mJsonString=null;
    private Picture[] mPictures;
    private Gson gson;
    private ImageRecordsAdapter mAdapter;

    public ImagesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.activity_title);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(String[].class, new SimpleDeserializer());

//        gsonBuilder.registerTypeAdapter(Picture[].class, new PictureDeserializer());
//        gsonBuilder.registerTypeAdapter(Caption.class, new CaptionDeserializer());
//        gsonBuilder.registerTypeAdapter(ImageSizes.class, new ImageSizesDeserializer());
//        gsonBuilder.registerTypeAdapter(StandardResolution.class, new StandardResolutionDeserializer());
//        gsonBuilder.registerTypeAdapter(Thumbnail.class, new ThumbnailDeserializer());
//        gsonBuilder.registerTypeAdapter(LowResolution.class, new LowResolutionDeserializer());

        gson = gsonBuilder.create();

        JsonObjectRequest request = new JsonObjectRequest("https://api.instagram.com/v1/tags/selfie/media/recent?COUNT=1&access_token=1460323222.858d928.3b9e24a3be9e4278b9cd73e120044e0a",
                null, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {
                mJsonString = response.toString();
                String[] urls = gson.fromJson(response.toString(),String[].class);
//                mPictures = gson.fromJson(response.toString(),Picture[].class);
                mAdapter.swapImageRecords(urls);

                for (int i = 0; i<urls.length; i++) {
                    Log.d("JSONString", urls[i]);
                }



            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("JSONString", error.toString());
            }
        });

        VolleyApplication.getInstance().getRequestQueue().add(request);

        //Now we parse With Gson


    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new ImageRecordsAdapter(getActivity());
        ListView listView = (ListView) getView().findViewById(R.id.list1);
        listView.setAdapter(mAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);




    }
}
