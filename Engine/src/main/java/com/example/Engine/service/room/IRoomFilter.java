package com.example.Engine.service.room;

import com.example.Engine.dto.entity.RoomFilterDTO;
import com.example.Engine.entity.Room;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface IRoomFilter {

    // Predicate<T> — điều kiện đúng/sai
    // Nhận T → trả về boolean.
    // lọc, kiểm tra, validate.
    List<RoomFilterDTO> filterRoom(List<RoomFilterDTO> rooms, Predicate<RoomFilterDTO> p);


    // Function<T, R> — biến đổi dữ liệu
    // Nhận T → trả về R.
    // map, transform, convert DTO
    List<Object> retrieveValueFromRoom(List<RoomFilterDTO> rooms, Function<RoomFilterDTO, Object> f);


    // Supplier<T> — nhà cung cấp dữ liệu
    // Không nhận gì, trả về T.
    // lazy loading, tạo đối tượng, mock data.
    RoomFilterDTO createRandomRandom(Supplier<RoomFilterDTO> s);


    //  Consumer<T> — hành động trên dữ liệu
    //  Nhận T, không trả về gì.
    //  in ra, ghi log, cập nhật trạng thái.
    void logInfoRoom(RoomFilterDTO room, Consumer<RoomFilterDTO> c);


    //  BinaryOperator<T> — kết hợp 2 giá trị
    //  Chức năng: Nhận 2 giá trị cùng kiểu → trả về 1 giá trị.
    //  Dùng để: cộng, gộp, reduce.


    //  BiFunction<T, U, R> — xử lý 2 input khác kiểu
    //  Chức năng: Nhận 2 tham số → trả về 1 kết quả.
    //  Dùng để: gộp 2 đối tượng.


    //  BiPredicate<T, U> — so sánh 2 đối tượng
    //  Chức năng: Nhận 2 input → trả về boolean.
    //  Dùng để: so sánh, validate quan hệ giữa 2 object.


    //  BiConsumer<T, U> — hành động trên 2 dữ liệu
    //  Chức năng: Nhận 2 input, không trả về gì.
    //  Dùng để: log, gộp, xử lý song song 2 dữ liệu.

}
