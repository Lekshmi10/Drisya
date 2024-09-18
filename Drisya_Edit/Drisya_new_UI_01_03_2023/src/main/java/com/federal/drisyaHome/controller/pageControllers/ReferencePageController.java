package com.federal.drisyaHome.controller.pageControllers;

import com.federal.drisyaHome.model.ReferenceTemplate;
import com.federal.drisyaHome.service.reference.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ReferencePageController {
    @Autowired
    ResponseService responseService;

    @GetMapping("/reference")
    public ReferenceTemplate fetchReferencePage() {
        return responseService.fetchHomePage();
    }

    @PostMapping("/publishReferences")
    public String publishReferences(@RequestBody ReferenceTemplate referenceTemplate) throws IOException {
        return responseService.publishReferences(referenceTemplate);
    }

}
