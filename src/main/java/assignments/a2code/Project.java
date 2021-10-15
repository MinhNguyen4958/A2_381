package assignments.a2code;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Project {
    private ArrayList<TTrackSubscriber> subs;
    private String title_name;
    private LocalTime tracker_timer;
    private LocalDate tracker_date;

    public void addSubscriber(TTrackSubscriber newSub) { subs.add(newSub); }

    private void notifySubs() { subs.forEach(TTrackSubscriber::modelUpdated); }

}
