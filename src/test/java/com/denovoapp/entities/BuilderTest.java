package com.denovoapp.entities;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuilderTest {

    private Builder builder;

    @Before
    public void setUp(){
        builder = new Builder();
    }

    @Test
    public void createdBuild(){
        Building building = builder.generateBuild();
        assertThat(building.getLift()).isNotNull();
        assertThat(building.getLift().getCurrentFloor()).isEqualTo(1);
        assertThat(building.getFloors().size()).isLessThan(21);
        assertThat(building.getFloors().size()).isGreaterThan(4);
        building.getFloors().stream().forEach(floor -> {
            assertThat(floor.getPassengers().size()).isLessThan(11);
            assertThat(floor.getPassengers().size()).isGreaterThan(-1);
        });
    }



}
