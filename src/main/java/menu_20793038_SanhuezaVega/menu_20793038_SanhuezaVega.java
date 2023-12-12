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
import storage_20793038_SanhuezaVega.storage_20793038_SanhuezaVega;

public class menu_20793038_SanhuezaVega {

    public void start(){
        int choice, cbCodelink, fCodelink, cbID, flID, opID;
        String name ,username, message, word;
        chatbot_20793038_SanhuezaVega newCB, selectedCB;
        flow_20793038_SanhuezaVega newFL, selectedFL;
        option_20793038_SanhuezaVega newOP, selectedOP;
        ArrayList<String> keyword;
        Scanner intInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);

        showWelcomeMenuA();
        name = stringInput.nextLine();
        showWelcomeMenuB();
        cbCodelink = intInput.nextInt();

        cbSystem_20793038_SanhuezaVega system = new cbSystem_20793038_SanhuezaVega(name, cbCodelink, new ArrayList<>());

        System.out.println("Cargando datos predefinidos....");
        system = addDefaultDataInSystem(system);
        storage_20793038_SanhuezaVega systemStorage = system.getSystemStorage();

        do {
            showUserMenu();
            choice = intInput.nextInt();
            switch (choice){
                case 1:
                    showLoginMenu();
                    username = stringInput.nextLine();
                    system.systemLogin(username);

                    if(system.someoneLoggedIn()){
                        user_20793038_SanhuezaVega userLogged = system.getLoggedUser();
                        if(userLogged instanceof normal_20793038_SanhuezaVega){
                            do {
                                showNormalUserMenu();
                                choice = intInput.nextInt();
                                switch (choice){
                                    case 1:
                                        showNotAvailableMessage();
                                        break;
                                    case 2:
                                        showNotAvailableMessage();
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
                                choice = intInput.nextInt();
                                switch (choice){
                                    case 1:
                                        System.out.println("Ingrese el id del chatbot: ");
                                        cbID = intInput.nextInt();
                                        System.out.println("Ingrese el nombre del chatbot: ");
                                        name = stringInput.nextLine();
                                        System.out.println("Ingrese el mensaje de bienvenida: ");
                                        message = stringInput.nextLine();
                                        System.out.println("Ingrese el codelink del flujo inicial: ");
                                        fCodelink = intInput.nextInt();
                                        newCB = new chatbot_20793038_SanhuezaVega(cbID, name, message, fCodelink, new ArrayList<>());

                                        do {
                                            system.showElements();
                                            System.out.println("Desea agregarlo al sistema?\n" +
                                                    "1. Si\n" +
                                                    "2. No\n" +
                                                    "Ingrese una opción: ");
                                            choice = intInput.nextInt();
                                            switch (choice){
                                                case 1:
                                                    system.systemAddChatbot(newCB);
                                                    break;
                                                case 2:
                                                    system.getSystemStorage().addChatbotInStorage(newCB);
                                                    break;
                                                default:
                                                    showWrongChoiceMessage();
                                            }
                                        } while (choice != 1 && choice != 2);
                                        choice = 1;
                                        break;
                                    case 2:
                                        if(systemStorage.getChatbotStorage().size() > 0){
                                            systemStorage.showChatbotsInStorage();
                                            System.out.println("Ingrese el numero del chatbot que quiere agregar: ");
                                            choice = intInput.nextInt();
                                            if(systemStorage.chosenChatbotExists(choice)){
                                                selectedCB = systemStorage.getChosenChatbotAndRemove(choice);
                                                system.systemAddChatbot(selectedCB);
                                            }
                                            else{
                                                System.out.println("No ha seleccionado correctamente un chatbot.");
                                            }
                                            choice = 2;
                                        }
                                        else{
                                            System.out.println("No existen chatbots guardados en el storage.");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Ingrese el id del flujo: ");
                                        flID = intInput.nextInt();
                                        System.out.println("Ingrese el nombre del mensaje: ");
                                        message = stringInput.nextLine();
                                        newFL = new flow_20793038_SanhuezaVega(flID, message, new ArrayList<>());

                                        do {
                                            System.out.println("Desea agregarlo a un chatbot?\n" +
                                                    "1. Si\n" +
                                                    "2. No\n" +
                                                    "Ingrese una opción: ");
                                            choice = intInput.nextInt();
                                            switch (choice){
                                                case 1:
                                                    if(system.getChatbotList().size() > 0){
                                                        do {
                                                            system.showElements();
                                                            System.out.println("Ingrese el id del chatbot a modificar: ");
                                                            cbID = intInput.nextInt();
                                                            if(system.idExists(cbID)){
                                                                selectedCB = system.getChatbotByID(cbID);
                                                                selectedCB.chatbotAddFlow(newFL);
                                                            }
                                                            else{
                                                                System.out.println("No existe un chatbot con ese id\n" +
                                                                        "Ingrese un id de uno de los chatbots disponibles.");
                                                            }
                                                        } while (!system.idExists(cbID));
                                                    }
                                                    else{
                                                        System.out.println("No existen chatbots en el sistema.");
                                                    }
                                                    break;
                                                case 2:
                                                    system.getSystemStorage().addFlowInStorage(newFL);
                                                    break;
                                                default:
                                                    showWrongChoiceMessage();
                                            }
                                        } while (choice != 1 && choice != 2);
                                        choice = 3;
                                        break;
                                    case 4:
                                        if(systemStorage.getFlowStorage().size() > 0){
                                            systemStorage.showFlowsInStorage();
                                            System.out.println("Ingrese el numero del flujo que quiere agregar: ");
                                            choice = intInput.nextInt();
                                            if(systemStorage.chosenFlowExists(choice)){
                                                selectedFL = systemStorage.getChosenFlowAndRemove(choice);

                                                if(system.getChatbotList().size() > 0){
                                                    do {
                                                        system.showElements();
                                                        System.out.println("Ingrese el id del chatbot a modificar: ");
                                                        cbID = intInput.nextInt();
                                                        if(system.idExists(cbID)){
                                                            selectedCB = system.getChatbotByID(cbID);
                                                            selectedCB.chatbotAddFlow(selectedFL);
                                                        }
                                                        else{
                                                            System.out.println("No existe un chatbot con ese id\n" +
                                                                    "Ingrese un id de uno de los chatbots disponibles.");
                                                        }
                                                    } while (!system.idExists(cbID));
                                                }
                                                else{
                                                    System.out.println("No existen chatbots en el sistema.");
                                                }
                                            }
                                            else {
                                                System.out.println("No se ha seleccionado un flujo correctamente.");
                                            }
                                            choice = 4;
                                        }
                                        else{
                                            System.out.println("No existen flujos guardados en el storage.");
                                        }
                                        break;
                                    case 5:
                                        System.out.println("Ingrese el id de la opcion: ");
                                        opID = intInput.nextInt();
                                        System.out.println("Ingrese el mensaje del la opcion: ");
                                        message = stringInput.nextLine();
                                        System.out.println("Ingrese el codelink del chatbot asociado: ");
                                        cbCodelink = intInput.nextInt();
                                        System.out.println("Ingrese el codelink del flujo asociado: ");
                                        fCodelink = intInput.nextInt();
                                        keyword = new ArrayList<>();
                                        do {
                                            System.out.println("Ingrese una palabra clave: ");
                                            word = stringInput.nextLine();
                                            keyword.add(word);

                                            System.out.println("Desea agregar otra palabra clave?\n" +
                                                    "1. Si\n" +
                                                    "n. No\n" +
                                                    "Ingrese la opción: ");
                                            choice = intInput.nextInt();
                                        } while (choice == 1);
                                        newOP = new option_20793038_SanhuezaVega(opID, message, cbCodelink, fCodelink, keyword);
                                        do {
                                            System.out.println("Desea agregarlo a un flujo?\n" +
                                                    "1. Si\n" +
                                                    "2. No\n" +
                                                    "Ingrese una opción: ");
                                            choice = intInput.nextInt();
                                            switch (choice){
                                                case 1:
                                                    if(system.getChatbotList().size() > 0){
                                                        do {
                                                            system.showElements();
                                                            System.out.println("Ingrese el id del chatbot a modificar: ");
                                                            cbID = intInput.nextInt();
                                                            if(system.idExists(cbID)){
                                                                selectedCB = system.getChatbotByID(cbID);
                                                                if(selectedCB.getFlowList().size() > 0){
                                                                    do {
                                                                        selectedCB.showElements();
                                                                        System.out.println("Ingrese el id del flujo a modificar: ");
                                                                        flID = intInput.nextInt();
                                                                        if(selectedCB.idExists(flID)){
                                                                            selectedFL = selectedCB.getFlowByID(flID);
                                                                            selectedFL.flowAddOption(newOP);
                                                                        }
                                                                        else{
                                                                            System.out.println("No existe un flujo con este id\n" +
                                                                                    "ingrese un id de uno de los flujos disponibles.");
                                                                        }
                                                                    }
                                                                    while (!selectedCB.idExists(flID));
                                                                }
                                                                else {
                                                                    System.out.println("No existen flujos en el chatbot.");
                                                                }
                                                            }
                                                            else{
                                                                System.out.println("No existe un chatbot con ese id\n" +
                                                                        "Ingrese un id de uno de los chatbots disponibles.");
                                                            }
                                                        } while (!system.idExists(cbID));
                                                    }
                                                    else{
                                                        System.out.println("No existen chatbots en el sistema.");
                                                    }
                                                    break;
                                                case 2:
                                                    system.getSystemStorage().addOptionInStorage(newOP);
                                                    break;
                                                default:
                                                    showWrongChoiceMessage();
                                            }
                                        } while (choice != 1 && choice != 2);
                                        choice = 5;
                                        break;
                                    case 6:
                                        if(systemStorage.getOptionStorage().size() > 0) {
                                            systemStorage.showOptionsInStorage();
                                            System.out.println("Ingrese el numero de la opcion que quiere agregar: ");
                                            choice = intInput.nextInt();
                                            if (systemStorage.chosenOptionExists(choice)) {
                                                selectedOP = systemStorage.getChosenOptionAndRemove(choice);

                                                if(system.getChatbotList().size() > 0) {
                                                    do {
                                                        system.showElements();
                                                        System.out.println("Ingrese el id del chatbot a modificar: ");
                                                        cbID = intInput.nextInt();
                                                        if (system.idExists(cbID)) {
                                                            selectedCB = system.getChatbotByID(cbID);
                                                            if (selectedCB.getFlowList().size() > 0) {
                                                                do {
                                                                    selectedCB.showElements();
                                                                    System.out.println("Ingrese el id del flujo a modificar: ");
                                                                    flID = intInput.nextInt();
                                                                    if (selectedCB.idExists(flID)) {
                                                                        selectedFL = selectedCB.getFlowByID(flID);
                                                                        selectedFL.flowAddOption(selectedOP);
                                                                    } else {
                                                                        System.out.println("No existe un flujo con este id\n" +
                                                                                "ingrese un id de uno de los flujos disponibles.");
                                                                    }
                                                                }
                                                                while (!selectedCB.idExists(flID));
                                                            } else {
                                                                System.out.println("No existen flujos en el chatbot.");
                                                            }
                                                        } else {
                                                            System.out.println("No existe un chatbot con ese id\n" +
                                                                    "Ingrese un id de uno de los chatbots disponibles.");
                                                        }
                                                    } while (!system.idExists(cbID));
                                                }
                                                else{
                                                    System.out.println("No existen chatbots en el sistema.");
                                                }
                                            }
                                            else {
                                                System.out.println("No existe una opcion con ese id\n" +
                                                        "Ingrese un id de uno de las opciones disponibles.");
                                            }
                                        }
                                        break;
                                    case 7:
                                        showNotAvailableMessage();
                                        break;
                                    case 8:
                                        showNotAvailableMessage();
                                        break;
                                    case 9:
                                        system.systemLogout();
                                        break;
                                    default:
                                        showWrongChoiceMessage();
                                }
                            } while (choice != 9);
                            choice = 1;
                        }
                    }
                    break;
                case 2:
                    do {
                        showRegisterMenu();
                        choice = intInput.nextInt();
                        switch (choice) {
                            case 1:
                                showRegisterNormalUserMenu();
                                username = stringInput.nextLine();
                                system.systemAddUser(new normal_20793038_SanhuezaVega(username));
                                break;
                            case 2:
                                showRegisterAdminMenu();
                                username = stringInput.nextLine();
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
                "Ingrese el id del chatbot inicial (considere que el id 0, 1 y 2, ya fueron usados): ");

    }
    private static void showWrongChoiceMessage(){
        System.out.println("No se ha seleccionado una opcion valida.\n" +
                "Porfavor, ingrese la opcion denuevo:");
    }

    private static void showNotAvailableMessage(){
        System.out.println("Esta funcion por ahora no se encuentra disponible.");
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
                "1. Crear chatbot\n" +
                "2. Agregar chatbot en el sistema\n" +
                "3. Crear flujo\n" +
                "4. Agregar un flujo a un chatbot\n" +
                "5. Crear una opción\n" +
                "6. Agregar una opción en un flujo\n" +
                "7. Interactuar con el chatbot\n" +
                "8. Obtener sintesis\n" +
                "9. Cerrar sesión\n" +
                "Ingrese una opción: ");
    }

    public cbSystem_20793038_SanhuezaVega addDefaultDataInSystem(cbSystem_20793038_SanhuezaVega system){
        ArrayList<String> keyword;
        ArrayList<option_20793038_SanhuezaVega> optionList;
        ArrayList<flow_20793038_SanhuezaVega> flowList;

        keyword = new ArrayList<>();
        keyword.add("viajar");
        keyword.add("turistear");
        keyword.add("conocer");
        option_20793038_SanhuezaVega op1 = new option_20793038_SanhuezaVega(1, "1) Viajar", 1, 1, keyword);

        keyword = new ArrayList<>();
        keyword.add("estudiar");
        keyword.add("aprender");
        keyword.add("perfeccionarme");
        option_20793038_SanhuezaVega op2 = new option_20793038_SanhuezaVega(2, "2) estudiar", 2, 1, keyword);

        optionList = new ArrayList<>();
        optionList.add(op1);
        optionList.add(op2);
        flow_20793038_SanhuezaVega fl1 = new flow_20793038_SanhuezaVega(1, "Flujo Principal Chatbot 1\nBienvenido\n¿Qué te gustaría hacer?", optionList);

        flowList = new ArrayList<>();
        flowList.add(fl1);
        chatbot_20793038_SanhuezaVega cb0 = new chatbot_20793038_SanhuezaVega(0, "inicial", "Bienvenido\n¿Qué te gustaría hacer?", 1, flowList);


        keyword = new ArrayList<>();
        keyword.add("USA");
        keyword.add("Estados Unidos");
        keyword.add("New York");
        option_20793038_SanhuezaVega op3 = new option_20793038_SanhuezaVega(1, "1) New York, USA", 1, 2, keyword);

        keyword = new ArrayList<>();
        keyword.add("Paris");
        keyword.add("Eiffel");
        option_20793038_SanhuezaVega op4 = new option_20793038_SanhuezaVega(2, "2) París, Francia", 1, 1, keyword);

        keyword = new ArrayList<>();
        keyword.add("Chile");
        keyword.add("Torres");
        keyword.add("Paine");
        keyword.add("Torres Paine");
        keyword.add("Torres del Paine");
        option_20793038_SanhuezaVega op5 = new option_20793038_SanhuezaVega(3, "3) Torres del Paine, Chile", 1, 3, keyword);

        keyword = new ArrayList<>();
        keyword.add("regresar");
        keyword.add("Salir");
        keyword.add("volver");
        option_20793038_SanhuezaVega op6 = new option_20793038_SanhuezaVega(4, "4) Volver", 0, 1, keyword);

        optionList = new ArrayList<>();
        optionList.add(op3);
        optionList.add(op4);
        optionList.add(op5);
        optionList.add(op6);
        flow_20793038_SanhuezaVega fl2 = new flow_20793038_SanhuezaVega(1, "Flujo 1 Chatbot1\n¿Dónde te Gustaría ir?", optionList);

        flowList = new ArrayList<>();
        flowList.add(fl2);
        chatbot_20793038_SanhuezaVega cb1 = new chatbot_20793038_SanhuezaVega(1, "Agencia Viajes", "Bienvenido\n¿Dónde quieres viajar?", 1, flowList);


        keyword = new ArrayList<>();
        keyword.add("Tecnica");
        option_20793038_SanhuezaVega op7 = new option_20793038_SanhuezaVega(1, "1) Carrera Técnica", 2, 1, keyword);

        keyword = new ArrayList<>();
        keyword.add("Doctorado");
        keyword.add("Magister");
        keyword.add("Postgrado");
        option_20793038_SanhuezaVega op8 = new option_20793038_SanhuezaVega(2, "2) Postgrado", 2, 2, keyword);

        keyword = new ArrayList<>();
        keyword.add("regresar");
        keyword.add("Salir");
        keyword.add("volver");
        option_20793038_SanhuezaVega op9 = new option_20793038_SanhuezaVega(3, "3) Volver", 0, 1, keyword);

        optionList = new ArrayList<>();
        optionList.add(op7);
        optionList.add(op8);
        optionList.add(op9);
        flow_20793038_SanhuezaVega fl3 = new flow_20793038_SanhuezaVega(1, "Flujo 1 Chatbot2\n¿Qué te gustaría estudiar?", optionList);

        flowList = new ArrayList<>();
        flowList.add(fl3);
        chatbot_20793038_SanhuezaVega cb2 = new chatbot_20793038_SanhuezaVega(2, "Orientador Académico",  "Bienvenido\n¿Qué te gustaría estudiar?", 1, flowList);


        admin_20793038_SanhuezaVega admin1 = new admin_20793038_SanhuezaVega("Admin");
        normal_20793038_SanhuezaVega normalUser1 = new normal_20793038_SanhuezaVega("user1");

        system.systemAddChatbot(cb0);
        system.systemAddChatbot(cb1);
        system.systemAddChatbot(cb2);
        system.systemAddUser(admin1);
        system.systemAddUser(normalUser1);

        return system;
    }
}
