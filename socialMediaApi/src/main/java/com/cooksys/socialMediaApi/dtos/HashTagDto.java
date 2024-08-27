package com.cooksys.socialMediaApi.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
public class HashTagDto {

    private String label;

    private Timestamp firstUsed;

    private Timestamp lastUsed;

}

