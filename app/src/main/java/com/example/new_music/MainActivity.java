package com.example.new_music;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
        // Some permissions have been granted
        // ...

        Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();

        getData();
    }

    private void getData() {

        String[] projection = new String[]
                {
                        MediaStore.Audio.Media._ID,
                        MediaStore.Audio.Media.SIZE,
                        MediaStore.Audio.Media.DATE_MODIFIED,
                        MediaStore.Audio.Media.BUCKET_DISPLAY_NAME,
                        MediaStore.Audio.Media.DISPLAY_NAME

                };
        Uri contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        Cursor cursor = getContentResolver().query(contentUri,projection,null,null,null);

        if (cursor !=null){
            cursor.moveToPosition(0);
        
        }

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
        // Some permissions have been denied
        // ...
        Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();

    }

}
