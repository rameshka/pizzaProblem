import java.util.concurrent.Semaphore;

public class SharedData {
    private Semaphore deliver = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);
    private int sleepCount =0;
    private Semaphore sleepingStudent = new Semaphore(0);
    private int slices = 0;

    public int getSleepCount() {
        return sleepCount;
    }


    public void setSleepCount() {
        sleepCount +=1;
    }

    public Semaphore getDeliver() {
        return deliver;

    }

    public Semaphore getSleepingStudent() {
        return sleepingStudent;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public int getSlices() {
        return slices;
    }

    public void setSlices(int slices) {
        this.slices = slices;
    }

    public void decrementSlices(){
        slices = slices -1;
    }

    public void decrementSleepingCount(){
        sleepCount -=1;
    }
}
