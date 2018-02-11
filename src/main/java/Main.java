public class Main {

    public static void main(String[] args) {

        SharedData sharedData = new SharedData();

        Thread thread[] = new Thread[10];

        for (int i=0;i <10;i++){
            thread[i]= new Thread(new Student(sharedData));
            thread[i].start();
        }

        Thread kamal = new Thread(new Kamal(sharedData));
        kamal.start();


    }
}
