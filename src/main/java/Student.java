
public class Student implements Runnable {
    private SharedData sharedData;

    public Student(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void run() {
        try {
            while (true) {
                sharedData.getMutex().acquire();
                if (sharedData.getSlices() == 0) {
                    if (sharedData.getSleepCount() ==0) {
                        System.out.println("calling pizza");
                        sharedData.getDeliver().release();
                    }

                    sharedData.setSleepCount();
                    sharedData.getMutex().release();
                    sharedData.getSleepingStudent().acquire();
                }else {
                    sharedData.decrementSlices();
                    sharedData.getMutex().release();
                    Study();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void Study(){

        System.out.println("studying");
    }
}
