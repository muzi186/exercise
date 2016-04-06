package com.recruit.tests.trains.model;

public class Route {
    private Town from;
    private Town to;

    private int distance;

    public Route(Town from, Town to, int distance) {
        super();
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public Town getFrom() {
        return from;
    }

    public Town getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + distance;
        result = prime * result + ((from == null) ? 0 : from.hashCode());
        result = prime * result + ((to == null) ? 0 : to.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Route other = (Route) obj;
        if (from == null) {
            if (other.from != null)
                return false;
        } else if (!from.equals(other.from)) {
            return false;
        }
        if (to == null) {
            if (other.to != null)
                return false;
        } else if (!to.equals(other.to)) {
            return false;
        }

        return true;
    }

    public String toString() {
        return from.getName() + to.getName() + distance;
    }
}
