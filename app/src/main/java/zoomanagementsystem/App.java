package zoomanagementsystem;

import zoomanagementsystem.models.*;
import zoomanagementsystem.services.FeedingScheduler;
import zoomanagementsystem.services.GroomingScheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<LargeAnimal> largeAnimals = Arrays.asList(
                new Lion(LocalDate.of(2010, 4, 28)),
                new Lion(LocalDate.of(2012, 5, 11)),
                new Zebra(LocalDate.of(2008, 12, 1))
        );
        List<SmallAnimal> smallAnimals = Arrays.asList(
                new Rabbit(LocalDate.of(2014, 1, 1)),
                new GuineaFowl(LocalDate.of(2020, 1, 1))
        );
        List<Animal> animals = new ArrayList<>();
        animals.addAll(largeAnimals);
        animals.addAll(smallAnimals);

        Keeper<LargeAnimal> largeAnimalKeeper = new Keeper<>(largeAnimals);
        Keeper<SmallAnimal> smallAnimalKeeper = new Keeper<>(smallAnimals);

        List<Keeper<? extends Animal>> keepers = Arrays.asList(largeAnimalKeeper, smallAnimalKeeper);

        Rabbit babyRabbit = new Rabbit(LocalDate.now());
        smallAnimalKeeper.startLookingAfter(babyRabbit);

        final FeedingScheduler feedingScheduler = FeedingScheduler.getInstance();
        final GroomingScheduler groomingScheduler = GroomingScheduler.getInstance();

        feedingScheduler.assignJobs(keepers);
        groomingScheduler.assignJobs(keepers);
        animals.forEach(System.out::println);
    }
}
