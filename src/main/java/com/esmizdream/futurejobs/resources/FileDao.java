/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esmizdream.futurejobs.resources;

import com.esmizdream.futurejobs.admin.servlet.AdminBean;
import jakarta.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author hp
 */
public class FileDao {

    private final static String dir_path = "C:\\Users\\hp\\Documents\\NetBeansProjects\\FutureJobs\\src\\main\\webapp\\attachment\\";
    private static InputStream file_stream;
    private static FileOutputStream fout;
    private static FileInputStream fin;
    private static BufferedImage pic;
    private static FileDao filedao;

    public static FileDao getInstance() {
        if (filedao == null) {
            filedao = new FileDao();
        }
        return filedao;
    }
//    not used right now need further reserach

    public static BufferedImage readImage(String path, String user_type) {

        try {
            pic = ImageIO.read(new File(dir_path.concat("/").concat(user_type)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pic;
    }

    public static boolean saveFile(Part file, String user_type, String file_type) throws FileNotFoundException, IOException {
        File file_path = new File(dir_path.concat(user_type).concat("\\").concat(file_type));
        if (!file_path.exists()) {
            file_path.mkdirs();
        }
        if (file != null && file_path.exists()) {
            String upload_path = file_path.getAbsolutePath().concat("\\").concat(file.getSubmittedFileName());
            fout = new FileOutputStream(upload_path);
            file_stream = file.getInputStream();
            byte[] data = new byte[file_stream.available()];
            file_stream.read(data);
            fout.write(data);
            fout.close();
            return true;
        }
        return false;
    }

    public static boolean deleteFile(String file_name, String user_type) {
        File file_path = new File(dir_path);
        String exact_path = dir_path.concat("/").concat(user_type).concat("/").concat(file_name);
        if (file_name != null && file_path.exists()) {

            return true;
        }
        return false;
    }

    public static boolean replaceFile(Part file_new, String old_file_path, AdminBean adminbean, String user_type) {
//        deleteFile(file_new, user_type);

        return false;
    }

}
