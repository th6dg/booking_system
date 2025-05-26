#!/bin/bash

# Base URL of your Book API
API_URL="http://localhost:8080/api/book"

# Number of books to create
TOTAL_BOOKS=200

# Function to generate random date between two years
random_date() {
    start_date="2000-01-01"
    end_date="2025-12-31"
    START_EPOCH=$(date -d "$start_date" "+%s")
    END_EPOCH=$(date -d "$end_date" "+%s")
    RAND_EPOCH=$((START_EPOCH + RANDOM * (END_EPOCH - START_EPOCH) / 32767))
    date -d "@$RAND_EPOCH" "+%Y-%m-%d"
}

# List of realistic book titles
TITLES=(
    "The Art of Code"
    "Mastering Spring Boot"
    "Java Concurrency in Practice"
    "Clean Code"
    "Design Patterns: Elements of Reusable Object-Oriented Software"
    "Modern Java in Action"
    "Head First Java"
    "Effective Java"
    "Code Complete"
    "Domain-Driven Design"
    "Refactoring"
    "Test-Driven Development"
    "The Pragmatic Programmer"
    "Introduction to Algorithms"
    "Patterns of Enterprise Application Architecture"
    "Programming Pearls"
    "The Mythical Man-Month"
    "Algorithms"
    "Structure and Interpretation of Computer Programs"
    "JavaScript: The Good Parts"
)

TYPES=("Programming" "Fiction" "Non-Fiction" "Fantasy" "History" "Science Fiction" "Biography")

# Loop to send POST requests
for ((i = 1; i <= TOTAL_BOOKS; i++)); do
    TITLE="${TITLES[$((RANDOM % ${#TITLES[@]}))]}"
    TYPE="${TYPES[$((RANDOM % ${#TYPES[@]}))]}"
    DATE=$(random_date)

    JSON_PAYLOAD=$(cat <<EOF
{
  "name": "$TITLE",
  "type": "$TYPE",
  "datePublish": "$DATE"
}
EOF
)

    echo "Creating Book $i: $TITLE ($TYPE)"
    curl -s -X POST "$API_URL" \
      -H "Content-Type: application/json" \
      -d "$JSON_PAYLOAD" > /dev/null

    echo " => Sent"
done

echo "✅ Done seeding $TOTAL_BOOKS books!"