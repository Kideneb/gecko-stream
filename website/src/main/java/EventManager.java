import com.google.api.services.calendar.model.Event;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class EventManager {

  GoogleCalendar calendar;

  public EventManager(GoogleCalendar calendar) {
    this.calendar = calendar;
  }

  public void triggerEvent() throws IOException {
    List<Event> calendarEvents = calendar.readCalendar();

    //Youtube stream

    //website erstellen

    //notifications senden

    //
  }
}
