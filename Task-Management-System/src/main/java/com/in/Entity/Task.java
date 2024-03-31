package com.in.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private Date dueDate;
    private String createdAt;
    private String updatedAt;




}
