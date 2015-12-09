package com.postalong.base;

/**
 * 后台地址请求常量，方便统一管理
 * 日期：2015年7月
 */
public class Api {
    public static final String BASE_URL_CAMPUS = "XX";//校园服务器
    public static final String BASE_URL_AMAZON = "XXX";//亚马逊云服务器
    private static String BASE_URL = BASE_URL_CAMPUS;//当前使用的服务器：默认校园服务器

    /*版本更新*/
    private static String URL_VERSION_CHECK = "api/common/version/check";

    /*auth身份验证部分*/
    private static final String URL_REQUEST_CODE = "api/auth/getDynCode";//注册时通过手机获取验证码
    private static final String URL_REG = "api/auth/reg";//注册
    private static final String URL_LOGIN = "api/auth/login";//登录
    private static final String URL_SEND_TOKEN = "api/auth/activate";//检查token
    private static final String URL_FIND_PWD = "api/auth/findPwd";//忘记密码之校验验证码

    /* 账户信息部分*/
    private static final String URL_ACCOUNT_INFO = "api/account/info";//点击个人头像获取个人信息
    private static final String URL_ACCOUNT_VERIFY = "api/account/updateSet";//账户验证
    private static final String URL_ACCOUNT_EDIT = "api/account/updateSave";//账户资料修改

    private static final String URL_ACCOUNT_HEADUPLOAD = "api/account/setHeadPic";//用户上传头像
    private static final String URL_ACCOUNT_COMMENT = "api/account/evaluateList"; //递送人评价信息
    private static final String URL_ACCOUNT_MODIFY_Pay_Pwd = "api/account/setPayPwd";   //设置支付密码
    private static final String URL_ACCOUNT_MODIFY_LOGIN_PWD = "api/account/setLoginPwd";   //设置登录密码

    private static final String URL_ACCOUNT_VERIFYPAYPWD = "api/account/checkPayPwd";   //验证支付密码

    /*申请递送人相关*/
    private static final String URL_APPLY_DELIVER_INFO = "api/account/applyDeliver";
    private static final String URL_GET_DELIVER_INFO = "api/account/getDeliverInfo";//获取递送人信息

    /*订单相关*/
    private static final String URL_ORDER_DELIVER_LIST = "api/deliver/goodList";//我来送订单接口
    private static final String URL_MY_ORDER_LIST = "api/order/myGoodList";
    private static final String URL_CREATE_ORDER = "api/order/resOrderByGood";

    /*接单*/
    private static final String URL_BARGAIN = "api/deliver/bargain";//接单人不满意价格，点击议价并提交
    private static final String URL_RECEIVE = "api/deliver/receive";//接单操作

    /*发行程*/
    private static final String URL_TRIP_PLAN = "api/trip/send"; //发行程
    private static final String URL_TRIP_PLAN_INFO = "api/trip/getMyTrip"; //获取我的行程信息

    /*用户的历史地址*/
    private static final String URL_GET_HISTORY_ADDRESS_LIST = "api/account/addressList";


    private static final String URL_GOOD_SHOW = "api/order/goodShow";//查看货物详情
    private static final String URL_ORDER_DRAFTS_LIST = "api/order/draftList";//订单草稿列表
    private static final String URL_ORDER_CANCEL = "api/order/cancel";//取消订单
    private static final String URL_ORDER_PICKUP = "api/order/pickUp";//递送人确认取货
    private static final String URL_ORDER_SEND_CODE = "api/order/sendCode";//发送收货码
    private static final String URL_ORDER_CONFIRM_CODE = "api/order/confirmCode";//收货码验证
    private static final String URL_ORDER_EVALUATE = "api/order/evaluate";//订单评价
    private static final String URL_ORDER_DELETE = "api/order/delete";//订单删除
    private static final String URL_ORDER_RELEASE = "api/order/release";//订单发布

    /*议价列表*/
    private static final String URL_BARGAIN_LIST = "api/order/bargainList";
    private static final String URL_BARGAIN_CONFIRM = "api/order/bargainConfirm";
    private static final String URL_BARGAIN_CANCEL = "api/order/bargainCancel";

    /*上传图片*/
    private static final String URL_UPLOAD_IMG = "api/common/file/imgUp";

