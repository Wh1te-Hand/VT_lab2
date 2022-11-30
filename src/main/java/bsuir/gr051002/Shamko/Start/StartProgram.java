package bsuir.gr051002.Shamko.Start;

import bsuir.gr051002.Shamko.entity.Appliance;
import bsuir.gr051002.Shamko.entity.Teapot;
import bsuir.gr051002.Shamko.entity.criteria.Criteria;
import bsuir.gr051002.Shamko.service.ApplianceService;
import bsuir.gr051002.Shamko.service.ServiceException;
import bsuir.gr051002.Shamko.service.ServiceFactory;

import java.util.ArrayList;
import java.util.Collections;

public class StartProgram {
    public static void main(String[] args) throws ServiceException {
        ArrayList<Appliance> appliances;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria criteriaTeapot = new Criteria(Teapot.class.getSimpleName());

        appliances = service.find(criteriaTeapot);

        System.out.println("Teapots:");
        PrintInfo.print(appliances); //чайники

        //////////////////////////////////////////////////////////////////

        appliances = new ArrayList<>(Collections.singletonList(service.findLowestCostAppliance()));

        System.out.println("The lowest price:");
        PrintInfo.print(appliances); //самый дешевый товар

    }
}
