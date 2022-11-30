package bsuir.gr051002.Shamko.Start;

import bsuir.gr051002.Shamko.entity.Appliance;

import java.util.List;

public class PrintInfo {
    public static void print(List<Appliance> appliances) {
        if (appliances.size() > 0) {
            for (Appliance appliance : appliances) {
                System.out.println(appliance.toString());
            }
        } else {
            System.out.println("There are no required appliances");
        }
    }
}
