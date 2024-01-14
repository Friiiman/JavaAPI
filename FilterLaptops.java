import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;

public class FilterLaptops {
    public static void filterLaptops(Set<modelAndBrandLaptop> laptops) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Predicate<modelAndBrandLaptop>> filters = new HashMap<>();

        filters.put("brand", laptop -> {
            System.out.print("Введите бренд: ");
            String brand = scanner.nextLine();
            return laptop.brand.equalsIgnoreCase(brand);
        });

        filters.put("model", laptop -> {
            System.out.print("Введите модель: ");
            String model = scanner.nextLine();
            return laptop.model.equalsIgnoreCase(model);
        });

        filters.put("price", laptop -> {
            System.out.print("Введите цену: ");
            int price = scanner.nextInt();
            return laptop.price == price;
        });

        System.out.print("Введите критерии фильтрации через пробел (brand, model, price): ");
        String[] filterArray = scanner.nextLine().split(" ");

        Predicate<modelAndBrandLaptop> filter = laptop -> true;
        for (String filterName : filterArray) {
            if (filters.containsKey(filterName)) {
                filter = filter.and(filters.get(filterName));
            }
        }

        laptops.stream()
                .filter(filter)
                .forEach(System.out::println);
    }


}
