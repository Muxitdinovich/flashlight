package com.example.flashlight;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;

import java.lang.reflect.Constructor;

public class FlashClass {
    private boolean flash_satus = false;
    private Context context;

    public  FlashClass(Context context) {
        this.context = context;
    }
    public void flashOn(){
        CameraManager cameraManager = (CameraManager)context.getSystemService(Context.CAMERA_SERVICE);
        try {
            assert cameraManager != null;
            String cameraId = cameraManager.getCameraIdList() [0];
            cameraManager.setTorchMode(cameraId, true);
            flash_satus = true;


        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
    public  void  flashOff()
    {
        CameraManager cameraManager = (CameraManager)context.getSystemService(Context.CAMERA_SERVICE);
        try {
            assert cameraManager != null;
            String cameraId = cameraManager.getCameraIdList() [0];
            cameraManager.setTorchMode(cameraId, false);
            flash_satus = false;


        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }
    public boolean isFlash_satus() {
        return flash_satus;
    }

}
