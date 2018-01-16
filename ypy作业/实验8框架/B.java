import java.util.Scanner;
import java.io.*;
public class B
{
    public static void main(String args[])
    {
        ClassMana classmana=new ClassMana();
        //classmana.input();
        //classmana.save();
        classmana=ClassMana.load();
        classmana.output();
     }
 }