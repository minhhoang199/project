package com.tm.j10.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.tm.j10.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ProductCharacteristicTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductCharacteristic.class);
        ProductCharacteristic productCharacteristic1 = new ProductCharacteristic();
        productCharacteristic1.setId(1L);
        ProductCharacteristic productCharacteristic2 = new ProductCharacteristic();
        productCharacteristic2.setId(productCharacteristic1.getId());
        assertThat(productCharacteristic1).isEqualTo(productCharacteristic2);
        productCharacteristic2.setId(2L);
        assertThat(productCharacteristic1).isNotEqualTo(productCharacteristic2);
        productCharacteristic1.setId(null);
        assertThat(productCharacteristic1).isNotEqualTo(productCharacteristic2);
    }
}
