package com.programacion.cloud.service;

import com.programacion.cloud.db.Vehiculo;
import com.programacion.cloud.dto.VehiculoDTO;

import java.util.List;

public interface IVehiculoService {
    boolean delete(Long id);
    void update(VehiculoDTO vehiculo,Long id);
    void save(VehiculoDTO vehiculo);
    List<VehiculoDTO> getAll();
}
