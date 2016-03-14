package com.hcp.thinking_in_java.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Thinking in java
 * 执行操作系统命令
 * Created by Administrator on 2016/3/8.
 */
public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null) {
                System.out.println(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.out.println(s);
                err = true;
            }
        } catch (Exception e) {
            if (!command.startsWith("CMD /C")) {
                command("CMD /C" + command);
            } else {
                throw new RuntimeException(e);
            }
            if (err) {
                try {
                    throw new OSExecuteException("Errors executing " + command);
                } catch (OSExecuteException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
