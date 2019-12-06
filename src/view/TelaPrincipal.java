package view;

import controller.GrafoController;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal {
    private JButton processarDadosButton;
    private JTextPane painelDeTexto;
    private JPanel container;

    private GrafoController controller = new GrafoController();

    private TelaPrincipal() {
        processarDadosButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    controller.processarDadosEntrada();
                    setMensagemPainelTexto("Dados carregados");
                } catch (Exception ex) {
                    mostrarMensagemErro(ex.getMessage());
                }
            }
        });
    }

    private void mostrarMensagemErro(String mensagem) {
        MensagemErroDialog dialog = new MensagemErroDialog(mensagem);

        dialog.pack();
        dialog.setVisible(true);

        setMensagemPainelTexto("Tente novamente!");
    }

    private void setMensagemPainelTexto(String mensagem) {
        painelDeTexto.setText(mensagem);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Trabalho Final Grafos");
        frame.setContentPane(new TelaPrincipal().container);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
