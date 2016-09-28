public class Main {

    public static void main(String[] args) {
        StudyRoom studyRoom = new StudyRoom();

        for(int i=0;i<10;i++){
            new Student(studyRoom).start();         //creates 10 students for eating and studying.
        }

        new DeliveryBoy(studyRoom).start();         //delivery boy to get pizza delivered.
    }
}
