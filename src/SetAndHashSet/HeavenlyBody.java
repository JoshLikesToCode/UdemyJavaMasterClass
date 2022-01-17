package SetAndHashSet;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeroid;
    private final Set<HeavenlyBody> satelites;

    public HeavenlyBody(String name, double orbitalPeroid) {
        this.name = name;
        this.orbitalPeroid = orbitalPeroid;
        this.satelites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeroid() {
        return orbitalPeroid;
    }

    public boolean addMoon(HeavenlyBody moon)
    {
        return this.satelites.add(moon);
    }

    public Set<HeavenlyBody> getSatelites() {
        return new HashSet<>(this.satelites);
    }

    
    @Override
    public boolean equals(Object obj)
    {
        // check obj references
        if(this == obj)
        {
            return true;
        }
        System.out.println("objs.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if((obj == null) || (obj.getClass() != this.getClass()))
        {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        System.out.println("Hashcode called.");
        return this.name.hashCode() + 57;
    }
}
