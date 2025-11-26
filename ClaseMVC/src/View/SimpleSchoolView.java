package View;

import Model.RoomDTO;

import java.util.Scanner;

public class SimpleSchoolView implements ISchoolView {

    public SimpleSchoolView() {}

    public String refresh(RoomDTO[] school){
        for(int i = 0; i < school.length; i++){
            RoomDTO room = school[i];

            System.out.println("Room: " + room.getId());
            System.out.println("\tTeacher: " + room.getTeacherName());
            System.out.println("\tIn class: " + (room.isActive() ? "Si" : "No"));

        }
        System.out.print("Introduce nombre profesor: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    public static void main(String[] args) {
        new SimpleSchoolView().refresh(new RoomDTO[]{
                new RoomDTO(1, "Pedro"),
                new RoomDTO(2, "Maria"),
        });
    }
}
