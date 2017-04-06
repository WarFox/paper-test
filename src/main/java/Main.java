import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> strings = Arrays.asList(in.nextLine().split(" "));
        List<Integer> collect = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
        bootstrap(collect);
    }

    public static void bootstrap(List<Integer> houses) {
        final App app = new StreetApp(houses);
        app.process();
    }


}
