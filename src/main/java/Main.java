import util.RestUtil;

/**
 * sample of non recative
 */
public class Main {

    /**
     * main logic
     */
    public static void main(String[] args) {
        System.out.println("*** main start ***");

        RestUtil.Weather tokyoWeather = RestUtil.getWeather(RestUtil.Place.TOKYO);
        RestUtil.Weather yokohamaWeather = RestUtil.getWeather(RestUtil.Place.YOKOHAMA);
        RestUtil.Weather nagoyaWeather = RestUtil.getWeather(RestUtil.Place.NAGOYA);

        System.out.println(tokyoWeather);
        System.out.println(yokohamaWeather);
        System.out.println(nagoyaWeather);

        System.out.println("*** main end ***");
    }
}
