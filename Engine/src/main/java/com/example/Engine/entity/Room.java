package com.example.Engine.entity;

import com.example.Engine.constant.roomStatus;
import com.example.Engine.constant.roomType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;
import static com.example.Engine.constant.roomStatus.AVAILABLE;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private Long roomId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private roomType roomType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private roomStatus roomStatus = AVAILABLE;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId", nullable = false)
    private Hotel hotel;
}
