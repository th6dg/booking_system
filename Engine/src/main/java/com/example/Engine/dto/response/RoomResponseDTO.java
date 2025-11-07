package com.example.Engine.dto.response;

import com.example.Engine.constant.roomStatus;
import com.example.Engine.constant.roomType;

import java.math.BigDecimal;

public record RoomResponseDTO(Long roomId, roomType roomType, roomStatus roomStatus, BigDecimal price, String hotelName) {}

