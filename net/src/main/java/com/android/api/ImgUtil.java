package com.android.api;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;

public class ImgUtil {

    public static boolean baseStrToImg(String baseStr, String imgFilePath) {
        if (StringUtils.isBlank(baseStr)) {// 图像数据为空
            return false;
        }
        try {
            // Base64解码
            byte[] bytes = Base64.getMimeDecoder().decode(baseStr);
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
        return Base64.getMimeEncoder().encodeToString(data); // 返回Base64编码过的字节数组字符
    }
}


