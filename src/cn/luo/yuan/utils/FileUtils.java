package cn.luo.yuan.utils;


import java.io.File;

/**
 * Created by gluo on 4/19/2017.
 */
public class FileUtils {
    public static File[] buildPaths(File[] base, String... segments) {
        File[] result = new File[base.length];
        for (int i = 0; i < base.length; i++) {
            result[i] = buildPath(base[i], segments);
        }
        return result;
    }

    public static File buildPath(File base, String... segments) {
        File cur = base;
        for (String segment : segments) {
            if (cur == null) {
                cur = new File(segment);
            } else {
                cur = new File(cur, segment);
            }
        }
        return cur;
    }


    public static String getType(File file){
        int lastDot = file.getName().lastIndexOf(".");
        if(lastDot > 0){
            return file.getName().substring(lastDot + 1);
        }
        return "";
    }
}
