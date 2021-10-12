package com.example.template.services;

import com.example.template.dtos.AsdasdRequestDTO;
import com.example.template.dtos.AsdasdResponseDTO;

import com.example.template.exceptions.AsdasdDontFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAsdasdService {
    AsdasdResponseDTO create(AsdasdRequestDTO AsdasdRequestDTO);
    AsdasdResponseDTO getById(long id) throws AsdasdDontFoundException;
    List<AsdasdResponseDTO> getAll();
    AsdasdResponseDTO update(long id, AsdasdRequestDTO AsdasdRequestDTO) throws AsdasdDontFoundException;
    boolean delete(long id) throws AsdasdDontFoundException;
}
