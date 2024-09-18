package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.model.Blurb;
import com.federal.drisyaHome.service.home.BlurbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/blurb")
public class BlurbController {
    @Autowired
    BlurbService blurbService;

    @GetMapping("/")
    public Blurb getBlurb() {
        return blurbService.getBlurb();
    }

    @PostMapping("/add")
    public Blurb setBlurb(@RequestBody Blurb datas) {
        return blurbService.setBlurb(datas);
    }
}
