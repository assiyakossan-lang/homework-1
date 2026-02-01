package edu.narxoz.galactic;
import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.bodies.SpaceStation;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.dispatcher.Result;
import edu.narxoz.galactic.drones.HeavyDrone;
import edu.narxoz.galactic.drones.LightDrone;
import edu.narxoz.galactic.task.DeliveryTask;

public class DemoApp {
        public static void main(String[] args) {
        Planet earth = new Planet("Earth", 0, 0, "Oxygen");
        SpaceStation iss = new SpaceStation("ISS", 100, 0, 5);
        Cargo cargo = new Cargo(20, "Medical supplies");
        LightDrone lightDrone = new LightDrone("LD-1", 5);
        HeavyDrone heavyDrone = new HeavyDrone("HD-1", 50);
        DeliveryTask task = new DeliveryTask(earth, iss, cargo);
        Dispatcher dispatcher = new Dispatcher();

        Result r1 = dispatcher.assignTask(task, lightDrone);
        System.out.println("LightDrone assign: ok=" + r1.ok() + ", reason=" + r1.reason());

        Result r2 = dispatcher.assignTask(task, heavyDrone);
        System.out.println("HeavyDrone assign: ok=" + r2.ok() + ", reason=" + r2.reason());

        System.out.println("Estimated time: " + task.estimateTime() + " min");

        Result r3 = dispatcher.completeTask(task);
        System.out.println("Task completed: ok=" + r3.ok());

        System.out.println("Task state: " + task.getState());
        System.out.println("Drone status: " + heavyDrone.getStatus());
    }
}
