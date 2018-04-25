package com.shenhua.idea.plugin.changegituser;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 * Created by shenhua on 2018/4/25.
 */
public class Change extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        MainComponent mainComponent = new MainComponent(e.getProject());
        mainComponent.setVisible(true);
    }
}
