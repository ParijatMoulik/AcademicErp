package com.example.erp.dao.implementation;

import com.example.erp.bean.Employee;
import com.example.erp.dao.EmployeeDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public Employee employeeVerify(Employee employee) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Employee where employee_id=:employee_id and department=:department");
            query.setParameter("employee_id", employee.getEmployee_id());
            query.setParameter("department", "Outreach");
            for (final Object fetch : query.list()) {
                return (Employee) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }
}
