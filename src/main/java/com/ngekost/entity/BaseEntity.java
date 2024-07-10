package com.ngekost.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author : Leonardo Siagian
 * @date : 7/9/2024
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
    private boolean isActive = true;
    private String createdBy = "NgeKost server";
    private LocalDateTime createdAt = LocalDateTime.now();
    private String modifiedBy = "NgeKost server";
    private LocalDateTime modifiedAt = LocalDateTime.now();
    private LocalDateTime deletedAt = null;
    private String deletedBy = null;

    @PreUpdate
    protected void onUpdate() {
        modifiedAt = LocalDateTime.now();
    }
}