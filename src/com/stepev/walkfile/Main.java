package com.stepev.walkfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/* 
Что внутри папки?
*/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();
        System.out.println("Введите путь к папке: ");
        String path = reader.readLine();
        Path dir = Paths.get(path);
        if(!Files.isDirectory(dir)) {
            System.out.println(path + " - не папка");
        }
        else{
            Files.walkFileTree(Paths.get(path), searchFileVisitor);
            System.out.println("Всего папок - " + searchFileVisitor.getNumberOfFolders());
            System.out.println("Всего файлов - " + searchFileVisitor.getNumbersOfFiles());
            System.out.println("Общий размер - " + searchFileVisitor.getWholeSize());
        }
    }
}