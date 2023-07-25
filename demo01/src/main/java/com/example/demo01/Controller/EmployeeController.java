package com.example.demo01.Controller;


import com.example.demo01.entity.Employee;
import com.example.demo01.service.EmployeeServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServicelmpl employeeServicelmpl;

    @GetMapping("/")

    public String viewHomePage(Model model){

        model.addAttribute("listall",employeeServicelmpl.getAllEmployee());
        return "index";

    }
    @GetMapping("/create")
    public String create(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "create";
    }

    @PostMapping("/save")
    public String save (@ModelAttribute("employee") Employee employee){
        employeeServicelmpl.save(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id")long id, Model model){
    Employee employee = employeeServicelmpl.getByID(id);
    model.addAttribute("employee",employee);
    return "update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") long id){

    employeeServicelmpl.deleteViaId(id);
        return "redirect:/";
    }



}
