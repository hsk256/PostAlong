package com.postalong.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.postalong.R;
import com.postalong.base.Constants;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 基础工具类
 * 2015年7月
 */
public class BaseUtils {
    private static int[] swipeRefreshColors;

    public static Context mApplicationContent;

    public static void initialize(Application app) {
        mApplicationContent = app.getApplicationContext();
    }

    public static void Toast(String text) {
        if (mApplicationContent != null) {
            Toast.makeText(mApplicationContent, text, Toast.LENGTH_SHORT).show();
        }
    }

    public static void Toast(int stringId) {
        if (mApplicationContent != null) {
            Toast.makeText(mApplicationContent, stringId, Toast.LENGTH_SHORT).show();
        }
    }

    public static void ToastLong(String text) {
        if (mApplicationContent != null) {
            Toast.makeText(mApplicationContent, text, Toast.LENGTH_LONG).show();
        }
    }

    public static String getString(int stringId) {
        return mApplicationContent.getString(stringId);
    }

    /**
     * 获取性别图片数组
     *
     * @param blankImg 是否拥有空白的那一套
     * @return 图片数组
     */
    public static int[] genderIconArr(boolean blankImg) {
        TypedArray ar = mApplicationContent.getResources().obtainTypedArray(blankImg ? R.array.data_gender_img_2 : R.array.data_gender_img);
        int len = ar.length();
        int[] genderIcons = new int[len];
        for (int i = 0; i < len; i++) {
            genderIcons[i] = ar.getResourceId(i, 0);
        }
        ar.recycle();
        return genderIcons;
    }

    /**
     * 获取下拉刷新的颜色数组
     * 用法：mSwipeRefreshLayout.setColorSchemeColors(BaseUtils.getRefreshColors())
     *
     * @return 颜色数组
     */
    public static int[] getRefreshColors() {
        if (swipeRefreshColors == null) {
            swipeRefreshColors = mApplicationContent.getResources().getIntArray(R.array.color_refresh_layout);
        }
        return swipeRefreshColors;
    }

    /**
     * 为传入的控件为设置为enable或者unable
     *
     * @param enable 是否可用
     * @param views  控件列表
     */
    public static void setEnable(boolean enable, View... views) {
        for (View view : views) {
            if (view != null) {
                view.setEnabled(enable);
            }
        }
    }

    /**
     * 将模板文字里的%d换成文本
     *
     * @param strTemplate 模板，比如：您还可以输入%d个字
     * @param content     要换成的文字
     * @return 格式化后的文本
     */
    public static String replaceContent(String strTemplate, String content) {
        return strTemplate.replace("%d", content);
    }

    /**
     * 将递送人评价分值转换成文字说明
     *
     * @param score 递送人评分值
     * @return 对应的文字说明
     */
    public static String scoreToText(double score) {
        if (score <= 1) {
            return getString(R.string.comment_bad);
        } else if (1 < score && score <= 2) {
            return getString(R.string.comment_general);
        } else if (2 < score && score <= 4) {
            return getString(R.string.comment_satisfaction);
        } else if (4 < score && score <= 5) {
            return getString(R.string.comment_very);
        } else {
            return getString(R.string.comment_very_well);
        }
    }

