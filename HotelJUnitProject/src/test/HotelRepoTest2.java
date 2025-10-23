package com.example.junittest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HotelRepoTest {

    @Autowired
    private HotelRepo hotelrepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveHotelTest() {
        Hotel hotel = new Hotel("radisonblue", "mysore", "dosa");
        hotelrepo.save(hotel);
        Assertions.assertThat(hotel.getHid()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getHotelTest() {
        List<Hotel> hotel = hotelrepo.findAll();
        Assertions.assertThat(hotel.size()).isGreaterThan(0);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updHotelTest() {
        Hotel hotel = hotelrepo.findById(1).get();
        hotel.setFitem("biriyani");
        Hotel newHotel = hotelrepo.save(hotel);
        Assertions.assertThat(newHotel.getFitem()).isEqualTo("biriyani");
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void delHotel() {
        boolean beforeDelete = hotelrepo.findById(1).isPresent();
        hotelrepo.deleteById(1);
        boolean afterDelete = hotelrepo.findById(1).isPresent();
        assertTrue(beforeDelete);
        assertFalse(afterDelete);
    }
}
