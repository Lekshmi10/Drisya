package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.model.Miscellaneous;
import com.federal.drisyaHome.service.home.MiscellaneousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/miscellaneous")
public class MiscellaneousController {

    @Autowired
    MiscellaneousService miscellaneousService;

    @GetMapping("/")
    public Miscellaneous getMiscellaneosAd() {
        return miscellaneousService.getMiscellaneous();
    }

    @PostMapping("/add")
    public Miscellaneous setMiscellaneosAd(@RequestBody Miscellaneous adsData) {
        return miscellaneousService.setMiscellaneous(adsData);
    }
}
