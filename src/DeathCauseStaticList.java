import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class DeathCauseStaticList {
    List<DeathCauseStatistic> deathCauseStatistics = new ArrayList<>();

    public void repopulate(String path) throws FileNotFoundException {
        deathCauseStatistics = new ArrayList<>();
        File file = new File(path);
        if(file.exists()){
            Scanner sc = new Scanner(file);
            sc.nextLine(); //kod
            sc.nextLine(); //ogółem
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                deathCauseStatistics.add(DeathCauseStatistic.fromCsvLine(line));
            }
        }
    }

    public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n){
        List<DeathCauseStatistic> result = new ArrayList<>(deathCauseStatistics);

        result = result.stream().sorted((d1,d2) -> {
            int a = d1.getAgeBracketDeaths(age).deathCount;
            int b = d2.getAgeBracketDeaths(age).deathCount;

            if(a==b){
                return 0;
            }
            else if(a > b){
                return -1;
            }
            else{
                return 1;
            }

        })
                .limit(n).collect(Collectors.toList());
        return result;
    }
}
