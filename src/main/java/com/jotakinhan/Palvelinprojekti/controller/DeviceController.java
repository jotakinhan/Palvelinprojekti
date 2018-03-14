package com.jotakinhan.Palvelinprojekti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jotakinhan.Palvelinprojekti.model.Device;
import com.jotakinhan.Palvelinprojekti.model.DeviceRepository;

@Controller
public class DeviceController {
	
	@Autowired
	private DeviceRepository repository;
	
	// login page
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	@RequestMapping(value = "/list") //main page, where list of devices is displayed
    public String deviceList(Model model) {	
		List<Device> devices = repository.findAll();
		model.addAttribute("devices", devices);
        return "list";
    }
  
    @RequestMapping(value = "/add") //a page with a form to add devices
    public String addDevice(Model model){
    	model.addAttribute("device", new Device());
        return "add";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET) //edit page
    public String editDevice(@PathVariable("id") Long deviceId, Model model) {
    	Device device = repository.findOne(deviceId);
    	model.addAttribute("device", device);
    	
        return "edit";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST) //a method for saving new entries
    public String save(Device device){
        repository.save(device);
        return "redirect:list";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET) //a method for deleting entries
    public String deleteDevice(@PathVariable("id") Long deviceId, Model model) {
    	repository.delete(deviceId);
        return "redirect:../list";
    }
    
 // REST service to get all devices
    @RequestMapping(value="/devices", method = RequestMethod.GET)
    public @ResponseBody List<Device> deviceListRest() {	
        return (List<Device>) repository.findAll();
        
    }    

}
