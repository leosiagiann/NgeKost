package com.ngekost.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@Entity
@Table(name = "rooms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class Room extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String roomNumber;
    private Double price;
    private Integer floor;
    private String facilities;
    @Builder.Default
    private String status = "available";
}
