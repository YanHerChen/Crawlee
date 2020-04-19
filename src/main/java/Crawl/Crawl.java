package Crawl;

import Parser.DataProcess;
import Storage.Data;
import Storage.Queue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Crawl {
    private String threadName;
    private InputStream in = null;
    private InputStreamReader r = null;
    private BufferedReader br = null;
    private ArrayList<String> line_data;
    private String url;
    public Crawl(String url, final String threadName) {
        this.threadName = threadName;
        this.line_data = new ArrayList();
        this.url = url;
    }

    public void Start() {
        URL u;
        String line;
        try {
            u = new URL(url);
            URLConnection conn = u.openConnection();
            conn.addRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36");

            in = u.openStream();
            r = new InputStreamReader(in, "UTF-8");
            br = new BufferedReader(r);
            while ((line = br.readLine()) != null) {
                line_data.add(line);
            }
            Data.setData(threadName, line_data);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                in.close();
                r.close();
                br.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}