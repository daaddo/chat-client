package it.cascella.chat.logger;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class LoggerManager {
    private static LoggerManager instance = null;
    private boolean verbose = false;

    private LoggerManager() {
    }

    public static LoggerManager getInstance() {
        if (instance == null) {
            instance = new LoggerManager();
        }
        return instance;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    private String now() {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return simpleDateFormat.format(now);
    }

    public void info(String string) {
        System.out.println(now() + " [INFO] " + string);
    }
    public void warn(String string) {
        System.out.println(now() + " [WARNING] " + string);
    }
    public void error(String string) {
        System.out.println(now() + " [ERROR] " + string);
    }
    public void debug(String string) {
        if (verbose) {
            System.out.println(now() + " [DEBUG] " + string);
        }
    }


}
