package com.example.erp.dao.implementation;
import com.example.erp.bean.Employee;
import com.example.erp.bean.Placement;
import com.example.erp.bean.Student;
import com.example.erp.dao.PlacementDao;
import com.example.erp.dao.StudentDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PlacementDaoImpl implements PlacementDao {
    public Placement fetchPlacementId(String placement_id){
        try(Session session = SessionUtil.getSession()){
           Query query = session.createQuery("from Placement where id=:placementId");
           query.setParameter("placementId", placement_id);
           for(final Object fetch:query.list())
               return (Placement) fetch;
        }
        catch(HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }
}
