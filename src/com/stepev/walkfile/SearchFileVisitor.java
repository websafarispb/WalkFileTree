package com.stepev.walkfile;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private int numbersOfFiles;
    private int numberOfFolders;
    private int wholeSize;

    public SearchFileVisitor() {
        numberOfFolders =0;
        numbersOfFiles = 0;
        wholeSize = 0;

    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        wholeSize+=Files.size(file);
        if(Files.isDirectory(file)){
            numberOfFolders++;
        }
        else
            numbersOfFiles++;
        return super.visitFile(file, attrs);
    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

        if(Files.isDirectory(dir)){
            numberOfFolders++;
        }
        return super.preVisitDirectory(dir, attrs);
    }

    public int getNumbersOfFiles() {
        return numbersOfFiles;
    }

    public int getNumberOfFolders() {
        return numberOfFolders;
    }

    public int getWholeSize() {
        return wholeSize;
    }
}