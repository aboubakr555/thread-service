package com.groupProject.threadservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@IdClass(VoteId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
    @Id
    private String username;
    @Id
    private UUID thread_id;

    @Max(1)
    @Min(-1)
    private int voteValue;


}
