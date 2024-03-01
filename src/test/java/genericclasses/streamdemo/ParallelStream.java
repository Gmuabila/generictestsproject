package genericclasses.streamdemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {
    /** Parallel Streams
     Java Parallel Streams is a feature of Java 8 and higher, meant for utilizing multiple cores of the processor.
     Normally any java code has one stream of processing, where it is executed sequentially. Whereas by using parallel streams,
     we can divide the code into multiple streams that are executed in parallel on separate cores and the final result is the combination of
     the individual outcomes. The order of execution, however, is not under our control. Therefore, it is advisable to use parallel streams in
     cases where no matter what the order of execution is, the result is unaffected and the state of one element does not affect the other as
     well as the source of the data also remains unaffected. A stream is simply a wrapper around a data source, allowing us to
     perform bulk operations on the data in a convenient way. The stream doesn’t store data or make any changes to the underlying data source.
     Rather, it adds support for functional-style operations on data pipelines.                                                                 */

     @Test
    public void testParallelStreamOne(){
        /** Sequential streams use a single thread to process the pipeline:                                                             */
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        listOfNumbers.stream().forEach(number -> System.out.println(number + " " + Thread.currentThread().getName()));
    }

    @Test
    public void testParallelStreamTwo(){
        /** Any stream can easily be transformed from sequential to parallel. We can achieve this by adding the
        parallel method to a sequential stream or by creating a stream using the parallelStream method of a collection:                             */
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        listOfNumbers.parallelStream().forEach(number -> System.out.println(number + " " + Thread.currentThread().getName()));
    }
}