    /*钱包相关*/
    private static final String URL_WALLET_INFO = "api/wallet/info";//获取钱包基础信息
    private static final String URL_WALLET_ACCOUNT_BALANCE = "api/wallet/money";//获取钱包余额
    private static final String URL_WALLET_MONEYLOG = "api/wallet/moneyLog";//获取钱包余额
    private static final String URL_WALLET_RECHARGE = "api/wallet/recharge";//充值
    private static final String URL_WALLET_WITHDRAW = "api/wallet/withdraw";//提现
    private static final String URL_WALLET_POINT = "api/wallet/point";//获取积分
    private static final String URL_WALLET_POINTLOG = "api/wallet/pointLog";//获取积分日志
    private static final String URL_WALLET_COUPON = "api/wallet/couponGet";//兑换优惠券
    private static final String URL_WALLET_COUPONLIST = "api/wallet/couponList";//获取优惠券列表
    private static final String URL_WALLET_ADD_MONEY_CHANNEL = "api/wallet/addMoneyChannel";//用户新增提现渠道7.10
    private static final String URL_WALLET_GET_MONEY_CHANNEL_LIST = "api/wallet/moneyChannelList";//提现渠道列表获取7.11
    private static final String URL_WALLET_GET_MONEY_CHANNEL_DETAIL = "api/wallet/moneyChannelDetail";//提现渠道详情获取7.12
    private static final String URL_WALLET_DELETE_WITHDRAW_CHANNEL = "api/wallet/delMoneyChannel";//删除绑定的提现渠道7.13

    /*支付相关*/
    private static final String URL_PAY_COUPONLIST = "api/pay/couponList";//订单可用优惠券
    private static final String URL_PAY_CHANNEL = "api/pay/payChannel";//获取支付渠道
    private static final String URL_PAY_ORDER = "api/pay/orderPay";//支付订单
    private static final String URL_PAY_ORDER_INFO = "api/pay/order";//获取支付订单信息5.1
    private static final String URL_PAY_ORDER_MAKE = "api/pay/save";//下订单5.3
    private static final String URL_PAY_PAYPAL_CONFIRM = "api/pay/confirmPaypal";//贝宝验证5.4

    /*消息相关*/
    private static final String URL_MESSAGE_GET_MSG = "api/message/getMsg";//8.1
    private static final String URL_MESSAGE_GET_ORDER_MSG = "api/message/getOrderMsg";//8.2

    /*Custom用户帮助、问题反馈相关*/
    private static  String URL_CUSTOMER_SUGGEST = "api/customer/suggest"; // 提交问题反馈
    private static  String URL_HELP_LIST = "api/help/list"; // 获取帮助数据列表

    //以下五个地址为使用帮助界面 webview需要的后台地址
    public static final String URL_USE_HELP_ITEM_1 = "http://www.baidu.com"; //使用帮助第一个item请求地址
    public static final String URL_USE_HELP_ITEM_2 = "http://www.youku.com";
    public static final String URL_USE_HELP_ITEM_3 = "http://www.163.com/";
    public static final String URL_USE_HELP_ITEM_4 = "http://www.baidu.com";
    public static final String URL_USE_HELP_ITEM_5 = "http://www.baidu.com";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public static String getUrlVersionCheck() {
        return BASE_URL + URL_VERSION_CHECK;
    }

    public static String getUrlRequestCode() {
        return BASE_URL + URL_REQUEST_CODE;
    }

    public static String getUrlReg() {
        return BASE_URL + URL_REG;
    }

    public static String getUrlLogin() {
        return BASE_URL + URL_LOGIN;
    }

    public static String getUrlSendToken() {
        return BASE_URL + URL_SEND_TOKEN;
    }

    public static String getUrlFindPwd() {
        return BASE_URL + URL_FIND_PWD;
    }

    public static String getUrlAccountInfo() {
        return BASE_URL + URL_ACCOUNT_INFO;
    }

    public static String getUrlAccountVerify() {
        return BASE_URL + URL_ACCOUNT_VERIFY;
    }

    public static String getUrlAccountEdit() {
        return BASE_URL + URL_ACCOUNT_EDIT;
    }

    public static String getUrlAccountHeadupload() {
        return BASE_URL + URL_ACCOUNT_HEADUPLOAD;
    }

    public static String getUrlAccountComment() {
        return BASE_URL + URL_ACCOUNT_COMMENT;
    }

    public static String getURL_ACCOUNT_MODIFY_Pay_Pwd() {
        return BASE_URL + URL_ACCOUNT_MODIFY_Pay_Pwd;
    }

    public static String getUrlAccountModifyLoginPwd() {
        return BASE_URL + URL_ACCOUNT_MODIFY_LOGIN_PWD;
    }

    public static String getUrlAccountVerifypaypwd() {
        return BASE_URL + URL_ACCOUNT_VERIFYPAYPWD;
    }

    public static String getUrlApplyDeliverInfo() {
        return BASE_URL + URL_APPLY_DELIVER_INFO;
    }

    public static String getUrlGetDeliverInfo() {
        return BASE_URL + URL_GET_DELIVER_INFO;
    }

    public static String getUrlOrderDeliverList() {
        return BASE_URL + URL_ORDER_DELIVER_LIST;
    }

    public static String getUrlMyOrderList() {
        return BASE_URL + URL_MY_ORDER_LIST;
    }

    public static String getUrlCreateOrder() {
        return BASE_URL + URL_CREATE_ORDER;
    }

    public static String getUrlBargain() {
        return BASE_URL + URL_BARGAIN;
    }

    public static String getUrlReceive() {
        return BASE_URL + URL_RECEIVE;
    }

    public static String getUrlTripPlan() {
        return BASE_URL + URL_TRIP_PLAN;
    }

