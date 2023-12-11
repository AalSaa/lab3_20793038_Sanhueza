package menu_20793038_SanhuezaVega;

import java.util.ArrayList;
import java.util.Scanner;

import cbSystem_20793038_SanhuezaVega.cbSystem_20793038_SanhuezaVega;
import user_20793038_SanhuezaVega.user_20793038_SanhuezaVega;
import user_20793038_SanhuezaVega.admin_20793038_SanhuezaVega;
import user_20793038_SanhuezaVega.normal_20793038_SanhuezaVega;
import chatbot_20793038_SanhuezaVega.chatbot_20793038_SanhuezaVega;
import flow_20793038_SanhuezaVega.flow_20793038_SanhuezaVega;
import option_20793038_SanhuezaVega.option_20793038_SanhuezaVega;


public class menu_20793038_SanhuezaVega {
    public void start(){
        int choice, cbCodelink, fCodelink, id;
        String name ,username, message, word;
        chatbot_20793038_SanhuezaVega selectedCB;
        flow_20793038_SanhuezaVega selectedFL;
        option_20793038_SanhuezaVega selectedOP;
        ArrayList<flow_20793038_SanhuezaVega> flowList;
        ArrayList<option_20793038_SanhuezaVega> optionList;
        ArrayList<String> keyword;
        Scanner input = new Scanner(System.in);

        showWelcomeMenuA();
        name = input.next();
        showWelcomeMenuB();
        cbCodelink = input.nextInt();

        cbSystem_20793038_SanhuezaVega system = new cbSystem_20793038_SanhuezaVega(name, cbCodelink, new ArrayList<>());

        do {
            showUserMenu();
            choice = input.nextInt();
            switch (choice){
                case 1:
                    showLoginMenu();
                    username = input.next();
                    system.systemLogin(username);

                    if(system.someoneLoggedIn()){
                        user_20793038_SanhuezaVega userLogged = system.getLoggedUser();
                        if(userLogged instanceof normal_20793038_SanhuezaVega){
                            do {
                                showNormalUserMenu();
                                choice = input.nextInt();
                                switch (choice){
                                    case 1:
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        system.systemLogout();
                                        break;
                                    default:
                                        showWrongChoiceMessage();
                                }
                            } while (choice != 3);
                            choice = 1;
                        }
                        else {
                            do {
                                showAdminMenu();
                                choice = input.nextInt();
                                switch (choice){
                                    case 1:
                                        system.showElements();
                                        System.out.println("Ingrese el id del chatbot: ");
                                        id = input.nextInt();
                                        System.out.println("Ingrese el nombre del chatbot: ");
                                        name = input.next();
                                        System.out.println("Ingrese el mensaje del chatbot: ");
                                        message = input.next();
                                        System.out.println("Ingrese el codelink del flujo inicial: ");
                                        fCodelink = input.nextInt();
                                        system.systemAddChatbot(new chatbot_20793038_SanhuezaVega(id, name, message, fCodelink, new ArrayList<>()));
                                        break;
                                    case 2:
                                        if(system.getChatbotList().size() > 0){
                                            system.showElements();
                                            System.out.println("Ingrese el id del chatbot a modificar");
                                            id = input.nextInt();
                                            if(system.idExists(id)){
                                                selectedCB = system.getChatbotByID(id);
                                                selectedCB.showElements();
                                                System.out.println("Ingrese el id del flujo: ");
                                                id = input.nextInt();
                                                System.out.println("Ingrese el mensaje: ");
                                                name = input.next();
                                                selectedCB.chatbotAddFlow(new flow_20793038_SanhuezaVega(id, name, new ArrayList<>()));
                                            }
                                            else {
                                                System.out.println("No existe un chatbot con ese id.");
                                            }
                                        }
                                        else{
                                            System.out.println("No hay chatbots en el sistema.");
                                        }
                                        break;
                                    case 3:
                                        if(system.getChatbotList().size() > 0){
                                            system.showElements();
                                            System.out.println("Ingrese el id del chatbot a modificar: ");
                                            id = input.nextInt();
                                            if(system.idExists(id)){
                                                selectedCB = system.getChatbotByID(id);
                                                if(selectedCB.getFlowList().size() > 0){
                                                    selectedCB.showElements();
                                                    System.out.println("Ingrese el id del flujo a modificar: ");
                                                    id = input.nextInt();
                                                    if(selectedCB.idExists(id)){
                                                        selectedFL = selectedCB.getFlowByID(id);
                                                        selectedFL.showElements();
                                                        System.out.println("Ingrese el id de la opcion: ");
                                                        id = input.nextInt();
                                                        System.out.println("Ingrese el mensaje de la opcion: ");
                                                        message = input.next();
                                                        System.out.println("Ingrese el codelink del chatbot asociado: ");
                                                        cbCodelink = input.nextInt();
                                                        System.out.println("Ingrese el codelink del flujo asociado: ");
                                                        fCodelink = input.nextInt();
                                                        keyword = new ArrayList<>();
                                                        System.out.println("Ingrese el ");

                                                    }
                                                    else{
                                                        System.out.println("No existe un flujo con ese id.");
                                                    }
                                                }
                                                else{
                                                    System.out.println("No existen flujos en el sistema.");
                                                }

                                            }
                                            else {
                                                System.out.println("No existe un chatbot con ese id.");
                                            }
                                        }
                                        else{
                                            System.out.println("No hay chatbots en el sistema.");
                                        }
                                        break;
                                    case 4:
                                        break;
                                    case 5:
                                        break;
                                    case 6:
                                        system.systemLogout();
                                        break;
                                    default:
                                        showWrongChoiceMessage();
                                }
                            } while (choice != 6);
                            choice = 1;
                        }
                    }
                    break;
                case 2:
                    do {
                        showRegisterMenu();
                        choice = input.nextInt();
                        switch (choice) {
                            case 1:
                                showRegisterNormalUserMenu();
                                username = input.next();
                                system.systemAddUser(new normal_20793038_SanhuezaVega(username));
                                break;
                            case 2:
                                showRegisterAdminMenu();
                                username = input.next();
                                system.systemAddUser(new admin_20793038_SanhuezaVega(username));
                                break;
                            case 3:
                                System.out.println("Se ha regresado al menu de usuarios.");
                                break;
                            default:
                                showWrongChoiceMessage();
                        }
                    } while (choice > 3);
                    choice = 1;
                    break;
                case 3:
                    System.out.println("Se ha cerrado el sistema.");
                    break;
                default:
                    showWrongChoiceMessage();
            }
        } while (choice != 3);
    }

