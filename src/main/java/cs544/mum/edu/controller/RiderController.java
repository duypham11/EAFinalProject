package cs544.mum.edu.controller;

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
	
	
}
