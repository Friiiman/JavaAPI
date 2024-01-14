public class characteristicLaptop extends modelAndBrandLaptop {
    int ram;
    int hdd;
    String cpu;
    String gpu;
    String operatingSystem;

    public characteristicLaptop(String brand, String model, int price, int ram, int hdd, String cpu, String gpu, String operatingSystem) {
        super(brand, model, price);
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
        this.gpu = gpu;
        this.operatingSystem = operatingSystem;
    }
}
