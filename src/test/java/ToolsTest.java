package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.Tools;

public class ToolsTest {
    @Test
    void testReadFile() {
        String path = "res/data_test/readFile.txt";
        try {
            String content = Tools.readFile(path);
            assertEquals(content, "ceci est un test.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
