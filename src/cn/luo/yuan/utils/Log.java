package cn.luo.yuan.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by gluo on 3/23/2017.
 * 一个静态的log工具类，存放目录为 logs
 * HOMOG.log为log文件名字，可以修改。
 */
public class Log {
    private static Logger logger = Logger.getLogger("HOMOG.log");
    static {
        try {
            File file = new File("logs");
            if(!file.exists() || !file.isDirectory()){
                file.mkdirs();
            }
            FileHandler handler = new FileHandler("logs/log.homog", 40240000, 30, true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void info(String msg){
        logger.info(msg);
    }

    public static void err(String msg) {
        logger.log(Level.SEVERE, msg);
    }

    public static void err(String msg, Exception e ) {
        e.printStackTrace();
        logger.log(Level.SEVERE, msg, e);
    }

    public static void err(Exception e ) {
        e.printStackTrace();
        logger.log(Level.SEVERE, "", e);
    }
}
