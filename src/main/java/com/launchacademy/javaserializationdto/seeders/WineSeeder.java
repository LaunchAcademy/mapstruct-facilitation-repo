package com.launchacademy.javaserializationdto.seeders;


import com.launchacademy.javaserializationdto.models.Wine;
import com.launchacademy.javaserializationdto.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WineSeeder implements CommandLineRunner {
  @Autowired
  private WineRepository wineRepo;

  @Override
  public void run(String... args) throws Exception {

    if(wineRepo.count() == 0) {
      Wine white = new Wine();
      white.setBrandName("Oyster Bay Chardonnay");
      white.setWinery("Oyster Bay");
      white.setVariety("Chardonnay");
      white.setIsCorked(false);
      white.setOriginCity("Oyster Bay");
      white.setOriginProvince("Marlborough");
      white.setOriginCountry("New Zealand");
      white.setPrice(11);
      white.setVolumeInMl(750);
      wineRepo.save(white);

      Wine red = new Wine();
      red.setBrandName("Silver Palm Pinot Noir");
      red.setWinery("Silver Palm");
      red.setVariety("Pinot Noir");
      red.setIsCorked(true);
      red.setOriginCity("Santa Rosa");
      red.setOriginProvince("California");
      red.setOriginCountry("USA");
      red.setPrice(17);
      red.setVolumeInMl(750);
      wineRepo.save(red);
    }

  }
}
