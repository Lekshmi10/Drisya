package com.federal.drisyaHome.controller.reference;


import com.federal.drisyaHome.model.ReferencesWithADLogin;
import com.federal.drisyaHome.service.reference.ReferencesWithADLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/referencesAd")
public class ReferencesWithADLoginController {
    @Autowired
    ReferencesWithADLoginService referencesWithADLoginService;

    @GetMapping("/")
    public ReferencesWithADLogin getReferencesAD() {
        return referencesWithADLoginService.getReferencesAD();
    }

    @PostMapping("/add")
    public ReferencesWithADLogin setReferencesAD(@RequestBody ReferencesWithADLogin reference) {
        return referencesWithADLoginService.setReferencesAD(reference);
    }

}
