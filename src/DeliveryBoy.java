/**
 * Created by pasindu on 9/24/16.
 */
public class DeliveryBoy extends Thread{
    private StudyRoom studyRoom;

    DeliveryBoy(StudyRoom studyRoom){
        this.studyRoom = studyRoom;
    }
    @Override
    public void run(){
        while(true) {
            try {
                studyRoom.checkAnyOrder();     //DeliveryBoy checks whether there are any orders.
                sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}