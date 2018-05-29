import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Надежда on 22.05.2018.
 */
public class LeaderBoard {
    public String getResult(String url) {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));
        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }

            // Read the response body.
            byte[] responseBody = method.getResponseBody();

            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            String result = new String(responseBody);
            return result;

        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Release the connection.
            method.releaseConnection();
        }
        return null;
    }

    public ArrayList<Athlete> parseResponse(String result) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> entrants = getEntrantsFromResponse(result);
        ArrayList<Athlete> athletes = new ArrayList<>();
        try {
            for (String entrant : entrants) {
                Athlete athlete = mapper.readValue(entrant, Athlete.class);
                athletes.add(athlete);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return athletes;
    }

    public ArrayList<String> getEntrantsFromResponse(String response) {
        ArrayList<String> entrants = new ArrayList<>();
        while (response.indexOf("\"entrant\":") > -1) {
            String entrant = response.substring(response.indexOf("\"entrant\":") + 1, response.indexOf("\"scores\":"));
            String entrantAndScores = response.substring(response.indexOf("\"entrant\":") + 1, response.indexOf("\"cf_rank_order\"") + 15);
            entrants.add(entrant.replace("entrant\": ", ""));
            response = response.replace(entrantAndScores, "");

        }
        return entrants;
    }
}
