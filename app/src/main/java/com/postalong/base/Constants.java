package com.postalong.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;


import java.io.File;

/**
 * 系统常用常量
 * Created by Heyiyong on 2015/7/3.
 */
public class Constants {
    public static final boolean TEST_STATUS = true;//默认开启测试人员工具箱

    /**
     * 触发主页和消息页时间
     */
    public static final long messageUpdateTime = 30 * 1000;
    /**
     * 主页和消息也定时请求数据
     */
    public static final long messagePollTime = 20 * 1000;

    /**
     * 常用默认值
     */
    public static final float MAP_ZOOM = 13f;//地图默认放大比例
   // public static final LatLng DEFAULT_LAT_LNG = new LatLng(45.25, -75.43);//地图没有定位好的时候，默认位置：加拿大首都渥太华

    /**
     * 服务器返回值状态码
     */
    public static final int RES_SUCCESS = 1;//返回成功
    public static final int RES_FAIL = -1;//返回失败
    public static final int RES_RECEIVE = 2; //该单已被接
    public static final int RES_BUSY = 0;//业务操作失败
    public static final int RES_GO_LOGIN = -99;//前往登录界面（需要重新获取token）

    public static final int RES_SYSTEM_ERROR = -100;//服务器有错
    public static final int RES_NEED_TOKEN = -101;//需要验证token
    public static final int RES_DATA_ERROR = -102;//业务数据有误

    /**
     * SharedPreference
     */
    public static final String SP_JSESSIONID = "JSessionId";//服务器的对每个客户端的身份标记
    public static final String SP_FIRST_IN = "setting_first_in";//第一次加载程序
    public static final String SP_LATEST_VERSION_CODE = "latest_version"; // 最新版本号
    public static final String SP_SOUND = "setting_sound";//声音
    public static final String SP_VIBRATE = "setting_vibrate";//震动
    public static final String SP_PUSH = "setting_push";//推送消息
    public static final String SP_LAST_CUR_JWD = "last_current_jwd";//上次定位的经纬度
    public static final String SP_LAST_CUR_ADDR = "last_current_address";//上次定位的位置（国家省市县，不包含街道）
    public static final String SP_LAST_LOGIN_PHONE = "last_login_phone";//上次登录的手机号

    public static final String SP_ACCOUNT_HEADPIC = "account_headPic";//个人信息 - 头像地址
    public static final String SP_ACCOUNT_PHONE = "account_phone";//个人信息——手机号
    public static final String SP_ACCOUNT_EMAIL = "account_email";//个人信息——邮箱
    public static final String SP_ACCOUNT_FIRST_NAME = "account_first_name";//个人信息——first name
    public static final String SP_ACCOUNT_FAMILY_NAME = "account_family_name";//个人信息——family name
    public static final String SP_ACCOUNT_P_TITLE = "account_p_title";//个人信息——头衔
    public static final String SP_ACCOUNT_NATION = "account_nation";//个人信息——国家
    public static final String SP_ACCOUNT_SEX = "account_sex";//个人信息——性别
    public static final String SP_ACCOUNT_DELIVER = "account_deliver";//个人信息——是否为递送人
    public static final String SP_ACCOUNT_IMG_WALL = "account_wall_img";//个人信息——墙壁图纸（本地保存即可，无需后台保存）
    public static final String SP_ACCOUNT_SET_PAY = "account_set_pay";//个人信息——setPay（本地保存即可，无需后台保存）
    public static final String SP_DRAWER_NOTICE_COUNT_SEND = "identity";//左侧导航——发单的数量
    public static final String SP_DRAWER_NOTICE_COUNT_RECEIVE = "identity";//左侧导航——接单的数量
    public static final String SP_MESSAGE_REQUEST_TIMESTAMP = "message_timestamp";//消息请求时间戳
    public static final String SP_ACCOUNT_BALANCE = "account_balance";//账户余额//退出时需要清空
    public static final String SP_TEST_CURRENT_SERVER = "test_current_server";//测试专用：当前选择的服务器

    /**
     * 数据库
     */
    public static final String DB_SETTING_KEY_TOKEN = "token";//数据库Setting表的token的key
    public static final String DB_SETTING_MUST_UPDATE_APP = "must_update_app";//是否必须更新程序

    /**
     * 定位相关
     */
    public static final String LOCATION = "location";
    public static final String LOCATION_ACTION = "locationAction";
    public static final long LOCATION_INTERVAL = 3 * 1000; // 订单列表重新定位的时间间隔
    public static final long LOCATE_NETWORK_FAIL_TIME = 4 * 1000; // 订单列表判定为定位失败的时间长度（网络定位)
    public static final long LOCATE_GOOGLE_FAIL_TIME = 10 * 1000; // 订单列表判定为定位失败的时间长度（网络定位、Google定位）

    /**
     * 身份验证模块返回值
     */
    public static final int RES_LOGIN_PWD_FAIL = -1;//手机号或者密码不正确
    public static final int RES_LOGIN_FROZEN = -2;//账号已冻结
    public static final int RES_LOGIN_TIMES_REFUSE = -3;//账号已冻结

    /**
     * Universal-Image-Loader的显示图片常量
     */
//    public static final DisplayImageOptions displayImageOptions = //显示图片的配置
//            new DisplayImageOptions.Builder()
//                    .showImageOnLoading(R.drawable.icon_loading)
//                    .showImageOnFail(R.mipmap.icon_error)
//                    .cacheInMemory(true)
//                    .cacheOnDisk(true)
//                    .bitmapConfig(Bitmap.Config.RGB_565)
//                    .build();

    /**
     * 上传图片相关
     */
    public static File SD_CARD_CACHE_DIR;//待上传图片缓存地址（SD卡） SD卡上包名的files文件夹

    /*时间展现格式*/
    public static final String TIME_FORMAT_NORTH_AMERICA_NO_SECOND = "MM/dd/yyyy HH:mm";//北美习惯：美国、加拿大
    public static final String TIME_FORMAT_CHINA_NO_SECOND = "yyyy-MM-dd HH:mm";//中国习惯
    public static final String TIME_FORMAT_SAVE_ALL = "yyyy-MM-dd HH:mm:ss";//后台保存格式



    /**
     * 初始化值
     *
     * @param context 应用程序上下文
     */
    public static void init(Context context) {
        Constants.SD_CARD_CACHE_DIR = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    }

}
