package com.shenhua.idea.plugin.changegituser.etc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 列表单击双击事件
 *
 * @author shenhua
 *         Email shenhuanet@126.com
 */
public class UserMouseAdapter extends MouseAdapter {

    private long firstTime = 0;

    /**
     * SingleClick
     *
     * @param e MouseEvent
     */
    public void onSingleClicked(MouseEvent e) {

    }

    /**
     * DoubleClick
     *
     * @param e MouseEvent
     */
    public void onDoubleClicked(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        long time = System.currentTimeMillis();
        if (time - firstTime > 200) {
            onSingleClicked(e);
            firstTime = time;
        } else {
            onDoubleClicked(e);
        }
    }
}