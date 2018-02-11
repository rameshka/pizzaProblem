
public class Kamal implements Runnable {
    private SharedData sharedData;

    public Kamal(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void run() {
        try {
            while (true) {
                sharedData.getDeliver().acquire();
                sharedData.getMutex().acquire();
                sharedData.setSlices(8);
                System.out.println("pizza arrived");
                while (sharedData.getSleepCount() != 0) {
                    System.out.println("waking up");
                    sharedData.decrementSleepingCount();
                    sharedData.getSleepingStudent().release();
                }
                sharedData.getMutex().release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
