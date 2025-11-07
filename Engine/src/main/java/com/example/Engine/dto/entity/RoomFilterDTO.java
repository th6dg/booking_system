package com.example.Engine.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  “interface-based projection”
 *  (tạm dịch: ánh xạ dữ liệu dựa trên interface).
 *  Spring tự tạo ra class ẩn danh (dynamic proxy)
 *  triển khai interface đó cho bạn.
 */
public interface RoomFilterDTO {
    Long getRoomId();
    String getRoomType();
    String getRoomStatus();
    Long getPrice();
    Long getHotelId();
    String getHotelName();
    Long getLocationId();
    String getCountry();
    String getProvince();
    String getCity();
}

