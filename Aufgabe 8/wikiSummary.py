#!/usr/bin/env python3

from requests import get

title = input("Insert Wikipedia Title: ")

json = get(f"https://en.wikipedia.org/api/rest_v1/page/summary/{title}").json()

summary = json["extract"]
print(summary)
print("---")

print("First word of summary with for-loop through String: ",end="")
for i in summary:
    if i != " ":
        print(i, end="")
    else:
        print()
        break;
        
print("---")
firstWord = summary.split()[0]
print("First word of Summary with split to Array: " + firstWord)

