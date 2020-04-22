package com.launchacademy.javaserializationdto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="wines")
@Getter
@Setter
public class Wine {
  @Id
  @SequenceGenerator(name="wine_generator",
      sequenceName="wines_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE,
      generator="wine_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @Column(name="brand_name")
  private String brandName;

  @Column
  private String winery;

  @Column
  private String variety;

  @Column
  private Integer price;

  @Column(name="is_corked")
  private Boolean isCorked;

  @Column(name="origin_city")
  private String originCity;

  @Column(name="origin_province")
  private String originProvince;

  @Column(name="origin_country")
  private String originCountry;

  @Column(name="volume_ml")
  private Integer volumeInMl;
}
