import java.io.FileNotFoundException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //DeathCauseStatistic deathCauseStatistic = DeathCauseStatistic.fromCsvLine("A04.7          ,758,-,-,-,-,-,1,-,1,3,5,9,12,30,58,64,94,161,192,95,33\n");
        //Stream.of(deathCauseStatistic.deaths).forEach(s -> System.out.println(s));



        DeathCauseStaticList deathCauseStaticList = new DeathCauseStaticList();
        deathCauseStaticList.repopulate("zgony.csv");
        deathCauseStaticList.mostDeadlyDiseases(100,4).stream().forEach((s) -> System.out.println(s.getCode()));
    }
}