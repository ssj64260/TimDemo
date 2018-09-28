package com.android.timdemo.business;

import com.android.timdemo.event.FriendshipEvent;
import com.android.timdemo.event.GroupEvent;
import com.android.timdemo.event.MessageEvent;
import com.tencent.imsdk.TIMConnListener;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMUserConfig;
import com.tencent.imsdk.TIMUserStatusListener;

public class TimUserConfigBusiness implements TIMConnListener {

    private TIMUserConfig userConfig;

    public TimUserConfigBusiness() {
        //登录之前要初始化群和好友关系链缓存
        userConfig = new TIMUserConfig();

        userConfig = MessageEvent.getInstance().init(userConfig);
        userConfig = FriendshipEvent.getInstance().init(userConfig);
        userConfig = GroupEvent.getInstance().init(userConfig);
        userConfig.setConnectionListener(this);

        TIMManager.getInstance().setUserConfig(userConfig);
    }

    public void setUserStatusListener(TIMUserStatusListener listener) {
        userConfig.setUserStatusListener(listener);
    }

    public void destroy() {
        userConfig.setUserStatusListener(null);
        userConfig.setConnectionListener(null);
        userConfig.setGroupEventListener(null);
        userConfig.setRefreshListener(null);
    }

    @Override
    public void onConnected() {
        //TODO 处理连接成功
    }

    @Override
    public void onDisconnected(int i, String s) {
        //TODO 处理断开连接
    }

    @Override
    public void onWifiNeedAuth(String s) {
        //TODO WIFI需要验证
    }
}
