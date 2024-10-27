package com.abel.services;

import com.abel.model.Cliente;
import com.abel.model.Factura;
import com.abel.model.dto.DetalleFacturaDTO;
import com.abel.model.dto.FacturaDTO;
import com.abel.repository.ClienteRepository;
import com.abel.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImpl extends GenericServiceImpl<Factura, Integer> implements GenericService<Factura, Integer>{

    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public CrudRepository<Factura, Integer> getDao() {
        return facturaRepository;
    }


    public List<FacturaDTO> findAllFacturas() {
        List<Factura> facturas = findByAll();
        return facturas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

//    private FacturaDTO convertToDTO(Factura factura) {
//        FacturaDTO facturaDTO = new FacturaDTO();
//        facturaDTO.setId(factura.getId());
//        facturaDTO.setFecha(factura.getFecha());
//        facturaDTO.setTotal(factura.getTotal());
//        facturaDTO.setUserId(factura.getUser().getId());
//        facturaDTO.setUsername(factura.getUser().getUsername());
//
//        // Convertir detalles de factura a DTO
//        List<DetalleFacturaDTO> detalleDTOs = factura.getDetalles().stream()
//                .map(detalle -> {
//                    DetalleFacturaDTO detalleDTO = new DetalleFacturaDTO();
//                    detalleDTO.setId(detalle.getId());
//                    detalleDTO.setProducto(detalle.getProducto());
//                    detalleDTO.setCantidad(detalle.getCantidad());
//                    detalleDTO.setPrecio(detalle.getPrecio());
//                    return detalleDTO;
//                })
//                .collect(Collectors.toList());
//
//        facturaDTO.setDetalles(detalleDTOs);
//        return facturaDTO;
//    }


    private FacturaDTO convertToDTO(Factura factura) {
        FacturaDTO facturaDTO = new FacturaDTO();
        facturaDTO.setId(factura.getId());
        facturaDTO.setFecha(factura.getFecha());
        facturaDTO.setTotal(factura.getTotal());
        facturaDTO.setUserId(factura.getUser().getId());
        facturaDTO.setUsername(factura.getUser().getUsername());

        // Convertir detalles de factura a DTO
        List<DetalleFacturaDTO> detalleDTOs = factura.getDetalles().stream()
                .map(detalle -> {
                    DetalleFacturaDTO detalleDTO = new DetalleFacturaDTO();
                    detalleDTO.setId(detalle.getId());
                    detalleDTO.setNombre_producto(detalle.getProducto().getNombre()); // Obtener el nombre del producto
                    detalleDTO.setPrecio_producto(detalle.getProducto().getPrecioUnitario());
                    detalleDTO.setCantidad(detalle.getCantidad());
//                    detalleDTO.setPrecio(detalle.getPrecio());
                    return detalleDTO;
                })
                .collect(Collectors.toList());

        facturaDTO.setDetalles(detalleDTOs);
        return facturaDTO;
    }


    // Método para filtrar facturas por un criterio de búsqueda y convertirlas a DTO
    public List<FacturaDTO> filtrarFacturas(String query) {
        List<Factura> facturas = facturaRepository.findByQuery(query);  // Utilizar la consulta personalizada
        return facturas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    // Método para filtrar facturas por un criterio y convertirlas a DTO
//    public List<FacturaDTO> filtrarFacturas(String query) {
//        // Buscar todas las facturas o hacer una consulta especializada desde el repositorio
//        List<Factura> facturas = facturaRepository.findAll();
//
//        // Filtrar las facturas basadas en el criterio de búsqueda
//        return facturas.stream()
//                .filter(factura ->
//                        String.valueOf(factura.getId()).contains(query) ||  // Filtra por ID
//                                factura.getUser().getUsername().toLowerCase().contains(query.toLowerCase()) ||  // Filtra por username
//                                String.valueOf(factura.getTotal()).contains(query) ||  // Filtra por total
//                                factura.getFecha().toString().contains(query)  // Filtra por fecha
//                )
//                .map(this::convertToDTO)  // Convierte las facturas filtradas a FacturaDTO
//                .collect(Collectors.toList());
//    }


}
