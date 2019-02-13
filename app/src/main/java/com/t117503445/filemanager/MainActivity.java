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
        
    }
    /**
     * 递归删除文件和文件夹
     * @param file
     *要删除的根目录
     */
    public static void RecursionDeleteFile(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] childFile = file.listFiles();
            if (childFile == null || childFile.length == 0) {
                file.delete();
                return;
            }
            for (File f : childFile) {
                RecursionDeleteFile(f);
            }
            file.delete();
        }
    }

    public void BtnClean_Click(View v) {
        File file = Environment.getExternalStorageDirectory();
        for(File f:file.listFiles()){
            for(String s:BadStrings){
                if(f.getName().equals(s)){
                    if(f.isFile()){
                         f.delete();
                    }else{
                        RecursionDeleteFile(f);
                    }
                }
            }
        }
    }

    public String ReadAllText(String path) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), path);
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
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    /**
     * Checks if the app has permission to write to device storage
     * If the app does not has permission then the user will be prompted to
     * grant permissions
     *
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
    private static String[] BadStrings={
            "weishi_yt_model"
            ,".tbs"
            ,"QQBrowser"
            ,"tv.danmaku.bili"
            ,"Documents"
            ,"Mob"
            ,"speechsdk"
            ,"hwrec"
            ,"wismcp"
            ,"mipush"
            ,"amap"
            ,".UTSystemConfig"
            ,".DataStorage"
            ,".mtacc"
            ,"MIUI"
            ,"alipay"
            ,".chartboost"
            ,"QQXposed"
            ,"360"
            ,".idm"
            ,".transportext"
            ,".com.taobao.dp"
            ,"libs"
            ,"system"
            ,".dlprovider"
            ,"baidu"
            ,"douban"
            ,".WL"
            ,"Quark"
            ,".jds"
            ,"sysdata"
            ,"data"
            ,"com.miui.voiceassist"
            ,".SystemConfig"
            ,".im"
            ,"PimMsgCache"
            ,"MIWiFi"
            ,"WoodenLetter"
            ,"DuoKan"
            ,".BD_SAPI_CACHE"
            ,".zp"
            ,"backup"
            ,"com.netease.cloudmusic"
            ,"TWRP"
            ,".Rcs"
            ,"JuphoonService"
            ,"miad"
            ,"ramdump"
            ,".qmt"
            ,"WechatChatroomHelper"
            ,"MiMarket"
            ,"com.tencent.tim"
            ,"tbs"
            ,"msc"
            ,"com.sf.activity"
            ,"com.tencent.gamehelper.pg"
            ,"WechatXposed"
            ,"browser"
            ,"备份"
            ,".g_m_o_bs"
            ,".g_b_d_v"
            ,"MifareClassicTool"
            ,"userexperience"
            ,".irsmonitorsdk"
            ,"QTAudioEngine"
            ,"sjly"
            ,".sys.log"
            ,".um"
            ,".uxx"
            ,".cc"
            ,".a.dat"
            ,".vivo"
            ,"UMETrip"
            ,".tcookieid"
            ,"mishop"
            ,"tmp"
            ,".com.android.providers.downloads.ui"
            ,"dctp"
            ,"did"
            ,".uct"
            ,"FSaCdeR2e"
            ,"com.xfun"
            ,"local"
            ,"youku"
            ,"AndroLua"
            ,"flywheel"
            ,"com"
            ,"com.tencent.mobileqq"
            ,".td-3"
            ,"SmartHome"
            ,".l_x_b_d"
            ,"Mopon_ZYGJ_Cache"
            ,"ctrip.android.view"
            ,"qqmusic"
            ,"Catfish"
            ,"tmsdual_shark_mq.bat"
            ,"Subtitles"
            ,"hawaii"
            ,"hawaii_log"
            ,"hawii"
            ,"qt"
            ,"bill.txt"
            ,"tencentmapsdk"
    };

}
