package View;

import Model.RoomDTO;

import java.util.Scanner;

public class ComplexSchoolView implements ISchoolView {

    private static final int SCHOOL_SIZE = 50;
    private static final int HALL_SIZE = 10;
    private static final int ROOM_SIZE = (SCHOOL_SIZE - HALL_SIZE) / 2 - 2;

    Scanner sc = new Scanner(System.in);
    @Override
    public String refresh(RoomDTO[] school){
        return refresh(school, null);
    }


    public String refresh(RoomDTO[] school, String errorMsg){
        if(errorMsg != null){
            System.out.println(errorMsg);
        }

        System.out.println("=".repeat(SCHOOL_SIZE));

        for(int i = 0; i < school.length / 2; i++){

            RoomDTO roomLeft =  school[i * 2];
            RoomDTO roomRight =  (i * 2 + 1 == school.length) ? new RoomDTO(0, "???") : school[i * 2 + 1];
            System.out.println("|" + pad("", ROOM_SIZE) + "|" + " ".repeat(HALL_SIZE) + "|" + pad("", ROOM_SIZE) + "|");
            System.out.println("|" + pad(roomLeft.isActive() ? roomLeft.getTeacherName() : "vacia", ROOM_SIZE) + "|" + " ".repeat(HALL_SIZE) + "|" + pad(roomRight.isActive() ? roomRight.getTeacherName() : "vacia", ROOM_SIZE) + "|");
            System.out.println("|" + pad("Aula " + roomLeft.getId(), ROOM_SIZE) + "|" + " ".repeat(HALL_SIZE) + "|" + pad( "Aula " + roomRight.getId() , ROOM_SIZE) + "|");
            System.out.println("|" + pad("", ROOM_SIZE) + "|" + " ".repeat(HALL_SIZE) + "|" + pad("", ROOM_SIZE) + "|");

            System.out.println("=".repeat(SCHOOL_SIZE));


        }

        System.out.print("Nombre del profesor: ");
        return sc.nextLine();

    }

    private String pad(String s, int size){
        int offset = s.length() % 2;
        return " ".repeat((size - s.length()) / 2) + s + " ".repeat((size - s.length()) / 2 + offset);
    }
}
