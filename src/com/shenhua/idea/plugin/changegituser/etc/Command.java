package com.shenhua.idea.plugin.changegituser.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 命令行工具类
 * Created by shenhua on 2018/4/26.
 */
public class Command {

    private static final String CONFIG = "git config";
    private static final String GLOBAL = " --global ";
    private static final String NAME = " user.name ";
    private static final String EMAIL = " user.email ";

    /**
     * 获取当前用户
     *
     * @return result
     */
    public static GitBean getUser() {
        return getUser(true);
    }

    /**
     * 获取当前用户
     *
     * @param global 是否全局，默认是
     * @return result
     */
    public static GitBean getUser(boolean global) {
        StringBuilder sb = new StringBuilder();
        sb.append(CONFIG);
        if (global) {
            sb.append(GLOBAL);
        }
        String name = executeCommand(sb.toString() + NAME);
        String email = executeCommand(sb.toString() + EMAIL);
        return new GitBean(name, email);
    }

    /**
     * 设置全局用户
     *
     * @param name user.name
     */
    public static void changeName(String name) {
        changeName(name, true);
    }

    /**
     * 设置用户
     *
     * @param name   user.name
     * @param global 是否全局，默认是
     */
    public static void changeName(String name, boolean global) {
        StringBuilder sb = new StringBuilder();
        sb.append(CONFIG);
        if (global) {
            sb.append(GLOBAL);
        }
        executeCommand(sb.toString() + NAME + name);
    }

    /**
     * 设置全局邮箱
     *
     * @param email user.email
     */
    public static void changeMail(String email) {
        changeMail(email, true);
    }

    /**
     * 设置全局邮箱
     *
     * @param email user.email
     */
    public static void changeMail(String email, boolean global) {
        StringBuilder sb = new StringBuilder();
        sb.append(CONFIG);
        if (global) {
            sb.append(GLOBAL);
        }
        executeCommand(sb.toString() + EMAIL + email);
    }

    private static String executeCommand(String command) {
        try {
            Process exec = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
