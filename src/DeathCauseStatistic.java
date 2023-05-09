import java.util.regex.Pattern;

public class DeathCauseStatistic {
    Integer[] deaths = new Integer[20];
    private String code;

    DeathCauseStatistic() {

    }

    DeathCauseStatistic(String code, Integer[] deaths) {
        this.code = code;
        this.deaths = deaths;

    }

    public static DeathCauseStatistic fromCsvLine(String line) {
        line = line.trim();
        String[] fields = line.split(",");
        Integer[] deaths = new Integer[20];
        for (int i = 0; i < deaths.length; ++i) {
            String field = fields[i+2];
            Integer f = 0;
            try{
                f = Integer.valueOf(field);
            }
            catch (Exception e){
                f = 0;
            }
            deaths[i] = f;
        }


        return new DeathCauseStatistic(fields[0].trim(), deaths);
    }

    public int deathSum(){
        int result = 0;
        for(Integer deathCount : deaths){
            result += deathCount;
        }
        return result;
    }

    public AgeBracketDeaths getAgeBracketDeaths(int age){
        if(age > 95){
            age = 95;
        }
        int start = age/5*5;
        int end = age/5*5+4;
        int index = age/5;
        AgeBracketDeaths ageBracketDeaths = new AgeBracketDeaths(start,end,deaths[index]);
        return ageBracketDeaths;
    }

    public String getCode() {
        return code;
    }

    public class AgeBracketDeaths {
        public final int young, old, deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }
    }


}
