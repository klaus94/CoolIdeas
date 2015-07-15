import java.util.Observable;
import java.util.Observer;
import java.util.List;
import java.util.LinkedList;

public class VehicleQueue implements Observer {
	private double entryDelay;
	private double exitDelay;
	private int trafficLightRate;
	private boolean greenLight;
	private List<Vehicle> queue;
	private VehicleGenerator generator;

	public VehicleQueue(double entryDelay, double exitDelay, int trafficLightRate, VehicleGenerator generator){
		if (generator == null) {
			throw new NullPointerException();
		}
		if (trafficLightRate <= 0 || entryDelay <= 0 || exitDelay <= 0) {
			throw new IllegalArgumentException();
		}

		this.entryDelay = entryDelay;
		this.exitDelay = exitDelay;
		this.trafficLightRate = trafficLightRate;
		this.generator = generator;

		greenLight = false;
		queue = new LinkedList<Vehicle>();
	}

	public void enter() {
		queue.add(generator.createVehicle());
	}

	public void leave() {
		if (queue.size() >= 1) {
			queue.remove(0);
		}
	}

	public double getLength() {
		double lenght= 0;
		for (Vehicle v : queue) {
			lenght += v.getLength();
		}
		return lenght;
	}

	public int getSize() {
		return queue.size();
	}

	public void update(Observable obs, Object obj){
		//neuer Algorithmus:
		int time = (int) obj;
		
		if (time != 0) {
			int time1 = time - 1;
			double z2 = (double) (time1);
			double z3 = (z2) / entryDelay;
			int z4 = (int) (z3);
			double z5 = (double) (z4);
			double z6 = (z5) * entryDelay;
			double z7 = ((double) time) - (z6);
			int runden1 = (int) (((z7) * 10) + 0.5);
			double runden2 = ((double) (runden1)) / 10;
			double z8 = (runden2) / entryDelay;
			int erg = (int) z8;

			int entry = erg;
			for (int i = 1; i <= entry; i++) {
				enter();
			}


			if (greenLight == true) {
				int timeGreenPeriod;
				if ((time % (2 * trafficLightRate)) == 0) {
					timeGreenPeriod = trafficLightRate;
				} else {
					timeGreenPeriod = time % trafficLightRate;
				}

				if (timeGreenPeriod > 0) {
					double exit = (int) ((((double) timeGreenPeriod) - (((double) ((int) (((double) (timeGreenPeriod - 1)) / exitDelay))) * exitDelay)) / exitDelay);
					for (int i = 1; i <= exit; i++) {
						leave();
					}
				}
			}	

			if (((int) (time / trafficLightRate)) - ((int) ((time - 1) / trafficLightRate)) > 0) {
				greenLight = !greenLight;
			}
		}
	}
}