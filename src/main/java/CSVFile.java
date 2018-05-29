import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Надежда on 23.05.2018.
 */
public class CSVFile {
    private static final HashMap<String, String> regionNameById;

    static {
        regionNameById = new HashMap<>();
        regionNameById.put("21", "East");
        regionNameById.put("22", "Europe");
        regionNameById.put("23", "South");
        regionNameById.put("24", "Central");
        regionNameById.put("25", "West");
        regionNameById.put("26", "Latin America");
        regionNameById.put("27", "Atlantic");
        regionNameById.put("28", "Meridian");
        regionNameById.put("29", "Pacific");
        regionNameById.put("32", "All");
    }

    private static final String CSV_SEPARATOR = ";";
    public static void writeToCSV(ArrayList<Athlete> athletes, HashMap<String,BenchMarkStats> stats, String fileName)
    {
        try
            {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputCSV\\" + fileName), "UTF-8"));
            StringBuffer tittles = new StringBuffer();
            tittles.append("CompetitorId");
            tittles.append(CSV_SEPARATOR);
            tittles.append("CompetitorName");
            tittles.append(CSV_SEPARATOR);
            tittles.append("FirstName");
            tittles.append(CSV_SEPARATOR);
            tittles.append("LastName");
            tittles.append(CSV_SEPARATOR);
            tittles.append("Gender");
            tittles.append(CSV_SEPARATOR);
            tittles.append("Age");
            tittles.append(CSV_SEPARATOR);
            tittles.append("CountryCode");
            tittles.append(CSV_SEPARATOR);
            tittles.append("RegionId");
            tittles.append(CSV_SEPARATOR);
                tittles.append("RegionalName");
                tittles.append(CSV_SEPARATOR);
            tittles.append("Profession");
            tittles.append(CSV_SEPARATOR);
            tittles.append("Height_cm");
            tittles.append(CSV_SEPARATOR);
            tittles.append("Weight_kg");
            tittles.append(CSV_SEPARATOR);
            tittles.append("AffiliateId");
            tittles.append(CSV_SEPARATOR);
            tittles.append("AffiliateName");
            tittles.append(CSV_SEPARATOR);
            tittles.append("DivisionId");
            tittles.append(CSV_SEPARATOR);
            tittles.append("RegionName");
            tittles.append(CSV_SEPARATOR);
            tittles.append("RegionCode");
            tittles.append(CSV_SEPARATOR);
            tittles.append("RegionalCode");
            tittles.append(CSV_SEPARATOR);
            tittles.append("Status");
            tittles.append(CSV_SEPARATOR);
            tittles.append("TeamCaptain");
            tittles.append(CSV_SEPARATOR);
            tittles.append("CountryOfOriginCode");
//--------------Benchmark stats
                tittles.append(CSV_SEPARATOR);
                tittles.append("BackSquat_kg");
                tittles.append(CSV_SEPARATOR);
                tittles.append("CleanAndJerk_kg");
                tittles.append(CSV_SEPARATOR);
                tittles.append("Snatch_kg");
                tittles.append(CSV_SEPARATOR);
                tittles.append("DeadLift_kg");
                tittles.append(CSV_SEPARATOR);
                tittles.append("FightGoneBad");
                tittles.append(CSV_SEPARATOR);
                tittles.append("MaxPullUps");
                tittles.append(CSV_SEPARATOR);
                tittles.append("Fran");
                tittles.append(CSV_SEPARATOR);
                tittles.append("Grace");
                tittles.append(CSV_SEPARATOR);
                tittles.append("Helen");
                tittles.append(CSV_SEPARATOR);
                tittles.append("Filthy50");
                tittles.append(CSV_SEPARATOR);
                tittles.append("Sprint400m");
                tittles.append(CSV_SEPARATOR);
                tittles.append("Rn5k");

            bw.write(tittles.toString());
            bw.newLine();
            for (Athlete athlete : athletes)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(athlete.getCompetitorId());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getCompetitorName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getFirstName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getLastName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getGender());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getAge());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getCountryCode());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getRegionId());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(regionNameById.get(athlete.getRegionId()));
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getProfession());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getHeight());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getWeight());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getAffiliateId());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getAffiliateName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getDivisionId());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getRegionName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getRegionCode());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getRegionalCode());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getStatus());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getTeamCaptain());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(athlete.getCountryOfOriginCode());
                oneLine.append(CSV_SEPARATOR);
                BenchMarkStats statsById = stats.get(athlete.getCompetitorId());
                oneLine.append(statsById.getBackSquat());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(statsById.getCleanAndJerk());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(statsById.getSnatch());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(statsById.getDeadLift());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(statsById.getFightGoneBad());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(statsById.getMaxPullUps());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(statsById.getFran());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(statsById.getGrace());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(statsById.getHelen());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(statsById.getFilthy50());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(statsById.getSprint400m());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(statsById.getRun5k());

                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
            catch (UnsupportedEncodingException e) {}
            catch (FileNotFoundException e){}
            catch (IOException e){}
    }
}
