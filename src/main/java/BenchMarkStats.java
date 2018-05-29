/**
 * Created by Надежда on 23.05.2018.
 */

public class BenchMarkStats {
    private String athleteId;
    private String backSquat;
    private String cleanAndJerk;
    private String snatch;
    private String deadLift;
    private String fightGoneBad;
    private String maxPullUps;
    private String fran;
    private String grace;
    private String helen;
    private String filthy50;
    private String sprint400m;
    private String run5k;

    public BenchMarkStats(String athleteId){
        setAthleteId(athleteId);
        setBackSquat("--");
        setCleanAndJerk("--");
        setRun5k("--");
        setSprint400m("--");
        setFilthy50("--");
        setDeadLift("--");
        setFightGoneBad("--");
        setFran("--");
        setGrace("--");
        setHelen("--");
        setMaxPullUps("--");
        setSnatch("--");
    }

    public String getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(String athleteId) {
        this.athleteId = athleteId;
    }

    public String getBackSquat() {
        return backSquat;
    }

    public void setBackSquat(String backSquat) {
        this.backSquat = LBToKG(backSquat);
    }

    public String getCleanAndJerk() {
        return cleanAndJerk;
    }

    public void setCleanAndJerk(String cleanAndJerk) {
        this.cleanAndJerk = LBToKG(cleanAndJerk);
    }

    public String getSnatch() {
        return snatch;
    }

    public void setSnatch(String snatch) {
        this.snatch = LBToKG(snatch);
    }

    public String getDeadLift() {
        return deadLift;
    }

    public void setDeadLift(String deadLift) {
        this.deadLift = LBToKG(deadLift);
    }

    public String getFightGoneBad() {
        return fightGoneBad;
    }

    public void setFightGoneBad(String fightGoneBad) {
        this.fightGoneBad = fightGoneBad;
    }

    public String getMaxPullUps() {
        return maxPullUps;
    }

    public void setMaxPullUps(String maxPullUps) {
        this.maxPullUps = maxPullUps;
    }

    public String getFran() {
        return fran;
    }

    public void setFran(String fran) {
        this.fran = fran;
    }

    public String getGrace() {
        return grace;
    }

    public void setGrace(String grace) {
        this.grace = grace;
    }

    public String getHelen() {
        return helen;
    }

    public void setHelen(String helen) {
        this.helen = helen;
    }

    public String getFilthy50() {
        return filthy50;
    }

    public void setFilthy50(String filthy50) {
        this.filthy50 = filthy50;
    }

    public String getSprint400m() {
        return sprint400m;
    }

    public void setSprint400m(String sprint400m) {
        this.sprint400m = sprint400m;
    }

    public String getRun5k() {
        return run5k;
    }

    public void setRun5k(String run5k) {
        this.run5k = run5k;
    }

    private String LBToKG(String in){
        String out=in;
        float lbTokg = (float) 0.453592;
        if(in.contains("lb")){
            in = in.replace("lb","").trim();
            out = String.valueOf(Integer.parseInt(in)*lbTokg);
        } else if (in.contains("kg")){
            out = in.replace("kg","").trim();
        }
        return out;
    }
}
