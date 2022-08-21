package com.tm.j10.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.tm.j10.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class OrderDescTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(OrderDesc.class);
        OrderDesc orderDesc1 = new OrderDesc();
        orderDesc1.setId(1L);
        OrderDesc orderDesc2 = new OrderDesc();
        orderDesc2.setId(orderDesc1.getId());
        assertThat(orderDesc1).isEqualTo(orderDesc2);
        orderDesc2.setId(2L);
        assertThat(orderDesc1).isNotEqualTo(orderDesc2);
        orderDesc1.setId(null);
        assertThat(orderDesc1).isNotEqualTo(orderDesc2);
    }
}
