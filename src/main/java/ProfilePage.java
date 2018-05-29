import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Надежда on 23.05.2018.
 */
public class ProfilePage {
    public String getResult(String athleteId) {
        String url = "https://games.crossfit.com/athlete/"+athleteId;
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

    public BenchMarkStats getBenchMarkStats(String athleteId, String html){
        BenchMarkStats benchMarkStats = new BenchMarkStats(athleteId);
        Document doc = Jsoup.parse(html);
        if (doc.getElementsByClass("stats-header").size()>0) {
            benchMarkStats.setBackSquat(doc.getElementsByClass("stats-header").get(0).parentNode().childNode(3).toString().replace("<td>", "").replace("</td>", "").trim());
            benchMarkStats.setCleanAndJerk(doc.getElementsByClass("stats-header").get(1).parentNode().childNode(3).toString().replace("<td>", "").replace("</td>", "").trim());
            benchMarkStats.setSnatch(doc.getElementsByClass("stats-header").get(2).parentNode().childNode(3).toString().replace("<td>", "").replace("</td>", "").trim());
            benchMarkStats.setDeadLift(doc.getElementsByClass("stats-header").get(3).parentNode().childNode(3).toString().replace("<td>", "").replace("</td>", "").trim());
            benchMarkStats.setFightGoneBad(doc.getElementsByClass("stats-header").get(4).parentNode().childNode(3).toString().replace("<td>", "").replace("</td>", "").trim());
            benchMarkStats.setMaxPullUps(doc.getElementsByClass("stats-header").get(5).parentNode().childNode(3).toString().replace("<td>", "").replace("</td>", "").trim());
            benchMarkStats.setFran(doc.getElementsByClass("stats-header").get(6).parentNode().childNode(3).toString().replace("<td>", "").replace("</td>", "").trim());
            benchMarkStats.setGrace(doc.getElementsByClass("stats-header").get(7).parentNode().childNode(3).toString().replace("<td>", "").replace("</td>", "").trim());
            benchMarkStats.setHelen(doc.getElementsByClass("stats-header").get(8).parentNode().childNode(3).toString().replace("<td>", "").replace("</td>", "").trim());
            benchMarkStats.setFilthy50(doc.getElementsByClass("stats-header").get(9).parentNode().childNode(3).toString().replace("<td>", "").replace("</td>", "").trim());
            benchMarkStats.setSprint400m(doc.getElementsByClass("stats-header").get(10).parentNode().childNode(3).toString().replace("<td>", "").replace("</td>", "").trim());
            benchMarkStats.setRun5k(doc.getElementsByClass("stats-header").get(11).parentNode().childNode(3).toString().replace("<td>", "").replace("</td>", "").trim());
        }
        return benchMarkStats;
    }
}
