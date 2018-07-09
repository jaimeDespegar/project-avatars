package turn;

import java.util.concurrent.TimeUnit;

public class Timer extends Thread {

    private Integer seconds;
    private Boolean passedTime;
    private static final Integer DEFAULT = 5;

    public Timer()
    {
        this.seconds = DEFAULT;
        this.passedTime = Boolean.FALSE;
    }

    public Timer(Integer seconds)
    {
        this.seconds = seconds;
        this.passedTime = Boolean.FALSE;
    }

    public boolean isFinish()
    {
        return this.passedTime;
    }

    public void initTime()
    {
        run();
    }

    public void run()
    {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.passedTime = Boolean.TRUE;
    }

}