package cl.proyecto.inventario.crud.pedido.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.proyecto.inventario.crud.pedido.dto.PedidoDTO;
import cl.proyecto.inventario.crud.pedido.repository.PedidoRepository;
import cl.proyecto.inventario.crud.pedido.service.IPedidoService;

@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    PedidoRepository repo;

    @Override
    public PedidoDTO insert(PedidoDTO pedido) {
        return repo.save(pedido);
    }

    @Override
    public PedidoDTO update(int id, PedidoDTO pedido) {
        pedido.setIdPedido(id);
        return repo.save(pedido);
    }

    @Override
    public PedidoDTO delete(int id) {
        PedidoDTO pedido = repo.findById(id).orElse(null);
        if (pedido != null) {
            repo.deleteById(id);
        }
        return pedido;
    }

    @Override
    public PedidoDTO getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<PedidoDTO> getAll() {
        return (List<PedidoDTO>) repo.findAll();
    }
}
