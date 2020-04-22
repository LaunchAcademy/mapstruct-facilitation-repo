package com.launchacademy.javaserializationdto.dtos;

import com.launchacademy.javaserializationdto.models.Wine;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WineDTO {
  private Integer id;
  private String brandName;
  private String winery;
  private String variety;
  private Integer price;
  private String bottleTop;
  private String originCity;
  private String originProvince;
  private String originCountry;
  private Integer volumeInMl;

  public void setIsCorked(Boolean isCorked) {
    if(isCorked) {
      bottleTop = "cork";
    }
    else {
      bottleTop = "screwtop";
    }
  }

  public double getVolumeInOz() {
    return volumeInMl * 0.033814;
  }


  public static WineDTO fromWine(Wine wine) {
      WineDTO dto = new WineDTO();
      dto.setBrandName(wine.getBrandName());
      dto.setWinery(wine.getWinery());
      dto.setVariety(wine.getVariety());
      dto.setPrice(wine.getPrice());

      //...
      return dto;
  }
}
