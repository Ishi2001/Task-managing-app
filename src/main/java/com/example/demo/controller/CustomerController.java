package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
@Controller
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;
	
//display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listCustomer", customerService.getAllCustomer());
		return "index";
	}
	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) {
		Customer customer=new Customer();
		model.addAttribute("customer", customer);
		return "new_customer";
	}
//	@PostMapping("/saveCustomer")
//	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
//		customerService.saveCustomer(customer);
//		return "redirect:/";
	//}
@PostMapping("/saveCustomer")
public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {
	if (result.hasErrors()) {
		logger.warn("Validation errors occurred while saving customer.");
		// Validation errors occurred, return to the form with error messages
		return "new_customer";
	}

	try {
		customerService.saveCustomer(customer);
		logger.info("Customer saved successfully: {}", customer.getTitle());
	} catch (Exception e) {
		// Handle any other exceptions (e.g., database errors)
		logger.error("An error occurred while saving customer.", e);
		result.rejectValue("title", null, "An error occurred while saving.");
		return "new_customer";
	}

	return "redirect:/";
}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value ="id")long id, Model model) {
		//get customer from service
		logger.debug("Request received to show form for updating customer with ID: {}", id);
		Customer customer=customerService.getCustomerById(id);
		
		//set
		model.addAttribute("customer", customer);
		logger.debug("Form for updating customer with ID {} displayed.", id);
		return "update_customer";
		
	}
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable (value = "id")long id) {
		this.customerService.deleteCustomerById(id);
		return "redirect:/";
	}
	@GetMapping("/tasks")
	public String viewTasks(Model model) {
		List<Customer> tasks = customerService.getAllCustomer();
		LocalDate specificDate = LocalDate.now();
		model.addAttribute("tasks", tasks);
		model.addAttribute("specificDate", specificDate);
		return "task-list";
	}

	@GetMapping("/update-status/{id}")
	public String updateTaskStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (customerService.updateStatus(id)) {
			logger.info("Task status updated successfully for task ID: {}", id);
			redirectAttributes.addFlashAttribute("message", "Update Success");

			return "redirect:/";
		}
		else {
			logger.error("Failed to update task status for task ID: {}", id);
			redirectAttributes.addFlashAttribute("message", "Update Failure");
		}


		return "redirect:/";
	}
}
