import java.io.*;

public class WeatherAnalyzer {

    public static void main(String args[])
    throws Exception {

        BufferedReader br =
        new BufferedReader(
        new FileReader(args[0]));

        String line;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while((line = br.readLine()) != null) {

            String data[] = line.split("\t");

            int temp =
            Integer.parseInt(data[1]);

            if(temp > max)
                max = temp;

            if(temp < min)
                min = temp;
        }

        System.out.println("Maximum Temperature: "+max);

        System.out.println("Minimum Temperature: "+min);

        br.close();
    }
}
