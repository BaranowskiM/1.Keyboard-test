import java.util.Random;
import java.util.Scanner;


public class Baranowski_TestKlawiaturowy {
    static String reWrite = "";

    static int index = 0;
    static String[] panT = {"Litwo! Ojczyzno moja! ty jesteś jak zdrowie",
            "Ile cię trzeba cenić, ten tylko się dowie,",
            "Kto cię stracił. Dziś piękność twą w całej ozdobie",
            "Widzę i opisuję, bo tęsknię po tobie.",
            "Panno święta, co Jasnej bronisz Częstochowy",
            "I w Ostrej świecisz Bramie! Ty, co gród zamkowy",
            "Nowogródzki ochraniasz z jego wiernym ludem!",
            "Jak mnie dziecko do zdrowia powróciłaś cudem",
            "Gdy od płaczącej matki, pod Twoją opiekę",
            "I zaraz mogłem pieszo, do Twych świątyń progu"};
    static int mistakes = 0;

    static void textCheck(String reWritedText, int intIndex, String[] array) {
        for (int i = 0; i < reWritedText.length(); i++) {
            if (array[intIndex].charAt(i) == reWritedText.charAt(i))
                System.out.print(" ");
            else {
                System.out.print("^");
                mistakes++;
            }
        }
    }

    public static void main(String[] args)  {
        System.out.println("WITAJ W PROGRAMIE DO ĆWICZENIA PISANIA NA KLAWIATURZE!");

        Random generator = new Random();
        Scanner reIndex = new Scanner(System.in);

        System.out.println();
        System.out.println();

        System.out.println("Przepisz podany niżej tekst. " +
                "Zadanie zakończ wciskając klawisz \"Enter\". " +
                "W przypadku chęci zakończenia działania programu " +
                "zostaw pusty wiersz i wciśnij \"Enter\".");

        do {
            //Generowanie numeru wiersza do wyświetlenia

            index = generator.nextInt(panT.length);

            System.out.println();
            System.out.print(">");
            System.out.println(panT[index]);
            System.out.print(">");

            //Rozpoczęcie naliczania czasu pisania

            long timeStart = System.nanoTime();
            reWrite = reIndex.nextLine();
            long timeStop = System.nanoTime();


            //Porównywanie teksu zapisanego w programie z tekstem wpisanym przez użytkownika
            if (panT[index].length() == reWrite.length()) {
                System.out.print(" ");
                textCheck(reWrite, index, panT);


                if (mistakes == 0) {
                    System.out.println();
                    System.out.println("GRATULACJE!\nPoprawnie przepisałeś tekst");

                }
                System.out.println();
            } else if (reWrite.length() == 0) {
                break;
            } else if (panT[index].length() < reWrite.length()) {
                System.out.print(" ");
                for (int i = 0; i < panT[index].length(); i++) {
                    if (panT[index].charAt(i) == reWrite.charAt(i))
                        System.out.print(" ");
                    else {
                        System.out.print("^");
                        mistakes++;
                    }
                }
                System.out.println();
                System.out.println("Nieporawna długość tekstu. Tekst zbyt długi");
            } else {
                System.out.print(" ");
                textCheck(reWrite, index, panT);

                System.out.println();
                System.out.println("Nieporawna długość tekstu. Zbyt krótki tekst");
            }

            if (mistakes > 0) {
                System.out.println("W wyżej wymienionych miejscach pojawiły się błędy. " +
                        "Łącznie błędów: " + mistakes);
                System.out.println();
            }

            System.out.println("Czas wprowadzania: " + ((timeStop - timeStart)/1000000) + "[ms]");
            System.out.println();
            mistakes = 0;

        } while (reWrite.length() > 0);


        reIndex.close();
        System.out.println("Program zakończył swoje działanie");
    }
}
