package com.launchacademy.javaserializationdto.mappers;

import com.launchacademy.javaserializationdto.dtos.WineDTO;
import com.launchacademy.javaserializationdto.models.Wine;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-22T11:40:03-0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class WineMapperImpl implements WineMapper {

    @Override
    public WineDTO wineToWineDTO(Wine wine) {
        if ( wine == null ) {
            return null;
        }

        WineDTO wineDTO = new WineDTO();

        wineDTO.setIsCorked( wine.getIsCorked() );
        wineDTO.setBrandName( wine.getBrandName() );
        wineDTO.setWinery( wine.getWinery() );
        wineDTO.setVariety( wine.getVariety() );
        wineDTO.setPrice( wine.getPrice() );
        wineDTO.setOriginCity( wine.getOriginCity() );
        wineDTO.setOriginProvince( wine.getOriginProvince() );
        wineDTO.setOriginCountry( wine.getOriginCountry() );
        wineDTO.setVolumeInMl( wine.getVolumeInMl() );

        return wineDTO;
    }

    @Override
    public Iterable<WineDTO> winesToWineDTOs(Iterable<Wine> wines) {
        if ( wines == null ) {
            return null;
        }

        ArrayList<WineDTO> iterable = new ArrayList<WineDTO>();
        for ( Wine wine : wines ) {
            iterable.add( wineToWineDTO( wine ) );
        }

        return iterable;
    }
}
