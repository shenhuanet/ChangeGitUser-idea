package com.shenhua.idea.plugin.changegituser;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 * 菜单被选中action
 * Created by shenhua on 2018/4/25.
 */
public class ChangeAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        MainComponent mainComponent = new MainComponent(e.getProject());
        mainComponent.setVisible(true);
    }
}
