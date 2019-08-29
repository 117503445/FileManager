package com.t117503445.filemanager;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import  android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Toast.makeText(this, "Backup", Toast.LENGTH_SHORT).show();
        String time=new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        File backup=new File(Environment.getExternalStorageDirectory(),"backup-"+time);
        if(!backup.exists()){
            backup.mkdir();
        }
        for(String s : backupStrings ){
            File source=new File(Environment.getExternalStorageDirectory()+"/"+s);
            File dest=new File(backup,source.getName());
            if(source.exists()&&(!dest.exists())){
                source.renameTo(dest);
            }
        }
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
        Toast.makeText(this, "Clean", Toast.LENGTH_SHORT).show();
        File file = Environment.getExternalStorageDirectory();
        for(File f:file.listFiles()){
             Log.d("",f.getName());

            if(Arrays.asList(badStrings).contains(f)){
                if(f.isFile()){
                    f.delete();
                }else{
                    RecursionDeleteFile(f);
                }
            }
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

    private static String[] backupStrings={
            "DCIM"
            ,"Tencent/MicroMsg/WeiXin"
            ,"Pictures"
            ,"Tencent/Tim_Images"
    };



    private static String[] badStrings ={
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
            ,"MiMarket"
            ,"com.tencent.tim"
            ,"tbs"
            ,"msc"
            ,"com.sf.activity"
            ,"com.tencent.gamehelper.pg"
            ,"WechatXposed"
            ,"browser"
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
            ,"_7ServiceRecAckFromServer.txt"
            ,".ColombiaMedia"
            ,".zp"
            ,"WisdomTreeforteacher"
            ,".com.taobao.dp"
            ,"com.cu.rsp"
            ,"UCDownloads"
            ,"5A968A4B377F25ED0A1FD3C67B0CEE31"
            ,"CardEmulator"
            ,".AOE"
            ,"storage"
            ,"wifi_config.log"
            ,".534cc757"
            ,"download_info"
            ,"WisdomTree"
            ,"unitType"
            ,"..ccdid"
            ,"libs"
            ,".Android"
            ,"log"
            ,"geetest"
            ,"chaoxing"
            ,".UTSystemConfig"
            ,"TMRI_12123"
            ,"MQ"
            ,"txrtmp"
            ,"userexperience"
            ,"GDTDOWNLOAD"
            ,"mucang"
            ,".x_o_b_d"
            ,".tts"
            ,".BD_SAPI_CACHE"
            ,"deviceId.txt"
            ,".mfw"
            ,"SmsContactsBackup"
            ,"..ccvid"
            ,"tieba"
            ,".iapppay"
            ,"mipush"
            ,"SpeakerData48.pcm"
            ,"com.tencent.tmgp.sgame"
            ,"_5ServiceRecAckFromSdk2.txt"
            ,"moji_light"
            ,"QQBrowser"
            ,"._android.dat"
            ,".mtacc"
            ,"wpkFlowLog.txt"
            ,"qmt"
            ,"Vgtime"
            ,"QQXposed"
            ,".n_b"
            ,"Panasonic"
            ,"_1ServiceAckToServer.txt"
            ,"FileDownloader"
            ,"wwise_cfg.txt"
            ,"sysdata"
            ,"AllenVersionPath"
            ,"wpk_uploading_fail"
            ,"baidu"
            ,".n_a"
            ,".tbs"
            ,"XiaoJi"
            ,"weishi_yt_model"
            ,".zzz"
            ,"qpython"
            ,"emlibs"
            ,"Music"
            ,"com.bilibili.comic"
            ,"amap"
            ,"JDIM"
            ,"_6ServiceRecAckFromSdk3.txt"
            ,".DataStorage"
            ,"config_system_switchs.txt"
            ,"alipay"
            ,"Pindd"
            ,".gs_file"
            ,".wk"
            ,"xzdz"
            ,"._driver.dat"
            ,".vivo"
            ,".ngdslog"
            ,"OpenMobileAPI"
            ,"setup"
            ,"sitemp"
            ,".sys.log"
            ,"Quark"
            ,"msc"
            ,"wismcp"
            ,".n_c"
            ,"iapppay"
            ,".mg"
            ,"iApp"
            ,".gs_fs0"
            ,"_0ServerSendToService.txt"
            ,"OSSLog"
            ,"wpk_uploading_ok"
            ,"at"
            ,"accmeta_vod"
            ,"com.bilibili.qing"
            ,"SpeakerData2.pcm"
            ,"Mob"
            ,"mfcache"
            ,"mobilestat_info"
            ,"muzhiwan"
            ,"QTAudioEngine"
            ,".g_b_d_v"
            ,"system"
            ,"Xiaomi"
            ,".jds"
            ,"FusionApp"

    };

}
