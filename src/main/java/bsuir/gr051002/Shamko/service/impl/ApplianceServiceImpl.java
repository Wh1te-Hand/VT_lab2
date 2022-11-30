package bsuir.gr051002.Shamko.service.impl;

import bsuir.gr051002.Shamko.dao.DaoException;
import bsuir.gr051002.Shamko.dao.DaoFactory;
import bsuir.gr051002.Shamko.dao.daoAppliance;
import bsuir.gr051002.Shamko.dao.DaoException;
import bsuir.gr051002.Shamko.dao.DaoFactory;
import bsuir.gr051002.Shamko.entity.Appliance;
import bsuir.gr051002.Shamko.entity.criteria.Criteria;
import bsuir.gr051002.Shamko.entity.criteria.SearchCriteria;
import bsuir.gr051002.Shamko.service.ApplianceService;
import bsuir.gr051002.Shamko.service.ServiceException;
import bsuir.gr051002.Shamko.service.validation.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public ArrayList<Appliance> find(Criteria criteria) throws ServiceException {
        if (!Validator.criteriaValidator(criteria)) {
            return null;
        }

        DaoFactory factory = DaoFactory.getInstance();
        daoAppliance applianceDAO = factory.getApplianceDAO();

        ArrayList<Appliance> appliances = new ArrayList<>() {
        };

        try {
            ArrayList<Appliance> applianceInfos = applianceDAO.find(criteria);

            for (Appliance appliance : applianceInfos) {
                if (isMeetsCriteria(appliance, criteria)) {
                    appliances.add(appliance);
                }
            }

        } catch (DaoException e) {
            throw new ServiceException(e);
        } finally {
            return appliances;
        }
    }

    private boolean isMeetsCriteria(Appliance appliance, Criteria criteria) {
        for (Map.Entry<String, Object> entry : criteria.getCriteria().entrySet()) {
            if (!appliance.getFieldByName(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public Appliance findLowestCostAppliance() {
        ArrayList<Appliance> appliances = new ArrayList<Appliance>();
        try {
            appliances.addAll(find(new Criteria(SearchCriteria.Laptop.class.getSimpleName())));
            appliances.addAll(find(new Criteria(SearchCriteria.Oven.class.getSimpleName())));
            appliances.addAll(find(new Criteria(SearchCriteria.Refrigerator.class.getSimpleName())));
            appliances.addAll(find(new Criteria(SearchCriteria.Speakers.class.getSimpleName())));
            appliances.addAll(find(new Criteria(SearchCriteria.TabletPC.class.getSimpleName())));
            appliances.addAll(find(new Criteria(SearchCriteria.VacuumCleaner.class.getSimpleName())));
            appliances.addAll(find(new Criteria(SearchCriteria.Teapot.class.getSimpleName())));

            Collections.sort(appliances);//
        } catch (ServiceException e) {
        } finally {
            return appliances.get(0);
        }
    }
}

