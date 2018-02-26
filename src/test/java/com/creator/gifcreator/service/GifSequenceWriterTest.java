package com.creator.gifcreator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GifSequenceWriterTest {

	@Test
	public void contextLoads() throws IOException {
	    String[] images = new String[]{"/home/searene/Pictures/1.png", "/home/searene/Pictures/2.png", "/home/searene/Pictures/3.png"};
        // grab the output image type from the first image in the sequence
        ImageOutputStream output =
                new FileImageOutputStream(new File("/home/searene/Desktop/output.gif"));
        // create a gif sequence with the type of the first image, 1 second
        // between frames, which loops continuously
        GifSequenceWriter writer =
                new GifSequenceWriter(output, ImageIO.read(new File(images[0])).getType(), 1000, true);
        // write out the first image to our sequence...
        for(int i=0; i<images.length; i++) {
            BufferedImage nextImage = ImageIO.read(new File(images[i]));
            writer.writeToSequence(nextImage);
        }
        writer.close();
        output.close();
	}

}
