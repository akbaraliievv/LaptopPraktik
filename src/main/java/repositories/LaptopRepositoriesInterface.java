package repositories;

import enums.OperationSystem;
import model.Laptops;

import java.util.List;
import java.util.Map;

public interface LaptopRepositoriesInterface {
    Laptops saveProgrammer(Laptops laptop);

    public List<Laptops> saveAll(List<Laptops> laptops);

    public Laptops deleteById(Long id);

    public void deleteAll();

    public List<Laptops> findAll();

    public Laptops update(Long id, Laptops laptop);

    Map<OperationSystem, List<Laptops>> groupBy();

    List<Laptops> sortByDifferentColumn(String column, String ascOrDesc);
}
