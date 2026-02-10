package com.programacion.cloud.repo;

import com.programacion.cloud.db.Vehiculo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class VehiculoRepo implements PanacheRepositoryBase<Vehiculo,Long> {
}
