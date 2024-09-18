package com.federal.drisyaHome.controller.home;
import com.federal.drisyaHome.model.MustRead;
import com.federal.drisyaHome.service.home.MustReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/mustRead")
public class MustReadController {
	  @Autowired
	    MustReadService mustReadService;

	    @GetMapping("/")
	    public MustRead getMustReadContents() {
	    	
	    	System.out.println("Inside Must read controller*****");
	        return mustReadService.getMustReadContents();
	    }
	    @PostMapping("/add")
	    public MustRead setMustReadContents(@RequestBody MustRead mustReadData) {
	        return mustReadService.setMustReadContents(mustReadData);
	    }
}
