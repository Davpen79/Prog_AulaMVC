package Model;

public class RoomDTO {

    private int id;
    private String teacherName;
    private boolean active;

    public int getId() {
        return id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public RoomDTO(int id, String teacherName) {
        this.id = id;
        this.teacherName = teacherName;
        this.active = false;
    }
}
