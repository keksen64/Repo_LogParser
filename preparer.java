package mainPack;
//этот класс не используется
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class preparer {
        public static String GetPrepare (String string){


                System.out.println("замена 1/4");
                StringBuffer sb1 = new StringBuffer(string);
                Pattern p1 = Pattern.compile("\n\"");
                Matcher m1 = p1.matcher(sb1);
                String s1 = m1.replaceAll("\nTRIGGER");

                System.out.println("замена 2/4");
                StringBuffer sb2 = new StringBuffer(s1);
                Pattern p2 = Pattern.compile("\"\"");
                Matcher m2 = p2.matcher(sb2);
                String s2 = m2.replaceAll("99");

                System.out.println("замена 3/4");
                StringBuffer sb3 = new StringBuffer(s2);
                Pattern p3 = Pattern.compile("\"\n");
                Matcher m3 = p3.matcher(sb3);
                String s3 = m3.replaceAll("\nTRIGGER");

                System.out.println("замена 4/4");
                StringBuffer sb4 = new StringBuffer(s3);
                Pattern p4 = Pattern.compile("\t99$");
                Matcher m4 = p4.matcher(sb4);
                String s4 = m4.replaceAll("\t99\nTRIGGER");



//                System.out.println("Старт замены");
//                System.out.println("замена 1/4");
//                Scanner scanner1 = new Scanner(string);
//                String string1 = "";
//                Pattern pat1 = Pattern.compile("(^\")");
//                int ct = 1;
//                while (scanner1.hasNextLine()){
//                        //string1 = string1 + scanner1.nextLine().replaceAll("^\"", "TRIGGER") + "\n";
//                        if(ct == 1){
//                                continue;
//                        }else {
//                                string1 = string1 + pat1.matcher(scanner1.nextLine()).replaceAll("TRIGGER") + "\n";
//                        }
//
//                }
//
//                System.out.println("замена 2/4");
//                Scanner scanner2 = new Scanner(string1);
//                String string2 = "";
//                Pattern pat2 = Pattern.compile("\"\"");
//                while (scanner2.hasNextLine()){
//                        string2 = string2 + pat2.matcher(scanner2.nextLine()).replaceAll("99") + "\n";
//                }
//
//                System.out.println("замена 3/4");
//                Scanner scanner3 = new Scanner(string2);
//                String string3 = "";
//                Pattern pat3 = Pattern.compile("\"$");
//                while (scanner3.hasNextLine()){
//                        //string1 = string1 + scanner1.nextLine().replaceAll("^\"", "TRIGGER") + "\n";
//                        string3 = string3 + pat3.matcher(scanner3.nextLine()).replaceAll("\nTRIGGER") + "\n";
//                }
//
//                System.out.println("замена 4/4");
//                Scanner scanner4 = new Scanner(string3);
//                String string4 = "";
//                Pattern pat4 = Pattern.compile("\t99$");
//                while (scanner4.hasNextLine()){
//                        //string1 = string1 + scanner1.nextLine().replaceAll("^\"", "TRIGGER") + "\n";
//                        string4 = string4 + pat4.matcher(scanner4.nextLine()).replaceAll("\t99\nTRIGGER") + "\n";
//                }




                //Pattern p1 = Pattern.compile("\n\"");
                //String s1 = p1.matcher(string).replaceAll("\nTRIGGER");
                //String s1 = string.replaceAll("\n\"", "\nTRIGGER");
             //   String s2 = s1.replaceAll("\"\"", "99");
              //  String s3 = s2.replaceAll("\"\\$", "\nTRIGGER");
             //   String s4 = s3.replaceAll("\t99\\$", "\t99\nTRIGGER");
                return s4;
        }
        }
