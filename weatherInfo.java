import java.io.*;
import java.net.URL;
import org.json.*;

class weather {
     private String city;
     private String state;

     public void weather(city, state) {
          this.city = city;
          this.state = state;
     }

     public String get_weather() {
          String[] r = parse_json(get_info);
          String o = "Temperature in " + city + ", " + state + " is " + r[1] + " weather condition: " + r[0];
          // return o;

          System.out.println(o);
     }

     public String get_info() {

          String weather_str_code = city + ',' + state;

          String uri = "http://api.openweathermap.org/data/2.5/weather?q=";
          String api_key = "a339079c4704cf90448be7e467027c02";

          String url_ = uri + weather_str_code + "&units=imperial&APPID=" + api_key;
          URL url = new URL(url_);
          InputStream is = url.openConnection().getInputStream();

          BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );

          String line = null;
          String line_ = null;
          while( ( line_ = reader.readLine() ) != null )  {
               System.out.println(line_);
               line += line_;
          }
          reader.close();

          return line;
     }

     public String[] parse_json(String json_query) {
          JSONObject obj = new JSONObject(json_query);
          JSONObject w = obj.getJSONArray("weather");
          JSONObject weather = w.getJSONObject(0);
          String condition = getString("description", weather);
          String temperature = String.valueOf(getInt("temp", getObject("main", obj)));
          return [condition, temperature];
     }

}
