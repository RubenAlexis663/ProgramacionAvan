package com.api.sexshop.Services;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.api.sexshop.Entitys.ClienteEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private List<ClienteEntity> clientes;

    public ClienteService() {
        clientes = new ArrayList<>();
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Deiver", "Torres", 312566458, "deiv@gmail.com", "Cr 87i #123-23"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Camila", "Ramírez", 314569874, "camila.ramirez@gmail.com", "Cl 52 #10-34"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Juan", "Pérez", 316784512, "juanperez@yahoo.com", "Cr 45A #112-56"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Laura", "Gómez", 313258741, "laura.gomez@hotmail.com", "Cl 78 #25-90"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Sofía", "Martínez", 315698754, "sofia.martinez@outlook.com", "Av 68 #102-12"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Carlos", "López", 312478569, "carlos.lopez@gmail.com", "Cl 15 #8-21"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Daniela", "Castro", 319658745, "daniela.castro@gmail.com", "Cr 66 #123-67"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Andrés", "Rodríguez", 311569832, "andres.rod@gmail.com", "Cr 12 #45-78"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Valentina", "Morales", 317564982, "valen.morales@gmail.com", "Cl 9 #24-56"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Felipe", "Hernández", 318963258, "felipe.hernandez@hotmail.com", "Cr 27B #36-14"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Ana", "Fernández", 312458796, "ana.fernandez@gmail.com", "Cl 18 #34-23"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Miguel", "Álvarez", 319852741, "miguel.alvarez@outlook.com", "Cr 85 #75-19"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Paula", "García", 313569874, "paula.garcia@gmail.com", "Cl 60 #14-82"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "José", "Ortega", 316745298, "jose.ortega@yahoo.com", "Av 34 #56-20"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Natalia", "Díaz", 312547963, "natalia.diaz@gmail.com", "Cl 89 #45-67"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Juliana", "Suárez", 314587963, "juliana.suarez@gmail.com", "Cr 7 #67-11"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Sebastián", "Ruiz", 318745632, "sebastian.ruiz@gmail.com", "Cl 54 #20-45"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Gabriela", "Mejía", 317852963, "gabriela.mejia@gmail.com", "Cr 99 #102-30"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "David", "Muñoz", 311478529, "david.munoz@outlook.com", "Av 23 #85-16"));
        clientes.add(new ClienteEntity(UUID.randomUUID(), "Andrea", "Rivas", 315478962, "andrea.rivas@gmail.com", "Cl 5 #45-90"));
    }

    //(GET){READ - ALL}
    public List<ClienteEntity> getClientes() {
        return clientes;
    }

    //(GET){READ - ID}
    public Optional<ClienteEntity> getClienteById(UUID id) {
        return clientes.stream().filter(cliente -> cliente.getId().equals(id)).findFirst();
    }

    //(POST){CREATE}
    public String createCliente(ClienteEntity cliente) {
        if(!(cliente.getNombre().isEmpty()) && !(cliente.getApellido().isEmpty()) && !(cliente.getCorreo().isEmpty())){
            cliente.setId(UUID.randomUUID());
            clientes.add(cliente);
            return "Se agrego correctamente el cliente "+cliente.getNombre();
        }
        return "No se pudo agregar el cliente, llena completamente los campos.";
    }

    //(PUT){UPDATE}
    public String updateClienteById(UUID id, ClienteEntity cliente) {
        Optional<ClienteEntity> clienteList = getClienteById(id);
        if(clienteList.isPresent() && !(cliente.getNombre().isEmpty()) && !(cliente.getApellido().isEmpty()) && !(cliente.getCorreo().isEmpty())){
            clienteList.get().setNombre(cliente.getNombre());
            clienteList.get().setApellido(cliente.getApellido());
            clienteList.get().setCorreo(cliente.getCorreo());
            clienteList.get().setTelefono(cliente.getTelefono());
            return "Se actualizo correctamente el cliente "+cliente.getNombre();
        }
        return "No se encontro el cliente o no llenaste correctamente los campos.";
    }

    //(DELETE){DELETE}
    public String deleteCLienteById(UUID id) {
        if(getClienteById(id).isPresent()){
            clientes.removeIf(cliente -> cliente.getId().equals(id));
            return "Se eliminó el cliente con el id "+id;
        }
        return "No se encontró el cliente.";
    }
}
