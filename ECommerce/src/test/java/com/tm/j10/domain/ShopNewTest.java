package com.tm.j10.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.tm.j10.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ShopNewTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ShopNew.class);
        ShopNew shopNew1 = new ShopNew();
        shopNew1.setId(1L);
        ShopNew shopNew2 = new ShopNew();
        shopNew2.setId(shopNew1.getId());
        assertThat(shopNew1).isEqualTo(shopNew2);
        shopNew2.setId(2L);
        assertThat(shopNew1).isNotEqualTo(shopNew2);
        shopNew1.setId(null);
        assertThat(shopNew1).isNotEqualTo(shopNew2);
    }
}
