package ro.euvt.tp.classroomDistancing.email;

public interface EmailSender {
    default void send(String to, String email){

    }
}
