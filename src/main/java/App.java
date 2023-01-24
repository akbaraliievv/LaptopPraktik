import configuration.DatabaseConnection;
import enums.OperationSystem;
import model.Laptops;
import service.LaptopSerivce;
import service.LaptopServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        DatabaseConnection.createEntityManagerFactory();
        LaptopSerivce laptopSerivce =  new LaptopServiceImpl();
        Laptops laptops = new Laptops("MAC",OperationSystem.MACBOOK,"512GB",120000,new Date(2020));
        Laptops laptops1 = new Laptops("Lenovo",OperationSystem.WINDOWS,"1024Gb",65000,new Date(2021));
        List<Laptops>laptopsList = new ArrayList<>(List.of(
                new Laptops("Asus",OperationSystem.WINDOWS,"512gb",80000,new Date(2022)),
                new Laptops("HP",OperationSystem.WINDOWS,"256GB",53000,new Date(2022)),
                new Laptops("ACER",OperationSystem.LINUX,"512GB",43000,new Date(2021))));
        while (true){
            System.out.println("""
            1.Save Laptops
            2.Save All
            3.Delete By Id
            4.Delete All
            5.Find All
            6.Update
            7.Group By
            8.Sort By Different Column
        """);
            int a = new Scanner(System.in).nextInt();
            switch (a){
                case 1-> System.out.println(laptopSerivce.saveProgrammer(laptops));
                case 2-> System.out.println(laptopSerivce.saveAll(laptopsList));
                case 3->{
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(laptopSerivce.deleteById(id));}
                case 4->laptopSerivce.deleteAll();
                case 5-> System.out.println(laptopSerivce.findAll());
                case 6->{
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(laptopSerivce.update(id,laptops1));
                }
                case 7-> System.out.println(laptopSerivce.groupBy());
                default -> System.out.println("No such command !!!!!");
            }
        }
    }
}
