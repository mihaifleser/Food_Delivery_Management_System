package Presentation;

public class Controller {

    private AdminGUI adminGUI = new AdminGUI();
    private ClientGUI clientGUI = new ClientGUI();
    private EmployeeGUI employeeGUI = new EmployeeGUI();


    public void start()
    {
        adminGUI.initialise();
        clientGUI.initialise();
        employeeGUI.initialise();
    }
}
