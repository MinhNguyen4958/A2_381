package assignments.a2code;

import javafx.util.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Project {
    private ArrayList<TTrackSubscriber> subs;
    private String title_name;
    private LocalTime tracker_timer;
    private LocalDate start_date;
    private LocalDate end_date;

    public void addSubscriber(TTrackSubscriber newSub) { subs.add(newSub); }

    private void notifySubs() { subs.forEach(TTrackSubscriber::modelUpdated); }

    public void addTitle(String title) {
        title_name = title;
        notifySubs();
    }
    public void addTime(LocalTime timer) {
        tracker_timer = timer;
        notifySubs();
    }
    public void addStartDate(LocalDate date) {
        start_date = date;
        notifySubs();
    }
    public void addEndDate(LocalDate date) {
        end_date = date;
        notifySubs();
    }
}
