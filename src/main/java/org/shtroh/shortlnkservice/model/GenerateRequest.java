package org.shtroh.shortlnkservice.model;


import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Data
public class GenerateRequest {

    @NotBlank(message = "Field \"url\" cannot be empty")
    @URL(message = "Field \"url\" must be a URL")
    private String url;
}
