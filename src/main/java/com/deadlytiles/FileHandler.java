package com.deadlytiles;

import java.io.File;
import java.util.Scanner;

public class FileHandler {
    //read, write and create files
    private File file;
    
    public FileHandler(String fileName) {
        this.file = new File(fileName);
    }
    //return file path
    public String getFilePath() {
        return file.getAbsolutePath();
    }
    //create file
    public void createFile() {
        try {
            if (this.file.createNewFile()) {
                System.out.println("File created: " + this.file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //read file
    public String readFile() {
        try {
            Scanner reader = new Scanner(this.file);
            String data = "";
            while (reader.hasNextLine()) {
                data += reader.nextLine();
            }
            reader.close();
            return data;
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
    //write to file
    public void writeToFile(String text) {
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(this.file);
            fileWriter.write(text);
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //add to file
    public void appendToFile(String text) {
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(this.file, true);
            fileWriter.write(text);
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //search JSON file for nickname
    public boolean searchFile(String nickname) {
        try {
            Scanner fileReader = new Scanner(this.file);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                if (data.contains(nickname)) {
                    fileReader.close();
                    return true;
                }
            }
            fileReader.close();
            return false;
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }
}



//Project by Vadims "OxCone" Lapins