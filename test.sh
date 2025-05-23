#!/bin/bash

for i in {1..1000}
do
  curl -s -o /dev/null -w "Sent request to http://localhost:8080/hello?index=$i | HTTP Status: %{http_code}\n" http://localhost:8080/hello?index=$i &
  sleep 0.01
done