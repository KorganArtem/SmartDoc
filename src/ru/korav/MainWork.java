/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.korav;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import net.sourceforge.tess4j.TesseractException;
import ru.koran.ocr.Recognizer;

/**
 *
 * @author korgan
 */
public class MainWork {
    String source;
    String baseDir;
    String conf;
    String text;
    int inputType;
    boolean sql = false;
    MainWork(String sourcePath, String baseDirPath, String confPath, String textPath, int inType ){
        if(textPath.equals("sql"))
            this.sql=true;
        else 
            this.text = textPath;
        this.conf = confPath;
        this.baseDir = baseDirPath;
        this.source = sourcePath;
        this.inputType = inType;
    }
    public void goToSky() throws InterruptedException, IOException, TesseractException{
        File inputFolder = new File(source);
        Recognizer rcz = new Recognizer();
        for (final File fileEntry : inputFolder.listFiles()) {
            if (fileEntry.isDirectory()) {
                continue;
            } else {
                rcz.checkDoc(source+"/"+fileEntry.getName());
                //rcz.doPdfFromJpg(source+"/"+fileEntry.getName(), getName(), baseDir);
            }
        }
    }
    private void pdfParser(){
        System.out.println("I WILL PARSE PDF");
    }
    private String getName() throws InterruptedException{
        Date dt = new Date();
        Thread.sleep(1);
        String st = dt.getTime()+"";
        MessageDigest messageDigest = null;
        byte[] digest = null; //new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            // тут можно обработать ошибку
            // возникает она если в передаваемый алгоритм в getInstance(,,,) не существует
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }
}
