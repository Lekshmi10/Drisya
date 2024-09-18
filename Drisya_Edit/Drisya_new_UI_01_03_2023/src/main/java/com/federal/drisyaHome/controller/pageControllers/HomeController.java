package com.federal.drisyaHome.controller.pageControllers;

import com.federal.drisyaHome.model.HomeTemplate;
import com.federal.drisyaHome.model.Retirement;
import com.federal.drisyaHome.model.RetirementView;
import com.federal.drisyaHome.model.RetirementViewData;
import com.federal.drisyaHome.service.home.HomeService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    HomeService homeService;

    @GetMapping("/home")
    public HomeTemplate fetchHomepage() throws IOException{
    	
        return homeService.fetchHomepage();

    }
    @PostMapping("/homePublish")
    public String  publish(@RequestBody HomeTemplate template) throws Exception {
        return homeService.publish(template);
    }
    
	
	  @PostMapping("/retirementPublish") public void publishRetirement(@RequestBody
	  String str) throws Exception {
	 // System.out.println("FLAG"+str.getFlag()+" "+str.getData());
	  homeService.publishRetirement(str); 
	  }
    
	/*
	 * @GetMapping("/retirementView") public RetirementView
	 * getApplicationRetirementView() { RetirementViewData retirementViewData=new
	 * RetirementViewData();
	 * System.out.println("Retirement"+retirementViewData.toString()); return
	 * applicationSideMenuService.getApplicationRetirementView(); }
	 */
    
	
	  @PostMapping("/vrsPublish") public void publishVrs(@RequestBody String str)
	  throws Exception { homeService.publishVrs(str);
	  
	  }
	 

}
