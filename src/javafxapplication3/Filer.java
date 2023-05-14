/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication3;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author kartc
 */
public class Filer 
{
    private int hgh;
    private int count = 0;
    int getCount;
    public Filer()
    {
        hgh = 1;
    }
    private String[][] strings = new String[100][2];
    private int row,col,x=0;
    public String[][] readBookFile() throws IOException
    {
        Scanner scan = new Scanner(new FileReader("books.txt"));
        ArrayList<Book> bookReader = new ArrayList<>();
        while(scan.hasNext()) 
        {
                String[] bookInfo = scan.nextLine().split(",");
                strings[x][0] = bookInfo[0];
                strings[x][1] = bookInfo[1];
                count++;
                x++;
        }
        return strings;
    }
    public static void removeRecord(String filepath, int deleteLine)
    {
        //full credit to
        //https://www.youtube.com/watch?v=ij07fW5q4oo&ab_channel=MaxO%27Didily
        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        int line = 0;
        String currentLine;
        try
        {
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            while((currentLine = br.readLine())!=null)
            {
                line++;
                if(deleteLine != line)
                {
                    pw.println(currentLine);
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();
            Path p = Paths.get(filepath);
            oldFile.delete();
            File dump = new File(filepath);
            Files.delete(p);
            newFile.renameTo(dump);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public int getCount()
    {
        return count;
    }
}