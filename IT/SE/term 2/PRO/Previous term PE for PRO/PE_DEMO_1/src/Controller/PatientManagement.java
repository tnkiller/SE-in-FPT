package Controller;

import Model.PatientList;
import VIew.Menu;
import java.text.ParseException;

public class PatientManagement extends Menu {

    PatientList patientList;
    static String[] choice = {
        "Display all patients",
        "Search patient",
        "Add patient",
        "Update phone number",
        "Quit"
    };

    public PatientManagement() throws ParseException {
        super("---PATIENT MANAGEMENT---", choice);
        patientList = new PatientList();
                

    }

    @Override
    public void execute(int n) throws ParseException {
        switch (n) {
            case 1 -> patientList.showAllPatient();
            case 2 -> patientList.searchPatient();
            case 3 -> patientList.addNewPatient();
            case 4 -> patientList.updateNewPhone();
        }
    }

    
    //MAIN
    public static void main(String[] args) throws ParseException {
        PatientManagement mgn = new PatientManagement();
        mgn.run();

    }

}
