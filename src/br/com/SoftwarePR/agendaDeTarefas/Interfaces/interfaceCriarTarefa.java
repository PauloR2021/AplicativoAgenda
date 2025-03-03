package br.com.SoftwarePR.agendaDeTarefas.Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JDayChooser;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;

public class interfaceCriarTarefa {

	private JFrame frmAdicionarTarefa;
	private final ButtonGroup checkStatus = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceCriarTarefa window = new interfaceCriarTarefa();
					window.frmAdicionarTarefa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfaceCriarTarefa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdicionarTarefa = new JFrame();
		frmAdicionarTarefa.getContentPane().setBackground(new Color(211, 211, 211));
		frmAdicionarTarefa.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STATUS:");
		lblNewLabel.setBounds(10, 36, 72, 14);
		frmAdicionarTarefa.getContentPane().add(lblNewLabel);
		
		JCheckBox checkConcluido = new JCheckBox("New check box");
		checkStatus.add(checkConcluido);
		checkConcluido.setBounds(69, 32, 99, 23);
		frmAdicionarTarefa.getContentPane().add(checkConcluido);
		
		JCheckBox checkNaoConcluido = new JCheckBox("New check box");
		checkNaoConcluido.setBounds(186, 32, 99, 23);
		frmAdicionarTarefa.getContentPane().add(checkNaoConcluido);
		frmAdicionarTarefa.setBackground(SystemColor.activeCaption);
		frmAdicionarTarefa.setTitle("Adicionar Tarefa");
		frmAdicionarTarefa.setBounds(100, 100, 770, 408);
		frmAdicionarTarefa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
