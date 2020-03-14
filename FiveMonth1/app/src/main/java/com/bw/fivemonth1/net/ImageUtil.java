package com.bw.fivemonth1.net;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.fivemonth1.App;
import com.bw.fivemonth1.R;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 16:07
 * @Description: 用途：完成特定功能
 */
public class ImageUtil {
    private static ImageUtil instance;
    private ImageUtil(){

    }
    public static ImageUtil getInstance(){
        if (instance == null) {
            synchronized (ImageUtil.class){
                if (instance == null) {
                    instance = new ImageUtil();
                }
            }
        }
        return instance;
    }

    public void setImg(String path, ImageView iv){
        Glide.with( App.context )
                .load( path )
                .error( R.mipmap.ic_launcher )
                .placeholder( R.mipmap.ic_launcher_round )
                .into( iv );
    }
}
