package mainPack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;


public class mainClass {
    public static Integer errorCount = 0;
    public static Integer workedCount = 0;
    public static Integer errorCalcCount = 0;
    public static String errorLog = "";
    public static String error;
    public static int init = 0;
    public static int noinit = 0;
    public static int rail = 0;
    public static int nochouse = 0;
    public static int initNOstart = 0;

    public static void main(String[] args) throws IOException {



        String fileName = "C:/qqq/декабрь.tsv";  //адрес лога
        //String fileName = "C:/qqq/rep.tsv";
         String filer = new String(Files.readAllBytes(Paths.get(fileName)));



        //  String yesPrepare = preparer.GetPrepare(filer);
       // System.out.println(yesPrepare);
        Scanner scan = new Scanner(filer);
        int c = 1;
        File file = new File("dfsfh"); //название готового файла, создастся в папке проекта
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        File fileerr = new File("error.txt"); //файл куда сливаются ошибочные блоки
        fileerr.createNewFile();
        FileWriter writer2 = new FileWriter(fileerr);


        String message = "";

        while (scan.hasNextLine()){
            String nextLine = scan.nextLine();
            String  ch;
            try {
                 ch = nextLine.substring(0, 7);
            }catch (Exception e){
                continue;
            }

            //String firstSymbol = String.valueOf(ch);
            if (ch.equals("TRIGGER")){
                //System.out.println(message);
                message=message.replace('\"','\n');


                //writer.write(message + "\n\n");
                // System.out.println(message);
               // System.out.println("время" + worker1.CountTime("111" + message));
               // System.out.println("время" + worker1.CalcTime(worker1.CountTime("tri" + message)));
                String ppp= worker1.CountTime("tri" + message);
                //String toWrite = worker1.CalcTime(worker1.CountTime("tri" + message));
                String toWrite = worker1.CalcTime(ppp);
                writer.write(toWrite);
                //System.out.println(ppp);
                System.out.println(toWrite);
                //send message
                message = "";
                continue;
            }
            message = message + nextLine + "\n";


            //System.out.println(nextLine);







            //writer.write(nextLine);
            c++;
        }
        writer.flush();
        writer.close();



        try {
            writer2.write(mainClass.error);
        }catch (Exception e){
            System.out.println("Ошибок для записи в файл нет");
        }


        System.out.println("Получено блоков: " + mainClass.workedCount);
        System.out.println("Ошибки получения времени: " + mainClass.errorCount);
        System.out.println("Ошибки вычисления времени: " + mainClass.errorCalcCount);
        System.out.println("Ошибки вычисления времени LOG: " + mainClass.errorLog);
        System.out.println("рассчет типа init "+mainClass.init);
        System.out.println("рассчет типа noinit "+ mainClass.noinit);
        System.out.println("рассчет типа rail "+mainClass.rail);
        System.out.println("рассчет типа nochouse "+mainClass.nochouse);
        System.out.println("рассчет типа initNOstart "+mainClass.initNOstart);


      //  String string2 = "02.12.2021 15:54:52";
       // DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
      //  LocalDateTime date2 = LocalDateTime.parse(string2, formatter2);


     //   String string = "02.12.2021 15:54:42";
     //   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
      //  LocalDateTime date = LocalDateTime.parse(string, formatter);

     //   System.out.println(date); // 2010-01-02

       // long millis2 = date2.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
     //   long millis1 = date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
       // System.out.println(millis2-millis1);
//02.12.2021 15:54:42

    }

}
