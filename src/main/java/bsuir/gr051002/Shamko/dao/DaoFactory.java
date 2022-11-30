package bsuir.gr051002.Shamko.dao;

import bsuir.gr051002.Shamko.dao.impl.FileApplianceDAOImpl;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final daoAppliance applianceDAO = new FileApplianceDAOImpl();

    private DaoFactory() {}

    public daoAppliance getApplianceDAO() {
        return applianceDAO;
    }

    public static DaoFactory getInstance() {
        return instance;
    }
}
