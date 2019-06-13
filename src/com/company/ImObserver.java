package com.company;

import java.awt.image.ImageObserver;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;

public class ImObserver implements ImageObserver{
    @Override
    public boolean imageUpdate(Image img, int status, int x, int у, int width, int height) {
        if ((status & ALLBITS) != 1) {
            System.out.println("Still processing the image");
            return true;
        } else {
            System.out.println("Done processing the image");
            return false;
        }
    }
}
