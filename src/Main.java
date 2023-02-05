import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(50, 100, 251, 301, 405, 1);
        Stream<Integer> list = Stream.of(50, 100, 251, 301, 405, 1);
        findMinMax(
                stream,
                Integer::compareTo,
                (min, max) -> System.out.println("min - " + min + "max - " + max)

        );

        task2(list);

    }


    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream
                .sorted(order)
                .collect(toList());
        minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));

    }


    public static void task2(Stream<Integer> stream) {
        System.out.println(stream.filter(e -> e % 2 == 0).count());

    }
}






