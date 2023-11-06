import htsjdk.samtools.SAMRecord;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.disq_bio.disq.HtsjdkReadsRddStorage;

import java.io.IOException;

public class TestDisq {

    public static void main(String[] args) throws IOException {
        SparkConf sparkConf = new SparkConf().setAppName("WordCount").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<SAMRecord> reads = HtsjdkReadsRddStorage.makeDefault(sc)
                .read("src/test/resources/1.bam")
                .getReads();

        System.out.println(reads.count());

    }
}
