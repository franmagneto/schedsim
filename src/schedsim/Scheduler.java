/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedsim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author francisco
 */
public class Scheduler {

	public enum Algorithm {

		FCFS,
		SJF,
		Priorities,
		RoundRobin
	}
	private final Algorithm algorithm;
	private final List<Process> readyQueue; // = new ArrayList<>();z
	private int nextRR = -1;
	private int quantum = 4;
	private int time = 0;

	public Scheduler(List<Process> readyQueue, Algorithm scheduler) {
		this.readyQueue = new ArrayList<>(readyQueue);
		this.algorithm = scheduler;
	}

	private Process nextProcess() {

		if (readyQueue.isEmpty()) {
			return null;
		}

		List<Process> auxQueue = new ArrayList<>(readyQueue);
		switch (algorithm) {
			case FCFS:
				Collections.sort(auxQueue, Process.timeComparator);
				break;
			case SJF:
				Collections.sort(auxQueue, Process.burstComparator);
				break;
			case Priorities:
				Collections.sort(auxQueue, Process.priorityComparator);
				break;
			case RoundRobin:
			default:
				nextRR %= nextRR + 1;
				return readyQueue.get(nextRR);
		}
		return auxQueue.get(0);
	}

	public void execute() {
		Process next = nextProcess();
		if (next == null) {
			return;
		}

		if (algorithm != Algorithm.RoundRobin) {
			time += next.execute();
			readyQueue.remove(next);
		} else {
			time += next.execute(quantum);
			if (next.getRemaining() == 0) {
				readyQueue.remove(next);
				nextRR--;
			}
		}
	}

	public Algorithm getAlgorithm() {
		return algorithm;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}

	public int getReadyCount() {
		return readyQueue.size();
	}
}
