package DesafioPedidos;

import javax.swing.JOptionPane;

public class RestauranteMain {

    public static void main(String[] args) {
        menuPadrao();
    }

    public static void menuPadrao() {
        System.out.println("╔╔══════════════════════╗╗");
        System.out.println("║║▐█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█▌║║        _______________________________________________________");
        System.out.println("║║▐▌░░▒▒░░▒▒░░▒▒░░▒▒░░▐▌║║        __________ BEM VINDO AO RESTAURANTE STREAM ____________");
        System.out.println("║║▐▌▒▒░░▒▒░░▒▒░░▒▒░░▒▒▐▌║║        _______________________________________________________");
        System.out.println("║║▐▌▒▒░░▒▒░░▒▒░░▒▒░░▒▒▐▌║║        _________ DIGA-NOS QUAL SEU TIPO DE PEDIDO? ___________");
        System.out.println("║║▐▌░░▒▒░░▒▒░░▒▒░░▒▒░░▐▌║║        _______________________________________________________");
        System.out.println("║║▐▌▒▒░░▒▒░░▒▒░░▒▒░░▒▒▐▌║║        |  Opção 1 - Presencial      |");
        System.out.println("║║▐▌░░▒▒░░▒▒░░▒▒░░▒▒░░▐▌║║        |  Opção 2 - Online          |");
        System.out.println("║║▐█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▌║║        |  Opção 3 - Sair            |");
        System.out.println("╚╚══════════════════════╝╝");
        System.out.println("██▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄██");
        System.out.println("██▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄██");
        System.out.println("██▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄██");
        System.out.println("██▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀██");
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");

        int escolha1 = JOptionPane.showOptionDialog(null,
                "Informe a opção desejada:", "Restaurante Stream", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Presencial", "Online", "Sair"}, "Presencial");
        switch (escolha1) {
            case 0:
                System.out.println("\n");
                RestaurantePresencial.main(null);
                break;

            case 1:
                RestauranteOnline.main(null);
                break;

            case 2:
                System.out.println("\n");
                System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒");
                System.out.println("▒▒▒▒▓▒▒▓▒▒▒▒");
                System.out.println("▒▒▒▒▓▒▒▓▒▒▒▒");
                System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒");
                System.out.println("▒▓▒▒▒▒▒▒▒▒▓▒");
                System.out.println("▒▒▓▓▓▓▓▓▓▓▒▒");
                System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒");
                System.out.println("_______________________________________");
                System.out.println("____ Até a próxima, volte sempre ;D ___");
                System.out.println("_______________________________________");
                System.exit(0);
                break;

            default:
                System.out.println(" (/)__(/)");
                System.out.println(" (=*.*=) ");
                System.out.println(" (“)__(“)");
                System.out.println("EPA, essa opção não está na nossa lista. Tente novamente!!;D");
                break;
        }
    }
}
