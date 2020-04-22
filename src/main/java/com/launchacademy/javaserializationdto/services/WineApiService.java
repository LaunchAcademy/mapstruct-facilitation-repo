package com.launchacademy.javaserializationdto.services;

import com.launchacademy.javaserializationdto.dtos.WineDTO;
import com.launchacademy.javaserializationdto.mappers.WineMapper;
import com.launchacademy.javaserializationdto.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineApiService {
  @Autowired
  private WineRepository wineRepo;

  @Autowired
  private WineMapper wineMapper;

  public Iterable<WineDTO> findAll() {
    return wineMapper.winesToWineDTOs(wineRepo.findAll());
  }
}
