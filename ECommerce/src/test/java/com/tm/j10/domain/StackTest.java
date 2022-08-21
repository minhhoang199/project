package com.tm.j10.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.tm.j10.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Stack.class);
        Stack stack1 = new Stack();
        stack1.setId(1L);
        Stack stack2 = new Stack();
        stack2.setId(stack1.getId());
        assertThat(stack1).isEqualTo(stack2);
        stack2.setId(2L);
        assertThat(stack1).isNotEqualTo(stack2);
        stack1.setId(null);
        assertThat(stack1).isNotEqualTo(stack2);
    }
}
