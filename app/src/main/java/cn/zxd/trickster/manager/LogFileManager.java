package cn.zxd.trickster.manager;

public class LogFileManager {
    private static final LogFileManager instance = new LogFileManager();

    public static LogFileManager getInstance() {
        return instance;
    }

    private LogFileManager() {
    }

    
}
