package com.shenhua.idea.plugin.changegituser;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shenhua on 2018/4/25.
 */
public class MainComponent extends JDialog {

    private JPanel jPanel;
    private JList list1;
    private JButton btnOk;
    private JButton btnCancel;
    private JLabel tvUser;
    private JLabel tvInfo;
    private JButton btnAdd;
    private JButton btnRemove;
    private Project project;

    public MainComponent(Project project) throws HeadlessException {
        this.project = project;
        setSize(400, 500);
        setLocationRelativeTo(null);
        setTitle("Change Git User");
        setResizable(false);
        setFocusableWindowState(true);
        setContentPane(jPanel);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setIconImage(new ImageIcon("/icon/logo_16.png").getImage());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        addActions();
        initData();
        initListener();
    }

    private void addActions() {
        btnAdd.setIcon(AllIcons.General.Add);
        btnRemove.setIcon(AllIcons.General.Remove);
    }

    private void initData() {

    }

    private void initListener() {
        btnCancel.addActionListener(e -> setVisible(false));
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tvInfo.setText("dene.");
            }
        });
    }
}
