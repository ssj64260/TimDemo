package com.android.timdemo.event;

import com.tencent.imsdk.TIMSNSChangeInfo;
import com.tencent.imsdk.TIMUserConfig;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.ext.sns.TIMFriendshipProxyListener;
import com.tencent.imsdk.ext.sns.TIMUserConfigSnsExt;

import java.util.List;
import java.util.Observable;

/**
 * 好友管理事件
 */
public class FriendshipEvent extends Observable implements TIMFriendshipProxyListener {

    private volatile static FriendshipEvent instance;

    public static FriendshipEvent getInstance() {
        if (instance == null) {
            synchronized (FriendshipEvent.class) {
                if (instance == null) {
                    instance = new FriendshipEvent();
                }
            }
        }
        return instance;
    }

    private FriendshipEvent() {

    }

    public TIMUserConfig init(TIMUserConfig userConfig) {
        TIMUserConfigSnsExt ext = new TIMUserConfigSnsExt(userConfig);
        ext.enableFriendshipStorage(true);
        ext.setFriendshipProxyListener(this);
        return ext;
    }

    @Override
    public void OnAddFriends(List<TIMUserProfile> list) {
        //TODO 处理添加好友
    }

    @Override
    public void OnDelFriends(List<String> list) {
        //TODO 处理删除好友
    }

    @Override
    public void OnFriendProfileUpdate(List<TIMUserProfile> list) {
        //TODO 处理好友资料更新
    }

    @Override
    public void OnAddFriendReqs(List<TIMSNSChangeInfo> list) {
        //TODO 处理好友申请通知
    }


}
