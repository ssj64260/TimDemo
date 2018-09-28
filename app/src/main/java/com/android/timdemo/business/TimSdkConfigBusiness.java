package com.android.timdemo.business;

import com.android.timdemo.app.APP;
import com.android.timdemo.config.Constants;
import com.tencent.imsdk.TIMLogLevel;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMSdkConfig;


/**
 * 初始化
 * 包括imsdk等
 */
public class TimSdkConfigBusiness {

    private TimSdkConfigBusiness() {
    }

    public static void init() {
        TIMSdkConfig config = new TIMSdkConfig(Constants.TIM_SDK_APP_ID)
                .enableCrashReport(false)
                .enableLogPrint(true)
                .setLogLevel(TIMLogLevel.DEBUG);

        TIMManager.getInstance().init(APP.get(), config);
    }
}
