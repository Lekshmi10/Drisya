package com.federal.drisyaHome.controller.reference;


import com.federal.drisyaHome.model.Archives;
import com.federal.drisyaHome.service.reference.ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/archives")
public class ArchivesController {

    @Autowired
    ArchivesService archivesService;

    @GetMapping("/")
    public Archives getArchives() {
        return archivesService.getArchives();
    }

    @PostMapping("/add")
    public Archives setArchives(@RequestBody Archives archives) {
        return archivesService.setArchives(archives);
    }
}
