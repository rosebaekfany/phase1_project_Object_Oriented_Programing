import view.Input;

public class Main {
    public static void main(String[] args) {
        Input myInput = new Input() ;
        myInput.register_menu();
        while (myInput.registerMenu==1){
            myInput.inputRegister();
        }
    }
}
