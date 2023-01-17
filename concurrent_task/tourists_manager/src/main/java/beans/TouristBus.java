package beans;

import java.util.HashSet;
import java.util.Set;

public class TouristBus implements Runnable{

    private Set<Tourist> places;

    public TouristBus(int places) {
        this.places = new HashSet<>(places);
    }

    public void sitToTheBus(Tourist tourist){
        places.add(tourist);
        tourist.setInTravel(true);
    }

    public void getOutOfTheBus(Tourist tourist){
        places.remove(tourist);
        tourist.setInTravel(false);
    }

    public Set<Tourist> getTourist(){
        return places;
    }

    public void showOccupiedPlaces(){
        System.out.println( places.size() + " are occupied");
    }

    public void showAllTourists(){
        for (Tourist t:places) {
            System.out.println(t);
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The bus achieved the next point ");
    }
}
