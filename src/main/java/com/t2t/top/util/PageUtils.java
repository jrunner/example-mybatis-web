package com.t2t.top.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Page辅助类
 *
 * @author ypf
 */
public class PageUtils {

    /**
     * 客户端输出xml
     */
    public static void WriteReponseXML(HttpServletResponse response, String info, String msg, String... strings) {

        response.reset();
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        String xml = "<?xml version = \"1.0\" encoding=\"UTF-8\"?>";
        xml += "<response>";
        xml += "<info>" + info + "</info>";
        xml += "<msg>" + msg + "</msg>";
        if (strings.length > 0)
            xml += strings[0];
        xml += "</response>";
        try {
            response.getWriter().write(xml);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 客户端输出文本
     */
    public static void WriteReponseText(HttpServletResponse response, String info) {

        response.reset();
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        try {
            response.getWriter().write(info);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String toConvert(Object element, Object msg) {

        if (msg == null || element == null) {
            return "";
        }

        msg = msg.toString().trim();
        element = element.toString().trim().toLowerCase();

        String info = "<" + element + ">" + msg + "</" + element + ">";
        return info;
    }

    /**
     * 客户端下载
     *
     * @@param request
     * @@param response
     * @@param bytes 内容
     * @@param fileName 文件名
     * @@throws IOException
     */
    public static void clientDown(HttpServletRequest request, HttpServletResponse response, String content, String fileName) throws IOException {

        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        response.setContentType("application/vnd.ms-excel");
        /* 如果想出来让IE提示你是打开还是保存的对话框，加上下面这句即可 */
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);

        PrintWriter writer = response.getWriter();
        writer.write(content);
        writer.flush();
        writer.close();
    }


    public static void WriteReponseJson(HttpServletResponse response, Object data) {

        String info = GsonUtils.toJson(data);
        System.out.println(info);
        response.reset();
        response.setContentType("text/json; charset=UTF-8");
        response.setHeader("Cache-ControQl", "no-cache");
        try {
            response.getWriter().write(info);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static HttpServletResponse download(String path, HttpServletResponse response, String filename) {

        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            filename = filename == null ? file.getName() : filename;
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(filename, "UTF-8"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public static void downloadLocal(HttpServletResponse response) throws FileNotFoundException {

        // 下载本地文件
        String fileName = "Operator.doc".toString(); // 文件的默认保存名
        // 读到流中
        InputStream inStream = new FileInputStream("c:/Operator.doc");// 文件的存放路径
        // 设置输出的格式
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 支持在线打开文件的一种方式
    public static void downLoad(String filePath, HttpServletResponse response, boolean isOnLine) throws Exception {

        File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;

        response.reset(); // 非常重要
        if (isOnLine) { // 在线打开方式
            URL u = new URL("file:///" + filePath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
            // 文件名应该编码成UTF-8
        } else { // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }

}