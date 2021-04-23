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
        Build build = builder.generateBuild();
        assertThat(build.getLift()).isNotNull();
        assertThat(build.getLift().getCurrentFloor()).isEqualTo(1);
        assertThat(build.getFloors().size()).isLessThan(21);
        assertThat(build.getFloors().size()).isGreaterThan(4);
        build.getFloors().stream().forEach(floor -> {
            assertThat(floor.getPassengers().size()).isLessThan(11);
            assertThat(floor.getPassengers().size()).isGreaterThan(-1);
        });
    }



}
