package Controller;

import Model.RoomDTO;
import View.ISchoolView;
import View.SimpleSchoolView;

public class SchoolController {

    //Memoria o estado
    private RoomDTO[] school;

    private ISchoolView schoolView;

    public boolean registrarEntraSalida(String nombreProfesor) {
        //Encontrar el aula asignada
        RoomDTO foundRoom = null;
        for (int i = 0; i < school.length; i++) {
            if(school[i].getTeacherName().equals(nombreProfesor)){
                foundRoom = school[i];
                break;
            }
        }
        //Si no encuentro el aula, avisar de un error
        if(foundRoom == null){
            return false;
        }else{
            //Activar el aula
            foundRoom.setActive(!foundRoom.isActive());
            return true;
        }




        //Cambiar el activo del aula

    }

    public SchoolController(ISchoolView _schoolView, String[] teachers) {
        this.schoolView = _schoolView;

        school = new RoomDTO[teachers.length];
        for(int i = 0; i < teachers.length; i++) {
            school[i] = new RoomDTO(i + 1, teachers[i]);
        }
    }

    public void run(){
        while(true){
            String name = schoolView.refresh(this.school);
            registrarEntraSalida(name);
        }
    }
}
