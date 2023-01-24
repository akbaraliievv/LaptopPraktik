package service;

import enums.OperationSystem;
import model.Laptops;
import repositories.LaptopRepositories;

import java.util.List;
import java.util.Map;

public class LaptopServiceImpl implements LaptopSerivce{
    private LaptopRepositories repositories = new LaptopRepositories();
    public Laptops saveProgrammer(Laptops laptop) {
        return repositories.saveProgrammer(laptop);
    }

    public List<Laptops> saveAll(List<Laptops> laptops) {

        return repositories.saveAll(laptops);
    }

    public Laptops deleteById(Long id) {
        return repositories.deleteById(id);
    }

    public void deleteAll() {
      repositories.deleteAll();
    }

    public List<Laptops> findAll() {
        return repositories.findAll();
    }

    public Laptops update(Long id, Laptops laptop) {
        return repositories.update(id,laptop);
    }

    public Map<OperationSystem, List<Laptops>> groupBy() {
        return repositories.groupBy();
    }

    public List<Laptops> sortByDifferentColumn(String column, String ascOrDesc) {
        return null;
    }
}
