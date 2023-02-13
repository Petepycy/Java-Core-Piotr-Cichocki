package EncryptDecrypt;

import java.util.ArrayList;

import static EncryptDecrypt.FileManagement.*;

class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-mode")) {
                menu.setAction(args[i+1]);
            }
            if (args[i].equalsIgnoreCase("-key")) {
                menu.setNumber(Integer.parseInt(args[i+1]));
            }
            if (args[i].equalsIgnoreCase("-data")) {
                menu.setInput(args[i+1]);
                menu.setData(true);
            }
            if (args[i].equalsIgnoreCase("-in")) {
                menu.setInputTxt(args[i + 1]);
                menu.setIn(true);
            }
            if (args[i].equalsIgnoreCase("-out")) {
                menu.setOutputTxt(args[i + 1]);
                menu.setOut(true);
            }
            if (args[i].equalsIgnoreCase("-alg")) {
                menu.setAlgorithm(args[i + 1]);
            }
        }

        Algorithm algorithm = AlgorithmFactory.getAlgorithm(menu.getAlgorithm());

        if (!menu.isData() && !menu.isIn()) {
            menu.setInput("");
        }
        else if (!menu.isData()) {
            menu.setInput(openFile(menu.getInputTxt()));
        }

        ArrayList<Character> result = null;

        if (menu.getAction().equalsIgnoreCase("enc")) {
            result = algorithm.encode(menu.add(menu.getInput(), menu.getMsg()), menu.getNumber());
        } else if (menu.getAction().equalsIgnoreCase("dec")) {
            result = algorithm.decode(menu.add(menu.getInput(), menu.getMsg()), menu.getNumber());
        } else System.out.println("Invalid mode!");

        StringBuilder message = new StringBuilder();
        assert result != null;
        for (var letter : result) {
            message.append(letter);
        }
        if (menu.isOut()) writeFile(menu.getOutputTxt(), message.toString());
        else System.out.println(message);

        //-mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode
        //-key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec
    }
}