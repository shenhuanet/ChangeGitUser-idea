package com.shenhua.idea.plugin.changegituser.etc;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;

/**
 * 列表中的model
 * Created by shenhua on 2018/4/26.
 */
public class GitModel implements ListModel<String> {

    private ArrayList<GitBean> gitBeans;

    public GitModel(ArrayList<GitBean> gitBeans) {
        this.gitBeans = gitBeans;
    }

    @Override
    public int getSize() {
        return gitBeans == null ? 0 : gitBeans.size();
    }

    @Override
    public String getElementAt(int index) {
        return gitBeans.get(index).toString();
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
