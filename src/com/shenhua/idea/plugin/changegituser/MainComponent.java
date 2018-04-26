package com.shenhua.idea.plugin.changegituser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.intellij.openapi.project.Project;
import com.shenhua.idea.plugin.changegituser.etc.Command;
import com.shenhua.idea.plugin.changegituser.etc.GitBean;
import com.shenhua.idea.plugin.changegituser.etc.GitModel;
import com.shenhua.idea.plugin.changegituser.etc.UserMouseAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;

/**
 * 主窗口
 * Created by shenhua on 2018/4/25.
 */
public class MainComponent extends JDialog {

    private Project project;
    private JPanel jPanel;
    private JList gitList;
    private JButton btnOk;
    private JButton btnSetting;
    private JLabel tvUser;
    private JLabel tvInfo;
    private ArrayList<GitBean> gitBeans;

    public MainComponent(Project project) throws HeadlessException {
        this.project = project;
        initView();
        EventQueue.invokeLater(() -> {
            addActions();
            initData();
            initListener();
        });
    }

    /**
     * 初始化Views
     */
    private void initView() {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setTitle("Change Git User");
        setResizable(false);
        setFocusableWindowState(true);
        setContentPane(jPanel);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setIconImage(new ImageIcon("/icon/logo_16.png").getImage());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        tvInfo.setText("DoubleClick item to Change.");
    }

    /**
     * 添加移除action
     */
    private void addActions() {

    }

    /**
     * 初始化数据
     */
    private void initData() {
        File file = new File(Config.JSON_FILE_PATH);
        gitBeans = parseGitBean(readJson(file));
        if (gitBeans != null) {
            gitList.setModel(new GitModel(gitBeans));
        }
        GitBean user = Command.getUser();
        tvUser.setText("Current Git user: " + user);
    }

    /**
     * 初始化事件监听器
     */
    private void initListener() {
        gitList.addMouseListener(new UserMouseAdapter() {

            @Override
            public void onDoubleClicked(MouseEvent e) {
                Command.changeName(gitBeans.get(gitList.getSelectedIndex()).getUsername());
                Command.changeMail(gitBeans.get(gitList.getSelectedIndex()).getUserEmail());

                GitBean user = Command.getUser();
                tvUser.setText("Current Git user: " + user);
                tvInfo.setText("dene.");
            }
        });
        btnSetting.addActionListener(e -> {
            // TODO: 2018/4/26 setting file.
        });
        btnOk.addActionListener(e -> setVisible(false));
    }

    /**
     * 读取json文件
     *
     * @param file 文件
     * @return json
     */
    private String readJson(File file) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String result = bufferedReader.readLine();
            while (result != null) {
                return result;
            }
            fileInputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            tvInfo.setText("File not Exists.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 解析json
     *
     * @param json json
     * @return ArrayList<GitBean>
     */
    private ArrayList<GitBean> parseGitBean(String json) {
        try {
            return new Gson().fromJson(json, new TypeToken<ArrayList<GitBean>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
