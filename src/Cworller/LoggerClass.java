package Cworller;

public class LoggerClass extends Logger {
    LoggerClass(){}
    @Override
    void log(String logMessage){
        System.out.println(logMessage);
    }
    @Override
    void alert(String alertMessage){
        System.out.println(alertMessage);
    }
}
