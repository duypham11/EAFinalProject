package cs544.mum.edu.controller;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.service.RiderService;

@Controller
//@RequestMapping(value="/rider")
public class RiderController {

	@Autowired
	private RiderService riderService;	
	
	@RequestMapping(value="/rider/{id}", method = RequestMethod.GET)
	public ModelAndView homePage(@PathVariable("id") long id) {		
		ModelAndView model = new ModelAndView("/rider/pacerl_list");
		List<Parcel> pacerlList = riderService.getRider(id).getParcelList();
		System.out.println("======list=Parcel==" + pacerlList.size());
		model.addObject("pacerl_list", pacerlList);		
		return model;
	}
	
	
=======
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RiderController {
	@RequestMapping(value = {"/rider"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	
		return "rider";
	}
>>>>>>> 9ef70778f0dab23276eada2b829b26811ae3e3c0
}
