package edu.sfsu;

import static java.lang.Thread.sleep;

/**
 * Executes the Process Management simulation.
 *
 * Instructions: create a
 */
public class Simulation {

  /**
   * TODO: Complete this function. Use the roundRobinSimulation function as an example.
   */
  static void prioritySimulation() throws InterruptedException {
  }

  /**
   * Simulates a priority queue implementation of a process scheduler.
   *
   * THIS IS ONLY AN EXAMPLE.
   */
  static void priorityQueueSimulation() throws InterruptedException {

    System.out.println("Simulation starting.");

    CentralProcessingUnit cpu = new CentralProcessingUnit();
    ProcessScheduler scheduler = ProcessScheduler.create(cpu);

    // Sleep for 5 seconds to show a few NO-OPs.
    for (int i = 0; i < 5; i++) {
      sleep(1000);
    }

    // Add a few processes
    SimulatedProcess parentProcess = SimulatedProcess.create(0);
    scheduler.addProcess(parentProcess);
    sleep(2000);

    SimulatedProcess firstChild = SimulatedProcess.create(parentProcess.processNumber(), SimulatedProcess.LOW_PRIORITY);
    scheduler.addProcess(firstChild);
    sleep(2000);

    SimulatedProcess secondChild = SimulatedProcess.create(parentProcess.processNumber(), SimulatedProcess.NORMAL_PRIORITY);
    scheduler.addProcess(secondChild);
    sleep(2000);

    SimulatedProcess thirdChild = SimulatedProcess.create(parentProcess.processNumber(), SimulatedProcess.HIGH_PRIORITY);
    scheduler.addProcess(thirdChild);
    sleep(2000);

    // Sleep for 1 minute, let the processes run.
    for (int i = 0; i < 60; i++) {
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // Remove them one by one with a delay.
    scheduler.removeProcess(thirdChild);
    sleep(2000);
    scheduler.removeProcess(secondChild);
    sleep(2000);
    scheduler.removeProcess(firstChild);
    sleep(2000);
    scheduler.removeProcess(parentProcess);
    sleep(2000);

  }

  public static void main(String[] args) throws InterruptedException {
    // TODO: call prioritySimulation() instead.
    Simulation.priorityQueueSimulation();
    System.out.println("END OF PROGRAM");
  }
}
