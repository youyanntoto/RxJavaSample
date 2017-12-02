import io.reactivex.Completable;
import util.RestUtil;

/**
 * sample of Completable
 */
public class CompletableSample {

    /**
     * main logic
     */
    public static void main(String[] args) {
        System.out.println("*** main start ***");

        Completable.create(emitter -> {
            RestUtil.Weather tokyoWeather = RestUtil.getWeather(RestUtil.Place.TOKYO);
            RestUtil.Weather yokohamaWeather = RestUtil.getWeather(RestUtil.Place.YOKOHAMA);
            RestUtil.Weather nagoyaWeather = RestUtil.getWeather(RestUtil.Place.NAGOYA);

            System.out.println(tokyoWeather);
            System.out.println(yokohamaWeather);
            System.out.println(nagoyaWeather);
            emitter.onComplete();

        }).subscribe(() -> {
            System.out.println("Complete!!");

        }, throwable -> {
            System.out.println("Error!!");
            throwable.printStackTrace();

        });

        System.out.println("*** main end ***");
    }
}
