import java.util.Random;

/**
 * Created by pasindu on 9/24/16.
 */
class Student extends Thread{
    private StudyRoom studyRoom;
    private Random r = new Random();            //to generate random value for sleeping.

    @Override
    public void run(){
        while(true) {
            try {
                studyRoom.startStudying();
                sleep(r.nextInt(9000));             //randomly sleep each thread.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    Student(StudyRoom studyRoom){
       this.studyRoom = studyRoom;
    }
}
