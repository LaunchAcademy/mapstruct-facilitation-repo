package com.launchacademy.javaserializationdto.mappers;

import com.launchacademy.javaserializationdto.dtos.WineDTO;
import com.launchacademy.javaserializationdto.models.Wine;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface WineMapper {
  @Mapping(target = "id", ignore = true)
  WineDTO wineToWineDTO(Wine wine);

  Iterable<WineDTO> winesToWineDTOs(Iterable<Wine> wines);
}
