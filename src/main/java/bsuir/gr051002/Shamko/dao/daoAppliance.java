package bsuir.gr051002.Shamko.dao;

import bsuir.gr051002.Shamko.entity.Appliance;
import bsuir.gr051002.Shamko.entity.criteria.Criteria;

import java.util.ArrayList;

public interface daoAppliance {
    ArrayList<Appliance> find(Criteria criteria) throws DaoException;

}
