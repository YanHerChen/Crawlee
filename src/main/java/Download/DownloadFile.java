package Download;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DownloadFile {
    private static String root_path;
    private static String file_extension;

    DownloadFile(String path, String extension) {
        root_path = path;
        file_extension = extension;
    }

    public static void Start(ArrayList<String> data) {
        StringBuilder path = new StringBuilder();
        BufferedWriter fw = null;
        File file = new File("path");
        try {
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
            for (String s : data) {
                fw.write(s);
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.gc();
    }
}
