package chapter_10.code_05;

import net.jcip.annotations.GuardedBy;

import java.util.HashSet;
import java.util.Set;

/**
 * 程序清单 10-5 在相互协作对象之间的锁顺序死锁（不要这么做）
 */
public class CooperatingDeadlock {
    // 注意：容易发生死锁！
    class Taxi {
        @GuardedBy("this")
        private Point location, destination;
        private final Dispatcher dispatcher;

        public Taxi(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        public synchronized Point getLocation() {
            return location;
        }

        public synchronized void setLocation(Point location) {
            this.location = location;
            if (location.equals(destination)) {
                dispatcher.notifyAvailable(this);
            }
        }

        public synchronized Point getDestination() {
            return destination;
        }

        public synchronized void setDestination(Point destination) {
            this.destination = destination;
        }
    }

    class Dispatcher {
        @GuardedBy("this")
        private final Set<Taxi> taxis;
        @GuardedBy("this")
        private final Set<Taxi> availableTaxis;

        public Dispatcher() {
            taxis = new HashSet<>();
            availableTaxis = new HashSet<>();
        }

        public synchronized void notifyAvailable(Taxi taxi) {
            availableTaxis.add(taxi);
        }

        public synchronized Image getImage() {
            Image image = new Image();
            for (Taxi taxi : taxis) {
                image.drawMarker(taxi.getLocation());
            }
            return image;
        }
    }

    class Image {
        public void drawMarker(Point p) {
        }
    }

    class Point {
    }
}
