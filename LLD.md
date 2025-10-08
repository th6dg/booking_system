## Enums 
+ enum PaymentMode { <br>
  &nbsp;&nbsp;&nbsp;&nbsp;CARD, UPI, NETBANKING <br>
}
+ enum BookingStatus { <br>
  &nbsp;&nbsp;&nbsp;&nbsp;INITIATED, CONFIRMED, CANCELLED <br>
}
+ enum RoomType { <br>
  &nbsp;&nbsp;&nbsp;&nbsp;SINGLE, DOUBLE, SUITE <br> 
}
+ enum RoomStatus { <br>
  &nbsp;&nbsp;&nbsp;&nbsp;AVAILABLE, BOOKED, UNDER_MAINTENANCE <br>
}

## FR 1: User Registration
+ class User { <br>
  &nbsp;&nbsp;&nbsp;&nbsp;String userID; <br>
  &nbsp;&nbsp;&nbsp;&nbsp;String username; <br>
  &nbsp;&nbsp;&nbsp;&nbsp;String email; <br>
  &nbsp;&nbsp;&nbsp;&nbsp;String phoneNo; <br>
}

+ class UserService { <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Map<String,User> userMap=new HashMap<>(); <br>
  &nbsp;&nbsp;&nbsp;&nbsp;void registerUser(String name, String email) {} <br>
  &nbsp;&nbsp;&nbsp;&nbsp;User getUser(String userID){} <br>
}
### CRUD Hotel
+ class DateRange { <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Date from;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Date to;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;boolean overLaps(Date from, Date to) {}<br>
}

+ class Room {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;String roomID;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;RoomType roomType;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;RoomStatus roomStatus;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;double price;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;List<DateRange> bookedDates;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;boolean isAvailable(Date from, Date to) {}<br>
  &nbsp;&nbsp;&nbsp;&nbsp;void book(Date from, Date to) {}<br>
  &nbsp;&nbsp;&nbsp;&nbsp;void cancel(Date from, Date to) {}<br>
}

+ class Hotel {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;String hotelID;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;String hotelName;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;String location;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;List<Room> rooms;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;void addRoom(Room room) { rooms.add(room); }<br>
  &nbsp;&nbsp;&nbsp;&nbsp;List<Room> getRooms() { return rooms; }<br>
}

+ class HotelService {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Map<String,Hotel> hotel=new HashMap<>();<br>
  &nbsp;&nbsp;&nbsp;&nbsp;void addHotel(Hotel hotel) {} <br>
  &nbsp;&nbsp;&nbsp;&nbsp;void updateHotel(Hotel hotel) {}<br>
  &nbsp;&nbsp;&nbsp;&nbsp;void deleteHotel(Hotel hotel) {} <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Hotel getHotel(String hotelID) {}<br>
}

## FR 2: User should be able to search based on search criteria
+ class SearchCriteria {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;String hotelName;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;String location;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Date date;<br>
	//constructor, getter, setter<br>
}

+ class SearchService {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;List<Hotel> searchHotel(SearchCriteria criteria) {} <br>
  &nbsp;&nbsp;&nbsp;&nbsp;List<Room> getAvailableRooms(String hotelID, Date from, Date to) {}<br>
}

## FR 3: User should be able to book particular room
+ class Booking {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;String boookingID;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;String userID;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;String hotelID;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;String roomID;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Date from;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Date to;<br>
  &nbsp;&nbsp;&nbsp;&nbsp;BookingStatus bookingStatus;<br>
}

+ class BookingService {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;Map<String,Booking> bookings=new HashMap<>(); <br>
  &nbsp;&nbsp;&nbsp;&nbsp;Booking bookRoom(String userID, String hotelID, String roomID, Date from, Date to) {}<br>
  &nbsp;&nbsp;&nbsp;&nbsp;void cancelBooking(String bookingID) {}<br>
}

## FR 4: User should be able to make payment 
+ enum PaymentMode {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;UPI, CARD, NETBANKING<br>
}

+ interface PaymentStrategy {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;void pay(double amount);<br>
}

+ public class UPIPayment implement PaymentStrategy {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;@Override<br>
  &nbsp;&nbsp;&nbsp;&nbsp;void pay(double amount) {}<br>
}

+ public class CardPayment implement PaymentStrategy {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;@Override<br>
  &nbsp;&nbsp;&nbsp;&nbsp;void pay(double amount) {} <br>
}

+ public class NetBankingPayment implement PaymentStrategy {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;@Override<br>
  &nbsp;&nbsp;&nbsp;&nbsp;void pay(double amount) {}<br>
}


+ public class PaymentFactory {<br>
public static PaymentMethod getPaymentMethod(PaymentMode mode) {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;if(mode==UPI) return new UPIPayment();<br>
  &nbsp;&nbsp;&nbsp;&nbsp;else if(mode==CARD) return CardPayment();<br>
  &nbsp;&nbsp;&nbsp;&nbsp;else if(mode==NETBANKING) return NetBankingPayment();<br>
  &nbsp;&nbsp;&nbsp;&nbsp;else throw new IllegalArgumentException("Invalid mode");;<br>
}<br>
}

+ class Payment {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;String bookingID; <br>
  &nbsp;&nbsp;&nbsp;&nbsp;double amount; <br>
}

+ public class PaymentService {<br>
public Payment processPayment(String bookingID, PaymentMethod method, double amount) { <br>
  &nbsp;&nbsp;&nbsp;&nbsp;method.pay(amount);<br>
  &nbsp;&nbsp;&nbsp;&nbsp;return new Payment();<br>
}<br>
}