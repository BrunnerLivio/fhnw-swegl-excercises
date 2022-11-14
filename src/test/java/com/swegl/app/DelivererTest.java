package com.swegl.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DelivererTest {
  @Test
  public void testAddDeliveryWithRemainingCapacityAndNotStarted() {
    // given a deliverer with remaining capacity >= 2
    Deliverer joe = new Deliverer(2, 10);
    int initialFreeCapacity = joe.totalCapacity(); // 20
    // when he is assigned a new delivery of 2 pizzas
    boolean accepted = joe.addDelivery(2);
    // then the delivery is accepted
    // and the remaining capacity decreased by 2
    assertTrue(accepted);
    assertEquals(initialFreeCapacity - 2, joe.getRemainingCapacity());
  }

  @Test
  public void testAddDeliveryWithNoRemainingCapacity() {
    // given a deliverer with full bags
    Deliverer joeMama = new Deliverer(1, 1);
    joeMama.addDelivery(1);
    assertEquals("the bag should be full", 0, joeMama.getRemainingCapacity());

    // when adding a new delivery
    boolean result = joeMama.addDelivery(1);

    // then the delivery is not accepted
    assertFalse("delivery is not accepted", result);

    // and the free capacity remains the same
    assertEquals("free capacity remains the same", 0, joeMama.getRemainingCapacity());
  }

  @Test
  public void testAddDeliveryWithRemainingCapacityAndAlreadyStarted() {
    // given a deliverer with remaining capacity and started
    Deliverer joeWho = new Deliverer(1, 2);
    joeWho.setOnTheRoad(true);

    // when he is assigned a new delivery of 2 pizzas
    boolean result = joeWho.addDelivery(2);
    // then the delivery is not accepted
    assertFalse("delivery is not accepted", result);
    // and the remaining capacity is the same as before
    assertEquals("remaining capacity is the same as before", 2, joeWho.getRemainingCapacity());
  }
}
