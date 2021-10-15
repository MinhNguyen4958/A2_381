package assignments.a2code;

import javafx.util.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Project {
    private ArrayList<TTrackSubscriber> subs;
    private String title_name;
    private LocalTime tracker_timer;
    private Duration break_timer;
    private LocalDate tracker_date;
    private boolean TrackerStatus;

    public Project() {
    }


    public void addSubscriber(TTrackSubscriber newSub) { subs.add(newSub); }

    private void notifySubs() { subs.forEach(TTrackSubscriber::modelUpdated); }

}
