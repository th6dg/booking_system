### 1. Check phòng trống (Room Availability)&nbsp;&nbsp;&nbsp;&nbsp;⭐⭐
+ __Description__: <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Khi khách chọn ngày check-in / check-out → hệ thống phải tìm phòng còn trống trong khoảng đó.
+ __Logic__: <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Duyệt danh sách các booking của phòng, kiểm tra có overlap không.<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Nếu không chồng lấn (overlap) → phòng trống.<br>
+ __Data Structure__: Map, List, Date, condition 

### 2. Smart Room Allocation (Phân bổ phòng thông minh)&nbsp;&nbsp;&nbsp;&nbsp;⭐⭐⭐
+ __Description__:<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Khi có nhiều phòng trống, chọn phòng “tối ưu nhất”: tầng thấp, view đẹp, gần thang máy...
+ __Logic__: <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Tạo PriorityQueue<Room> với custom Comparator (ưu tiên tiêu chí).<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Lấy pq.poll() để chọn phòng tốt nhất.
+ __Data structure__: PriorityQueue, Comparator chaining

### 3. Dynamic Pricing (Giá phòng linh hoạt)&nbsp;&nbsp;&nbsp;&nbsp;⭐⭐⭐
+ __Description__:<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Tăng/giảm giá theo ngày, mùa, lễ, hoặc % phòng còn trống.
+ __Logic__: <br>
&nbsp;&nbsp;&nbsp;&nbsp;Lấy giá gốc từ Map<RoomType, Double> <br>
&nbsp;&nbsp;&nbsp;&nbsp;Áp dụng rule:<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nếu còn < 20% phòng → tăng 30%<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nếu ngày lễ → tăng cố định<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nếu khách VIP → giảm 10%<br>
+ __Data Structure__: Map, Set, Optional, business rule

### 4. Detect Overbooking (Phát hiện đặt trùng)&nbsp;&nbsp;&nbsp;&nbsp;⭐⭐⭐
+ __Description__:<br>
&nbsp;&nbsp;&nbsp;&nbsp;Khi thêm booking mới → phát hiện phòng bị đặt trùng thời gian.
+ __Logic__:<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Duyệt danh sách booking theo phòng (bookingsByRoom)<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Kiểm tra khoảng ngày chồng nhau.<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Nếu trùng → báo lỗi.<br>
+ __Data Structure__: TreeSet, Comparator, interval logic

### 5. Loyalty / Reward Points (Hệ thống điểm thưởng)&nbsp;&nbsp;&nbsp;&nbsp;⭐⭐
+ __Description__: <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Mỗi khi khách thanh toán → cộng điểm tích lũy.<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Đạt mốc → được ưu đãi hoặc nâng hạng.
+ __Logic__:
  &nbsp;&nbsp;&nbsp;&nbsp;Mỗi booking → điểm = totalPrice * 0.05<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Lưu điểm vào Map<Long, Integer> (userId → points)<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Khi > 1000 → cấp “Gold”<br>
+ __Data Structure__: Map

### 6. Doanh thu theo ngày / tháng (Revenue Report)&nbsp;&nbsp;&nbsp;&nbsp;⭐⭐
+ __Description__: <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Tính tổng doanh thu từng ngày, hoặc từng tháng.
+ __Logic__:<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Group tất cả booking theo ngày checkout<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Cộng dồn tiền<br>
+ __Data Structure__: Stream API, groupingBy, Map

### 7. Room Maintenance Scheduler (Lịch bảo trì phòng)&nbsp;&nbsp;&nbsp;&nbsp;⭐⭐
+ __Description__: <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Sau khi phòng được check-out 10 lần → đánh dấu cần bảo trì.
+ __Logic__:<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Mỗi lần check-out → tăng counter trong Map<Long, Integer> (roomId → timesUsed)<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Nếu ≥ 10 → chuyển RoomStatus = MAINTENANCE.<br>
+ __Data Structue__: Map, if condition, enum state

### 8. Top Customer / Top Room Report&nbsp;&nbsp;&nbsp;&nbsp;⭐⭐⭐
+ __Description__: <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Tìm 5 khách hàng đặt nhiều nhất hoặc 5 phòng có doanh thu cao nhất.<br>
+ __Logic__:<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Dùng Map<Customer, Integer> → đếm số booking.<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Sắp xếp theo value giảm dần.<br>
+ __Data Structure__: Sorting, Comparator, Stream

### 9. Room Availability Calendar (Lịch hiển thị phòng)&nbsp;&nbsp;&nbsp;&nbsp;⭐⭐⭐
+ __Description__: <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Tạo một lịch dạng “ngày – phòng – trạng thái” để hiển thị dashboard.
+ __Logic__:<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Duyệt qua tất cả phòng.<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Với từng ngày trong tháng → đánh dấu trạng thái (available/booked/maintenance).<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Lưu vào cấu trúc 2 chiều.<br>
+ __Data Structure__: Nested Map, iteration, data organization

### 10. Fraud Detection — phát hiện đặt phòng ảo&nbsp;&nbsp;&nbsp;&nbsp;⭐⭐⭐
+ __Description__: <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Nếu cùng 1 user đặt nhiều booking chưa check-in → nghi ngờ spam.
+ __Logic__:<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Đếm số booking status = RESERVED của user.<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Nếu > 3 → cảnh báo.<br>
+ __Data Structure__: Map grouping, filtering
