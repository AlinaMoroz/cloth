package com.example.mobile_app.rest;

import com.example.mobile_app.database.clothes.Type;
import com.example.mobile_app.database.clothes.ClothReadDto;
import com.example.mobile_app.service.ClothService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cloth")
public class ClothController {

    private final ClothService clothService;


}
