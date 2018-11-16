package Util;

public class Log {
    private final static boolean isOn=true;
    public static void d(String title,String info){
        if(isOn){
            System.out.println(title+"------->>"+info);
        }

    }
}
