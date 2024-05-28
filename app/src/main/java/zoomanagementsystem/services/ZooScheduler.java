package zoomanagementsystem.services;

import java.util.List;
import zoomanagementsystem.models.Animal;
import zoomanagementsystem.models.Keeper;

/**
 * Implementers of this class should be singletons
 */
public abstract class ZooScheduler {
    protected static ZooScheduler instance;

    protected ZooScheduler() {}

    public abstract void assignJobs(final List<? extends Keeper<? extends Animal>> keepers);
}
