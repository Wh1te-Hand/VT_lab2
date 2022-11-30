package bsuir.gr051002.Shamko.service;

import bsuir.gr051002.Shamko.entity.Appliance;
import bsuir.gr051002.Shamko.entity.criteria.Criteria;

import java.util.ArrayList;

public interface ApplianceService {
    ArrayList<Appliance> find(Criteria criteria) throws ServiceException;

    Appliance findLowestCostAppliance() throws ServiceException;

}
