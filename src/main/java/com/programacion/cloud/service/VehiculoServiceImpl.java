package com.programacion.cloud.service;

import com.programacion.cloud.db.Vehiculo;
import com.programacion.cloud.dto.VehiculoDTO;
import com.programacion.cloud.repo.VehiculoRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
@Transactional
public class VehiculoServiceImpl implements IVehiculoService{

    @Inject
    private VehiculoRepo vehiculoRepo;


    @Override
    public boolean delete(Long id) {
        return vehiculoRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void update(VehiculoDTO dto, Long id) {
        var vehi = vehiculoRepo.findById(id);

        if (vehi == null) {
            throw new NotFoundException("Vehículo no encontrado");
        }

        vehi.setMarca(dto.getMarca());
        vehi.setModelo(dto.getModelo());
        vehi.setPrecio(dto.getPrecio());
    }

    @Override
    public void save(VehiculoDTO dto) {
        var vehi = new Vehiculo();
        vehi.setMarca(dto.getMarca());
        vehi.setModelo(dto.getModelo());
        vehi.setPrecio(dto.getPrecio());

        vehiculoRepo.persist(vehi);

    }

    @Override
    public List<VehiculoDTO> getAll() {
        return vehiculoRepo.findAll().stream()
                .map(t->VehiculoDTO.builder()
                        .id(t.getId())
                        .marca(t.getMarca())
                        .modelo(t.getModelo())
                        .precio(t.getPrecio()).build())
                .toList();
    }
}
