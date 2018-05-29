import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Надежда on 22.05.2018.
 */
public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        String menLBurl = "https://games.crossfit.com/competitions/api/v1/competitions/regionals/2018/leaderboards?division=1&regional=22&sort=0&page=1";
        createCSVLeaderBoardbyURL(menLBurl,"athletesMen.csv");

        String womenLBurl = "https://games.crossfit.com/competitions/api/v1/competitions/regionals/2018/leaderboards?division=2&regional=22&sort=0&page=1";
        createCSVLeaderBoardbyURL(womenLBurl,"athletesWomen.csv");

        String teamsLBurl = "https://games.crossfit.com/competitions/api/v1/competitions/regionals/2018/leaderboards?division=11&regional=22&sort=0&page=1";
        createCSVLeaderBoardbyURL(teamsLBurl,"athletesTeams.csv");
    }

    public static void createCSVLeaderBoardbyURL(String url, String fileName){
        LeaderBoard lb = new LeaderBoard();
        String result = lb.getResult(url);
        ArrayList<Athlete> athletes = lb.parseResponse(result);

        ProfilePage pp = new ProfilePage();
        HashMap<String,BenchMarkStats> benchMarkForAthlete = new HashMap<>();
        for (Athlete athlete : athletes) {
            result = pp.getResult(athlete.getCompetitorId());
            benchMarkForAthlete.put(athlete.getCompetitorId(),pp.getBenchMarkStats(athlete.getCompetitorId(), result));
        }
        CSVFile.writeToCSV(athletes,benchMarkForAthlete, fileName);
    }
}
