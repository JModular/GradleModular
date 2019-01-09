package com.android.utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;

public class ImgUtil {
	/**
     * 将base64位字符串转换成图�?
    * @author liwang
    * @date 2017�?11�?14�?
    * @param baseStr        base64图片字符�?
    * @param imgFilePath    要保存到图片地址
    * @return boolean
     */
    public static boolean baseStrToImg(String baseStr, String imgFilePath) {
        if (StringUtils.isBlank(baseStr)) {// 图像数据为空
            return false;
        }
        try {
            // Base64解码
            byte[] bytes = Base64.getDecoder().decode(baseStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * 将图片转换成base64位字符串
    * @author liwang
    * @date 2017�?11�?14�?
    * @param imgFilePath 图片路径
    * @return String
     */
    public static String imgToBaseStr(String imgFilePath) {
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        return Base64.getEncoder().encodeToString(data); // 返回Base64编码过的字节数组字符�?
    }
}


