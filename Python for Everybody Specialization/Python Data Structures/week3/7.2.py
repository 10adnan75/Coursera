# -*- coding: utf-8 -*-

"""
Created on Jun 8 12:29 PM IST
@author: atse
"""

# Use the file name mbox-short.txt as the file name
fname = input("Enter file name: ")
fh = open(fname)
a = []
for line in fh:
    if line.startswith("X-DSPAM-Confidence:"):
        a.append(float(line[-6:]))
total = 0
for i in a:
    total = total + i
mean = total/(len(a))    
print("Average spam confidence:", mean)
