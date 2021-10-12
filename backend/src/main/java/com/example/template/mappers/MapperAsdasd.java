package com.example.template.mappers;

import com.example.template.dtos.AsdasdRequestDTO;
import com.example.template.dtos.AsdasdResponseDTO;
import com.example.template.model.Asdasd;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperAsdasd {

    public Asdasd toAsdasd(AsdasdRequestDTO AsdasdRequestDTO){
        Asdasd Asdasd = new Asdasd();

        return Asdasd;
    }

    public Asdasd toAsdasd(AsdasdRequestDTO AsdasdRequestDTO, long id){
        Asdasd Asdasd = new Asdasd();

        return Asdasd;
    }

    public AsdasdResponseDTO toAsdasdResponseDTO(Asdasd Asdasd){
        AsdasdResponseDTO AsdasdResponseDTO = new AsdasdResponseDTO();

        return AsdasdResponseDTO;
    }

}
