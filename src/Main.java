import model.Pergunta;

import javax.swing.*;

import static java.lang.System.exit;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Main {

    private static JFrame f;

    public static void main(String[] args) {
        Pergunta inicial = new Pergunta("O prato que você pensou é massa?", null,
                new Pergunta("O prato que você pensou é lasanha?", "lasanha"),
                new Pergunta("O prato que você pensou é Bolo de chocolate?", "Bolo de chocolate"));

        while (true) {
            message("Pense em um prato!");
            realizaPergunta(inicial);
        }
    }

    private static void message(String conteudo) {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, conteudo);
    }

    private static String input(String conteudo) {
        f = new JFrame();
        String retorno = JOptionPane.showInputDialog(f, conteudo);
        if (nonNull(retorno)) {
            return retorno;
        }
        exit(-1);
        return null;
    }

    private static boolean confirm(String conteudo) {
        f = new JFrame();
        int resp = JOptionPane.showConfirmDialog(f, conteudo, "title", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            return true;
        } else if (resp == JOptionPane.NO_OPTION) {
            return false;
        }
        exit(-1);
        return false;
    }

    private static void realizaPergunta(Pergunta p) {
        if (confirm(p.getPergunta())) {
            if (isNull(p.getRespSim())) {
                message("Acertei de novo!");
            } else {
                realizaPergunta(p.getRespSim());
            }
        } else {
            if (isNull(p.getRespNao())) {
                addPergunta(p);
            } else {
                realizaPergunta(p.getRespNao());
            }
        }
    }

    private static void addPergunta(Pergunta p) {
        String prato = input("Qual prato você pensou?");
        String caracteristicaPrato = input(prato + " é ___, mas " + p.getPrato() + " não.");

        p.setRespNao(new Pergunta(p.getPergunta(), p.getPrato()));
        p.setPrato(null);
        p.setPergunta("O prato que você pensou é " + caracteristicaPrato + "?");
        p.setRespSim(new Pergunta("O prato que você pensou é " + prato + "?", prato));
    }

}
