package herapheri.com.fintech.Controller;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import herapheri.com.fintech.R;

/**
 * Created by codyj on 11/5/2017.
 */

public class LenderFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lender, container, false);
        Log.d("stages", "OnCreateView called");
//        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference();
//        userRef = database.getReference();
//        preview = (FrameLayout) v.findViewById(R.id.camera_preview);
//        //cameraBtn = (Button) v.findViewById(R.id.camera_btn);
//        manualBtn = (Button) v.findViewById(R.id.edit);
//        galleryBtn = (Button) v.findViewById(R.id.gallery);
//        storage = FirebaseStorage.getInstance();
//        storageRef = storage.getReferenceFromUrl("gs://niner-demo.appspot.com");
//        textureView = (TextureView) v.findViewById(R.id.texture);
//        assert textureView != null;
//        textureView.setSurfaceTextureListener(textureListener);
//        takePictureButton = (Button) v.findViewById(R.id.camera_btn);
//        assert takePictureButton != null;
//        takePictureButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                takePicture();
//            }
//        });
//        syncUserInformation();
//        try {
//            //initCamera();
//            manualBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent i  = new Intent(getContext(),CreateEventManuallyActivity.class);
//                    i.putExtra("UNIVERSITY",mainActivity.getEditorUniversity());
//                    i.putExtra("EMAIL",mainActivity.getUserEmail());
//                    startActivity(i);
//                }
//            });
//            galleryBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent();
//                    intent.setType("image/*");
//                    intent.setAction(Intent.ACTION_GET_CONTENT);
//                    startActivityForResult(Intent.createChooser(intent, "Select Picture"),2);
//
//
//                }
//            });
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        //initCamera();
//        return v;
//    }
        return null;
    }
}