package com.federal.drisyaHome.controller.reference;


import com.federal.drisyaHome.model.References;
import com.federal.drisyaHome.service.reference.ReferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/references")
public class ReferencesController {
    @Autowired
    ReferencesService referencesService;

    @GetMapping("/")
    public References getReferences()  {
        return referencesService.getReferences();
    }
    @PostMapping("/add")
    public References setReferences(@RequestBody References reference)  {
        return referencesService.setReferences(reference);
    }
}
