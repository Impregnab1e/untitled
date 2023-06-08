package Lesson6;
import java.util.*;
//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//        Создать множество ноутбуков (Set).
//        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map или в Сет. Например:
//        “Введите цифру, соответствующую необходимому критерию:
//        1 - цвет
//        2 - бренд


public class Task1 {
    public static void main() {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Apple", "MacBook Pro", "Silver", 1500.99));
        notebooks.add(new Notebook("Dell", "XPS 13", "Rose Gold", 1200.99));
        notebooks.add(new Notebook("Lenovo", "ThinkPad X1 Carbon", "Black", 1850.99));
        notebooks.add(new Notebook("HP", "Spectre x360", "Dark Ash Silver", 1600.99));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите критерии фильтрации (brand, model, color):");
        String[] criteria = scanner.nextLine().split(",");

        Map<String, String> filters = new HashMap<>();
        for (String criterion : criteria) {
            String[] parts = criterion.trim().split(":");
            filters.put(parts[0].trim(), parts[1].trim());
        }

        System.out.println("Результаты фильтрации:");
        Notebook.filterNotebooks(notebooks, filters);
    }
}

class Notebook {
    private String brand;
    private String model;
    private String color;
    private double price;

    public Notebook(String brand, String model, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public static void filterNotebooks(Set<Notebook> notebooks, Map<String, String> filters) {
        for (Notebook notebook : notebooks) {
            boolean matchesFilter = true;

            for (Map.Entry<String, String> entry : filters.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                switch (key) {
                    case "brand":
                        if (!notebook.getBrand().equalsIgnoreCase(value)) {
                            matchesFilter = false;
                        }
                        break;
                    case "model":
                        if (!notebook.getModel().equalsIgnoreCase(value)) {
                            matchesFilter = false;
                        }
                        break;
                    case "color":
                        if (!notebook.getColor().equalsIgnoreCase(value)) {
                            matchesFilter = false;
                        }
                        break;
                }
            }

            if (matchesFilter) {
                System.out.println(notebook);
            }
        }
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}