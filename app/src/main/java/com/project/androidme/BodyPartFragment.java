package com.project.androidme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    private static final String TAG = "BodyPartFragment";
    private List<Integer> mImageIds;
    private int mListIndex;
        public BodyPartFragment(){

        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            if(savedInstanceState!=null){
                mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
                mListIndex = savedInstanceState.getInt(LIST_INDEX);
            }

        View rootView = inflater.inflate(R.layout.fragment_body_parts, container, false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image);

        if(mImageIds!= null)
        {
            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListIndex<mImageIds.size()-1){
                        mListIndex++;
                    }

                    else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        }
        else {
            Log.v(TAG,"THis fragment has null list of Id's");
        }
       // imageView.setImageResource(AndroidImageAssets.getHeads().get(0));
        //imageView.setImageResource(AndroidImageAssets.getBodies().get(0));
        //imageView.setImageResource(AndroidImageAssets.getLegs().get(0));

        return rootView;
    }

            public void setImageIds(List<Integer> imageIds){
                mImageIds = imageIds;
        }
            public void setListIndex(int index){
                mListIndex = index;

        }
        @Override
        public void onSaveInstanceState(Bundle currentState){
            currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
            currentState.putInt(LIST_INDEX,mListIndex);


        }


    }
