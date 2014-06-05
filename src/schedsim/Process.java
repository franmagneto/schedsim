/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedsim;

import java.util.Comparator;

/**
 *
 * @author francisco
 */
public class Process {

	private final int id;
	private final int burst;
	private final int creationTime;
	private final int priority;
	private int remaining;

	public Process(int id, int burst, int time) {
		this.id = id;
		this.burst = burst;
		this.creationTime = time;
		this.priority = 0;
		remaining = burst;
	}

	public Process(int id, int burst, int time, int priority) {
		this.id = id;
		this.burst = burst;
		this.creationTime = time;
		this.priority = priority;
		remaining = burst;
	}

	/**
	 * Executa processo até o fim (não-preemptivo)
	 *
	 * @return Tempo que o processo ficou em execução
	 */
	public int execute() {
		int time = getRemaining();
		remaining = 0;
		return time;
	}

	/**
	 * Executa o processo até o tempo dado, ou até o fim (preemptivo)
	 *
	 * @param time Tempo máximo a executar
	 * @return Tempo que ficou em execução
	 */
	public int execute(int time) {
		if (time > getRemaining()) {
			time = getRemaining();
		}
		remaining -= time;
		return time;
	}

	/**
	 * @return Identificador do processo
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return Tempo de burst
	 */
	public int getBurst() {
		return burst;
	}

	/**
	 * @return Tempo de chegada
	 */
	public int getCreationTime() {
		return creationTime;
	}

	/**
	 * @return Prioridade
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Compara os processos pelo tempo de chegada
	 */
	public static Comparator<Process> timeComparator = new Comparator<Process>() {
		@Override
		public int compare(Process process1, Process process2) {
			return process1.getCreationTime() - process2.getCreationTime();
		}
	};

	/**
	 * Compara os processos pelo tempo de burst
	 */
	public static Comparator<Process> burstComparator = new Comparator<Process>() {
		@Override
		public int compare(Process process1, Process process2) {
			return process1.getBurst() - process2.getBurst();
		}
	};

	/**
	 * Compara os processos pela prioridade
	 */
	public static Comparator<Process> priorityComparator = new Comparator<Process>() {
		@Override
		public int compare(Process process1, Process process2) {
			return process1.getPriority() - process2.getPriority();
		}
	};

	/**
	 * @return Tempo restante do processo
	 */
	public int getRemaining() {
		return remaining;
	}
}
