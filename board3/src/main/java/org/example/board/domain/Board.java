package org.example.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
    private Long id;
    private String title;
    private String content;
    private String author;
    private Date regDate;
}
