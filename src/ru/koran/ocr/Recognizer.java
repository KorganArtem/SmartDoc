/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.koran.ocr;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.ITesseract.RenderedFormat;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import ru.korav.imager.Crapper;

/**
 *
 * @author korgan
 */
public class Recognizer {
    List<RenderedFormat> list = new ArrayList<RenderedFormat>();
    Tesseract instance = new Tesseract();
    public Recognizer(){
        list.add(RenderedFormat.PDF);
        instance.setDatapath("F:\\libs\\Tess4J-3.4.2-src\\Tess4J\\tessdata");
        instance.setLanguage("rus");
    }
    
    public void doPdfFromJpg(String filePath, String fileId, String baseDir){
        System.out.println(filePath+" --> "+baseDir+"/pdf/"+fileId);
        File imgFl = new File(filePath);
        long start = new Date().getTime();
        try{
            //String result = instance.doOCR(imgFl);
            instance.createDocuments(imgFl.getAbsolutePath(), baseDir+"/pdf/"+fileId, list);
            //System.out.println(result);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println((new Date().getTime()-start)/1000+"");
    }

    public void checkDoc(String path) throws IOException, TesseractException {
        System.out.println(path);
        long start = new Date().getTime();
        File fl = new File(path);
        Crapper cr = new Crapper();
        BufferedImage bi = cr.crapperField(fl);
        //String result = instance.doOCR(bi);
        //System.out.println(result+" \n\n\n");
        System.out.println((new Date().getTime()-start)/1000+"");
    }
}
