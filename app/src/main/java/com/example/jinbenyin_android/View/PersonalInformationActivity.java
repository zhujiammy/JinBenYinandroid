package com.example.jinbenyin_android.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jinbenyin_android.R;
import com.example.jinbenyin_android.Tools.MyBottomSheetDialog;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.InvokeParam;
import org.devio.takephoto.model.TContextWrap;
import org.devio.takephoto.model.TResult;
import org.devio.takephoto.permission.InvokeListener;
import org.devio.takephoto.permission.PermissionManager;
import org.devio.takephoto.permission.TakePhotoInvocationHandler;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonalInformationActivity extends AppCompatActivity implements View.OnClickListener,TakePhoto.TakeResultListener, InvokeListener {

    @BindView(R.id.take_photo)
    RelativeLayout take_photo;
    @BindView(R.id.profile_image)
    ImageView profile_image;
    @BindView(R.id.account_lin)
    RelativeLayout account_lin;//账号管理
    @BindView(R.id.moblie_phone_lin)
    RelativeLayout moblie_phone_lin;//修改手机号
    public TakePhoto takePhoto;
    public Intent intent;
    public File file;
    public InvokeParam invokeParam;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getTakePhoto().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalinformation_xml);
        ButterKnife.bind(this);
        initEvent();
    }

    public void initEvent(){
        take_photo.setOnClickListener(this);
        account_lin.setOnClickListener(this);
        moblie_phone_lin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == take_photo){
            final MyBottomSheetDialog dialog = new MyBottomSheetDialog(this);
            View box_view = LayoutInflater.from(this).inflate(R.layout.takephoto,null);
            dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);  //←重点在这里，来，都记下笔记
            dialog.setContentView(box_view);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();
            TextView camera = (TextView) box_view.findViewById(R.id.camera);
            TextView Album = (TextView) box_view.findViewById(R.id.Album);
            TextView cancel_btn = (TextView) box_view.findViewById(R.id.cancel_btn);
            View.OnClickListener listener = new View.OnClickListener() {
                public void onClick(View v) {

                    File file = new File(getExternalCacheDir(), System.currentTimeMillis() + ".png");
                    Uri uri = Uri.fromFile(file);
                    int size = Math.min(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
                    CropOptions cropOptions = new CropOptions.Builder().setOutputX(size).setOutputX(size).setWithOwnCrop(false).create();
                    switch (v.getId()) {
                        //相机
                        case R.id.camera:
                            takePhoto.onPickFromCaptureWithCrop(uri, cropOptions);
                            break;
                        //相册
                        case R.id.Album:
                            //相机获取照片并剪裁
                            takePhoto.onPickFromGalleryWithCrop(uri, cropOptions);
                            break;
                        //取消
                        case R.id.cancel_btn:
                            dialog.dismiss();
                            break;

                    }
                    dialog.dismiss();
                }
            };

            cancel_btn.setOnClickListener(listener);
            camera.setOnClickListener(listener);
            Album.setOnClickListener(listener);
        }

        if(v == account_lin){
            intent = new Intent(this,AccountManagementActivity.class);
            startActivity(intent);
        }
        if(v == moblie_phone_lin){
            intent = new Intent(this,MobliePhoneAcitivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //以下代码为处理Android6.0、7.0动态权限所需
        PermissionManager.TPermissionType type=PermissionManager.onRequestPermissionsResult(requestCode,permissions,grantResults);
        PermissionManager.handlePermissionsResult(this,type,invokeParam,this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void takeSuccess(TResult result) {
        String iconPath = result.getImage().getOriginalPath();
        file = new File(iconPath);
        Glide.with(this).load(iconPath).into(profile_image);
    }

    @Override
    public void takeFail(TResult result, String msg) {

    }

    @Override
    public void takeCancel() {

    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {  PermissionManager.TPermissionType type=PermissionManager.checkPermission(TContextWrap.of(this),invokeParam.getMethod());
        if(PermissionManager.TPermissionType.WAIT.equals(type)){
            this.invokeParam=invokeParam;
        }
        return type;
    }
    /** * 获取TakePhoto实例 * @return */
    public TakePhoto getTakePhoto(){
        if (takePhoto==null){
            takePhoto= (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this,this));
        }
        //设置压缩规则，最大500kb
        takePhoto.onEnableCompress(new CompressConfig.Builder().setMaxSize(500 * 1024).create(), true);
        return takePhoto;
    }

}
