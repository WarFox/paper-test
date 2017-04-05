package services;

import models.Street;
import utils.NumberUtils;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreetSpecification {

    private final Street street;

    public StreetSpecification(Street street) {
        this.street = street;
    }

    public boolean isValid() {
        return startingHouseNumber() == 1 && !hasDuplicates() && !hasMissingNumbers();
    }

    public int startingHouseNumber() {
        return street.getHousesNumbers()
                .stream()
                .min(Comparator.<Integer>naturalOrder())
                .orElse(0);
    }

    public int endingHouseNumber() {
       return street.getHousesNumbers()
               .stream()
               .max(Comparator.<Integer>naturalOrder())
               .orElse(0);
    }

    public boolean hasDuplicates() {
        final List<Integer> housesNumbers = street.getHousesNumbers();
        Set<Integer> set = new HashSet<Integer>(housesNumbers);
        return housesNumbers.size() != set.size();
    }

    public boolean hasMissingNumbers() {
        return endingHouseNumber() != street.getHousesNumbers().size();
    }

    public Integer numberOfHouses() {
        return street.getHousesNumbers().size();
    }

    public long numberOfHousesInNorth() {
        return street.getHousesNumbers()
                .stream()
                .filter(NumberUtils::isOdd).count();
    }

    public long numberOfHousesInSouth() {
        return street.getHousesNumbers()
                .stream()
                .filter(NumberUtils::isEven).count();
    }

}
