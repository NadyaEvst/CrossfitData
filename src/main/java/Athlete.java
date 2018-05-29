/**
 * Created by Надежда on 22.05.2018.
 */
public class Athlete {
    private String countryCode;
    private String regionId;
    private String regionalName;
    private String profession;
    private String height;
    private String affiliateId;
    private String divisionId;
    private String regionName;
    private String weight;
    private String affiliateName;
    private String regionCode;
    private String status;
    private String regionalCode;
    private String bibId;
    private String profilePicS3key;
    private String teamCaptain;
    private String competitorId;
    private String firstName;
    private String gender;
    private String age;
    private String lastName;
    private String countryOfOriginCode;
    private String competitorName;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = footToCM(height);
    }

    public String getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = LBToKG(weight);
    }

    public String getAffiliateName() {
        return affiliateName;
    }

    public void setAffiliateName(String affiliateName) {
        this.affiliateName = affiliateName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegionalCode() {
        return regionalCode;
    }

    public void setRegionalCode(String regionalCode) {
        this.regionalCode = regionalCode;
    }

    public String getProfilePicS3key() {
        return profilePicS3key;
    }

    public void setProfilePicS3key(String profilePicS3key) {
        this.profilePicS3key = profilePicS3key;
    }

    public String getTeamCaptain() {
        return teamCaptain;
    }

    public void setTeamCaptain(String teamCaptain) {
        this.teamCaptain = teamCaptain;
    }

    public String getCompetitorId() {
        return competitorId;
    }

    public void setCompetitorId(String competitorId) {
        this.competitorId = competitorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountryOfOriginCode() {
        return countryOfOriginCode;
    }

    public void setCountryOfOriginCode(String countryOfOriginCode) {
        this.countryOfOriginCode = countryOfOriginCode;
    }

    public String getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(String competitorName) {
        this.competitorName = competitorName;
    }

    public String getBibId() {
        return bibId;
    }

    public void setBibId(String bibId) {
        this.bibId = bibId;
    }

    private String LBToKG(String in){
        String out=in;
        float lbTokg = (float) 0.453592;
        if(in.contains("lbs")){
            in = in.replace("lbs","").trim();
            out = String.valueOf(Integer.parseInt(in)*lbTokg);
        } else if (in.contains("kg")){
            out = in.replace("kg","").trim();
        }
        return out;
    }

    private String footToCM(String in){
        String out=in;
        float footToCm = (float) 30.48;
        float inchToCm = (float) 2.54;
        if(in.contains("'")){
            int foots = Integer.parseInt(in.split("'")[0]);
            int inches = Integer.parseInt(in.split("'")[1].replace("\"",""));
            out = String.valueOf(foots*footToCm+inches+inchToCm);
        } else if (in.contains("cm")){
            out = in.replace("cm","").trim();
        }
        return out;
    }

}
