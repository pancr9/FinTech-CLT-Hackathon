package herapheri.com.fintech.Controller;


import android.graphics.Camera;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.media.ImageReader;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.File;

import herapheri.com.fintech.R;

/**
 * Created by codyj on 11/5/2017.
 */

public class LenderFragment extends Fragment {

    private Camera mCamera;
    //private CameraPreview cameraPreview;
    private FrameLayout preview;
    private Button cameraBtn;
    private Button manualBtn;
    private Button galleryBtn;
    public String imagePath = "";
    //public FirebaseStorage storage;
    //public StorageReference storageRef;
    //StorageReference riversRef;
    private String userEmailAddress;
    //DatabaseReference myRef;
    //DatabaseReference userRef;
    int eventsUploaded;
    private MainActivity mainActivity;
    int pictureQueue = 0;
    static final int PICK_IMAGE = 1;
    //private FirebaseDatabase database;
    final int MAX_EVENTS = 100;
   // private Event e;
   // private FirebaseAuth mAuth;
    private int openSpotInQueue = 999;
    private String eventDate;
    private static final String TAG = "CameraFragment";
    private Button takePictureButton;
    private TextureView textureView;
    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }
    private String cameraId;
    protected CameraDevice cameraDevice;
    protected CameraCaptureSession cameraCaptureSessions;
    protected CaptureRequest captureRequest;
    protected CaptureRequest.Builder captureRequestBuilder;
    //private Size imageDimension;
    private ImageReader imageReader;
    private File file;
    private static final int REQUEST_CAMERA_PERMISSION = 200;
    private boolean mFlashSupported;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lender,container,false);
        Log.d("stages","OnCreateView called");
        //database = FirebaseDatabase.getInstance();
        //myRef = database.getReference();
        //userRef = database.getReference();
        preview = (FrameLayout) v.findViewById(R.id.camera_preview);
        //cameraBtn = (Button) v.findViewById(R.id.camera_btn);
        manualBtn = (Button) v.findViewById(R.id.edit);
        galleryBtn = (Button) v.findViewById(R.id.gallery);
        //storage = FirebaseStorage.getInstance();
        //storageRef = storage.getReferenceFromUrl("gs://niner-demo.appspot.com");
        textureView = (TextureView) v.findViewById(R.id.texture);
        assert textureView != null;

        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {

            }

            @Override
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

            }

            @Override
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                return false;
            }

            @Override
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {

            }
        });
        takePictureButton = (Button) v.findViewById(R.id.camera_btn);
        assert takePictureButton != null;
        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //takePicture();
            }
        });
       // syncUserInformation();
        try {
            //initCamera();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //initCamera();
        return v;
    }
}
