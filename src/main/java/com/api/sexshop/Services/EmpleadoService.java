package com.api.sexshop.Services;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
    private List<EmpleadoEntity> empleados;
    public EmpleadoService() {
        empleados = new ArrayList<>();
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Deiver", "Torres", 312566458, "Jefe"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "María", "Gómez", 310456789, "Gerente"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Juan", "Pérez", 315789012, "Supervisor"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Laura", "Martínez", 318654321, "Analista"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Carlos", "Rodríguez", 320987654, "Desarrollador"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Ana", "López", 312123456, "Diseñadora"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Luis", "González", 314789123, "Tester"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Sofía", "Ramírez", 317456789, "Consultora"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Pedro", "Jiménez", 319876543, "Administrador"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Mónica", "Vargas", 311234567, "Líder de Proyecto"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Fernando", "Castro", 312345678, "Soporte Técnico"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Camila", "Ruiz", 315678901, "Desarrolladora Junior"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Jorge", "Morales", 313456789, "Arquitecto de Software"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Valentina", "Pérez", 318987654, "Reclutadora"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Andrés", "Hernández", 319654321, "Director de TI"));
        empleados.add(new EmpleadoEntity(UUID.randomUUID(), "Lucía", "Salazar", 316789012, "Ingeniera de Datos"));
    }

    //(GET){READ - ALL}
    public List<EmpleadoEntity> getEmpleados() {
        return empleados;
    }

    //(GET){READ - ID}
    public Optional<EmpleadoEntity> getEmpleadoById(UUID id) {
        return empleados.stream().filter(empleado -> empleado.getId().equals(id)).findFirst();
    }

    //(POST){CREATE}
    public String createEmpleado(EmpleadoEntity empleado) {
        if(!(empleado.getNombre().isEmpty()) && !(empleado.getApellido().isEmpty()) && !(empleado.getCargo().isEmpty())){
            empleado.setId(UUID.randomUUID());
            empleados.add(empleado);
            return "Se agrego correctamente el empleado "+empleado.getNombre();
        }
        return "No se pudo agregar el empleado, llena completamente los campos.";
    }

    //(PUT){UPDATE}
    public String updateEmpleadoById(UUID id, EmpleadoEntity empleado) {
        Optional<EmpleadoEntity> empleadoList = getEmpleadoById(id);
        if(empleadoList.isPresent() && !(empleado.getNombre().isEmpty()) && !(empleado.getApellido().isEmpty()) && !(empleado.getCargo().isEmpty())){
            empleadoList.get().setNombre(empleado.getNombre());
            empleadoList.get().setApellido(empleado.getApellido());
            empleadoList.get().setCargo(empleado.getCargo());
            empleadoList.get().setTelefono(empleado.getTelefono());
            return "Se actualizo correctamente el empleado "+empleado.getNombre();
        }
        return "No se encontro el empleado o no llenaste correctamente los campos.";
    }

    //(DELETE){DELETE}
    public String deleteEmpleadoById(UUID id) {
        if(getEmpleadoById(id).isPresent()){
            empleados.removeIf(empleado -> empleado.getId().equals(id));
            return "Se eliminó el empleado con el id "+id;
        }
        return "No se encontró el empleado.";
    }
}
