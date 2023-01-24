package repositories;

import configuration.DatabaseConnection;
import enums.OperationSystem;
import exceptions.LaptopNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.Laptops;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LaptopRepositories implements LaptopRepositoriesInterface, AutoCloseable {
    private EntityManagerFactory entityManagerFactory = DatabaseConnection.createEntityManagerFactory();

    public void close() throws Exception {
        entityManagerFactory.close();
    }

    public Laptops saveProgrammer(Laptops laptops){
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(laptops);
            entityManager.getTransaction().commit();
            entityManager.close();
            return laptops;
        }catch (LaptopNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Laptops> saveAll(List<Laptops> laptops) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            for (Laptops laptop : laptops) {
                entityManager.persist(laptop);}
            entityManager.getTransaction().commit();
            entityManager.close();
            return laptops;
        }
        catch (LaptopNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Laptops deleteById(Long id){
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Laptops deletedById = entityManager.createQuery("select l from Laptops l where l.id = :id", Laptops.class).
                    setParameter("id",id)
                    .getSingleResult();
            entityManager.remove(deletedById);
            entityManager.getTransaction().commit();
            entityManager.close();
            return deletedById;
         }catch (LaptopNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void deleteAll() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete Laptops").executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (LaptopNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public List<Laptops> findAll() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptops> laptops = entityManager.createQuery("from Laptops ").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return laptops;
        } catch (LaptopNotFoundException e){
            System.out.println(e.getMessage());
        }return null;
    }
    public Laptops update(Long id, Laptops laptop) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Laptops updated = entityManager.getReference(Laptops.class, id);
            updated.setBrand(laptop.getBrand());
            updated.setOperationSystem(laptop.getOperationSystem());
            updated.setMemory(laptop.getMemory());
            updated.setPrice(laptop.getPrice());
            updated.setDateOfIssue(laptop.getDateOfIssue());
            entityManager.getTransaction().commit();
            entityManager.close();
            return updated;
        }catch (LaptopNotFoundException e){
            System.out.println(e.getMessage());
        }return null;
    }
    public Map<OperationSystem, List<Laptops>> groupBy() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Map<OperationSystem, List<Laptops>> group = entityManager.createQuery("select l from Laptops l", Laptops.class)
                    .getResultStream().collect(Collectors.groupingBy(Laptops::getOperationSystem));
            entityManager.getTransaction().commit();
            entityManager.close();
            return group;
        } catch (LaptopNotFoundException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public List<Laptops> sortByDifferentColumn(String column, String ascOrDesc) {
        return null;
    }
}
