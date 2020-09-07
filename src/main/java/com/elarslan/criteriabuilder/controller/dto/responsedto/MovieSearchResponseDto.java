package com.elarslan.criteriabuilder.controller.dto.responsedto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieSearchResponseDto {
    private String productionYear;
    private String name;
    private Integer genreId;
    private Integer producerId;
    private Integer writerId;
    private String duration;
}
