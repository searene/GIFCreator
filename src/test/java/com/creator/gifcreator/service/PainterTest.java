package com.creator.gifcreator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PainterTest {

    @Autowired
    private Painter painter;

    @Test
    public void writeTextOnImageTest() throws IOException {
        painter.WriteTextOnImage("/home/searene/Pictures/1.png", "/home/searene/Desktop/output.png", "Hello World!", 100, 100);
    }

}
