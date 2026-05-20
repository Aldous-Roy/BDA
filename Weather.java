import java.io.BufferedReader;
import java.io.FileReader;

public class WeatherAnalyzer {

    public static void main(String args[]) {

        try {

            // Open input file
            BufferedReader br =
            new BufferedReader(
            new FileReader("weather.txt"));

            String line;

            // Initial values
            int maxTemperature =
            Integer.MIN_VALUE;

            int minTemperature =
            Integer.MAX_VALUE;

            // Read file line by line
            while((line = br.readLine()) != null) {

                // Split using tab space
                String data[] =
                line.split("\t");

                // Get temperature
                int temp =
                Integer.parseInt(data[1]);

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

            br.close();

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}
