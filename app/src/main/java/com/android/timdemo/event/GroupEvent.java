package com.android.timdemo.event;

import com.tencent.imsdk.TIMGroupEventListener;
import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMGroupTipsElem;
import com.tencent.imsdk.TIMUserConfig;
import com.tencent.imsdk.ext.group.TIMGroupAssistantListener;
import com.tencent.imsdk.ext.group.TIMGroupCacheInfo;
import com.tencent.imsdk.ext.group.TIMUserConfigGroupExt;

import java.util.List;
import java.util.Observable;

/**
 * 群组管理事件
 */
public class GroupEvent extends Observable implements TIMGroupAssistantListener, TIMGroupEventListener {

    private volatile static GroupEvent instance;

    public static GroupEvent getInstance() {
        if (instance == null) {
            synchronized (GroupEvent.class) {
                if (instance == null) {
                    instance = new GroupEvent();
                }
            }
        }
        return instance;
    }

    private GroupEvent() {

    }

    public TIMUserConfig init(TIMUserConfig userConfig) {
        TIMUserConfigGroupExt ext = new TIMUserConfigGroupExt(userConfig);
        ext.enableGroupStorage(true);
        ext.setGroupAssistantListener(this);
        ext.setGroupEventListener(this);
        return ext;
    }

    @Override
    public void onMemberJoin(String s, List<TIMGroupMemberInfo> list) {
        //TODO 处理新成员加入群组
    }

    @Override
    public void onMemberQuit(String s, List<String> list) {
        //TODO 处理群成员退群
    }

    @Override
    public void onMemberUpdate(String s, List<TIMGroupMemberInfo> list) {
        //TODO 处理群成员资料更新
    }

    @Override
    public void onGroupAdd(TIMGroupCacheInfo timGroupCacheInfo) {
        //TODO 处理加入群组
    }

    @Override
    public void onGroupDelete(String s) {
        //TODO 处理解散群组
    }

    @Override
    public void onGroupUpdate(TIMGroupCacheInfo timGroupCacheInfo) {
        //TODO 处理群组资料更新
    }

    @Override
    public void onGroupTipsEvent(TIMGroupTipsElem timGroupTipsElem) {
        //TODO 处理群组Tips事件
    }
}
