# SDRLibrary
用于sdr开发APP集成的library，封装了一些基础的UI组件以供APP使用
## gradle
project
```
allprojects {
    repositories {
        ...
        ...
        ...
        maven {
            url "https://jitpack.io"
        }
    }
}
```

module
```
implementation 'com.github.HyfSunshine:SDRLibrary:last-release'
```
### 已依赖
```
// 必须依赖的库
// rx java     rx android
compile 'io.reactivex.rxjava2:rxandroid:2.1.0'
compile 'io.reactivex.rxjava2:rxjava:2.2.2'
// retrofit2  已依赖OKHttp3
compile 'com.squareup.retrofit2:retrofit:2.4.0'
compile 'com.squareup.retrofit2:converter-gson:2.4.0'
compile 'com.squareup.retrofit2:adapter-rxjava2:2.4.0'
compile 'com.squareup.okhttp3:logging-interceptor:3.9.1'  // 打印log的interceptor

// other
// glide 变换
compile('jp.wasabeef:glide-transformations:3.3.0') {
    exclude group: 'com.android.support'
}
// material dialog
compile('com.afollestad.material-dialogs:core:0.9.6.0')
// okdownload
// core
compile 'com.liulishuo.okdownload:okdownload:1.0.4'
// provide sqlite to store breakpoints
compile 'com.liulishuo.okdownload:sqlite:1.0.4'
// provide okhttp to connect to backend
// and then please import okhttp dependencies by yourself
compile 'com.liulishuo.okdownload:okhttp:1.0.4'

// logger
compile 'com.orhanobut:logger:2.2.0'

// 图片查看 缩放
compile 'com.davemorrissey.labs:subsampling-scale-image-view:3.10.0'

// Android 6.0授权
compile 'com.github.tbruyelle:rxpermissions:0.10.2'
```

## 使用
### 初始化
在application中
```java
SDRLibrary.getInstance().init(application, BuildConfig.DEBUG);
```

### Base
- BaseActivity
    沉浸式状态栏的activity
- BaseFragment
    懒加载fragment，

    ```java
    protected void onFragmentFirstVisible() {

    }
    ```
    第一次加载的时候可以在该方法中获取数据。

    推荐在PagerAdapter中的
    ``` java
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
    ```
    方法中什么都不用操作

## MVP

- AbstractPresenter

- AbstractView

## Support

- update app 检测、更新APP
    ```java
    new RxPermissions(activity)
                    .request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                    .subscribe(granted -> {
                        if (granted) {
                            UpdateAppManager.checkUpdate(activity, "bpm", 1, AppPath.getFilePath(), showDialog, needUpdateListener);
                        } else {

                        }
                    });
    ```

- weather 获取天气数据
    ```java
    new WeatherObservable().getWeatherData()
    ```

## UI

- dialog

    关键类：SDRLoadingDialog、SDRSimpleDialog

- popupwindow

    关键类：PopWindowMenuHelper

- toast

   关键类：ToastSimple、ToastTop

- tree

    关键类：TreeNode、TreeNodeRecyclerAdapter

- 下载图片

    关键类：RxSaveImage

## Util

- CommonUtil

    | 方法名 | 作用 |
    | ------ | ------ |
    | getPackageInfo(Context context) | 获取packageinfo信息，常用于获取版本号、版本名称 |
    | dip2px(Context context, float dpValue) | dp转px |
    | isNetworkConnected(Context context) | 检测网络是否可用 |
    | installApk(Context context, File file) | 安装应用，适配Android 7.0+ |
    | getScreenHeight(Activity activity) | 获取屏幕高度 |
    | getScreenWidth(Activity activity) | 获取屏幕宽度 |
    | setTransformBg(float bgAlpha, Activity activity) | 设置activity阴影，适配华为。黑色透明一般取0.6f，正常设置1.0f |
    | viewImage(Context context, boolean isLocal, Object image) | 查看单张图片 |
    | viewImageList(Context context, boolean isLocal, int position, List imageList) | 查看多张图片 |

- HttpUtil

    | 方法名 | 作用 |
    | ------ | ------ |
    | clearDomainAddress(String domainAddress) | 去掉请求协议头和端口，即纯IP。如 http://192.168.0.1:8888/ 转化为 192.168.0.1|

- ToastTopUtil
- ToastUtil