    /**
     * 根据当前系统语言环境，新建一个时间格式器。
     *
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat newLocaleDateFormat() {
        Locale locale = mApplicationContent.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
//        System.out.println("language = " + language + ", country = " + locale.getCountry());
        if (language.endsWith("zh")) {
            return new SimpleDateFormat(Constants.TIME_FORMAT_CHINA_NO_SECOND);
        } else {
            return new SimpleDateFormat(Constants.TIME_FORMAT_NORTH_AMERICA_NO_SECOND);
        }
    }

    /**
     * 获取 yy-MM-dd HH:mm:ss
     *
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat newSimpleDateFormat() {
        return new SimpleDateFormat(Constants.TIME_FORMAT_SAVE_ALL);
    }

    /**
     * 取APP版本号（参照AndroidManifest.xml）
     */
    public static int getAppVersionCode() {
        try {
            if (mApplicationContent != null) {
                PackageManager mPackageManager = mApplicationContent.getPackageManager();
                PackageInfo _info = mPackageManager.getPackageInfo(mApplicationContent.getPackageName(), 0);
                return _info.versionCode;
            } else {
                return 0;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    /**
     * 取APP版本名（参照AndroidManifest.xml）
     */
    public static String getAppVersionName() {
        try {
            PackageManager mPackageManager = mApplicationContent.getPackageManager();
            PackageInfo _info = mPackageManager.getPackageInfo(mApplicationContent.getPackageName(), 0);
            return _info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /**
     * 使得密码可见
     *
     * @param canSee    true:可以查看密码
     * @param editText  密码框
     * @param imageView 查看密码图标
     */
    public static void pwdCanSee(boolean canSee, EditText editText, ImageView imageView) {
        if (!canSee) {
            editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            editText.setTypeface(Typeface.SANS_SERIF);
            imageView.setImageResource(R.mipmap.icon_eye);
        } else {
            editText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            editText.setTypeface(Typeface.SANS_SERIF);
            imageView.setImageResource(R.mipmap.icon_eye_open);
        }
        // 将光标放到最后一位
        editText.setSelection(editText.getText().toString().length());
    }

    /**
     * dp转px
     */
    public static int dip2px(float dpValue) {
        final float scale = mApplicationContent.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dp
     */
    public static int px2dip(float pxValue) {
        final float scale = mApplicationContent.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 取屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        DisplayMetrics dm = mApplicationContent.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 打印（请求参数）map
     *
     * @param requestMap
     */
    public static void printMap(Map<String, String> requestMap) {
        Set<Map.Entry<String, String>> entries = requestMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("请求参数 key=" + entry.getKey() + ", value=" + entry.getValue());
        }
    }

    /**
     * 取屏幕高度
     *
     * @return
     */
    public static int getScreenHeight() {
        DisplayMetrics dm = mApplicationContent.getResources().getDisplayMetrics();
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, sbar = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = mApplicationContent.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
        }

        return dm.heightPixels - sbar;
    }

    /**
     * 关闭输入法
     *
     * @param act
     */
    public static void closeInputMethod(Activity act) {
        View view = act.getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 判断应用是否处于后台状态
     *
     * @return
     */
    public static boolean isBackground() {
        ActivityManager am = (ActivityManager) mApplicationContent.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(mApplicationContent.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 产生不重复的随机数
     *
     * @param count 产生随机数的个数
     * @param range 范围:0—range
     */
    public static int[] getRandomNumbers(int count, int range) {
        int randomCount = count;
        int randomRange = range;
        int[] intRet = new int[randomCount];
        int intRd = 0; //存放随机数
        int number = 0; //记录生成的随机数个数
        int flag = 0; //是否已经生成过标志
        while (number < randomCount) {
            Random rdm = new Random(System.currentTimeMillis());
            intRd = Math.abs(rdm.nextInt()) % (randomRange + 1);
            for (int i = 0; i < number; i++) {
                if (intRet[i] == intRd) {
                    flag = 1;
                    break;
                } else {
                    flag = 0;
                }
            }
            if (flag == 0) {
                intRet[number] = intRd;
                number++;
            }
        }
        return intRet;
    }


    /**
     * 公有的获取用户姓名和电话的入口
     *
     * @param data
     * @return
     */
    public static HashMap<String, String> getUserNameAndPhone(Activity activity, int resultCode, Intent data) {
            if (resultCode == Activity.RESULT_OK) {
            try {
                /**
                 * ContentProvider展示数据类似一个单个数据库表
                 * ContentResolver实例带的方法可实现找到指定的ContentProvider并获取到ContentProvider的数据
                 */
                ContentResolver reContentResolverol = activity.getContentResolver();
                //URI,每个ContentProvider定义一个唯一的公开的URI,用于指定到它的数据集
                Uri contactData = data.getData();
                //查询就是输入URI等参数,其中URI是必须的,其他是可选的,如果系统能找到URI对应的ContentProvider将返回一个Cursor对象.
                Cursor cursor = activity.managedQuery(contactData, null, null, null, null);
                cursor.moveToFirst();
                //获得DATA表中的名字
                String userName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                //条件为联系人ID
                String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                // 获得DATA表中的电话号码，条件为联系人ID,因为手机号码可能会有多个
                Cursor phone = reContentResolverol.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
                if (phone != null) {
                    String userPhone = "";
                    while (phone.moveToNext()) {
                        userPhone = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("userName", userName);
                    hashMap.put("userPhone", userPhone);
                    return hashMap;
                } else {
                    BaseUtils.ToastLong("无法从系统通信录获取信息，请手动填写");
                }
            } catch (Exception e) {
                e.printStackTrace();
                BaseUtils.Toast("无法从系统通信录获取信息，请查询读取联系人权限是否被禁止");
            }
        }
        return null;

    }

    /**
     * 是否安装了某款软件
     *
     * @param packageName 包名：com.qihoo360.mobilesafe
     * @return
     */
    public static boolean isAppInstalled(String packageName) {
        PackageInfo packageInfo;
        try {
            packageInfo = mApplicationContent.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        if (packageInfo == null) {
//            System.out.println("没有安装");
            return false;
        } else {
//            System.out.println("已经安装");
            return true;
        }
    }
}
