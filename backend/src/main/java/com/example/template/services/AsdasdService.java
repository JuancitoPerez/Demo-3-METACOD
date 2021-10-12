package com.example.template.services;

import com.example.template.dtos.AsdasdRequestDTO;
import com.example.template.dtos.AsdasdResponseDTO;
import com.example.template.exceptions.AsdasdDontFoundException;
import com.example.template.model.Asdasd;
import com.example.template.repositories.AsdasdRepository;
import com.example.template.services.IAsdasdService;
import com.example.template.mappers.MapperAsdasd;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AsdasdService implements IAsdasdService {

    protected AsdasdRepository AsdasdRepository;
    protected MapperAsdasd mapperAsdasd;

    @Override
    public AsdasdResponseDTO create(AsdasdRequestDTO AsdasdRequestDTO) {
        AsdasdResponseDTO AsdasdResponseDTO;
        Asdasd Asdasd;

        Asdasd = mapperAsdasd.toAsdasd(AsdasdRequestDTO);
        Asdasd.setFechaInicioVigencia(LocalDate.now());
        AsdasdResponseDTO = mapperAsdasd.toAsdasdResponseDTO(Asdasd);

        Asdasd AsdasdSave = AsdasdRepository.save(Asdasd);

        AsdasdResponseDTO.setAsdasdId(AsdasdSave.getAsdasdId());

        return AsdasdResponseDTO;
    }

    @Override
    public AsdasdResponseDTO getById(long id) throws AsdasdDontFoundException {
        Optional<Asdasd> optional = AsdasdRepository.findById(id);
        if (optional.isEmpty()){
            throw new AsdasdDontFoundException(id);
        }
        Asdasd Asdasd = optional.get();

        if (!(Asdasd.getFechaFinVigencia()==null)){
            throw new AsdasdDontFoundException(id);
        }

        AsdasdResponseDTO AsdasdResponseDTO = mapperAsdasd.toAsdasdResponseDTO(Asdasd);

        return AsdasdResponseDTO;
    }

    @Override
    public List<AsdasdResponseDTO> getAll() {
        List<Asdasd> AsdasdList;
        List<AsdasdResponseDTO> AsdasdResponseDTOList = new ArrayList<>();

        AsdasdList = AsdasdRepository.findAll();

        for (Asdasd Asdasd: AsdasdList) {
            if (Asdasd.getFechaFinVigencia()==null) {
                AsdasdResponseDTO AsdasdResponseDTO = mapperAsdasd.toAsdasdResponseDTO(Asdasd);
                AsdasdResponseDTOList.add(AsdasdResponseDTO);
            }
        }
        return AsdasdResponseDTOList;
    }

    @Override
    public AsdasdResponseDTO update(long id, AsdasdRequestDTO AsdasdRequestDTO) throws AsdasdDontFoundException {
        Optional<Asdasd> AsdasdOptional  = AsdasdRepository.findById(id);
        if (AsdasdOptional.isEmpty()){
            throw new AsdasdDontFoundException(id);
        }
        Asdasd Asdasd = AsdasdOptional.get();
        if (!(Asdasd.getFechaFinVigencia()==null)){
            throw new AsdasdDontFoundException(id);
        }

        Asdasd AsdasdUpdate = mapperAsdasd.toAsdasd(AsdasdRequestDTO,id);

        AsdasdUpdate.setFechaInicioVigencia(Asdasd.getFechaInicioVigencia());
       AsdasdUpdate = AsdasdRepository.save(AsdasdUpdate);

        AsdasdResponseDTO AsdasdResponseDTO = mapperAsdasd.toBaseDeDatosDTO(baseDeDatosUpdate);

        return AsdasdResponseDTO;
    }

    @Override
    public boolean delete(long id) throws AsdasdDontFoundException {
        Optional<Asdasd> AsdasdOptional  = AsdasdRepository.findById(id);

        if (AsdasdOptional.isEmpty()){
            throw new AsdasdDontFoundException(id);
        }

        Asdasd Asdasd = AsdasdOptional.get();
        Asdasd.setFechaFinVigencia(LocalDate.now());
        AsdasdRepository.save(Asdasd);

        return true;
    }
}
