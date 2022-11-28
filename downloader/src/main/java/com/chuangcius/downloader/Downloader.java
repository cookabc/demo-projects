package com.chuangcius.downloader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Downloader
 *
 * @author chuangcius
 * @date 2022.11.07
 */
public class Downloader {

    public static void main(String[] args) {
        String address = "https://www.africau.edu/images/default/sample.pdf";
        String filePathName = "sample.pdf";
        run(address, filePathName);
    }

    public static void run(String urlAddress, String fullPathFileName) {
        final URL url;
        HttpURLConnection httpURLConnection;

        FileOutputStream fos = null;
        BufferedOutputStream bout = null;

        try {
            url = new URL(urlAddress);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestMethod("GET");

            File file = new File(fullPathFileName);
            if (file.exists()) {
                if (file.length() == httpURLConnection.getContentLength()) {
                    //we are done, return.
                    return;
                } else {
                    // resume download, append to existing file
                    String lastModified = httpURLConnection.getHeaderField("Last-Modified");
                    httpURLConnection.setRequestProperty("If-Range", lastModified);
                    httpURLConnection.setRequestProperty("Range", "bytes=" + file.length() + "-");
                    fos = new FileOutputStream(file, true);
                }
            } else {
                // create brand-new file
                fos = new FileOutputStream(file);
            }

            final int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200 || responseCode == 206) {
                BufferedInputStream bin = new BufferedInputStream(httpURLConnection.getInputStream());
                final byte[] buffer = new byte[1024];
                int length;
                bout = new BufferedOutputStream(fos, 1024);
                while ((length = bin.read(buffer)) != -1) {
                    bout.write(buffer, 0, length);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bout != null) {
                    bout.flush();
                    bout.close();
                }
                if (fos != null) {
                    fos.flush();
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
