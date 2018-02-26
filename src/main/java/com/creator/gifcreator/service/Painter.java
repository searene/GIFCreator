package com.creator.gifcreator.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class Painter {
    public void WriteTextOnImage(String inputImagePath, String outputImagePath, String text, Integer locationX, Integer locationY) throws IOException {
        final BufferedImage image = ImageIO.read(new File(inputImagePath));
        Graphics g = image.getGraphics();
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString(text, locationX, locationY);
        g.dispose();

        // for the second parameter, png is definitely supported,
        // not sure if other types are supported, either.
        ImageIO.write(image, FilenameUtils.getExtension(outputImagePath), new File(outputImagePath));
    }
}
