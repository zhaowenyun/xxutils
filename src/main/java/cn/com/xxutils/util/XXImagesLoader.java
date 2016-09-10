package cn.com.xxutils.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * Created by Administrator on 2016/2/22.
 */
public class XXImagesLoader {
    private DisplayImageOptions options;
    private ImageLoader imageLoader = null;

    /**
     * 初始化载入的参数
     *
     * @param c
     * @param imageloderOptions     配置参数（可为null）
     * @param isCache               是否缓存
     * @param OnUriNlllImageRes     当将要载入的Uri为空的时候显示的图片资源ID
     * @param OnLoadingImageRes     正在载入中显示的图片资源ID
     * @param OnLoadingImageFailRes 载入失败时显示的图片资源ID
     */
    public XXImagesLoader(Context c, DisplayImageOptions imageloderOptions, boolean isCache, int OnUriNlllImageRes, int OnLoadingImageRes, int OnLoadingImageFailRes) {
        if (imageloderOptions == null) {
            this.options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(OnLoadingImageRes)
                    .showImageForEmptyUri(OnUriNlllImageRes)
                    .showImageOnFail(OnLoadingImageFailRes)
                    .cacheInMemory(isCache)
                    .cacheOnDisk(isCache)
                    .considerExifParams(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .displayer(new RoundedBitmapDisplayer(20))
                    .build();
        } else {
            this.options = imageloderOptions;
        }
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(c));
        Log.d("ImageLoader对象实例化成功：" + imageLoader + "\noptions配置成功:" + options);
    }


    /**
     * 初始化载入的参数
     *
     * @param c
     * @param imageloderOptions     配置参数（可为null）
     * @param isCache               是否缓存
     * @param OnUriNlllDrawable     当将要载入的Uri为空的时候显示的图片
     * @param OnLoadingDrawable     正在载入中显示的图片
     * @param OnLoadingFailDrawable 载入失败时显示的图片
     */
    public XXImagesLoader(Context c, DisplayImageOptions imageloderOptions, boolean isCache, Drawable OnUriNlllDrawable, Drawable OnLoadingDrawable, Drawable OnLoadingFailDrawable) {
        if (imageloderOptions == null) {
            this.options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(OnLoadingDrawable)
                    .showImageForEmptyUri(OnUriNlllDrawable)
                    .showImageOnFail(OnLoadingFailDrawable)
                    .cacheInMemory(isCache)
                    .cacheOnDisk(isCache)
                    .considerExifParams(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
//                    .displayer(new RoundedBitmapDisplayer(20))
                    .build();
        } else {
            this.options = imageloderOptions;
        }
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(c));
        Log.d("ImageLoader对象实例化成功：" + imageLoader + "\noptions配置成功:" + options);
    }

    /**
     * 请求图片
     *
     * @param uri       图片地址
     * @param imageView 显示的ImageView
     */
    public void disPlayImage(String uri, ImageView imageView) {
        imageLoader.displayImage(uri, imageView, this.options);
    }

    /**
     * @param uri             图片地址
     * @param imageView       显示的ImageView
     * @param loadingListener 过程监听器
     */
    public void disPlayImage(String uri, ImageView imageView, ImageLoadingListener loadingListener) {
        imageLoader.displayImage(uri, imageView, this.options, loadingListener);
    }

    /**
     * @param uri                        图片地址
     * @param imageView                  显示的ImageView
     * @param simpleImageLoadingListener 过程监听器
     */
    public void disPlayImage(String uri, ImageView imageView, SimpleImageLoadingListener simpleImageLoadingListener) {
        imageLoader.displayImage(uri, imageView, this.options, simpleImageLoadingListener);
    }

    /**
     * 清除缓存
     */
    public void clearCache() {
        imageLoader.clearDiskCache();
        imageLoader.clearMemoryCache();
    }
}
