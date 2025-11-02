package org.example.common.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * A generic response DTO used for returning additional information in API responses.
 *
 * @author julianwalter
 */
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse implements Serializable {
    private String additionalInformation;
}
