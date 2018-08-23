@GenericGenerator(
    name = "ID_GENERATOR",
    strategy = "enhanced-sequence",
    parameters = {
        @Parameter(
            name = "sequence_name",
            value = "JPAWH_SEQUENCE"
        ),
        @Parameter(
            name = "initial_value",
            value = "1000"
        )
    }
)

package com.nick.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;