/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_eco;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author maibenben
 */
public class My_eco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println(NewClass.values().length);
//        NewClass2 jjj= NewClass2.valueOf("jjj");
//         System.out.println(NewClass.values().length);
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
//        try {
//            Date d1 = new Date();
//            Thread.sleep(6000);
//            Date d2 = new Date();
//            long diff = d2.getTime() - d1.getTime();
//            int ne = (int) (TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS))/4;
//            System.out.println("seconds: " + ne);
////            System.out.println(3%2);
//
//        } catch (InterruptedException e) {
//
//        }

//        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
//        String inputString1 = "1 12 2018";
//        String inputString2 = "27 04 1997";
//try {
//    Date date1 = myFormat.parse(inputString1);
//    Date date2 = myFormat.parse(inputString2);
//    long diff = date2.getTime() - date1.getTime();
//    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
//} catch (ParseException e) {
//    e.printStackTrace();
//}
    }

    public enum NewClass2 {
        jikewei("jikewei");
        String nameString;

        private NewClass2(String name) {
            this.nameString = name;
        }

        public String getNameString() {
            return nameString;
        }

        public void setNameString(String nameString) {
            this.nameString = nameString;
        }

    }

}
