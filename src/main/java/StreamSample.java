import util.RestUtil;

import java.util.List;
import java.util.stream.Stream;

/**
 * sample of Stream
 */
public class StreamSample {

    /**
     * main logic
     */
    public static void main(String[] args) {
        System.out.println("*** main start ***");

        RestUtil.Weather tokyoWeather = RestUtil.getWeather(RestUtil.Place.TOKYO);
        RestUtil.Weather yokohamaWeather = RestUtil.getWeather(RestUtil.Place.YOKOHAMA);
        RestUtil.Weather nagoyaWeather = RestUtil.getWeather(RestUtil.Place.NAGOYA);

        Stream.of(List.of(tokyoWeather, yokohamaWeather, nagoyaWeather))
                .forEach(weather -> {
                    System.out.println(weather + "");
                });

        System.out.println("*** main end ***");
    }
}
