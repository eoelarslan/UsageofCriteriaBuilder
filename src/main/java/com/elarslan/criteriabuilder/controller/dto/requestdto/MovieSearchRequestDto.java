package com.elarslan.criteriabuilder.controller.dto.requestdto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieSearchRequestDto {
    private String productionYear;
    private String name;
    private Integer genreId;
    private Integer producerId;
    private Integer writerId;
}
