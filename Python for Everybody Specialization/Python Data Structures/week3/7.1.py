# -*- coding: utf-8 -*-

"""
Created on Jun 8 12:29 PM IST
@author: 10adnan75
"""

# Use words.txt as the file name
fname = input("Enter file name: ")
fh = open(fname)
a = fh.read()
print(a.upper().rstrip())
