package com.chuangcius.tools.downloader;

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
        URL url;
        String address = "https://www.africau.edu/images/default/sample.pdf";
        BufferedInputStream in;

        File file;
        String filePathName = "sample.pdf";
        FileOutputStream fos = null;
        BufferedOutputStream bout = null;

        try {
            url = new URL(address);
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedInputStream(httpUrlConnection.getInputStream());

            file = new File(filePathName);
            if (file.exists()) {
                // resume download, append to existing file
                fos = new FileOutputStream(file, true);
            } else {
                fos = new FileOutputStream(file);
            }

            bout = new BufferedOutputStream(fos, 1024);
            int x;
            byte[] data = new byte[1024];
            while ((x = in.read(data, 0, 1024)) >= 0) {
                bout.write(data, 0, x);
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
