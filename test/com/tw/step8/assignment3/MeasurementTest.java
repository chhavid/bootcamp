package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidMeasurementException;
import com.tw.step8.assignment3.exception.MeasurementMismatchedException;
import com.tw.step8.assignment3.exception.UnacceptableUnitException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {
    @Test
    void shouldThrowAnExceptionForNegativeLength() {
        assertThrows(InvalidMeasurementException.class, () -> Measurement.createMeasurement(MeasuringQuantity.LENGTH, -1, Unit.INCH));
    }

    @Test
    void shouldRelateSameLengthsAsEqual() throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        assertEquals(Relation.EQUAL,length1.compare(length2));
    }

    @Test
    void shouldRelateGreaterIfGivenLengthIsSmaller() throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,2, Unit.INCH);
        assertEquals(Relation.GREATER,length1.compare(length2));
    }

    @Test
    void shouldRelateLesserIfGivenLengthIsLarger() throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,8, Unit.INCH);
        assertEquals(Relation.LESSER,length1.compare(length2));
    }

    @Test
    void shouldCompareLengthsInFeetAndInch() throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        Measurement feet = Measurement.createMeasurement(MeasuringQuantity.LENGTH,1, Unit.FEET);
        Measurement inch = Measurement.createMeasurement(MeasuringQuantity.LENGTH,12, Unit.INCH);
        assertEquals(Relation.EQUAL,feet.compare(inch));
    }

    @Test
    void shouldCompareLengthsInInchAndCentimeter() throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        Measurement cm = Measurement.createMeasurement(MeasuringQuantity.LENGTH,5, Unit.CM);
        Measurement inch = Measurement.createMeasurement(MeasuringQuantity.LENGTH,3, Unit.INCH);
        assertEquals(Relation.LESSER,cm.compare(inch));
    }

    @Test
    void shouldCompareLengthsInMillimeterAndCentimeter() throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        Measurement cm = Measurement.createMeasurement(MeasuringQuantity.LENGTH,1, Unit.CM);
        Measurement mm = Measurement.createMeasurement(MeasuringQuantity.LENGTH,10, Unit.MM);
        assertEquals(Relation.EQUAL,cm.compare(mm));
    }

    @Test
    void shouldCompareLengthsInMillimeterAndInch() throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        Measurement mm = Measurement.createMeasurement(MeasuringQuantity.LENGTH,100, Unit.MM);
        Measurement inch = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        assertEquals(Relation.EQUAL,inch.compare(mm));
    }

    @Test
    void shouldCompareVolumesInLitreAndGallons() throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        Measurement litre = Measurement.createMeasurement(MeasuringQuantity.VOLUME,3.78, Unit.LITRE);
        Measurement gallon = Measurement.createMeasurement(MeasuringQuantity.VOLUME,1, Unit.GALLON);
        assertEquals(Relation.EQUAL,gallon.compare(litre));
    }

    @Test
    void shouldThrowAnExceptionForComparingDifferentQuantities() throws InvalidMeasurementException, UnacceptableUnitException {
        Measurement volume = Measurement.createMeasurement(MeasuringQuantity.VOLUME, 1, Unit.LITRE);
        Measurement length = Measurement.createMeasurement(MeasuringQuantity.LENGTH, 1, Unit.CM);
        assertThrows(MeasurementMismatchedException.class, () -> volume.compare(length));
    }

    @Test
    void shouldAddTwoMeasurementsOfSameUnit() throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH, 2, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH, 2, Unit.INCH);
        Measurement actualLength = length1.add(length2);
        Measurement expectedLength = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4,Unit.INCH);
        assertTrue(actualLength.isEqual(expectedLength,0.01));
    }

    @Test
    void shouldAddTwoLengthsOfDifferentUnitsAndGiveResultInInch() throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH, 2, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH, 2.5, Unit.CM);
        Measurement actualLength = length1.add(length2);
        Measurement expectedLength = Measurement.createMeasurement(MeasuringQuantity.LENGTH,3,Unit.INCH);
        assertTrue(actualLength.isEqual(expectedLength,0.01));
    }
    @Test
    void shouldAddTwoVolumesOfDifferentUnitsAndGiveResultInLitres() throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        Measurement gallon = Measurement.createMeasurement(MeasuringQuantity.VOLUME, 1, Unit.GALLON);
        Measurement litre = Measurement.createMeasurement(MeasuringQuantity.VOLUME, 1, Unit.LITRE);
        Measurement actualVolume = gallon.add(litre);
        Measurement expectedVolume = Measurement.createMeasurement(MeasuringQuantity.VOLUME,4.78,Unit.LITRE);
        assertTrue(actualVolume.isEqual(expectedVolume,0.01));
    }

    @Test
    void shouldThrowAnExceptionForAddingDifferentQuantities() throws InvalidMeasurementException, UnacceptableUnitException {
        Measurement volume = Measurement.createMeasurement(MeasuringQuantity.VOLUME, 1, Unit.LITRE);
        Measurement length = Measurement.createMeasurement(MeasuringQuantity.LENGTH, 1, Unit.CM);
        assertThrows(MeasurementMismatchedException.class, () -> volume.add(length));
    }

    @Test
    void shouldCompareTemperaturesInCelsiusAndFahrenheit() throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        Measurement celsius = Measurement.createMeasurement(MeasuringQuantity.TEMPERATURE,100, Unit.CELSIUS);
        Measurement fahrenheit = Measurement.createMeasurement(MeasuringQuantity.TEMPERATURE,212, Unit.FAHRENHEIT);
        assertEquals(Relation.EQUAL,celsius.compare(fahrenheit));
    }

    @Test
    void shouldThrowAnExceptionForInvalidUnitOfAQuantity() {
        assertThrows(UnacceptableUnitException.class, () -> Measurement.createMeasurement(MeasuringQuantity.VOLUME, 1, Unit.INCH));
    }
}