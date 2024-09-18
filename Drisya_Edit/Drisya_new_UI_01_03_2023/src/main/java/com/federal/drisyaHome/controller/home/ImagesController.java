package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.model.Images;
import com.federal.drisyaHome.service.home.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/images")
public class ImagesController {
    @Autowired
    ImagesService imagesService;

    @GetMapping("/")
    public Images getImages() {
        return imagesService.getImages();
    }

    @PostMapping("/add")
    public Images setImage(@RequestBody Images image) {
        return imagesService.setImage(image);
    }
}
