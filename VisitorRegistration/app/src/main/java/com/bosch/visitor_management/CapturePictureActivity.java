package com.bosch.visitor_management;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

public class CapturePictureActivity extends FragmentActivity {
    private static final int PERMISSIONS_REQUEST_CAMERA = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_picture);
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CameraPreviewFragment.newInstance())
                    .commit();
        }

        /*
        if (checkFrontCamera()) {
            // Permission has already been granted
            if (!checkCameraPermission()) {
                // Permission is not granted Should we show an explanation?
                if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    Toast.makeText(this, "Camera is required to take visitor picture", Toast.LENGTH_SHORT).show();
                } else {
                    // No explanation needed; request the permission
                    requestPermissions(
                            new String[]{Manifest.permission.CAMERA},
                            PERMISSIONS_REQUEST_CAMERA);
                }
            } else {
                initCamera();
            }
        } else {
            Toast.makeText(this, "Front camera is not available, function will be disabled", Toast.LENGTH_SHORT).show();
        }
        */
    }
/*
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initCamera();
                } else {
                    Toast.makeText(this, "Front camera is not available, function will be disabled", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    private void initCamera() {
        // Create an instance of Camera
        Camera mCamera = getCameraInstance();
        if (mCamera == null) {
            Toast.makeText(this, "Front camera is not available, function will be disabled", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create our Preview view and set it as the content of our activity.
        CameraPreview mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = findViewById(R.id.camera_preview);
        preview.addView(mPreview);
    }

    private boolean checkFrontCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT);
    }

    private boolean checkCameraPermission() {
        return checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    private Camera getCameraInstance() {
        Camera cam = null;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int cameraCount = Camera.getNumberOfCameras();
        for (int camIdx = 0; camIdx < cameraCount; camIdx++) {
            Camera.getCameraInfo(camIdx, cameraInfo);
            if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                try {
                    cam = Camera.open(camIdx);
                } catch (RuntimeException e) {
                    Log.e(Constants.TAG, "Camera failed to open: " + e.getLocalizedMessage());
                }
            }
        }
        return cam;
    }
    */
}
