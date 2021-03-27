package brighteststar;

import javafx.util.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/***
 * to run the class call BrightestStar.fireballWrapper()
 */
public class BrightestStar
{
    private static String baseUrl = "https://ssd-api.jpl.nasa.gov/fireball.api";
    private static String dateMin = "date-min=2017-01-01";
    private static String dateMax = "date-max=2021-01-01";
    private static String requiredLoc = "req-loc=true"; // to avoid fetching data without location
    private static String questionMark = "?";
    private static String ampersand = "&";

    //normally such data would be cached
    private static JSONArray jsonData ;

    public static Double fireball(double latitude, String latitudeDirection, double longitude, String longitudeDirection)
    {
        Double maxBrightness = -1.0;
        try {
            if (jsonData == null) {
                jsonData = fetchData();
                if(jsonData == null){
                    return maxBrightness;
                }
            }

            Double minLatitudeInRange = Math.max(latitude - 15, -90);
            Double maxLatitudeInRange = Math.min(latitude + 15, 90);
            Double minLongitudeInRange = Math.max(longitude - 15, -180);
            Double maxLongitudeInRange = Math.min(longitude + 15, 180);

            for (Object entry : jsonData) {
                if (entry instanceof JSONArray) {
                    JSONArray arrayEntry = (JSONArray) entry;
                    Double lat = Double.valueOf(arrayEntry.get(3).toString());
                    String latDirection = arrayEntry.get(4).toString();
                    Double lon = Double.valueOf(arrayEntry.get(5).toString());
                    String lonDirection = arrayEntry.get(6).toString();
                    if (latDirection.equalsIgnoreCase(latitudeDirection)
                        && lonDirection.equalsIgnoreCase(longitudeDirection)) {
                        if (lat >= minLatitudeInRange && lat <= maxLatitudeInRange && lon >= minLongitudeInRange && lon <= maxLongitudeInRange) {
                            if(arrayEntry.get(7)!=null) { //there is no need to handle null pointer for other fields since we fetch data with "req-loc=true" only
                                maxBrightness = Math.max(Double.valueOf(arrayEntry.get(7).toString()),
                                    maxBrightness);
                            }
                        }
                    }
                }
            }

        }catch (Exception e){
            System.out.println("Exception while calculating brightest star for latitude: " + latitude + ", longitude: " + longitude);
            e.printStackTrace();
        }
        return maxBrightness;
    }

    public static JSONArray fetchData ()
    {
        JSONArray data = null;
        try {
            URL url = buildURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            JSONParser parser = new JSONParser();
            if (parser.parse(content.toString()) instanceof JSONObject) {
                JSONObject json = (JSONObject) parser.parse(content.toString());
                if(json.get("data") instanceof JSONArray) {
                    data = (JSONArray) json.get("data");
                }
            }

        } catch (MalformedURLException mue) {
            System.out.println("Exception while fetching the data: " + mue.getMessage());
            mue.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("Exception while fetching the data: " + ioe.getMessage());
            ioe.printStackTrace();
        } catch (ParseException pe) {
            System.out.println("Exception while fetching the data: " + pe.getMessage());
            pe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception while fetching the data: " + e.getMessage());
            e.printStackTrace();
        }
        return data;
    }


    public static void fireballWrapper(){
        jsonData = null;
        ArrayList<Location> locations = new ArrayList<>();
        Location boston = new Location("Boston", 42.36, "N", 71.05, "W");
        Location london = new Location("London", 51.51,"N",0.12,"W");
        Location ncr = new Location("NCR", 28.58, "N", 77.31,"E");
        Location sanFrancisco = new Location("San Francisco", 37.79, "N",122.40, "W");
        locations.add(boston);
        locations.add(london);
        locations.add(ncr);
        locations.add(sanFrancisco);

        HashMap<String, Double> locationsWithBrightestStars = new HashMap<>();
        for (Location location: locations){
            Double brightness = fireball(location.getLatitude(), location.getLatitudeDirection(), location.getLongitude(), location.getLongitudeDirection());
            locationsWithBrightestStars.put(location.getCity(), brightness);
        }

        Pair<String, Double> maxBrightness = new Pair<>("none", -1.0);
        for (String city: locationsWithBrightestStars.keySet()){
            Double currBrightness = locationsWithBrightestStars.get(city);
            if(currBrightness > maxBrightness.getValue()){
                maxBrightness = new Pair<>(city,currBrightness);
            }
        }

        if(maxBrightness.getKey() != "none"){
            System.out.println("The brightest shooting star was found in " + maxBrightness.getKey()+ ", its brightness was " + maxBrightness.getValue());
        }else{
            System.out.println("No brightest shooting stars were found in given locations whiting given time frame");
        }

    }

    private static class Location{
        String city;
        Double latitude;
        String latitudeDirection;
        Double longitude;
        String longitudeDirection;

        public Location (String city, Double latitude, String latitudeDirection, Double longitude, String longitudeDirection) {
            this.city = city;
            this.latitude = latitude;
            this.latitudeDirection = latitudeDirection;
            this.longitude = longitude;
            this.longitudeDirection = longitudeDirection;
        }

        public String getCity ()
        {
            return city;
        }

        public void setCity (String city)
        {
            this.city = city;
        }

        public Double getLatitude ()
        {
            return latitude;
        }

        public void setLatitude (Double latitude)
        {
            this.latitude = latitude;
        }

        public String getLatitudeDirection ()
        {
            return latitudeDirection;
        }

        public void setLatitudeDirection (String latitudeDirection)
        {
            this.latitudeDirection = latitudeDirection;
        }

        public Double getLongitude ()
        {
            return longitude;
        }

        public void setLongitude (Double longitude)
        {
            this.longitude = longitude;
        }

        public String getLongitudeDirection ()
        {
            return longitudeDirection;
        }

        public void setLongitudeDirection (String longitudeDirection)
        {
            this.longitudeDirection = longitudeDirection;
        }
    }

    public static URL buildURL() throws MalformedURLException
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseUrl);
        stringBuilder.append(questionMark);
        stringBuilder.append(dateMin);
        stringBuilder.append(ampersand);
        stringBuilder.append(dateMax);
        stringBuilder.append(ampersand);
        stringBuilder.append(requiredLoc);
        URL url = new URL(stringBuilder.toString());
        return url;
    }
}
