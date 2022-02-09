package mainPack;
//работает по воле божьей
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class worker1 {
    public static String CountTime(String string) {

        try {
            String id = "00000";
            //System.out.println(string);///////////////////////////////////////
            Scanner scan = new Scanner(string);
            String time1 = "НАЧАЛО НЕ НАЙДЕНО";
            String time2 = "ошибка!";


            String bigRPV = "";
            String smallRPV = "";
            String init = "";
            String rail = "";
            String end = "ошибка!";
            String absStart = "";
            String absEnd = "";

            Boolean isbigRPV = false;
            Boolean issmallRPV = false;
            Boolean israil = false;
            Boolean isinit = false;
            Boolean isend = false;
            int iterCount = 0;
            //int commCount = 1;
            //int num = 342;
            while (scan.hasNextLine()) {
                iterCount++;
                String nextLine = scan.nextLine();
               // System.out.println("LINE     :"+nextLine);////////////////////////
                String tr="22222222";
                try {

                    tr = nextLine.substring(0, 3);
                    //System.out.println("log" + tr);
                } catch (Exception e) {
                   // e.printStackTrace();
                    continue;
                }

                if (tr.equals("tri")) {
                   // System.out.println("nextLine        :" + nextLine);////////////////////////////
                    String[] subStr = nextLine.split("\t");
                    //System.out.println("log" + subStr[0].substring(4, 9));
                    try{
                        id = subStr[0].substring(3, 8);
                    }catch (Exception e){
                        id = "Ошибка получение id";
                    }



                    //num = Integer.parseInt(subStr[1]);
                    //System.out.println(num);
                    continue;
                }

                String time;
                String comm;
                //  System.out.println(nextLine);
                try{String[] subStr2 = nextLine.split(" :: ");
                     time = subStr2[0];
                     comm = subStr2[1];

                }catch (Exception e){
                    continue;
                }


                absEnd=time;


                // System.out.println(time);
                //System.out.println(comm);
                time2 = "ОШИБКА! Последняя строка: " + comm ;
                if(comm.equals("расчет поставлен в очередь")){
                    smallRPV= time;
                    issmallRPV = true;


                }
                if(comm.equals("\nрасчет поставлен в очередь")){
                    smallRPV= time;
                    issmallRPV = true;
                }

                if(comm.equals("\nРасчёт поставлен в очередь...")){
                    bigRPV= time;
                    isbigRPV = true;
                }

                if(comm.equals("Расчёт поставлен в очередь...")){
                    bigRPV= time;
                    isbigRPV = true;
                }

                if(comm.equals("\nрасчет тарифов в rail tariff")&&issmallRPV==false&&isbigRPV==false){
                    rail= time;
                    israil = true;
                }

                if(comm.equals("расчет тарифов в rail tariff")&&issmallRPV==false&&isbigRPV==false){
                    rail= time;
                    israil = true;
                }
                if(iterCount==2){
                    absStart = time;
                }

               // if(comm.equals("\nрасчет тарифов в rail tariff")){
               //     time1= time;
              //  }
               // if(comm.equals("расчет тарифов в rail tariff")){
              //      time1= time;
              //  }Инициализация расчёта
                if(comm.equals("Инициализация расчёта")){
                    init=time;
                    isinit = true;

                }if(comm.equals("\nИнициализация расчёта")){
                    init=time;
                    isinit = true;
                }

                if(comm.equals("выполнен")){
                    end=time;
                    isend=true;
                    break;

                }
                if(comm.equals("Выполнен")){
                    end=time;
                    isend=true;
                    break;
                }



            }
            String res = time1 + " splitTrigger " + time2 + " splitTrigger " + id ;

            if(isbigRPV&&isinit&&isend){
                res = "type init splitTrigger " + bigRPV + " splitTrigger " + init + " splitTrigger " + end + " splitTrigger " +id + " splitTrigger " + absStart + " splitTrigger " + absEnd;
                mainClass.init++;
                mainClass.workedCount++;
                return res;
            }
            if(issmallRPV&&isinit&&isend){
                res = "type init splitTrigger " +  smallRPV + " splitTrigger " + init + " splitTrigger " + end + " splitTrigger " +id + " splitTrigger " + absStart + " splitTrigger " + absEnd;
                mainClass.init++;
                mainClass.workedCount++;
                return res;
            }
            if(issmallRPV&&isinit==false&&isend){
                res = "type NOinit splitTrigger " +  smallRPV + " splitTrigger null splitTrigger " + end + " splitTrigger " +id + " splitTrigger " + absStart + " splitTrigger " + absEnd;
                mainClass.noinit++;
                mainClass.workedCount++;
                return res;
            }
            if(isbigRPV&&isinit==false&&isend){
                res = "type NOinit splitTrigger " +  bigRPV + " splitTrigger null splitTrigger " + end + " splitTrigger " +id + " splitTrigger " + absStart + " splitTrigger " + absEnd;
                mainClass.noinit++;
                mainClass.workedCount++;
                return res;
            }
            if(israil&&isbigRPV==false&&issmallRPV==false&&isend){
                res = "type rail splitTrigger " +  rail + " splitTrigger null splitTrigger " + end + " splitTrigger " +id + " splitTrigger " + absStart + " splitTrigger " + absEnd;
                mainClass.rail++;
                mainClass.workedCount++;
                return res;
            }
            if(isinit&&isend&&isbigRPV==false&&issmallRPV==false){
                res = "type initNOTqueue splitTrigger null splitTrigger " + init + " splitTrigger " + end + " splitTrigger " +id + " splitTrigger " + absStart + " splitTrigger " + absEnd;
                mainClass.initNOstart++;
                mainClass.workedCount++;
                return res;
            }




            mainClass.nochouse++;
            mainClass.error = mainClass.error + string +"\n\n\n\n\n";
            return res;

        }catch (Exception e){
            mainClass.errorCount++;
            mainClass.error = mainClass.error + string +"\n\n\n\n\n";
            return "1";
        }

    }

    public static String CalcTime(String string){

        try {
            String[] subSubStr = string.split(" splitTrigger ");

            String absStart = subSubStr[5];
            String absEnd = subSubStr[6];


            DateTimeFormatter absFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            LocalDateTime dateAbsStart = LocalDateTime.parse(absStart, absFormatter);
            LocalDateTime dateAbsEnd = LocalDateTime.parse(absEnd, absFormatter);

            long millisAbsStart = dateAbsStart.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            long millisAbsEnd = dateAbsEnd.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

            long absTime = (millisAbsEnd - millisAbsStart)/1000;




            String type = subSubStr[0];
            if(type.equals("type init")){
                String startTime = subSubStr[1];
                String initTime = subSubStr[2];
                String endTime = subSubStr[3];
                String id = subSubStr[4];

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
                LocalDateTime datestartTime = LocalDateTime.parse(startTime, formatter);
                LocalDateTime dateinitTime = LocalDateTime.parse(initTime, formatter);
                LocalDateTime dateendTime = LocalDateTime.parse(endTime, formatter);

                long millisstartTime = datestartTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                long millisinitTime = dateinitTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                long millisendTime = dateendTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                long queueTime = (millisinitTime - millisstartTime)/1000;
                long worktime = (millisendTime-millisinitTime)/1000;



                return "________INIT;" + id + ";" + absTime + ";" + Long.toString(worktime) + ";" + Long.toString(queueTime) +"\n";
            }
            if(type.equals("type NOinit")){

                String startTime = subSubStr[1];
                String endTime = subSubStr[3];
                String id = subSubStr[4];

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
                LocalDateTime datestartTime = LocalDateTime.parse(startTime, formatter);
                LocalDateTime dateendTime = LocalDateTime.parse(endTime, formatter);

                long millisstartTime = datestartTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                long millisendTime = dateendTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();


                long worktime = (millisendTime-millisstartTime)/1000;



                return "______NOINIT;" + id + ";" + absTime + ";" + Long.toString(worktime) +"\n";

            }
            if(type.equals("type rail")){
                String startTime = subSubStr[1];
                String endTime = subSubStr[3];
                String id = subSubStr[4];

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
                LocalDateTime datestartTime = LocalDateTime.parse(startTime, formatter);
                LocalDateTime dateendTime = LocalDateTime.parse(endTime, formatter);

                long millisstartTime = datestartTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                long millisendTime = dateendTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();


                long worktime = (millisendTime-millisstartTime)/1000;



                return "________RAIL;" + id + ";" + absTime + ";" + Long.toString(worktime) +"\n";

            }
            if(type.equals("type initNOTqueue")){
                String inittTime = subSubStr[2];
                String endTime = subSubStr[3];
                String id = subSubStr[4];

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
                LocalDateTime dateinitTime = LocalDateTime.parse(inittTime, formatter);
                LocalDateTime dateendTime = LocalDateTime.parse(endTime, formatter);

                long millisinitTime = dateinitTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                long millisendTime = dateendTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();


                long worktime = (millisendTime-millisinitTime)/1000;



                return "INITNOTSTART;" + id + ";" + absTime + ";" + Long.toString(worktime) +"\n";
            }





            //String string2 = "02.12.2021 15:54:52";
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
//            LocalDateTime date1 = LocalDateTime.parse(subSubStr[1], formatter);
//            LocalDateTime date0 = LocalDateTime.parse(subSubStr[0], formatter);
//
//            long millis2 = date1.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//            long millis1 = date0.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//            long res = (millis2-millis1)/1000;
//
//            String id = subSubStr[2];
//            String ret = id + ";" + Long.toString(res) + "\n";




            mainClass.errorLog = mainClass.errorLog + "\n" + string;
            mainClass.errorCalcCount++;

            return "ERRRRRRRRRRRRRRRRRRRRRRRROOOOOOOOOOOOOOOOOOOOOOORRRRRRRRRRRRRRRRRRR";





        }catch (Exception e){
            mainClass.errorLog = mainClass.errorLog + "\n" + string;
            mainClass.errorCalcCount++;
            return "";
        }
    }

}
