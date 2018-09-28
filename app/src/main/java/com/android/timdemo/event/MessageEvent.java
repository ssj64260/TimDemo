package com.android.timdemo.event;

import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMMessageListener;
import com.tencent.imsdk.TIMUserConfig;
import com.tencent.imsdk.ext.message.TIMMessageLocator;
import com.tencent.imsdk.ext.message.TIMMessageReceipt;
import com.tencent.imsdk.ext.message.TIMMessageReceiptListener;
import com.tencent.imsdk.ext.message.TIMMessageRevokedListener;
import com.tencent.imsdk.ext.message.TIMUserConfigMsgExt;

import java.util.List;
import java.util.Observable;

/**
 * 消息管理事件
 */
public class MessageEvent extends Observable implements TIMMessageListener, TIMMessageReceiptListener, TIMMessageRevokedListener {

    private volatile static MessageEvent instance;

    public static MessageEvent getInstance() {
        if (instance == null) {
            synchronized (MessageEvent.class) {
                if (instance == null) {
                    instance = new MessageEvent();
                }
            }
        }
        return instance;
    }

    private MessageEvent() {
        TIMManager.getInstance().addMessageListener(this);
    }

    public TIMUserConfig init(TIMUserConfig userConfig) {
        TIMUserConfigMsgExt ext = new TIMUserConfigMsgExt(userConfig);
        ext.enableReadReceipt(true);
        ext.setMessageReceiptListener(this);
        ext.setMessageRevokedListener(this);
        return ext;
    }

    @Override
    public boolean onNewMessages(List<TIMMessage> list) {
        //TODO 处理新消息
        return false;
    }

    @Override
    public void onRecvReceipt(List<TIMMessageReceipt> list) {
        //TODO 处理已读消息回执
    }

    @Override
    public void onMessageRevoked(TIMMessageLocator timMessageLocator) {
        //TODO 处理撤回消息
    }
}
