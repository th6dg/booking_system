## 1. User Table
   + UserID (Primary Key): It is a Unique identifier for each user.
   + Username: User's display name.
   + Email: User's email address for contact and login.
   + PasswordHash: Securely hashed password for user authentication.
   + Preferences: User preferences for search filters and notifications.
   + CreatedAt: It is a Timestamp when the user account was created.

## 2. Hotel Table
   + HotelID (Primary Key): It is a Unique identifier for each hotel.
   + Name: Name of the hotel.
   + Location: Address of the hotel.
   + Description: Detailed description of the hotel.
   + StarRating: Star rating of the hotel.
   + Amenities: It is a List of amenities provided by the hotel.
   + ContactInfo: Contact information of the hotel.

## 3. Room Table
   + RoomID (Primary Key): It is a Unique identifier for each room.
   + HotelID: Identifier for the hotel to which the room belongs.
   + RoomType: Type of room (e.g., single, double, suite).
   + Price: Price per night for the room.
   + Availability: Availability status of the room.
   + Features: List of features specific to the room.

## 4. Booking Table
   + BookingID (Primary Key): It is a Unique identifier for each booking.
   + UserID: Identifier for the user who made the booking.
   + RoomID: Identifier for the room booked.
   + CheckInDate: Date of check-in.
   + CheckOutDate: Date of check-out.
   + TotalPrice: Total price of the booking.
   + BookingStatus: Status of the booking (e.g., confirmed, canceled).
   + Timestamp: Date and time of the booking.

## 5. Review Table
   + ReviewID (Primary Key): It is a Unique identifier for each review.
   + UserID: Identifier for the user who wrote the review.
   + HotelID: Identifier for the hotel being reviewed.
   + Rating: Rating given by the user.
   + Comment: Review the comment left by the user.
   + Timestamp: Date and time of the review.

## 6. Payment Table
   + PaymentID (Primary Key): It is a Unique identifier for each payment.
   + BookingID: Identifier for the associated booking.
   + UserID: Identifier for the user who made the payment.
   + Amount: Amount paid.
   + PaymentMethod: Method of payment (e.g., credit card, PayPal).
   + PaymentStatus: It is a Status of the payment (e.g., completed, pending).
   + Timestamp: Date and time of the payment.