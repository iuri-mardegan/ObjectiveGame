import model.Caracteristica;
import model.Prato;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;
import static java.util.Objects.nonNull;

public class Main {

    private static List<Caracteristica> caracteristicaMassaList = null;
    private static List<Caracteristica> caracteristicaList = null;
    private static JFrame f;

    public static void main(String[] args) {
        caracteristicaMassaList = new ArrayList<>();
        caracteristicaList = new ArrayList<>();

        while (true) {
            message("Pense em um prato!");

            boolean resposta = confirm("o prato que você pensou é massa?");

            if (resposta) {
                if (confirm("o prato que você pensou é lasanha?")) {
                    message("Acertei de novo!");
                } else {
                    if (!caracteristicaMassaList.isEmpty()) {
                        verificaPrato(true);
                    } else {
                        adicionaNovaCaracteristicaNovoPrato(true);
                    }
                }
            } else {
                if (confirm("o prato que você pensou é Bolo de chocolate?")) {
                    message("Acertei de novo!");
                } else {
                    if (!caracteristicaList.isEmpty()) {
                        verificaPrato(false);
                    } else {
                        adicionaNovaCaracteristicaNovoPrato(false);
                    }
                }
            }

        }

    }

    private static void message(String conteudo) {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, conteudo);
    }

    private static String input(String conteudo) {
        f = new JFrame();
        String retorno = JOptionPane.showInputDialog(f, conteudo);
        if(nonNull(retorno)){
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

    private static void adicionaNovaCaracteristicaNovoPrato(Boolean massa) {
        String prato;
        String caracteristicaPrato;
        String pratoDefault = (massa) ? "lasanha" : "Bolo de chocolate";

        prato = input("Qual prato você pensou?");
        caracteristicaPrato = input(prato + " é ___ mas " + pratoDefault + " não.");
        List<Prato> pratoList = new ArrayList<Prato>();
        pratoList.add(new Prato(prato));
        if (massa) {
            caracteristicaMassaList.add(new Caracteristica(caracteristicaPrato, pratoList));
        } else {
            caracteristicaList.add(new Caracteristica(caracteristicaPrato, pratoList));
        }
    }

    private static void adicionaNovoPrato(Boolean massa, Caracteristica caracteristicaRecebida, String pratoDefault) {
        String finalPrato = input("Qual prato você pensou?");
        String caracteristicaPrato = input(finalPrato + " é ___ mas " + pratoDefault + " não.");

        if (massa) {
            caracteristicaMassaList.stream().filter(c -> c.getNome().equals(caracteristicaRecebida.getNome())).forEach(c -> c.getPratoList().add(new Prato(finalPrato)));
        } else {
            caracteristicaList.stream().filter(c -> c.getNome().equals(caracteristicaRecebida.getNome())).forEach(c -> c.getPratoList().add(new Prato(finalPrato)));
        }
    }

    private static void verificaPrato(Boolean massa) {
        List<Caracteristica> caracteristicaVerificaList = new ArrayList<>();

        if (massa) {
            caracteristicaVerificaList.addAll(caracteristicaMassaList);
        } else {
            caracteristicaVerificaList.addAll(caracteristicaList);
        }
        for (Caracteristica caracteristica : caracteristicaVerificaList) {
            if (confirm("O prato que vc pensou é " + caracteristica.getNome() + "?")) {
                Prato localPrato = null;
                for (Prato prato : caracteristica.getPratoList()) {
                    if (confirm("O prato que vc pensou é " + prato.getPrato() + "?")) {
                        message("Acertei de novo!");
                        return;
                    } else {
                        localPrato = prato;
                        continue;
                    }
                }
                if (nonNull(localPrato)) {
                    adicionaNovoPrato(massa, caracteristica, localPrato.getPrato());
                    return;
                }
            }
        }
        adicionaNovaCaracteristicaNovoPrato(massa);
    }
}
