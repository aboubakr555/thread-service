package com.groupProject.threadservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Data
@AllArgsConstructor
public class VoteId  implements Serializable {
    private String username;
    private UUID thread_id;
}
