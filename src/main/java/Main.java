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
        String menGames = "https://games.crossfit.com/competitions/api/v1/competitions/games/2019/leaderboards?division=1&sort=0&page=1";
        createCSVLeaderBoardByURL(menGames, "athletesMenGames2019.csv");

        String womenGames = "https://games.crossfit.com/competitions/api/v1/competitions/games/2019/leaderboards?division=2&sort=0&page=1";
        createCSVLeaderBoardByURL(womenGames, "athletesWomenGames2019.csv");
    }

    public static void createCSVLeaderBoardByURL(String url, String fileName) {
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
