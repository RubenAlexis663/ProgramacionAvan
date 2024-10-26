package com.api.sexshop.Services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProvedorService {

    private List<ProvedorEntity> provedores;

    public ProvedorService() {
        provedores = new ArrayList<>();
        provedores.add(new ProvedorEntity(UUID.randomUUID(), "SexToys", "sextoys21@gmail.com", 234123, "CR 6 #12-43"));
        provedores.add(new ProvedorEntity(UUID.randomUUID(), "LoveLife Supplies", "lovelife.supply@gmail.com", 314589, "Av 19 #45-12"));
        provedores.add(new ProvedorEntity(UUID.randomUUID(), "Intimex", "contact@intimex.com", 213456, "CL 7 #18-56"));
        provedores.add(new ProvedorEntity(UUID.randomUUID(), "Pleasure Paradise", "info@pleasureparadise.com", 345678, "CR 15 #25-34"));
        provedores.add(new ProvedorEntity(UUID.randomUUID(), "SensualArt", "ventas@sensualart.com", 456789, "AV 9 #11-23"));
        provedores.add(new ProvedorEntity(UUID.randomUUID(), "Erotika Shop", "contacto@erotikashop.com", 567890, "CR 8 #14-67"));
        provedores.add(new ProvedorEntity(UUID.randomUUID(), "Desire Plus", "support@desireplus.com", 678901, "CL 10 #20-14"));
        provedores.add(new ProvedorEntity(UUID.randomUUID(), "Passion Store", "ventas@passionstore.com", 789012, "CR 12 #22-50"));
        provedores.add(new ProvedorEntity(UUID.randomUUID(), "Erotic Essence", "info@eroticessence.com", 890123, "AV 15 #30-19"));
        provedores.add(new ProvedorEntity(UUID.randomUUID(), "AmorPro", "contact@amorpro.com", 901234, "CL 5 #14-09"));
    }


    //(GET){READ - ALL}
    public List<ProvedorEntity> getProvedores() {
        return provedores;
    }

    //(GET){READ - ID}
    public Optional<ProvedorEntity> getProvedoresById(UUID id) {
        return provedores.stream().filter(provedor -> provedor.getId().equals(id)).findFirst();
    }

    //(POST){CREATE}
    public String createProvedor(ProvedorEntity provedor) {
        if(!(provedor.getName().isEmpty()) && !(provedor.getEmail().isEmpty()) && !(provedor.getDireccion().isEmpty()) && !(provedor.getTelefono()==0)){
            provedor.setId(UUID.randomUUID());
            provedores.add(provedor);
            return "Se agrego correctamente el provedor "+provedor.getName();
        }
        return "No se pudo agregar el provedor, llena completamente los campos.";
    }

    //(PUT){UPDATE}
    public String updateprovedorById (UUID id, ProvedorEntity provedor) {
        Optional<ProvedorEntity> provedorList = getProvedoresById(id);
        if(provedorList.isPresent() && !(provedor.getName().isEmpty()) && !(provedor.getEmail().isEmpty()) && !(provedor.getDireccion().isEmpty()) && !(provedor.getTelefono()==0)){
            provedorList.get().setName(provedor.getName());
            provedorList.get().setEmail(provedor.getEmail());
            provedorList.get().setDireccion(provedor.getDireccion());
            provedorList.get().setTelefono(provedor.getTelefono());
            return "Se actualizo correctamente el provedor "+provedor.getName();
        }
        return "No se encontro el provedor o no llenaste correctamente los campos.";
    }

    //(DELETE){DELETE}
    public String deleteProvedorById(UUID id) {
        if(getProvedoresById(id).isPresent()){
            provedores.removeIf(provedor -> provedor.getId().equals(id));
            return "Se eliminó el provedor con el id "+id;
        }
        return "No se encontró el provedor.";
    }

}
