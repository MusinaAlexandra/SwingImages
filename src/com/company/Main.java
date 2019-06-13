package com.company;

import com.sun.javafx.iio.ImageFrame;

import java.awt.image.ImageObserver;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        watchImages("./src");
    }

    public static void watchImages(String directory) {
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        //System.out.println(listOfFiles[0]);
        ArrayList<Image> listOfImages = new ArrayList<>();
        try {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    String name = listOfFiles[i].getName();

                    String ext = name.substring(name.lastIndexOf('.') + 1);
                    //System.out.println(ext);
                    if (ext.compareTo("jpg") == 0 || ext.compareTo("png") == 0) {
                        listOfImages.add(ImageIO.read(listOfFiles[i]));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("error of reading directory");
        }
        //System.out.println(listOfImages.size());


        JPanel wnd = new JPanel();

        wnd.setSize(300, 300);
        wnd.setLocation(250, 250);
        wnd.setVisible(true);
        Graphics g;

        Image[] arrIm = new Image[listOfImages.size()];
        try {
            for (int i = 0; i < listOfImages.size(); i++) {
                wnd.print(g.drawImage(listOfImages.get(i), 0, 0, new ImObserver()));
                        Thread.sleep(50000);
            }
        } catch (Exception e) {
            System.out.println("error of draw");
        }
    }
}
