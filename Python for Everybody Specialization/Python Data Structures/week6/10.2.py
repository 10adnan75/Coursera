# -*- coding: utf-8 -*-

"""
Created on Jun 29 12:29 PM IST
@author: 10adnan75
"""

name = input("Enter file: ")
if len(name) < 1: name = "mbox-short.txt"
handle = open(name)
a = handle.read()
b = a.split("\n")
d = []
for i in b:
    if i.startswith("From "):
        c = i.split(":")
        d.append(c[0][-2:])
d.sort()
counts = {}
for j in d:
    counts[j] = d.count(j)
for k, l in counts.items():
    print(k, l)
