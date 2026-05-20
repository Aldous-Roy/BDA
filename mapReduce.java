import java.io.*;
import java.util.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {

    public static class Map
    extends Mapper<Object,Text,Text,IntWritable>{

        static IntWritable one =
        new IntWritable(1);

        Text word = new Text();

        public void map(Object key,
        Text value,
        Context context)
        throws IOException, InterruptedException {

            StringTokenizer st =
            new StringTokenizer(value.toString());

            while(st.hasMoreTokens()) {

                word.set(st.nextToken());

                context.write(word, one);
            }
        }
    }

    public static class Reduce
    extends Reducer<Text,IntWritable,
    Text,IntWritable>{

        public void reduce(Text key,
        Iterable<IntWritable> values,
        Context context)
        throws IOException, InterruptedException {

            int sum = 0;

            for(IntWritable val : values) {
                sum += val.get();
            }

            context.write(key,
            new IntWritable(sum));
        }
    }

    public static void main(String args[])
    throws Exception {

        Configuration conf =
        new Configuration();

        Job job =
        Job.getInstance(conf,"WordCount");

        job.setJarByClass(WordCount.class);

        job.setMapperClass(Map.class);

        job.setReducerClass(Reduce.class);

        job.setOutputKeyClass(Text.class);

        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job,
        new Path(args[0]));

        FileOutputFormat.setOutputPath(job,
        new Path(args[1]));

        System.exit(
        job.waitForCompletion(true)?0:1);
    }
}
