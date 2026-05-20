import java.io.BufferedReader;
import java.io.StringReader;

public class WeatherAnalyzer {

    public static void main(String args[]) {

        try {

            // Weather data in text form
            String data =
            "25-01-2018\t35\n" +
            "26-01-2018\t40\n" +
            "27-01-2018\t20\n" +
            "28-01-2018\t45\n" +
            "29-01-2018\t15";

            // Read text data
            BufferedReader br =
            new BufferedReader(
            new StringReader(data));

            String line;

            int maxTemperature =
            Integer.MIN_VALUE;

            int minTemperature =
            Integer.MAX_VALUE;

            // Read line by line
            while((line = br.readLine()) != null) {

                // Split using tab
                String values[] =
                line.split("\t");

                // Get temperature
                int temp =
                Integer.parseInt(values[1]);

                // Find maximum
                if(temp > maxTemperature)
                    maxTemperature = temp;

                // Find minimum
                if(temp < minTemperature)
                    minTemperature = temp;
            }

            // Display result
            System.out.println(
            "Maximum Temperature: "
            + maxTemperature);

            System.out.println(
            "Minimum Temperature: "
            + minTemperature);

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}
