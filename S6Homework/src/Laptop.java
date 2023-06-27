import java.util.*;

public class Laptop {
    String modelName;
    int ram;
    int storage;
    String graphicsCard;
    String operatingSystem;


    /***
     * Constructor
     */
    public Laptop(String modelName, int ram, int storage, String graphicsCard, String operatingSystem) {
        this.modelName = modelName;
        this.ram = ram;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
        this.operatingSystem = operatingSystem;
    }


    /***
     * Launch filter request and printing result
     */
    public static void launchFilter(HashSet<Laptop> laptops) {
        Map<String, String> filterCriteria = getFilterCriteria();
        List<Laptop> filteredLaptops = filterLaptops(laptops, filterCriteria);
        printLaptops(filteredLaptops);
    }


    /***
     * Request filter from user
     * @return chosen filter stored in map<criteriaName,userChoice>
     */
    private static Map<String, String> getFilterCriteria() {
        Map<String, String> filterCriteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose criteria:");
        System.out.println("1 - RAM");
        System.out.println("2 - Storage");
        System.out.println("3 - Graphics");
        System.out.println("4 - Operating System");
        System.out.print("Criteria:");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        switch (choice) {
            case 1:
                System.out.print("Enter min RAM value (GB): ");
                int ram = scanner.nextInt();
                filterCriteria.put("ram", String.valueOf(ram));
                break;
            case 2:
                System.out.print("Enter min storage value (TB): ");
                int storage = scanner.nextInt();
                filterCriteria.put("storage", String.valueOf(storage));
                break;
            case 3:
                System.out.print("Enter graphics: ");
                String graphics = scanner.nextLine();
                filterCriteria.put("graphics", graphics);
                break;
            case 4:
                System.out.print("Enter operating system: ");
                String os = scanner.nextLine();
                filterCriteria.put("os", os);
                break;
            default:
                System.out.println("Wrong choice");
        }
        return filterCriteria;
    }


    /***
     * @param laptops - set of laptops
     * @param filterCriteria - map of chosen criteria
     * @return ArrayList of laptops, found by criteria
     */
    private static List<Laptop> filterLaptops(HashSet<Laptop> laptops, Map<String, String> filterCriteria) {
        List<Laptop> filteredLaptops = new ArrayList<>();

        for (Laptop laptop : laptops) {
            boolean passFilter = true;

            for (Map.Entry<String, String> entry : filterCriteria.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                switch (key) {
                    case "ram":
                        if (laptop.getRam() < Integer.parseInt(value)) {
                            passFilter = false;
                        }
                        break;
                    case "storage":
                        if (laptop.getStorage() < Integer.parseInt(value)) {
                            passFilter = false;
                        }
                        break;
                    case "graphics":
                        if (!laptop.getGraphicsCard().equalsIgnoreCase(value)) {
                            passFilter = false;
                        }
                        break;
                    case "os":
                        if (!laptop.getOperatingSystem().equalsIgnoreCase(value)) {
                            passFilter = false;
                        }
                        break;
                    default:
                        System.out.println("Wrong criteria");
                        passFilter = false;
                }

                if (!passFilter) {
                    break;
                }
            }

            if (passFilter) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }


    /***
     * Print filter result
     */
    private static void printLaptops(List<Laptop> laptops) {
        System.out.println("\nLaptops found:\n");
        for (Laptop laptop : laptops) {
            System.out.println(" - " + laptop);
        }
    }


    /***
     * Getters
     */
    public String getModelName() {
        return modelName;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }


    /***
     * equals() - all fields included, except model name
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram
                && storage == laptop.storage
                && graphicsCard.equals(laptop.graphicsCard)
                && Objects.equals(operatingSystem,
                laptop.operatingSystem);
    }


    /***
     * hashCode() - all fields included
     */
    @Override
    public int hashCode() {
        return Objects.hash(modelName, ram, storage, graphicsCard, operatingSystem);
    }


    /***
     * toString() - all fields included
     */
    @Override
    public String toString() {
        return modelName +
                " [ RAM:" + ram + "GB" +
                ", Storage:" + storage + "TB" +
                ", Graphics:" + graphicsCard +
                ", OS:" + operatingSystem + " ]";
    }
}
