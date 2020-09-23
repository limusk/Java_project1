package junit;

import domain.Employee;
import org.junit.Test;
import service.NameListService;
import service.TeamException;

import java.awt.*;

/**
 * @auther limusk
 * @create 2020-09--15:47
 * @project project3
 */

public class NameListServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++){
            System.out.println(employees[i]); //需要重写toString方法

        }
    }

    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id = 15;

        try{
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }
    }


}
