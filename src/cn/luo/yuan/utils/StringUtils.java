package cn.luo.yuan.utils;

/**
 * Created by gluo on 9/8/2015.
 */
public class StringUtils {


    //转换数字为十六进制显示格式
    public static String toHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return "0x" + str;//0x表示十六进制
    }

    //转换十六进制编码为字符串
    public static String toStringHex(String s) {
        if ("0x".equals(s.substring(0, 2))) {
            s = s.substring(2);
        }
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
                        i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            s = new String(baKeyword, "utf-16");//UTF-16le:Not
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    public static boolean isNotEmpty(String countStr) {
        return countStr !=null && !countStr.trim().isEmpty() && !"null".equalsIgnoreCase(countStr);
    }

    public static String[] split(String str,String regularExpression){
        if(isNotEmpty(str)){
            return str.split(regularExpression);
        }else{
            return new String[]{""};
        }
    }


    public static Float toFloat(String number){
        try {
            return Float.parseFloat(number);
        }catch (Exception e){
            try {
                return Double.valueOf(number).floatValue();
            }catch (Exception e1){
                return 0.1f;
            }
        }
    }

    public static Integer toInt(String type) {
        try {
            return Integer.parseInt(type);
        }catch (Exception e){
            try {
                return Double.valueOf(type).intValue();
            }catch (Exception exp){
                return 1;
            }
        }
    }
}
