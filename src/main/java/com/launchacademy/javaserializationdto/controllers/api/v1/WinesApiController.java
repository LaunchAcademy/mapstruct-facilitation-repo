package com.launchacademy.javaserializationdto.controllers.api.v1;

import com.launchacademy.javaserializationdto.dtos.WineDTO;
import com.launchacademy.javaserializationdto.mappers.WineMapper;
import com.launchacademy.javaserializationdto.models.Wine;
import com.launchacademy.javaserializationdto.repositories.WineRepository;
import com.launchacademy.javaserializationdto.services.WineApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wines")
public class WinesApiController {
//  @Autowired
//  private WineRepository wineRepository;
//
//  @Autowired
//  private WineMapper wineMapper;

    @Autowired
    private WineApiService wineApiService;

//  @GetMapping
//  public Iterable<Wine> getList() {
//    return wineRepository.findAll();
//  }

//  @GetMapping
//  public Iterable<WineDTO> getList() {
//    return wineMapper.winesToWineDTOs(wineRepository.findAll());
//  }

  @GetMapping
  public Iterable<WineDTO> getList() {
    return wineApiService.findAll();
  }
}
