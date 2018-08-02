/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.korav;

import java.io.IOException;
import net.sourceforge.tess4j.TesseractException;

/**
 *
 * @author korgan
 */
public class SmartDoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException, TesseractException {
        // TODO code application logic here
        String sourcePath = null;
        String baseDirPath = null;
        String confPath = null;
        String outPath = null;
        int inputType = 0;
        for(int argId = 0; argId<args.length; argId=argId+2){
            switch(args[argId]){
                case("-s"):
                    sourcePath = args[argId+1];
                    break;
                case("-d"):
                    baseDirPath = args[argId+1];
                    break;
                case("-c"):
                    confPath = args[argId+1];
                    break;
                case("-t"):
                    if(args[argId+1].equals("pdf"))
                        inputType=1;
                    break;
                case("-o"):
                    outPath = args[argId+1];
                    break;
            }
        }
        MainWork mw = new MainWork(sourcePath, baseDirPath, confPath, outPath, inputType);
        mw.goToSky();
    }
    
}
