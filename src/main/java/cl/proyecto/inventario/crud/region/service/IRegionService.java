package cl.proyecto.inventario.crud.region.service;


import cl.proyecto.inventario.crud.region.dto.RegionDTO;
import java.util.List;

public interface IRegionService {
    List<RegionDTO> getAll();
    RegionDTO save(RegionDTO regionDTO);
    RegionDTO getById(int id);
    void delete(int id);
    RegionDTO update(int id, RegionDTO regionDTO);
}