    private static void showWelcomeMenuA(){
        System.out.println("### Bienvenido ###\n" +
                "Ingrese un nombre para el sistema de chatbots: ");

    }

    private static void showWelcomeMenuB(){
        System.out.println("### Bienvenido ###\n" +
                "Ingrese el id del chatbot inicial: ");

    }
    private static void showWrongChoiceMessage(){
        System.out.println("No se ha seleccionado una opcion valida.\n" +
                "Porfavor, ingrese la opcion denuevo:");
    }

    private static void showUserMenu(){
        System.out.println("### Sistema de Chatbots - Usuarios ###\n" +
                "1. Login de usuario\n" +
                "2. Registro de usuario\n" +
                "3. Salir\n" +
                "Ingrese una opción: ");
    }

    private static void showLoginMenu(){
        System.out.println("### Sistema de Chatbots - Login ###\n" +
                "Ingrese el nombre del usuario: ");
    }

    private static void showRegisterMenu(){
        System.out.println("### Sistema de Chatbots - Registro ###\n" +
                "1. Registrar usuario normal\n" +
                "2. Registrar usuario administrador\n" +
                "3. Volver\n" +
                "Ingrese una opción: ");
    }

    private static void showRegisterNormalUserMenu(){
        System.out.println("### Sistema de Chatbots - Registro ###\n" +
                "Ingrese el nombre del usuario: ");
    }
    private static void showRegisterAdminMenu(){
        System.out.println("### Sistema de Chatbots - Registro ###\n" +
                "Ingrese el nombre del administrador: ");
    }


    private static void showNormalUserMenu(){
        System.out.println("#### Sistema de Chatbots - Usuario\n" +
                "1. Interactuar con el chatbot\n" +
                "2. Obtener sintesis\n" +
                "3. Cerrar sesión\n" +
                "Ingrese una opción: ");

    }

    private static void showAdminMenu(){
        System.out.println("#### Sistema de Chatbots - Admin\n" +
                "1. Crear chatbot en el sistema\n" +
                "2. Crear flujo en un chatbot\n" +
                "3. Crear una opción en un flujo\n" +
                "4. Interactuar con el chatbot\n" +
                "5. Obtener sintesis\n" +
                "6. Cerrar sesión\n" +
                "Ingrese una opción: ");
    }
}
