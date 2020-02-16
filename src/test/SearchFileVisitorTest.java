package test;

import com.stepev.walkfile.SearchFileVisitor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class SearchFileVisitorTest {
    private SearchFileVisitor searchFileVisitor;

    @BeforeEach
    void setUp() {
        searchFileVisitor = new SearchFileVisitor();
    }
    @Test
    public void SomeTest() throws Exception{
        Files.walkFileTree(Paths.get("d:/temp"), searchFileVisitor);
        int actual = searchFileVisitor.getNumbersOfFiles();

        int expected = 10;

        assertEquals(expected, actual);
    }
}