    public static String getUrlTripPlanInfo() {
        return BASE_URL + URL_TRIP_PLAN_INFO;
    }

    public static String getUrlGetHistoryAddressList() {
        return BASE_URL + URL_GET_HISTORY_ADDRESS_LIST;
    }

    public static String getUrlGoodShow() {
        return BASE_URL + URL_GOOD_SHOW;
    }

    public static String getUrlOrderDraftsList() {
        return BASE_URL + URL_ORDER_DRAFTS_LIST;
    }

    public static String getUrlOrderCancel() {
        return BASE_URL + URL_ORDER_CANCEL;
    }

    public static String getUrlOrderPickup() {
        return BASE_URL + URL_ORDER_PICKUP;
    }

    public static String getUrlOrderSendCode() {
        return BASE_URL + URL_ORDER_SEND_CODE;
    }

    public static String getUrlOrderConfirmCode() {
        return BASE_URL + URL_ORDER_CONFIRM_CODE;
    }

    public static String getUrlOrderEvaluate() {
        return BASE_URL + URL_ORDER_EVALUATE;
    }

    public static String getUrlOrderDelete() {
        return BASE_URL + URL_ORDER_DELETE;
    }

    public static String getUrlOrderRelease() {
        return BASE_URL + URL_ORDER_RELEASE;
    }

    public static String getUrlBargainList() {
        return BASE_URL + URL_BARGAIN_LIST;
    }

    public static String getUrlBargainConfirm() {
        return BASE_URL + URL_BARGAIN_CONFIRM;
    }

    public static String getUrlBargainCancel() {
        return BASE_URL + URL_BARGAIN_CANCEL;
    }

    public static String getUrlUploadImg() {
        return BASE_URL + URL_UPLOAD_IMG;
    }

    public static String getUrlWalletInfo() {
        return BASE_URL + URL_WALLET_INFO;
    }

    public static String getUrlHelpList() {
        return BASE_URL + URL_HELP_LIST;
    }

    public static void setUrlHelpList(String urlHelpList) {
        URL_HELP_LIST = urlHelpList;
    }

    public static String getUrlCustomerSuggest() {
        return BASE_URL + URL_CUSTOMER_SUGGEST;
    }

    public static void setUrlCustomerSuggest(String urlCustomerSuggest) {
        URL_CUSTOMER_SUGGEST = urlCustomerSuggest;
    }

    public static String getUrlWalletAccountBalance() {
        return BASE_URL + URL_WALLET_ACCOUNT_BALANCE;
    }

    public static String getUrlWalletMoneylog() {
        return BASE_URL + URL_WALLET_MONEYLOG;
    }

    public static String getUrlWalletRecharge() {
        return BASE_URL + URL_WALLET_RECHARGE;
    }

    public static String getUrlWalletWithdraw() {
        return BASE_URL + URL_WALLET_WITHDRAW;
    }

    public static String getUrlWalletPoint() {
        return BASE_URL + URL_WALLET_POINT;
    }

    public static String getUrlWalletPointlog() {
        return BASE_URL + URL_WALLET_POINTLOG;
    }

    public static String getUrlWalletCoupon() {
        return BASE_URL + URL_WALLET_COUPON;
    }

    public static String getUrlWalletCouponlist() {
        return BASE_URL + URL_WALLET_COUPONLIST;
    }

    public static String getUrlWalletAddMoneyChannel() {
        return BASE_URL + URL_WALLET_ADD_MONEY_CHANNEL;
    }

    public static String getUrlWalletGetMoneyChannelList() {
        return BASE_URL + URL_WALLET_GET_MONEY_CHANNEL_LIST;
    }


    public static String deleteWithDrawChannel() {
        return BASE_URL + URL_WALLET_DELETE_WITHDRAW_CHANNEL;
    }

    public static String getUrlWalletGetMoneyChannelDetail() {
        return BASE_URL + URL_WALLET_GET_MONEY_CHANNEL_DETAIL;
    }

    public static String getUrlPayCouponlist() {
        return BASE_URL + URL_PAY_COUPONLIST;
    }

    public static String getUrlPayChannel() {
        return BASE_URL + URL_PAY_CHANNEL;
    }

    public static String getUrlPayOrder() {
        return BASE_URL + URL_PAY_ORDER;
    }

    public static String getUrlPayOrderInfo() {
        return BASE_URL + URL_PAY_ORDER_INFO;
    }

    public static String getUrlPayOrderMake() {
        return BASE_URL + URL_PAY_ORDER_MAKE;
    }

    public static String getUrlPayPaypalConfirm() {
        return BASE_URL + URL_PAY_PAYPAL_CONFIRM;
    }

    public static String getUrlMessageGetMsg() {
        return BASE_URL + URL_MESSAGE_GET_MSG;
    }

    public static String getUrlMessageGetOrderMsg() {
        return BASE_URL + URL_MESSAGE_GET_ORDER_MSG;
    }
}
