import java.util.*;
import java.util.function.Predicate;


public class laptopShop {

    public static void main(String[] args) {
        modelAndBrandLaptop laptop1 = new modelAndBrandLaptop("MSI", "Modern 14", 32999);
        modelAndBrandLaptop laptop2 = new modelAndBrandLaptop("MSI", "Titan GT77", 488999);
        modelAndBrandLaptop laptop3 = new modelAndBrandLaptop("IRBIS", "NB 257", 15999);
        modelAndBrandLaptop laptop4 = new modelAndBrandLaptop("IRBIS", "17NBP4500", 49999);
        modelAndBrandLaptop laptop5 = new modelAndBrandLaptop("ACER", "Extensa 15", 25199);
        modelAndBrandLaptop laptop6 = new modelAndBrandLaptop("ACER", "Nitro", 109999);
        modelAndBrandLaptop laptop7 = new modelAndBrandLaptop("HUAWEI", "MateBook D 15", 44999);
        modelAndBrandLaptop laptop8 = new modelAndBrandLaptop("HUAWEI", "MateBook B3-410", 97999);
        modelAndBrandLaptop laptop9 = new modelAndBrandLaptop("HONOR", "MagicBook X15", 52999);
        modelAndBrandLaptop laptop10 = new modelAndBrandLaptop("HONOR", "MagicBook 16", 89999);
        modelAndBrandLaptop laptop11 = new modelAndBrandLaptop("Apple", "MacBook Air", 81899);
        modelAndBrandLaptop laptop12 = new modelAndBrandLaptop("Apple", "MacBook Pro", 297999);

        Set<modelAndBrandLaptop> laptops = new HashSet<>();

        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);
        laptops.add(laptop6);
        laptops.add(laptop7);
        laptops.add(laptop8);
        laptops.add(laptop9);
        laptops.add(laptop10);
        laptops.add(laptop11);
        laptops.add(laptop12);

        System.out.println(laptops);

        filterLaptopsTwo(laptops);
    }

    public static void filterLaptopsTwo(Set<modelAndBrandLaptop> laptops) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите критерий фильтрации: ");
        System.out.println("1 - по бренду");
        System.out.println("2 - по модели");
        System.out.println("3 - по цене");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Predicate<modelAndBrandLaptop> predicate = null;

        switch (choice) {
            case 1:
                System.out.println("Введите бренд: ");
                String brand = scanner.nextLine();
                predicate = laptop -> laptop.brand.equalsIgnoreCase(brand);
                break;
            case 2:
                System.out.println("Введите модель: ");
                String model = scanner.nextLine();
                predicate = laptop -> laptop.model.equalsIgnoreCase(model);
                break;
            case 3:
                System.out.println("Введите минимальную цену: ");
                int minPrice = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Введите максимальную цену: ");
                int maxPrice = scanner.nextInt();
                scanner.nextLine();
                predicate = laptop -> laptop.price >= minPrice && laptop.price <= maxPrice;
                break;
            default:
                System.out.println("Некорректный выбор");
                return;
        }

        laptops.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
