package services;

import models.Street;
import utils.NumberUtils;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreetSpecification {

    private final Street street;

    public StreetSpecification(Street street) {
        this.street = street;
    }

    public boolean isValid() {
        return startingHouseNumber() == 1 && !hasDuplicates() && !hasMissingNumbers();
    }

    public int startingHouseNumber() {
        return getHousesNumbers()
                .stream()
                .min(Comparator.<Integer>naturalOrder())
                .orElse(0);
    }

    public int endingHouseNumber() {
        return getHousesNumbers()
                .stream()
                .max(Comparator.<Integer>naturalOrder())
                .orElse(0);
    }

    public boolean hasDuplicates() {
        final List<Integer> housesNumbers = getHousesNumbers();
        Set<Integer> set = new HashSet<Integer>(housesNumbers);
        return housesNumbers.size() != set.size();
    }

    public boolean hasMissingNumbers() {
        return endingHouseNumber() != getHousesNumbers().size();
    }

    public Integer numberOfHouses() {
        return getHousesNumbers().size();
    }

    public List<Integer> housesInLeftHandSide() {
        return getHousesNumbers()
                .stream()
                .filter(NumberUtils::isOdd)
                .collect(Collectors.toList());
    }

    public List<Integer> housesInRightHandSide() {
        return getHousesNumbers()
                .stream()
                .filter(NumberUtils::isEven)
                .collect(Collectors.toList());
    }

    public long numberOfHousesInLeftHandSide() {
        return housesInLeftHandSide().size();
    }

    public long numberOfHousesInRightHandSide() {
        return housesInRightHandSide().size();
    }

    public List<Integer> getHousesNumbers() {
        return street.getHousesNumbers();
    }

}
