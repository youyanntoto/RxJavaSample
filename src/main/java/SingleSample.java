import io.reactivex.Single;
import util.RestUtil;

import java.util.List;

/**
 * sample of Single
 */
public class SingleSample {

    /**
     * main logic
     */
    public static void main(String[] args) {
        System.out.println("*** main start ***");

        Single.<List<RestUtil.Weather>>create(emitter -> {
            RestUtil.Weather tokyoWeather = RestUtil.getWeather(RestUtil.Place.TOKYO);
            RestUtil.Weather yokohamaWeather = RestUtil.getWeather(RestUtil.Place.YOKOHAMA);
            RestUtil.Weather nagoyaWeather = RestUtil.getWeather(RestUtil.Place.NAGOYA);
            emitter.onSuccess(List.of(tokyoWeather, yokohamaWeather, nagoyaWeather));

        }).subscribe(weathers -> {
            System.out.println("Complete!!");
            for (RestUtil.Weather weather : weathers) {
                System.out.println(weather);
            }

        }, throwable -> {
            System.out.println("Error!!");
            throwable.printStackTrace();

        });

        System.out.println("*** main end ***");
    }
}
