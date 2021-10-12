package com.example.template.controllers;

import com.example.template.dtos.AsdasdRequestDTO;
import com.example.template.dtos.AsdasdResponseDTO;
import com.example.template.exceptions.AsdasdDontFoundException;
import com.example.template.services.IAsdasdService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/Asdasd")
@AllArgsConstructor
public class AsdasdController {

    protected IAsdasdService iAsdasdService;
    @PostMapping("/")
    public ResponseEntity<AsdasdResponseDTO> create(@Valid @RequestBody AsdasdRequestDTO AsdasdRequestDTO){
        return new ResponseEntity<>(iAsdasdService.create(AsdasdRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsdasdResponseDTO> getById(@PathVariable long id) throws AsdasdDontFoundException {
        return new ResponseEntity<>(iAsdasdService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<AsdasdResponseDTO>> getAll(){
        return new ResponseEntity<>(iAsdasdService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsdasdResponseDTO> update(@PathVariable long id, @Valid @RequestBody AsdasdRequestDTO AsdasdRequestDTO) throws AsdasdDontFoundException {
        return new ResponseEntity<>(iAsdasdService.update(id,AsdasdRequestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) throws AsdasdDontFoundException {
        return new ResponseEntity<>(iAsdasdService.delete(id),HttpStatus.NO_CONTENT);
    }
}
