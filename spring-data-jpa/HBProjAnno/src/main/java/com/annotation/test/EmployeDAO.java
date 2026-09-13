package com.annotation.test;

import com.annotation.domain.Employee;
import com.annotation.util.HibernateUtil;
import com.annotation.util.HibernateUtils;
import org.hibernate.*;

import java.util.List;
import java.util.Objects;

public class EmployeDAO {

    public void save(){
        Session session = null;
        boolean flag=false;
        Transaction transaction = null;
        Employee employee = null;
        int idVal=0;
        //get Session
        session= HibernateUtils.getSession();

        try{
            transaction = session.beginTransaction();
            //create domain class object
            employee = new Employee();
            employee.setId((int)2);
            employee.setFirstName("pallavi");
            employee.setLastName("Kumari");
            //save the object
            session.save(employee);
            transaction.commit();
        }
        catch (HibernateException e){
            e.printStackTrace();
            flag=false;
        }
        catch (Exception e){
            e.printStackTrace();
            flag=false;
        }
        finally {
            if(flag==true){
                transaction.commit();
                System.out.println("Object saved successfully");
            }
            //close session
            HibernateUtil.closeSession(session);
            HibernateUtil.closeSessionFactory();
        }
    }
    public Employee findById(int id){
        Session session = null;
        boolean flag=false;
        Employee employee = null;
        int idVal=0;
        //get session
        session= HibernateUtils.getSession();

        try{
            employee = (Employee) session.load(Employee.class, id);
            System.out.println(employee.getId()+":"+employee.getFirstName()+":"+employee.getLastName());
        }catch(HibernateException e){
            e.printStackTrace();
            flag=false;
        }catch (NullPointerException e){
            if(employee==null){
                System.out.println("Employee not found");
            }
        }
        catch (ObjectNotFoundException e){
            if(Objects.isNull(employee)){
                System.out.println("Employee not found");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            flag=false;
        }finally {
            HibernateUtil.closeSession(session);
            HibernateUtil.closeSessionFactory();
        }
        return  employee;
    }
//    public List<Employee> findAll(){
//
//        //create the session object
//        Session session = null;
//        SessionFactory sessionFactory=null;
//        List<Employee> employeeList=null;
//
//        //get the Session object
//        session= HibernateUtils.getSession();
//
//    }
}
