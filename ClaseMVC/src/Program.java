import Controller.SchoolController;
import View.ComplexSchoolView;
import View.ISchoolView;
import View.SimpleSchoolView;

public class Program {

    public static void main(String[] args) {
        String[] teachers =  new String[]{
                "Pedro", "Sofía", "Rosa", "Marco"
        };

        ISchoolView sv;



        if(args.length != 0 && args[0].equals("SimpleSchoolView")){
            sv = new SimpleSchoolView();
        }else{
            sv = new ComplexSchoolView();
        }

        SchoolController controller = new SchoolController(sv, teachers);
        controller.run();

    }
}
