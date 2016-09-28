import java.util.concurrent.Semaphore;

/**
 * Created by pasindu on 9/24/16.
 */
class StudyRoom{
        private int pizzaSlices = 8;
        private Semaphore pizzaPlate = new Semaphore(1);
        private Semaphore callKamal = new Semaphore(0);    //since only one call should be given to Kamal.

    void startStudying() throws InterruptedException {
            pizzaPlate.acquire();             //trying to grab the pizza plate.
            if(pizzaSlices > 0){
                pizzaSlices--;                 //eat one slice.
                System.out.println("Student no." + Thread.currentThread().getId()+ " took a slice.");
                pizzaPlate.release();          //releasing pizza plate for others to grab.
            }
            else {                             //the who have no slices, call Kamal.
                System.out.println("Called DeliveryBoy.");
                callKamal.release();
            }
    }

    void checkAnyOrder() throws InterruptedException {
                callKamal.acquire();            //waiting for students to call.
                System.out.println("New Pizza delivered!");
                pizzaSlices = 8;                //fill back new slices.
                pizzaPlate.release();           //let the pizza plate to students to eat.
    }
}
