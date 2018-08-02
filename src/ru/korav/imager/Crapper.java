/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.korav.imager;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author korgan
 */
public class Crapper {
    
    public BufferedImage crapperField(File fl) throws IOException{
        BufferedImage img = ImageIO.read(fl);
        img = img.getSubimage(220, 250, 450, 200);
        WritableRaster raster = img.getRaster();
        long line = 0;
        System.out.println(img.getHeight());
        for(int x = 0; x < raster.getWidth(); x++){
            //System.out.print(line);
            for(int y = 0; y < raster.getHeight(); y++){
                int[] pixel = raster.getPixel(x, y, new int[4]);
                if((pixel[0]+pixel[1]+pixel[2])/3>240)
                    continue;
                System.out.print("  "+pixel[0]+"  "+pixel[1]+"  "+pixel[2]);
            }
            //System.out.println( "   ");
            line++;
        }
        
        if(!ImageIO.write(img, "jpg", new File("/IWTRT/output/cr_"+fl.getName())))
            System.err.println("Error in save image!!!");
        System.out.println("Found "+" pixels!!!");
        return img;
    }
}
