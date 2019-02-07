package com.t117503445.filemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.os.Environment;
import android.Manifest;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.content.pm.PackageManager;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verifyStoragePermissions(this);


    }

    public void Btntest_Click(View v) {
        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();
        System.out.println("Click");
    }

    public void BtnFile_Click(View v){
        Toast.makeText(this, "BtnFile_Click", Toast.LENGTH_SHORT).show();
        String s=ReadAllText("test.txt");
        System.out.println(s);

    }

    public String ReadAllText(String path){
        try {
            File file = new File(Environment.getExternalStorageDirectory(),
                    path);
            FileInputStream is = new FileInputStream(file);
            byte[] b = new byte[is.available()];
            is.read(b);
            String result = new String(b);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }



    // Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE };
    /**
     * Checks if the app has permission to write to device storage
     * If the app does not has permission then the user will be prompted to
     * grant permissions
     * @param activity
     */
    public static void verifyStoragePermissions(Activity activity) {
// Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
// We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }


}
