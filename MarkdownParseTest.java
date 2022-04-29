import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MarkdownParseTest {
    public static ArrayList<String> getLinksResult(String filepath) throws IOException {
        Path fileName = Path.of(filepath);
        String content = Files.readString(fileName);
        return MarkdownParse.getLinks(content);
    }
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void fileTest1() throws IOException {
        Path fileName = Path.of("my-test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> result = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), result);
    }
    @Test
    public void fileTest2() throws IOException {
        Path fileName = Path.of("my-test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> result = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://amazon.com", "ucsd.html"), result);
    }
    @Test
    public void fileTest3() throws IOException {
        Path fileName = Path.of("my-test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> result = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://mail.google.com", "github.html"), result);
    }
    @Test
    public void fileTest4() throws IOException {
        Path fileName = Path.of("my-test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> result = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://ucsd.edu"), result);
        //assertEquals(List.of("https://mail.google.com", "github.html"), result);
    }
    @Test
    public void fileTest5() throws IOException {
        Path fileName = Path.of("my-test-file5.md");
        String content = Files.readString(fileName);
        ArrayList<String> result = MarkdownParse.getLinks(content);
        assertEquals(new ArrayList<String>(), result);
    }
    @Test
    public void fileTest6() throws IOException {
        Path fileName = Path.of("my-test-file6.md");
        String content = Files.readString(fileName);
        ArrayList<String> result = MarkdownParse.getLinks(content);
        assertEquals(new ArrayList<String>(), result);
    }
    @Test
    public void GivenFileTest1() throws IOException {
            assertEquals(List.of("https://something.com", "some-thing.html"),getLinksResult("test-file.md"));
    }
    @Test
    public void GivenFileTest2() throws IOException {
            assertEquals(List.of("https://something.com", "some-page.html"), getLinksResult("test-file2.md"));
    }
    @Test
    public void GivenFileTest3() throws IOException {
            assertEquals(List.of(), getLinksResult("test-file3.md"));
    }
    @Test
    public void GivenFileTest4() throws IOException {
            assertEquals(List.of(), getLinksResult("test-file4.md"));
    }
    @Test
    public void GivenFileTest5() throws IOException {
            assertEquals(List.of(), getLinksResult("test-file5.md"));
    }
    @Test
    public void GivenFileTest6() throws IOException {
            assertEquals(List.of(), getLinksResult("test-file6.md"));
    }
    @Test
    public void GivenFileTest7() throws IOException {
            assertEquals(List.of(), getLinksResult("test-file7.md"));
    }
    @Test
    public void GivenFileTest8() throws IOException {
            assertEquals(List.of(), getLinksResult("test-file8.md"));
    }
    
}