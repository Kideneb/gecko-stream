import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.calendar.model.Event;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveBroadcastListResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class YoutubeManager {

  private static final Collection<String> SCOPES = Arrays.asList("https://www.googleapis.com/auth/youtube.readonly");
  private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
  private static final String CREDENTIALS_FILE_PATH = "credentials.json";
    private static final String APPLICATION_NAME = "Google YouTube API Java Quickstart";

  public void init() {

  }

  public static Credential authorize(final NetHttpTransport httpTransport) throws IOException {
    // Load client secrets.
    InputStream in = CalendarQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
    GoogleClientSecrets clientSecrets =
        GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
    // Build flow and trigger user authorization request.
    GoogleAuthorizationCodeFlow flow =
        new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
            .build();
    Credential credential =
        new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    return credential;
  }

  /**
   * Build and return an authorized API client service.
   *
   * @return an authorized API client service
   * @throws GeneralSecurityException, IOException
   */
  public static YouTube getService() throws GeneralSecurityException, IOException {
    final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
    Credential credential = authorize(httpTransport);
    return new YouTube.Builder(httpTransport, JSON_FACTORY, credential)
        .setApplicationName(APPLICATION_NAME)
        .build();
  }

  /**
   * Call function to create API service object. Define and
   * execute API request. Print API response.
   *
   * @throws GeneralSecurityException, IOException, GoogleJsonResponseException
   */
  public static void main(String[] args)
      throws GeneralSecurityException, IOException, GoogleJsonResponseException {
    YouTube youtubeService = getService();
    // Define and execute the API request
    YouTube.LiveBroadcasts.List request = youtubeService.liveBroadcasts().list(Collections.singletonList(""));
    LiveBroadcastListResponse response = request.execute();
    System.out.println(response);
  }

  public String getCreateStreamLink(Event event) {

    return "not implemented yet";
  }
}
