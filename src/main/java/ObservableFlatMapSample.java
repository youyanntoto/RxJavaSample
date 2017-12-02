import io.reactivex.Observable;
import util.RestUtil;

/**
 * sample of Observable
 */
public class ObservableFlatMapSample {

    /**
     * main logic
     */
    public static void main(String[] args) {
        System.out.println("*** main start ***");

        Observable.<RestUtil.Place>create(emitter -> {
            emitter.onNext(RestUtil.Place.TOKYO);
            emitter.onNext(RestUtil.Place.YOKOHAMA);
            emitter.onNext(RestUtil.Place.NAGOYA);
            emitter.onComplete();

        }).flatMap(place -> {
            return Observable.create(emitter -> {
                RestUtil.Weather tokyoWeather = RestUtil.getWeather(place);
                emitter.onNext(tokyoWeather);
                emitter.onComplete();
            });

        }).subscribe(weather -> {
            System.out.println("Next!!");
            System.out.println(weather);

        }, throwable -> {
            System.out.println("Error!!");
            throwable.printStackTrace();

        }, () -> {
            System.out.println("Complete!!");

        });

        System.out.println("*** main end ***");
    }
}
